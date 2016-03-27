package bootcamp.finalproject.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;


@Entity
@Table(name = "cart")
public class Cart {
	
	public enum CartStatus {
		CHECKOUT, CURRENT
	}
	
	@PersistenceContext
	EntityManager em;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cartId;
	
	@ManyToOne
	@JoinColumn(name = "user_fk", nullable = false)
	private User user;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private CartStatus cartStatus;
	
	@OneToOne
	@JoinColumn(name = "payorder_fk")
	private PayOrder payOrder;
	
	@OneToMany(mappedBy = "cart")
	private Set<ItemCart> products = new HashSet<ItemCart>();

	protected Cart() {}
	
	public Cart(User user, CartStatus status) {
		this.user = user;
		this.cartStatus = status;
	}
	
	public void addProduct(Product product, int amount) {
		ItemCart itemCart = findProduct(product);
		itemCart.setProduct(product);
		itemCart.setCart(this);
		itemCart.setCartId(this.getCartId());
		itemCart.setProductId(product.getProductId());
		itemCart.setAmount(amount);
		em.persist(itemCart);
		
		this.products.add(itemCart);
		product.getCart().add(itemCart);
	}
	
	public void deleteProduct(Product product) {
		this.products.remove(findProduct(product));
	}

	public long getCartId() {
		return cartId;
	}

	public User getUser() {
		return user;
	}
	
	public Set<ItemCart> getProducts() {
		return this.products;
	}
	
	public ItemCart getProduct(Product product) {
		return findProduct(product);
	}

	public void setUser(User user) {
		this.user = user;
	}

	public CartStatus getCartStatus() {
		return cartStatus;
	}

	public void setCartStatus(CartStatus cartStatus) {
		this.cartStatus = cartStatus;
	}
	
	public PayOrder getPayOrder() {
		return payOrder;
	}

	public void setPayOrder(PayOrder payOrder) {
		this.payOrder = payOrder;
	}
	
	private ItemCart findProduct(Product product) {
		if(!(this.products.size() == 0)) {
			for (ItemCart itemCart : this.products) {
				if(itemCart.getProduct().equals(product)) {
					return itemCart;
				}
			}
		}
		
		return new ItemCart();
	}
	
}