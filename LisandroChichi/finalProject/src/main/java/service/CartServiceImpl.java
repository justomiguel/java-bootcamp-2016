package service;


import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import repository.CartRepository;
import repository.ProductRepository;
import entity.Cart;
import entity.Product;

public class CartServiceImpl implements CartService{

	CartRepository cr;
	
	ProductRepository pr;

	@Override
	public void addCart(Cart cart) {
		cr.save(cart);
	}

	@Override
	public void deleteUser(Cart cart) {
		cr.delete(cart);
		
	}

	@Override
	public void addProduct(Cart cart, Product product) {
		List<Product> listProduct = (List<Product>) pr.findAll();
		cart.setProducts(listProduct);
		
	}

	@Override
	public void removeProduct(Cart cart, int idProduct) {
		cart.getProducts().remove(idProduct);
		updateCart(cart);
	}

	@Override
	public void updateCart(Cart cart) {
		cr.save(cart);
		
	}

}
