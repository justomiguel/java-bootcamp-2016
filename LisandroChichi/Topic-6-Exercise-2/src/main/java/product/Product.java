package product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



@ApiModel(value="product entity",description="a product entity")
public class Product {
	
	@ApiModelProperty(value="name product", required=true)
	private String name;
	@ApiModelProperty(value="price product", required=true)
	private double price;
	@ApiModelProperty(value="quantity product", required=true)
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

	public Product setName(String name) {
		this.name = name;
		return this;
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