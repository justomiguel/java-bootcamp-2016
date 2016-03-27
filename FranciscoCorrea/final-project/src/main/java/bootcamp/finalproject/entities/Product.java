package bootcamp.finalproject.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long productId;
	
	@Column(nullable = false, length = 50)
	private String name;
	private String description;
	
	@Column(nullable = false)
	private double price;
	
	@ManyToOne
	@JoinColumn(name = "category_fk", nullable = false)
	private Category category;
	
	@OneToMany(mappedBy = "product")
	private List<Stock> stocks;
	
	@OneToMany(mappedBy = "product")
	private Set<ItemCart> cart = new HashSet<ItemCart>();

	protected Product() {}
	
	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	public Product(String name, double price, Category category) {
		this.name = name;
		this.price = price;
		this.category = category;
	}

	public long getProductId() {
		return productId;
	}
	
	public Set<ItemCart> getCart() {
		return this.cart;
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
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Product) {
			Product otherProduct = (Product) obj;
			return otherProduct.getProductId() == this.getProductId();
		}
		return false;
	}
	
	
}
