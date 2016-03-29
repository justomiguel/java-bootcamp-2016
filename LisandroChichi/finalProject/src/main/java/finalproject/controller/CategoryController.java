package finalproject.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import finalproject.entity.Category;
import finalproject.service.CategoryService;

@RestController
@RequestMapping("/api/cart/category")
@Api(value = "categoryController")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ApiOperation(value = "add a category", notes = "add category")
	@ApiResponse(code = 200, message = "category was added successfully")
	public @ResponseBody Category persistCategory(@RequestBody Category category) {

		return categoryService.persistCategory(category);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "remove a category", notes = "remove category")
	@ApiResponse(code = 200, message = "category was removed successfully")
	public @ResponseBody void removeCategory(@PathVariable Long id) {

		categoryService.deleteCategory(id);

	}
}
