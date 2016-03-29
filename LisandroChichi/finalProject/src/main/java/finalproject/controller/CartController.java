package finalproject.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import finalproject.entity.Cart;
import finalproject.service.CartService;

@RestController
@RequestMapping("/api/cart")
@Api(value = "cartController")
public class CartController {


	@Autowired
	CartService cartService;
	

	@RequestMapping(value = "/", method = RequestMethod.POST,produces = "application/json")
	@ApiOperation(value = "create a cart")
	@ApiResponse(code = 200, message = "cart was created successfully")
	public Cart createCart(@RequestBody Cart cart) {
		// TODO Auto-generated method stub
		return cartService.persistCart(cart);
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE,produces = "application/json")
	@ApiOperation(value = "delete a cart")
	@ApiResponse(code = 200, message = "cart was deleted successfully")
	public void deleteCart(@PathVariable long id) {
		// TODO Auto-generated method stub
		cartService.deleteCart(id);
		
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET,produces = "application/json")
	@ApiOperation(value = "find a cart by id")
	@ApiResponse(code = 200, message = "cart was finded successfully")
	public Cart findByID(@PathVariable int id) {
		return cartService.findCartByID(id);
		
	}

}
