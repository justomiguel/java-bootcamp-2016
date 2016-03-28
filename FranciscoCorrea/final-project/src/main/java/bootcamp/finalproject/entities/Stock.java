package bootcamp.finalproject.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Stock Entity", description = "Stock for every product")
@Entity
@Table(name = "stock")
public class Stock {

	public enum State {
		PUBLISHED, SOLD
	}
	
	@ApiModelProperty(value = "Stock Id", required = true)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long stockId;
	
	@ApiModelProperty(value = "Product's Stock", required = true)
	@ManyToOne
	@JoinColumn(name = "product_fk", nullable = false)
	private Product product;
	
	@ApiModelProperty(value = "State of the current Stock", required = true)
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	private State state;
	
	@ApiModelProperty(value = "Amount of the product", required = true)
	@Column(nullable = false)
	private int amount;
	
	protected Stock() {}
	
	public Stock(Product product, State state, int amount) {
		this.product = product;
		this.state = state;
		this.amount = amount;
	}

	public long getStockId() {
		return stockId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
