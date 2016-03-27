package bootcamp.finalproject.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item_cart")
@IdClass(ItemCartId.class)
public class ItemCart {
	
	@Id
	private long cartId;
	
	@Id
	private long productId;
	
	@Column(name = "amount", nullable = false)
	private int amount = 0;

	@ManyToOne
	@JoinColumn(name = "cartId", nullable = false, insertable = false, updatable = false)
	private Cart cart;
	
	@ManyToOne
	@JoinColumn(name = "productId", nullable = false, insertable = false, updatable = false)
	private Product product;
	
	protected ItemCart() {}
		
	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
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
