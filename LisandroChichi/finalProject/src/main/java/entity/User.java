package entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
import javax.persistence.Transient;

@ApiModel(value = "User entity", description = "Complete info of a entity user")
@Entity
@Table(name = "users")
public class User {

    @ApiModelProperty(value = "The id of the user")
    @Column(name = "id", nullable = false)
    @Id
    @GeneratedValue
    private int id;

    @ApiModelProperty(value = "The name of the user", required = true)
    @Column(name = "name", nullable = false)
    private String name;

    @ApiModelProperty(value = "The lastname of the user", required = true)
    @Column(name = "lastname", nullable = false)
    private String lastname;

    @ApiModelProperty(value = "The address of the user", required = true)
    @Column(name = "address", nullable = false)
    private String address;

    @ApiModelProperty(value = "The phone of the user", required = true)
    @Column(name = "phone", nullable = false)
    private String phone;

    @ApiModelProperty(value = "The username of the user", required = true)
    @Column(name = "username", nullable = false)
    private String username;

    @ApiModelProperty(value = "The password of the user", required = true)
    @Column(name = "password", nullable = false)
    private String password;

    @Transient
    @ApiModelProperty(value = "The purchases belong to an user", required = true)
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = { CascadeType.ALL })
    @JsonIgnore
    public List<Purchase> purchases;

    @Transient
    @ApiModelProperty(value = "The carts belong to a user", required = true)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = { CascadeType.MERGE })
    @JsonIgnore
    public List<Cart> carts;

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(int id, String name, String lastname, String address, String phone, String username, String password) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.phone = phone;
        this.username = username;
        this.password = password;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }

}