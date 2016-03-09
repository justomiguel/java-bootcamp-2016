package test;

import static org.junit.Assert.*;

import org.junit.Test;

import product.Product;
import service.ShoppingCartImp;
import service.ShoppingCartProxy;
import service.ShoppingCartWebService;

public class ShoppingCartTest {

	
	@Test
	public void addProduct(){
		
		ShoppingCartWebService shopping = new ShoppingCartWebService();
		assertTrue(shopping.addProduct(new Product("Milk",50.00,1)));
	}
	
	@Test
	public void deleteProduct(){
		ShoppingCartImp shopping = new ShoppingCartImp();
		shopping.addProduct(new Product("Milk",50.00,1));
		shopping.addProduct(new Product("Sugar",30.00,10));
		assertTrue(shopping.deleteProduct("Sugar", 2));
		assertTrue(shopping.calculatePrice()==290.00);
		
	}
	
	@Test
	public void searchProduct(){
		ShoppingCartImp shopping = new ShoppingCartImp();
		ShoppingCartProxy service = new ShoppingCartProxy(shopping);
		
		
		service.addProduct(new Product("Milk",50.00,1));
		service.addProduct(new Product("Sugar",30.00,2));
		Product product = shopping.searchProducts("Sugar");
		assertTrue(product.getName()!=null);
		
	}
	
	@Test
	public void updateProduct(){
		ShoppingCartImp shopping = new ShoppingCartImp();
		shopping.addProduct(new Product("Milk",50.00,1));
		shopping.updateProduct("Milk", "Chocolate", 30.00);
		assertTrue("Chocolate".equals(shopping.searchProducts("Chocolate").getName()));
	}

}