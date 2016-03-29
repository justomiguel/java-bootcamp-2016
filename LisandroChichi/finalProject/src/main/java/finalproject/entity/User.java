package finalproject.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "User entity", description = "Complete info of a entity user")
@Entity
@Table(name = "user")
public class User {

	@ApiModelProperty(value = "The id of the user")
	@Column(name = "idUser", nullable = false)
	@Id
	@GeneratedValue
	private Long idUser;

	@ApiModelProperty(value = "The name of the user", required = true)
	@Column(name = "name", nullable = false)
	private String firstName;

	@ApiModelProperty(value = "The lastname of the user", required = true)
	@Column(name = "lastname", nullable = false)
	private String lastname;

	@ApiModelProperty(value = "The username of the user", required = true)
	@Column(name = "username", nullable = false)
	private String username;

	@ApiModelProperty(value = "The password of the user", required = true)
	@Column(name = "password", nullable = false)
	private String password;
	

	public User() {
		this.firstName = null;
		this.lastname = null;
		this.username = null;
		this.password = null;
	}
	
	public User(String username, String password) {
	    this.username = username;
	    this.password = password;
	  }

	public Long getId() {
		return idUser;
	}

	public void setId(Long id) {
		this.idUser = id;
	}

	public String getName() {
		return firstName;
	}

	public void setName(String name) {
		this.firstName = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

}