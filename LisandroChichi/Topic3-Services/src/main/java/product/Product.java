package product;

public class Product {
	
	private String name;
	private double price;
	private int qty;

	public Product(String name, double price, int qty) {
		// TODO Auto-generated constructor stub
		this.setName(name);
		this.setPrice(price);
		this.setQty(qty);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

}