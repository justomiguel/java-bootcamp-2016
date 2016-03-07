package bootcamp.topic3.shoppingcart;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.Before;

public class ShoppingCartTest {

	static final double DELTA = 1e-15;
	Product product, product1;
	ShoppingCart cart;
	
	@Before
	public void setUp() {
		cart = new SimpleShoppingCart();
		product = new Product("Lapiz", "Descripcion lapiz", 15.0);
		product1 = new Product("Ojota", "Descripcion Ojota", 50.0);
	}
	
	@Test
	public void whenAddProduct() {
		assertTrue(cart.addProduct(product, 5));
	}
	
	@Test
	public void whenDeleteProduct() {
		cart.addProduct(product, 4);
		assertTrue(cart.deleteProduct(product, 3));
	}
	
	@Test
	public void whenDeleteProductAndThisNotExistsInCart() {
		assertFalse(cart.deleteProduct(product, 2));
	}
	
	@Test
	public void whenCheckMyCart() {
		List<Product> tempList = new ArrayList<Product>();
		tempList.add(product);
		tempList.add(product);
		tempList.add(product1);
		
		cart.addProduct(product, 2);
		cart.addProduct(product1, 1);
		
		assertArrayEquals(tempList.toArray(), cart.checkMyCart().toArray());
	}
	
	@Test
	public void whenAddOrDeleteProductCheckPrice() {
		double priceExpected = product.getPrice() * 3;
		cart.addProduct(product, 4);
		cart.deleteProduct(product, 1);
		
		assertEquals(priceExpected, cart.checkTotal(), DELTA);
	}

}
