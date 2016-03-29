package finalproject.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@ApiModel(value = "Category entity", description = "Complete info of a entity category")
@Entity
@Table(name = "categories")
public class Category {

	@ApiModelProperty(value = "The id of the category", required = true)
	@Column(name = "idCategory", nullable = false)
	@Id
	@GeneratedValue
	private Long idCategory;

	@ApiModelProperty(value = "The name of the category", required = true)
	private String categoryName;

	@ApiModelProperty(value = "The products belong to a category", required = true)
	@OneToMany(targetEntity = Product.class, fetch = FetchType.EAGER, mappedBy = "category", cascade = { CascadeType.ALL })
	public List<Product> products;

	public Category() {
	}

	public Category(String category, List<Product> products) {
		this.categoryName = null;
		this.products = null;
	}

	public Long getId() {
		return idCategory;
	}

	public void setId(Long id) {
		this.idCategory = id;
	}

	public String getCategory() {
		return categoryName;
	}

	public void setCategory(String category) {
		this.categoryName = category;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}