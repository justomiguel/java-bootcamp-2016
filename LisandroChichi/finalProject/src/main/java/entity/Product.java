package entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@ApiModel(value = "product entity", description = "Complete info of a entity product")
@Entity
@Table(name = "products")
public class Product {

    @ApiModelProperty(value = "The id of the product")
    @Column(name = "id", nullable = false)
    @Id
    @GeneratedValue
    private int id;

    @ApiModelProperty(value = "The name of the product", required = true)
    @Column(name = "name", nullable = false)
    private String name;

    @ApiModelProperty(value = "The description of the product", required = true)
    @Column(name = "description", nullable = false)
    private String description;

    @ApiModelProperty(value = "The pridce of the product", required = true)
    @Column(name = "price", nullable = false)
    private double price;

    @Transient
    @ApiModelProperty(value = "The category of the product", required = true)
    @ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
    @JoinColumn(name = "idcategory", nullable = false) // FK
    @JsonManagedReference(value = "category-products")
    private Category category;

    @Transient
    @ApiModelProperty(value = "The carts where the product is", required = true)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.product")
    @JsonBackReference(value = "product-cartproducts")
    private List<Cart_product> cartproducts;

    public Product() {
    }

    
    public Product(int id, String name, String description, double price, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Cart_product> getCartproducts() {
        return cartproducts;
    }

    public void setCartproducts(List<Cart_product> cartproducts) {
        this.cartproducts = cartproducts;
    }

}
