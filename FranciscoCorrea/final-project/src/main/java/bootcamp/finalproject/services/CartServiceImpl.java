package bootcamp.finalproject.services;

import java.sql.Date;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import bootcamp.finalproject.entities.Cart;
import bootcamp.finalproject.entities.Cart.CartStatus;
import bootcamp.finalproject.entities.ItemCart;
import bootcamp.finalproject.entities.PayOrder;
import bootcamp.finalproject.entities.Product;
import bootcamp.finalproject.repositories.CartRepository;
import bootcamp.finalproject.repositories.ItemCartRepository;


@Service
public class CartServiceImpl implements CartService {

	@Autowired CartRepository cartRepository;
	@Autowired UserService userService;
	@Autowired StockService stockService;
	@Autowired ItemCartRepository itemCartRepository;
	@Autowired PayOrderService payOrderService;
	
	@Override
	public Cart getCart() {
		org.springframework.security.core.userdetails.User authUser = 
				(org.springframework.security.core.userdetails.User) 
				SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		Optional<Cart> cart = findByNickNameAndStatus(authUser.getUsername(), Cart.CartStatus.CURRENT);
		if(!cart.isPresent()) {
			return saveCart(new Cart(userService.findByNickName(authUser.getUsername()), Cart.CartStatus.CURRENT));
		}
		return cart.get();
	}

	@Override
	public Cart saveCart(Cart cart) {
		return cartRepository.saveAndFlush(cart);
	}

	@Override
	public Optional<Cart> findByNickNameAndStatus(String nickName, Enum<CartStatus> status) {
		return cartRepository.findByUserNickNameAndCartStatus(nickName, status);
	}

	@Override
	public Set<ItemCart> showCart(Cart cart) {
		return cart.getProducts();
	}

	@Override
	public ItemCart findProduct(Cart cart, Product product) {
		if(!cart.getProducts().isEmpty()) {
			for (ItemCart itemCart : cart.getProducts()) {
				if(itemCart.getProduct().equals(product)) {
					return itemCart;
				}
			}
		}
		
		return new ItemCart();
	}

	@Override
	public void addProduct(Cart cart, Product product, int amount) {
		ItemCart itemCart = findProduct(cart, product);
		itemCart.setProduct(product);
		itemCart.setCart(cart);
		itemCart.setAmount(itemCart.getAmount() + amount);
		
		cart.addItemcart(itemCart);
		saveCart(cart);
	}

	@Override
	public void deleteProduct(Cart cart, Product product) {
		ItemCart itemCart = findProduct(cart, product);
		cart.deleteItemcart(itemCart);
		saveCart(cart);
		itemCartRepository.delete(itemCart); // No debería ser así
	}

	@Override
	public void checkout(Cart cart) {
		double price = 0;
		for (ItemCart itemCart : cart.getProducts()) {
			int amount = itemCart.getAmount();
			stockService.addSoldStock(itemCart.getProduct().getProductId(), amount);
			price = price + itemCart.getProduct().getPrice()*amount;
		}
		
		Date date = Date.valueOf("2016-03-28");
		PayOrder payOrder = new PayOrder(cart, price, date);
		
		payOrderService.savePayOrder(payOrder);
		
		cart.setCartStatus(Cart.CartStatus.CHECKOUT);
		saveCart(cart);
	}
	
}	
