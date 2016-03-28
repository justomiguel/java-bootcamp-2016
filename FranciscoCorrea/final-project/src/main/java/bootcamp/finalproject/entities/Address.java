package bootcamp.finalproject.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Address Entity", description = "Address for a User")
@Entity
@Table(name = "address")
public class Address {

	@ApiModelProperty(value = "Address's Id", required = true)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long addressId;
	
	@ApiModelProperty(value = "User who has the address", required = true)
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_fk", nullable = false)
	private User user;
	
	@ApiModelProperty(value = "Street where lives the customer", required = true, example = "Av. Marconi")
	@Column(nullable = false)
	private String street;
	
	@ApiModelProperty(value = "Number of the Street", required = true, example = "505")
	@Column(nullable = false)
	private String streetNumber;
	
	@ApiModelProperty(value = "City where lives the customer", required = false, example = "Resistencia")
	private String city;
	
	@ApiModelProperty(value = "Zip Code of the city", required = false, example = "3500")
	private int zipCode;
	
	protected Address() {}
	
	public Address(User user, String street, String sNumber, String city) {
		this.user = user;
		this.street = street;
		this.streetNumber = sNumber;
		this.city = city;
	}

	public long getAddressId() {
		return addressId;
	}

	public User getUser() {
		return user;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	
}
