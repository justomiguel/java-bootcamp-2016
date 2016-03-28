package bootcamp.finalproject.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Products categories", description = "Categories of every product in stock")
@Entity
@Table(name = "category")
public class Category {

	@ApiModelProperty(value = "Category Id", required = true)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long categoryId;
	
	@ApiModelProperty(value = "Name of the category", required = true, example = "Computacion")
	@Column(nullable = false, length = 50, unique = true)
	private String name;
	
	@ApiModelProperty(value = "Description of the category", required = false)
	private String description;
	
	@ApiModelProperty(value = "Products belonging to the category", required = false)
	@OneToMany(mappedBy = "category")
	private Set<Product> products;
	
	protected Category(){}
	
	public Category(String name) {
		this.name = name;
	}
	
	public Category(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public long getCategoryId() {
		return categoryId;
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
	
	
}
