package bootcamp.finalproject.entities;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Product Entity", description = "Products published for add to cart")
@Entity
@Table(name = "product")
public class Product {
	
	@ApiModelProperty(value = "Product's Id", required = true) 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long productId;
	
	@ApiModelProperty(value = "Name of the product", required = true)
	@Column(nullable = false, length = 50)
	private String name;
	
	@ApiModelProperty(value = "Product description", required = false)
	private String description;
	
	@ApiModelProperty(value = "Price of the product", required = true)
	@JsonSerialize(using = PriceSerializer.class)
	@JsonDeserialize(using = PriceDeserializer.class)
	@Column(nullable = false)
	private BigDecimal price;
	
	@ApiModelProperty(value = "Category of the product", required = true)
	@ManyToOne
	@JoinColumn(name = "category_fk", nullable = false)
	private Category category;
	
	@ApiModelProperty(value = "Stock of the product", required= true)
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	private List<Stock> stocks;
	
	@ApiModelProperty(value = "Carts that the product belongs", required = false)
	@JsonIgnore
	@OneToMany(mappedBy = "product", cascade = CascadeType.MERGE)
	private Set<ItemCart> cart = new HashSet<ItemCart>();
	
	protected Product() {}
	
	public Product(String name, BigDecimal price) {
		this.name = name;
		this.price = price;
	}
	
	public Product(String name, BigDecimal price, Category category) {
		this.name = name;
		this.price = price;
		this.category = category;
	}
	
	public void addToCart(ItemCart itemCart) {
		this.cart.add(itemCart);
	}
	
	public void deleteFromCart(ItemCart itemCart) {
		this.cart.remove(itemCart);
	}

	public long getProductId() {
		return productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Product) {
			Product otherProduct = (Product) obj;
			return otherProduct.getProductId() == this.getProductId();
		}
		return false;
	}
	
}
