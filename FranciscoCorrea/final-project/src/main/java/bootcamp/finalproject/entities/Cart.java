package bootcamp.finalproject.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Shopping Cart Entity", description = "Cart that stores products for the user purchase")
@Entity
@Table(name = "cart")
public class Cart {
	
	public enum CartStatus {
		CHECKOUT, CURRENT
	}
	
	@ApiModelProperty(value = "Cart Id", required = true)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cartId;
	
	@ApiModelProperty(value = "User owner of the cart", required = true)
	@ManyToOne
	@JoinColumn(name = "user_fk", nullable = false)
	private User user;
	
	@ApiModelProperty(value = "Cart's Status", required = true, example = "CURRENT")
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private CartStatus cartStatus;
	
	@ApiModelProperty(value = "Products stores in the cart", required = false)
	@OneToMany(mappedBy = "cart", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<ItemCart> products = new HashSet<ItemCart>();

	public Cart() {}
	
	public Cart(User user, CartStatus status) {
		this.user = user;
		this.cartStatus = status;
	}

	public long getCartId() {
		return cartId;
	}

	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public Set<ItemCart> getProducts() {
		return this.products;
	}
	
	public void addItemcart(ItemCart itemCart) {
		this.products.add(itemCart);
	}
	
	public void deleteItemcart(ItemCart itemCart) {
		this.products.remove(itemCart);
	}

	public CartStatus getCartStatus() {
		return cartStatus;
	}

	public void setCartStatus(CartStatus cartStatus) {
		this.cartStatus = cartStatus;
	}
	
}