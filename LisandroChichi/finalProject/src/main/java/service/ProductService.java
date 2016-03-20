package service;

import java.util.ArrayList;
import java.util.List;

import entity.Category;
import entity.Product;


public interface ProductService  {
	public List<Product> findByCategory(Category category);

	public List<Product> getProductByName(String name);
}