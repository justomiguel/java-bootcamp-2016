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


@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;
	
	@Column(nullable = false, unique = true, length = 25)
	private String nickName;
	
	@Column(nullable = false, length = 70)
	private String password;
	@Column(length = 50) private String firstName;
	@Column(length = 50) private String lastName;
	private String phone;
	
	@Column(nullable = false)
	private String email;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private Set<Address> adreesses;
	
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
