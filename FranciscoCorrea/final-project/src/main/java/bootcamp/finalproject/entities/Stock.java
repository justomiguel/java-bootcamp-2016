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


@Entity
@Table(name = "stock")
public class Stock {

	public enum State {
		PUBLISHED, SOLD
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long stockId;
	
	@ManyToOne
	@JoinColumn(name = "product_fk", nullable = false)
	private Product product;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	private State state;
	
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
