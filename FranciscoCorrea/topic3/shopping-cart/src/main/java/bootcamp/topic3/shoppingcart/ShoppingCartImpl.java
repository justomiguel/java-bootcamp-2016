package bootcamp.topic3.shoppingcart;

import java.util.ArrayList;
import java.util.List;

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

}
