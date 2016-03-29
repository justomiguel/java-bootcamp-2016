package finalproject.service;

import finalproject.entity.Category;

public interface CategoryService {

	public Category persistCategory(Category category);

	public void deleteCategory(long id);

	public Category findCategoryById(long idCategory);

}
