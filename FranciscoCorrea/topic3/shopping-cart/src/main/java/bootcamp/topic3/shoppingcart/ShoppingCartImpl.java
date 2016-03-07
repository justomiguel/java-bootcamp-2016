package bootcamp.topic3.shoppingcart;

import java.util.ArrayList;
import java.util.List;

/**
 * Interface shopping cart's implementation 
 * @author Correa Franciscp
 * @version 0.1
 */
public class ShoppingCartImpl implements ShoppingCart {

	private List<Product> products;
	
	protected ShoppingCartImpl() {
		this.products = new ArrayList<Product>();
	}

	@Override
	public boolean addProduct(Product product, int amount) {
		List<Product> productsToAdd = new ArrayList<Product>();
		for (int i = 0; i < amount; i++) {
			productsToAdd.add(product);
		}
		return this.products.addAll(productsToAdd);
	}

	@Override
	public boolean deleteProduct(Product product, int amount) {
		List<Product> productsToAdd = new ArrayList<Product>();
		for (int i = 0; i < amount; i++) {
			productsToAdd.add(product);
		}
		return this.products.removeAll(productsToAdd);
	}

	@Override
	public List<Product> checkMyCart() {
		return this.products;
	}
	
	@Override
	public double checkTotal() {
		double total = 0;
		for (int i = 0; i < this.products.size(); i++) {
			total = total + this.products.get(i).getPrice();
		}
		return total;
	}

}
