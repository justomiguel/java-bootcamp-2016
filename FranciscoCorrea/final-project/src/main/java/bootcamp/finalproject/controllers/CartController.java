package bootcamp.finalproject.controllers;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.finalproject.entities.Cart;
import bootcamp.finalproject.entities.ItemCart;
import bootcamp.finalproject.entities.Product;
import bootcamp.finalproject.services.CartService;
import bootcamp.finalproject.services.ProductService;
import bootcamp.finalproject.services.StockService;

@RequestMapping("/cart")
@RestController
public class CartController {

	@Autowired CartService cartService;
	@Autowired ProductService productService;
	@Autowired StockService stockService;
	
	
	@RequestMapping(value = "/products/{productId}", method = RequestMethod.POST)
	public ResponseEntity<?> addProductToCart(
			@RequestParam(name = "amount", defaultValue = "1" ) int amount,
			@PathVariable long productId) {
		if (!productService.findById(productId).isPresent()) {
			return new ResponseEntity<>("Product non-existent", HttpStatus.UNPROCESSABLE_ENTITY);
		}
		if(!stockService.existsStock(productId, amount)) {
			return new ResponseEntity<>("Amount exceeds stock", HttpStatus.NOT_FOUND);
		}
		
		Cart cart = cartService.getCart();		
		Product productToAdd = productService.findById(productId).get();
		try {
		cartService.addProduct(cart, productToAdd, amount);
		stockService.recalculateStock(productId, amount, true);
		cartService.saveCart(cart);} catch (Exception e) {
			return new ResponseEntity<>(e, HttpStatus.OK);
		}
		
		
		return new ResponseEntity<>("Product(s) added to Cart", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/products/{productId}", method = RequestMethod.DELETE) 
	public ResponseEntity<?> deleteProductFromCart(@PathVariable long productId) {
		if(!productService.findById(productId).isPresent()) {
			return new ResponseEntity<>("Product non-existent", HttpStatus.UNPROCESSABLE_ENTITY);
		}
		
		Product productToDelete = productService.findById(productId).get();
		Cart cart = cartService.getCart();		
		int amountToAdd = cartService.findProduct(cart, productToDelete).getAmount();
		stockService.recalculateStock(productId, amountToAdd, false);
		cartService.deleteProduct(cart, productToDelete);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(method = RequestMethod.GET)
	public Set<ItemCart> seeCart() {
		return cartService.getCart().getProducts();
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public ResponseEntity<?> checkout() {
		Cart cart = cartService.getCart();
		try {
			cartService.checkout(cart);
			return new ResponseEntity<>("Fine", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
