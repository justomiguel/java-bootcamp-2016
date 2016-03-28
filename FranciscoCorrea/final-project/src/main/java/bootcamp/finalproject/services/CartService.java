package bootcamp.finalproject.services;

import java.util.Optional;
import java.util.Set;

import bootcamp.finalproject.entities.Cart;
import bootcamp.finalproject.entities.Cart.CartStatus;
import bootcamp.finalproject.entities.ItemCart;
import bootcamp.finalproject.entities.Product;

public interface CartService {
	
	Cart getCart(); 
	
	Optional<Cart> findByNickNameAndStatus(String nickName, Enum<CartStatus> status);
	
	Cart saveCart(Cart cart);
	
	Set<ItemCart> showCart(Cart cart);
	
	ItemCart findProduct(Cart cart, Product product);
	
	void addProduct(Cart cart, Product product, int amount);
	
	void deleteProduct(Cart cart, Product product);
	
	void checkout(Cart cart);
}
