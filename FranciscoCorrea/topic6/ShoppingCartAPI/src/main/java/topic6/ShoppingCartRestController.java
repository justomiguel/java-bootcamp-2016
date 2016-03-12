package topic6;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping
public class ShoppingCartRestController implements ShoppingCart {
	
	private ShoppingCart cart;
	
	
	public ShoppingCartRestController() {
		this.cart = new ShoppingCartImpl();
	}

	
	// Example here, the other methods must implement the same swagger annotations
	@ApiOperation(
			value = "Add products to cart", 
			notes = "Notes...",
			response = Boolean.class)
	@ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Boolean.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
	@RequestMapping(value = "/product", method = RequestMethod.POST, consumes = "application/json")
	@Override
	public boolean addProduct(@ApiParam(value = "Product to add", required = true) @RequestBody Product product,
							@ApiParam(value = "Amount of the product", required = true) @RequestBody int amount) {
		return cart.addProduct(product, amount);
	}

	@RequestMapping(value = "/product", method = RequestMethod.DELETE)
	@Override
	public boolean deleteProduct(@RequestBody Product product, int amount) {
		return cart.deleteProduct(product, amount);
	}

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	@Override
	public List<Product> checkMyCart() {
		return cart.checkMyCart();
	}

	@RequestMapping(value = "/product/total", method = RequestMethod.GET)
	@Override
	public double checkTotal() {
		return 0;
	}
}
