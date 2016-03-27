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

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long addressId;
	
	@JsonIgnore /*why?*/
	@ManyToOne
	@JoinColumn(name = "user_fk", nullable = false)
	private User user;
	
	@Column(nullable = false)
	private String street;
	
	@Column(nullable = false)
	private String streetNumber;
	private String city;
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
