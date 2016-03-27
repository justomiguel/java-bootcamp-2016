package bootcamp.finalproject.controllers;


import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.finalproject.entities.Cart;
import bootcamp.finalproject.entities.ItemCart;
import bootcamp.finalproject.entities.Product;
import bootcamp.finalproject.entities.Stock;
import bootcamp.finalproject.repositories.CartRepository;
import bootcamp.finalproject.repositories.PayOrderRepository;
import bootcamp.finalproject.repositories.ProductRepository;
import bootcamp.finalproject.repositories.StockRepository;
import bootcamp.finalproject.repositories.UserRepository;

@RequestMapping("/cart")
@RestController
public class CartController {

	@Autowired 
	private CartRepository cartRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PayOrderRepository payOrderRepository;
	
	@Autowired
	private StockRepository stockRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	
	@RequestMapping(value = "/products/{productId}", method = RequestMethod.POST)
	public ResponseEntity<?> addProductToCart(
			@RequestParam(name = "amount", defaultValue = "1" ) int amount,
			@PathVariable long productId) {
		if(!productRepository.findByProductId(productId).isPresent()) {
			return new ResponseEntity<>("Product non-existent", HttpStatus.BAD_REQUEST);
		}
		if(!existsStock(productId, amount)) {
			return new ResponseEntity<>("Amount exceeds stock", HttpStatus.BAD_REQUEST);
		}
		
		Cart cart = getCart();
		Product productToAdd = productRepository.findByProductId(productId).get();

		try {
			cart.addProduct(productToAdd, amount);
			recalculateStock(productId, amount, true);
			cartRepository.save(cart);
		} catch (Exception e) {
			return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
		}
		
		
		return new ResponseEntity<>("Veremos", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/products/{productId}", method = RequestMethod.DELETE) 
	public ResponseEntity<?> deleteProductFromCart(@PathVariable long productId) {
		if(!productRepository.findByProductId(productId).isPresent()) {
			return new ResponseEntity<>("Product non-existent", HttpStatus.BAD_REQUEST);
		}
		
		Product productToDelete = productRepository.findByProductId(productId).get();
		Cart cart = getCart();
		int amountToAdd = cart.getProduct(productToDelete).getAmount();
		recalculateStock(productId, amountToAdd, false);
		cart.deleteProduct(productToDelete);
		cartRepository.save(cart);
		return new ResponseEntity<>("Product deleted from cart", HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "/products/{productId}", method = RequestMethod.PUT)
	public ResponseEntity<?> subtractAmount(
			@PathVariable long productId,
			@RequestParam(name = "amount", defaultValue = "0") int amount) {
		if(!productRepository.findByProductId(productId).isPresent()) {
			return new ResponseEntity<>("Product non-existent", HttpStatus.BAD_REQUEST);
		}
		
		Product productToSubtractAmount = productRepository.findByProductId(productId).get();
		Cart cart = getCart();
		int amountToUpdate = cart.getProduct(productToSubtractAmount).getAmount();
		if(!(amountToUpdate - amount >= 0)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		recalculateStock(productId, amount, false);
		cart.getProduct(productToSubtractAmount).setAmount(amountToUpdate - amount);
		cartRepository.save(cart);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public Set<ItemCart> seeCart() {
		Cart cart = getCart();
		return cart.getProducts();
	}
	
	private Cart getCart() {
		org.springframework.security.core.userdetails.User authUser = 
				(org.springframework.security.core.userdetails.User) 
				SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		Optional<Cart> cart = cartRepository.findByUserNickNameAndCartStatus(
				authUser.getUsername(), Cart.CartStatus.CURRENT);
		if(!cart.isPresent()) {
			return new Cart(userRepository.findByNickName(authUser.getUsername()), Cart.CartStatus.CURRENT);
		}
		return cart.get();
	}
	
	private boolean existsStock(long productId, int amount) {
		Stock stock = stockRepository.findByProductProductIdAndState(productId, Stock.State.PUBLISHED);
		return stock.getAmount() - amount >= 0; 
	}
	
	private void recalculateStock(long productId, int amount, boolean subtraction) {
		Stock stock = stockRepository.findByProductProductIdAndState(productId, Stock.State.PUBLISHED);
		int currentStock = stock.getAmount();
		if(subtraction) {
			stock.setAmount(currentStock - amount);
		} else {
			stock.setAmount(currentStock + amount);
		}
		stockRepository.save(stock);
	}
}
