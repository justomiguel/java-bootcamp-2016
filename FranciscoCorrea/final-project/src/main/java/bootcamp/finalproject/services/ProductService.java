package bootcamp.finalproject.services;

import java.util.List;
import java.util.Optional;

import bootcamp.finalproject.entities.Product;

public interface ProductService {
	
	Product saveProduct(Product product);
	void updateProduct(Product product);
	void deleteProduct(long productId);
	Product findByName(String name);
	Optional<Product> findById(long productId);
	List<Product> searchByName(String name);
	List<Product> findByCategoryName(String category);
}
