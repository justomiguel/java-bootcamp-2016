package bootcamp.finalproject.controllers;

import java.util.List;

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

import bootcamp.finalproject.repositories.ProductRepository;
import bootcamp.finalproject.entities.Product;


@RestController
@RequestMapping("products")
public class ProductController {
	
	@Autowired
	ProductRepository productReposirory;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Product> findProductsByName(@RequestParam(value = "name") String name) {
		return productReposirory.findByNameStartingWith(name);
	}
	
	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public List<Product> findProductsByCategory(@RequestParam(value = "name") String categoryName) {
		return productReposirory.findByCategoryName(categoryName);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		Product p = this.productReposirory.save(product);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(p.getProductId()).toUri());
		return new ResponseEntity<Product>(httpHeaders, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<?> update(@PathVariable long id, @RequestBody Product input) {
		Product old = this.productReposirory.findOne(id);
		if(old != null) {
			old.setCategory(input.getCategory());
			old.setName(input.getName());
			old.setDescription(input.getDescription());
			old.setPrice(input.getPrice());
			this.productReposirory.save(old);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		this.productReposirory.delete(id);
	}
	
}
