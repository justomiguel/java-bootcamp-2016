package service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import repository.ProductRepository;
import entity.Category;
import entity.Product;

@Service("productService")
public class ProductServiceImp implements ProductService {

	@Autowired
	private ProductRepository pdao;

	@Override
	public List<Product> findByCategory(Category category) {
		return pdao.findByCategory(category);
	}

	@Transactional
	public List<Product> getProductByName(String name) {
		return pdao.findByName(name);
	}

	@Transactional
	public Product add(Product product) {
		return pdao.save(product);
	}

	@Transactional
	public void delete(Product product) {
		pdao.delete(product);
	}

}