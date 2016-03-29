package finalproject.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@ApiModel(value = "product entity", description = "Complete info of a entity product")
@Entity
@Table(name = "product")
public class Product {

	@ApiModelProperty(value = "The id of the product")
	@Column(name = "idProduct", nullable = false)
	@Id
	@GeneratedValue
	private Long idProduct;

	@ApiModelProperty(value = "The name of the product", required = true)
	@Column(name = "nameProduct", nullable = false)
	private String nameProduct;

	@ApiModelProperty(value = "The description of the product", required = true)
	@Column(name = "description", nullable = false)
	private String description;

	@ApiModelProperty(value = "The pridce of the product", required = true)
	@Column(name = "price", nullable = false)
	private double price;


	@ManyToOne
	@JoinColumn(name = "idCategory", nullable = false)
	@ApiModelProperty(value = "The category of the product", required = true)
	private Category category;


	@ManyToOne
	@JoinColumn(name = "idCart", nullable = false)
	@ApiModelProperty(value = "The cart where the product is", required = true)
	private Cart cart;

	
	
	public Product() {
		this.nameProduct = null;
		this.description = null;
		this.price = 0;
		this.category = null;
		this.cart = null;
	}

	public Long getId() {
		return idProduct;
	}

	public void setId(Long id) {
		this.idProduct = id;
	}

	public String getName() {
		return nameProduct;
	}

	public void setName(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

}
