package finalproject.entity;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@ApiModel(value = "Cart entity", description = "Complete info of a entity cart")
@Entity
@Table(name = "cart")
public class Cart {

	@ApiModelProperty(value = "The id of a cart", required = true)
	@Column(name = "idCart", nullable = false)
	@Id
	@GeneratedValue
	private Long idCart;

	@ApiModelProperty(value = "The products of a cart", required = true)
	@OneToMany(targetEntity = Product.class, fetch = FetchType.LAZY, mappedBy = "cart", cascade = CascadeType.ALL)
	private List<Product> products;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idUser")
	@ApiModelProperty(value = "The user of a cart", required = true)
	private User user;


	public Cart() {
		this.products = null;
		this.user = null;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
		return idCart;
	}

	public void setId(Long id) {
		this.idCart = id;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> listProduct) {
		this.products = listProduct;
	}

}
