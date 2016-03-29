package bootcamp.finalproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bootcamp.finalproject.entities.Product;
import bootcamp.finalproject.repositories.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService {

	@Autowired ProductRepository productRepository;
	
	@Override
	public Product saveProduct(Product product) {
		return productRepository.saveAndFlush(product);
	}

	@Override
	public void updateProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	public void deleteProduct(long productId) {
		productRepository.delete(productId);
	}

	@Override
	public Product findByName(String name) {
		return productRepository.findByName(name);
	}

	@Override
	public Optional<Product> findById(long productId) {
		return productRepository.findByProductId(productId);
	}

	@Override
	public List<Product> searchByName(String name) {
		return productRepository.findByNameStartingWith(name);
	}

	@Override
	public List<Product> findByCategoryName(String category) {
		return productRepository.findByCategoryName(category);
	}

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

}
