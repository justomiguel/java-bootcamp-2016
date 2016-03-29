package bootcamp.finalproject.controllers;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.finalproject.entities.Cart;
import bootcamp.finalproject.entities.ItemCart;
import bootcamp.finalproject.entities.Product;
import bootcamp.finalproject.services.CartService;
import bootcamp.finalproject.services.ProductService;
import bootcamp.finalproject.services.StockService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("/cart")
@RestController
public class CartController {

	@Autowired CartService cartService;
	@Autowired ProductService productService;
	@Autowired StockService stockService;
	
	
	@ApiOperation(
			value = "Add product to cart with their amount",
			response = ResponseEntity.class
			)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "amount", value = "Quantity of given product",
				required = false, dataType = "Int", paramType = "query"),
		@ApiImplicitParam(name = "productId", value = "Product's Id",
				required = true, dataType = "Int", paramType = "query")
	})
	@ApiResponses({
		@ApiResponse(code = 200, message = "Product added to cart"),
		@ApiResponse(code = 404, message = "Stock exceeds"),
		@ApiResponse(code = 401, message = "Unauthorizad")
	})
	@RequestMapping(value = "/products/{productId}", method = RequestMethod.POST)
	public ResponseEntity<?> addProductToCart(
			@RequestParam(name = "amount", defaultValue = "1" ) int amount,
			@PathVariable long productId) {
		if (!productService.findById(productId).isPresent()) {
			return new ResponseEntity<>("Product non-existent", HttpStatus.NOT_FOUND);
		}
		if(!stockService.existsStock(productId, amount)) {
			return new ResponseEntity<>("Amount exceeds stock", HttpStatus.NOT_FOUND);
		}
		
		Cart cart = cartService.getCart();		
		Product productToAdd = productService.findById(productId).get();
		cartService.addProduct(cart, productToAdd, amount);
		stockService.recalculateStock(productId, amount, true);
		cartService.saveCart(cart);
		return new ResponseEntity<>("Product(s) added to Cart", HttpStatus.OK);
	}
	
	
	@ApiOperation(
			value = "Delete product to cart and their amount",
			response = ResponseEntity.class
			)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "productId", value = "Product's Id",
				required = true, dataType = "Int", paramType = "query")
	})
	@ApiResponses({
		@ApiResponse(code = 204, message = "Product deleted to cart"),
		@ApiResponse(code = 404, message = "Product not found"),
		@ApiResponse(code = 401, message = "Unauthorizad")
	})
	@RequestMapping(value = "/products/{productId}", method = RequestMethod.DELETE) 
	public ResponseEntity<?> deleteProductFromCart(@PathVariable long productId) {
		if(!productService.findById(productId).isPresent()) {
			return new ResponseEntity<>("Product non-existent", HttpStatus.NOT_FOUND);
		}
		
		Product productToDelete = productService.findById(productId).get();
		Cart cart = cartService.getCart();		
		int amountToAdd = cartService.findProduct(cart, productToDelete).getAmount();
		stockService.recalculateStock(productId, amountToAdd, false);
		cartService.deleteProduct(cart, productToDelete);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	
	@ApiOperation(
			value = "Get products and their amount from current cart",
			response = ResponseEntity.class
			)
	@ApiResponses({
		@ApiResponse(code = 200, message = "Products in the cart"),
		@ApiResponse(code = 401, message = "Unauthorizad")
	})
	@RequestMapping(method = RequestMethod.GET)
	public Set<ItemCart> seeCart() {
		return cartService.getCart().getProducts();
	}
	
	
	@ApiOperation(
			value = "Buy the current cart and generates a Pay Order for the purchase",
			response = ResponseEntity.class
			)
	@ApiResponses({
		@ApiResponse(code = 200, message = "Checkout success"),
		@ApiResponse(code = 500, message = "Internal Error"),
		@ApiResponse(code = 401, message = "Unauthorizad")
	})
	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public ResponseEntity<?> checkout() {
		Cart cart = cartService.getCart();
		try {
			cartService.checkout(cart);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
