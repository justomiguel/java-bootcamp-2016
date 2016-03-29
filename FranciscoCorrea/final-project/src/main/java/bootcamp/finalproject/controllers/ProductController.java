package bootcamp.finalproject.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import bootcamp.finalproject.services.ProductService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import bootcamp.finalproject.entities.Product;


@RestController
@RequestMapping("products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@ApiOperation(
			value = "Get products filter by name",
			response = List.class
			)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "name", value = "Product's name",
				required = false, dataType = "String", paramType = "query")
	})
	@ApiResponses({
		@ApiResponse(code = 200, message = "Products founded"),
		@ApiResponse(code = 401, message = "Unauthorizad")
	})
	@RequestMapping(method = RequestMethod.GET)
	public List<Product> findProductsByName(@RequestParam(value = "name", defaultValue = "") String name) {
		if (name.equals("")) {
			return productService.findAll();
		}
		return productService.searchByName(name);
	}
	
	
	@ApiOperation(
			value = "Get products filter by category",
			response = ResponseEntity.class
			)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "categoryName", value = "Category's name",
				required = true, dataType = "String", paramType = "query")
	})
	@ApiResponses({
		@ApiResponse(code = 200, message = "Products founded"),
		@ApiResponse(code = 401, message = "Unauthorizad"),
		@ApiResponse(code = 404, message = "Not Found")
	})
	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public ResponseEntity<?> findProductsByCategory(@RequestParam(value = "name") String categoryName) {
		if(productService.findByCategoryName(categoryName).isEmpty()) {
			return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Product>>(productService.findByCategoryName(categoryName), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		Product p = this.productService.saveProduct(product);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(p.getProductId()).toUri());
		return new ResponseEntity<Product>(httpHeaders, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<?> update(@PathVariable long id, @RequestBody Product input) {
		Optional<Product> old = this.productService.findById(id);
		if(old.isPresent()) {
			Product toUpdate = old.get();
			toUpdate.setCategory(input.getCategory());
			toUpdate.setName(input.getName());
			toUpdate.setDescription(input.getDescription());
			toUpdate.setPrice(input.getPrice());
			this.productService.updateProduct(toUpdate);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		this.productService.deleteProduct(id);
	}
	
}
