package finalproject.service;

import finalproject.entity.Cart;

public interface CartService {

	public Cart persistCart(Cart cart);

	public void deleteCart(long id);
	
	public Cart findCartByID(long id);




}
