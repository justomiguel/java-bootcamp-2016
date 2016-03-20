package controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import service.CategoryService;
import entity.Cart;
import entity.Category;

@RestController
@RequestMapping("/category")
@Api(value = "cartController")
public class CategoryController {

	CategoryService cs;

	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "add a category", response = Boolean.class, notes = "add category")
	@ApiResponse(code = 200, message = "category was added successfully")
	public @ResponseBody void addCategory(Category category) {

		cs.addCategory(category);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "remove a category", response = Boolean.class, notes = "remove category")
	@ApiResponse(code = 200, message = "category was removed successfully")
	public @ResponseBody void removeCategory(Iterable<Integer> idCategory) {
		Category categoryToremove = (Category) cs.findById(idCategory);
		cs.deleteCategory(categoryToremove);

	}
}
