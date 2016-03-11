package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import product.Product;

@Service
public class ShoppingCartServiceMock implements ShoppingCartService {

	ArrayList<Product> listProducts = new ArrayList<Product>();

	private static final String NAME_POTATOES = "Potatoes";
	private static final String NAME_ORANGE = "Orange";
	private static final String NAME_APPLE = "Aplle";
	private static final double PRICE_1 = 5.00;
	private static final double PRICE_2 = 7.00;
	private static final double PRICE_3 = 10.00;
	private static final int QUANTITY_1 = 66;
	private static final int QUANTITY_2 = 15;
	private static final int QUANTITY_3 = 22;

	public Product addProduct(Product product) {
		return product.setName(NAME_POTATOES);
	}

	public void deleteProduct(String name, int qty) {

	}

	public Product searchProduct(String name) {
		return new Product(name, PRICE_1, QUANTITY_1);

	}

	public Product updateProduct(String oldName, Product product) {
		return new Product(oldName, PRICE_2, QUANTITY_2);

	}

	public List<Product> getAllProducts() {
		return Arrays.asList(new Product(NAME_APPLE, PRICE_1, QUANTITY_1),
				new Product(NAME_ORANGE, PRICE_2, QUANTITY_2), new Product(
						NAME_POTATOES, PRICE_3, QUANTITY_3)

		);

	}
}