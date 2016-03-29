package finalproject.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import finalproject.entity.Product;
import finalproject.service.CategoryService;
import finalproject.service.ProductService;

@RestController
@RequestMapping("/cart")
@Api(value = "productController")
public class ProductController {

	@Autowired
    private CategoryService cs;
	@Autowired
    private ProductService ps;

    @RequestMapping(value = "/category/{idCategory}", method = RequestMethod.GET)
    @ApiOperation(value = "return product by category")
    @ApiResponse(code = 200, message = "product was returned successfully")
    public List<Product> getProductByCategory(@PathVariable long idCategory) {

        List<Product> products = ps.findByCategory(idCategory);
        return products;

    }

    @RequestMapping(value = "/product/{name]", method = RequestMethod.GET)
    @ApiOperation(value = "return product by name", response = Boolean.class, notes = "Return product")
    @ApiResponse(code = 200, message = "product was returned successfully")
    public Product getProductByName(@PathVariable String name) {

        return ps.getProductByName(name);
    }
    @RequestMapping(value = "/product", method = RequestMethod.POST)
    @ApiOperation(value = "persist product by name", response = Boolean.class, notes = "persist product")
    @ApiResponse(code = 200, message = "product was returned successfully")
	public Product persistProduct(@RequestBody Product product) {
		return ps.persistProduct(product);
	}

	@RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "remove product by id")
    @ApiResponse(code = 200, message = "product was removed successfully")
	public void deleteProductById(@PathVariable long id) {
		ps.removeById(id);
		
	}
	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "get product by id")
    @ApiResponse(code = 200, message = "product was obtained successfully")
	public Product findProductById(@PathVariable long  id) {
		return ps.findById(id);
	}

	
}