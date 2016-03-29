package finalproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import finalproject.entity.Category;
import finalproject.repository.CategoryRepository;


@Component 
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	CategoryRepository cr;

	@Override
	public Category persistCategory(Category category) {
		return cr.save(category);
		
	}

	@Override
	public Category findCategoryById(long idCategory) {
		return  cr.findOne(idCategory);
		
	}

	@Override
	public void deleteCategory(long id) {
		cr.delete(id);
		
	}

}
