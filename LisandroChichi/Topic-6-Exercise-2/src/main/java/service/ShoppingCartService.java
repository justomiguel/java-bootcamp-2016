package service;

import java.util.List;

import product.Product;


public interface ShoppingCartService {

	public Product addProduct(Product product);
	public void deleteProduct(String name,int qty);
	public Product updateProduct(String oldName,Product product);
	public Product searchProduct(String name);
	public List<Product> getAllProducts();
	
	
}