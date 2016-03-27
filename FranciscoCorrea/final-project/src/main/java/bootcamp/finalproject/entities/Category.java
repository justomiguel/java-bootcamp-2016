package bootcamp.finalproject.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long categoryId;
	
	@Column(nullable = false, length = 50, unique = true)
	private String name;
	private String description;
	
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
