package bootcamp.finalproject.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "User Entity", description = "Model for stores the users in the API")
@Entity
@Table(name = "user")
public class User {

	@ApiModelProperty(value = "User Id", required = true)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;
	
	@ApiModelProperty(value = "Username or nickname of the user", required = true)
	@Column(nullable = false, unique = true, length = 25)
	private String nickName;
	
	@ApiModelProperty(value = "Password of the user", required = true)
	@Column(nullable = false, length = 70)
	private String password;
	
	@ApiModelProperty(value = "First Name of the user", required = false)
	@Column(length = 50)
	private String firstName;
	
	@ApiModelProperty(value = "Last name of the user", required = false)
	@Column(length = 50)
	private String lastName;
	
	@ApiModelProperty(value = "Phone of the user", required = false)
	private String phone;
	
	@ApiModelProperty(value = "Email of the user", required = true)
	@Column(nullable = false)
	private String email;
	
	@ApiModelProperty(value = "Adresses of the user", required = true)
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private Set<Address> adreesses;
	
	@ApiModelProperty(value = "Carts belonging to the user", required = false)
	@OneToMany(mappedBy = "user")
	private Set<Cart> carts;
	
	protected User() {}
	
	public User(String nickName, String password, String email) {
		this.nickName = nickName;
		this.password = password;
		this.email = email;
	}

	public void addAddress(Address address) {
		this.adreesses.add(address);
	}
	
	public void deleteAddress(Address address) {
		this.adreesses.remove(address);
	}
	
	public long getUserId() {
		return userId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
