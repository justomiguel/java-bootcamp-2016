package controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import product.Product;
import service.ShoppingCartService;

@RestController
@RequestMapping("/cart")
@Api(value="Shpopping cart")
public class ShoppingCartController {

	
	ShoppingCartService service;

	@ApiOperation(httpMethod= "GET",value="return all products")
	@RequestMapping(value = "/get/",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({ @ApiResponse(code = 200, message = "Exits one product at least") })
	public List<Product> getAllProducts() {
		return service.getAllProducts();

	}

	@ApiOperation(httpMethod= "POST",value="add a product")
	@RequestMapping(value = "/post/",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({ @ApiResponse(code = 201, message = "Successful create of a info") })
	public Product addProduct(@RequestBody Product product) {
		return service.addProduct(product);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(method = RequestMethod.DELETE, value = "delete/{name}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(httpMethod= "DELETE",value = "Delete Info", notes = "Delete a info")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Successful delete of a info")
    })
	public void deleteProduct(@PathVariable String name, @PathVariable int qty) {
		service.deleteProduct(name, qty);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(method = RequestMethod.PUT, value = "/put/{oldName}")
    @ApiOperation(httpMethod= "PUT",value = "Update Info", notes = "Update a info")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Successful update of a info")
    })
	public Product updateProduct(@PathVariable String oldName,
			@RequestBody Product product) {
		return service.updateProduct(oldName, product);
	}

    @RequestMapping(method = RequestMethod.GET, value = "/get/{name}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(httpMethod= "GET",value = "Get one Info", notes = "Returns one info")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Exists this info")
    })
	public Product findProduct(@PathVariable String name) {
		return service.searchProduct(name);
	}
	
}