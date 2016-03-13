package userapi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "User Entity",  description = "Entity that describes an User information")
@Entity
public class User {

	@ApiModelProperty(value = "User's Id", required=true, example = "1")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ApiModelProperty(value = "Username or nickname of an user", required = true, example = "Pepe")
	@NotNull
	@Column(unique=true)
	private String nickName;
	
	@ApiModelProperty(value = "User's password", required = true)
	@NotNull
	private String password;
	
	@ApiModelProperty(value = "User's firstname", required = false, example = "Melina")
	private String firstName;
	
	@ApiModelProperty(value = "User's lastname", required = false, example = "Ballack")
	private String lastname;
	
	protected User() {}
	
	public User(String nickname, String password, String firstname) {
		this.nickName = nickname;
		this.password = password;
		this.firstName = firstname;
	}

	public long getId() {
		return id;
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

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
}
