package service;

import java.util.List;

import entity.Cart;
import entity.Product;

public interface CartService {

	public void addCart(Cart cart);

	public void deleteUser(Cart cart);
	
	public void addProduct(Cart cart, Product product);

	public void removeProduct(Cart cart, int idProduct);
	
	public void updateCart(Cart cart);

}
