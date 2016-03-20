package service;

import java.util.List;

import entity.Category;
import entity.User;

public interface CategoryService {

	

	public void addCategory(Category category);
	public void deleteCategory(Category category);
	public List<Category> findById (Iterable<Integer> idCategory);
	
	
}
