package entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "cart_product")
@AssociationOverrides({
		@AssociationOverride(name = "pk.cart", joinColumns = @JoinColumn(name = "idcart")),
		@AssociationOverride(name = "pk.product", joinColumns = @JoinColumn(name = "idproduct")) })
public class Cart_product {

	@ApiModelProperty(required = true)
	@Column(name = "id", nullable = false)
	@Id
	@GeneratedValue
	private int id;
	
	@Transient
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "product")
	private Product product;
	
	
	@ApiModelProperty(value = "The quantity of the product", required = true)
    @Column(name = "quantity", nullable = false)
	private int quantity;
	
	@Transient
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cart")
	@JsonBackReference
	private Cart cart;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

}