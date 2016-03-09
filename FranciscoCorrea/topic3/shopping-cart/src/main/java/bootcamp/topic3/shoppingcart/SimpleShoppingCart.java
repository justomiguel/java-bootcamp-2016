
package bootcamp.topic3.shoppingcart;

import java.util.List;


public class SimpleShoppingCart implements ShoppingCart {
	
	private ShoppingCart implementation;
	
	protected SimpleShoppingCart() {
		this.implementation = new ShoppingCartImpl();
	}

	@Override
	public boolean addProduct(Product product, int amount) {
		return implementation.addProduct(product, amount);
	}

	@Override
	public boolean deleteProduct(Product product, int amount) {
		return implementation.deleteProduct(product, amount);
	}

	@Override
	public List<Product> checkMyCart() {
		return implementation.checkMyCart();
	}
	
	@Override
	public double checkTotal() {
		return implementation.checkTotal();
	}

}
