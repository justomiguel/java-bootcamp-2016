package topic6;

import java.util.List;

/**
 * 
 * @author Correa Francisco <correa.francisco.21@gmail.com>
 * @version 0.1
 */
public interface ShoppingCart {
	
	/**
	 * Add to cart a certain amount of a product 
	 * @param product
	 * @param quantity
	 * @return boolean value
	 */
	public boolean addProduct(Product product, int amount);
	
	/**
	 * Remove a certain amount of a product from Cart
	 * @param product
	 * @param amount
	 * @return boolean
	 */
	public boolean deleteProduct(Product product, int amount);
	
	/**
	 * Allow see the products that i have in the cart
	 * @return List<Product>
	 */
	public List<Product> checkMyCart();
	
	/**
	 * Check the total price about the products in the cart
	 * @return double
	 */
	public double checkTotal();
}
