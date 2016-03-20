package controller;

import java.util.List;

import javax.ws.rs.QueryParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import service.CartService;
import service.ProductService;
import entity.Cart;
import entity.Cart_product;
import entity.Product;

@RestController
@RequestMapping("/cart")
@Api(value = "cartController")
public class CartController {

	CartService cartService;
	

	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "add a product", response = Boolean.class, notes = "add product")
	@ApiResponse(code = 200, message = "product was added successfully")
	public @ResponseBody void addProduct(Cart cart, Product product) {

		cartService.addProduct(cart, product);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "add a product", response = Boolean.class, notes = "add product")
	@ApiResponse(code = 200, message = "product was added successfully")
	public @ResponseBody void removeProduct(Cart cart, int idProduct) {

		cartService.removeProduct(cart, idProduct);
	}
}
