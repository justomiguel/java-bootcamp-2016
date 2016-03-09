package bootcamp.topic3.shoppingcart;

/**
 *  
 * @author Correa Francisco <correa.francisco.21@gmail.com>
 * @version 0.1
 *
 */
public class Product {
	private String name;
	private String description;
	private double price;
	
	/**
	 * Product Constructor, throws an Exception if name parameter is empty
	 * @param name
	 * @param desc
	 * @param price
	 * @throws IllegalArgumentException
	 */
	public Product(String name, String desc, double price) throws IllegalArgumentException {
		if(name == null || name.equals("")) {
			throw new IllegalArgumentException();
		}
		this.name = name;
		this.description = desc;
		this.price = price;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
