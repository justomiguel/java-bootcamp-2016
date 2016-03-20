package entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@ApiModel(value = "Category entity", description = "Complete info of a entity category")
@Entity
@Table(name = "categories")
public class Category {

    @ApiModelProperty(value = "The id of the category", required = true)
    @Column(name = "id", nullable = false)
    @Id
    @GeneratedValue
    private int id;

    @ApiModelProperty(value = "The name of the category", required = true)
    @Column(name = "category", nullable = false)
    private String category;
    @Transient
    @ApiModelProperty(value = "The products belong to a category", required = true)
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category", cascade = { CascadeType.ALL })
    @JsonBackReference(value = "category-products")
    public List<Product> products;

    public Category() {
        // TODO Auto-generated constructor stub
    }

    public Category(int id, String category) {
        this.id = id;
        this.category = category;
    }

    public Category(int idCategory) {
        this.id = idCategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}