package bootcamp.finalproject.services;

import java.util.Optional;
import java.util.Set;

import bootcamp.finalproject.entities.Cart;
import bootcamp.finalproject.entities.Cart.CartStatus;
import bootcamp.finalproject.entities.ItemCart;
import bootcamp.finalproject.entities.Product;

public interface CartService {
	
	Cart getCart();
	
	Cart saveCart(Cart cart);
	
	Optional<Cart> findByNickNameAndStatus(String nickName, Enum<CartStatus> status);
	
	Set<ItemCart> showCart();
	
	ItemCart findProduct(Product product);
	
	ItemCart addProduct(Product product, int amount);
	
	void deleteProduct(Product product);
	
	Cart checkout();
}
