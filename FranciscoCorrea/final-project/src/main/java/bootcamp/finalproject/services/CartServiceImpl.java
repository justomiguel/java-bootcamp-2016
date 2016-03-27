package bootcamp.finalproject.services;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import bootcamp.finalproject.entities.Cart;
import bootcamp.finalproject.entities.Cart.CartStatus;
import bootcamp.finalproject.entities.ItemCart;
import bootcamp.finalproject.entities.Product;
import bootcamp.finalproject.repositories.CartRepository;


@Service
public class CartServiceImpl implements CartService {

	@Autowired CartRepository cartRepository;
	@Autowired UserService userService;
	
	@Override
	public Cart getCart() {
		org.springframework.security.core.userdetails.User authUser = 
				(org.springframework.security.core.userdetails.User) 
				SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		Optional<Cart> cart = findByNickNameAndStatus(authUser.getUsername(), Cart.CartStatus.CURRENT);
		if(!cart.isPresent()) {
			return new Cart(userService.findByNickName(authUser.getUsername()), Cart.CartStatus.CURRENT);
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
	public Set<ItemCart> showCart() {
		Cart cart = getCart();
		return cart.getProducts();
	}

	@Override
	public ItemCart findProduct(Product product) {
		Cart cart = getCart();
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
	public ItemCart addProduct(Product product, int amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cart checkout() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
