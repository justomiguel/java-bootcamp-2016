package bootcamp.finalproject.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "item_cart")
public class ItemCart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long itemCartId;
	
	@Column(name = "amount", nullable = false)
	private int amount = 0;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cart_id", nullable = false)
	@JsonBackReference
	private Cart cart;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;
	
	public ItemCart() {}
	
	public long getItemCartId() {
		return this.itemCartId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
