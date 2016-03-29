package finalproject.service;

import java.util.List;

import finalproject.entity.Product;


public interface ProductService  {
	
	public List<Product> findByCategory(long idCategory);

	public Product getProductByName(String name);
	
	public Product persistProduct(Product product);
	
	public void removeById(long idProduct);

	public Product findById(long idProd);
}