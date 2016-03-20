package service;

import java.util.List;

import repository.CategoryRepository;
import entity.Category;

public class CategoryServiceImpl implements CategoryService{
	
	CategoryRepository cr;

	@Override
	public void addCategory(Category category) {
		cr.save(category);
		
	}

	@Override
	public void deleteCategory(Category category) {
		cr.delete(category);
		
	}

	@Override
	public List<Category> findById(Iterable<Integer> idCategory) {
		return (List<Category>) cr.findAll(idCategory);
		
	}

}
