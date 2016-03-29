package finalproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import finalproject.entity.Product;
import finalproject.repository.ProductRepository;

@Component 
public class ProductServiceImp implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> findByCategory(long idCategory) {
		return productRepository.getProductByCategory(idCategory);
	
	}

	@Transactional
	public Product getProductByName(String name) {
		return productRepository.getProductByName(name);
	}

	@Transactional
	public Product persistProduct(Product product) {
		return productRepository.save(product);
	}

	@Transactional
	public void delete(Product product) {
		productRepository.delete(product);
	}

	@Override
	public void removeById(long idProduct) {
		productRepository.delete(idProduct);
	}

	@Override
	public Product findById(long id) {
		return productRepository.findOne(id);
	}

}