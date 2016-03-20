package entity;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@ApiModel(value = "Cart entity", description = "Complete info of a entity cart")
@Entity
@Table(name = "cart")
public class Cart {

	@ApiModelProperty(value = "The id of a cart", required = true)
	@Column(name = "id", nullable = false)
	@Id
	@GeneratedValue
	private int id;

	@Transient
	@ApiModelProperty(value = "The products of a cart", required = true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.cart", cascade = CascadeType.ALL)
	@JsonBackReference(value = "cart-cartproducts")
	private List<Product> cartproducts;
	@Transient
	@ApiModelProperty(value = "The user of a cart", required = true)
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	@JoinColumn(name = "iduser", nullable = false)
	// FK
	@JsonIgnore
	private User user;

	public Cart() {

	}

	public Cart(int idcart) {
		this.id = idcart;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Product> getProducts() {
		return cartproducts;
	}

	public void setProducts(List<Product> listProduct) {
		this.cartproducts = listProduct;
	}

}
