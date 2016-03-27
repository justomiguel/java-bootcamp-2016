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
import bootcamp.finalproject.entities.Product;


@RestController
@RequestMapping("products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Product> findProductsByName(@RequestParam(value = "name") String name) {
		return productService.searchByName(name);
	}
	
	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public List<Product> findProductsByCategory(@RequestParam(value = "name") String categoryName) {
		return productService.findByCategoryName(categoryName);
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
