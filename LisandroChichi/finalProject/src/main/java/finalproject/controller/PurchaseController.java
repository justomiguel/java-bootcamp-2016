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

import finalproject.entity.Purchase;
import finalproject.service.PurchaseService;

@RestController
@RequestMapping("/api/cart/purchase")
@Api(value = "purchaseController")
public class PurchaseController {

	@Autowired
	PurchaseService purchaseService;

	@RequestMapping(value = "/{idCart}", method = RequestMethod.POST)
	@ApiOperation(value = "calculate the total ")
	public double calcularTotal(@PathVariable long idCart) {
		return purchaseService.calcularTotal(idCart);

	}

	@RequestMapping(value = "/{idCart}", method = RequestMethod.GET)
	@ApiOperation(value = "detail of the shopping")
	public String detalleCompra(@PathVariable long idCart) {
		return purchaseService.detalleCompra(idCart);

	}

	@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
	@ApiOperation(value = "create a purchse")
	@ApiResponse(code = 200, message = "purchse was created successfully")
	public Purchase createPurchase(@RequestBody Purchase purchase) {
		// TODO Auto-generated method stub
		return purchaseService.persistPurchase(purchase);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	@ApiOperation(value = "delete a purchse")
	@ApiResponse(code = 200, message = "purchse was deleted successfully")
	public void deletePurchse(@PathVariable long id) {
		// TODO Auto-generated method stub
		purchaseService.removeById(id);

	}

}
