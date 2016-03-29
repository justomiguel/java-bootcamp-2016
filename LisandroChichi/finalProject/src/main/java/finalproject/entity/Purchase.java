package finalproject.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@ApiModel(value = "purchase entity", description = "Complete info of a entity purchase")
@Entity
@Table(name = "Purchase")
public class Purchase {

	@ApiModelProperty(value = "The id of the purchase", required = true)
	@Column(name = "idPucharse", nullable = false)
	@Id
	@GeneratedValue
	private Long idPucharse;

	// @ApiModelProperty(value = "The quatity of the purchase", required = true)
	// private int quantity;

	@ManyToOne
	@JoinColumn(name = "idUser", nullable = false)
	@ApiModelProperty(value = "The user of the purchase", required = true)
	private User user;

	@ApiModelProperty(value = "The total of the purchase", required = true)
	private double total;

	@ApiModelProperty(value = "The detail of the purchase", required = true)
	private String detail;

	public Purchase() {
	}

	public Purchase(User user, double total, String detail) {
		this.user = null;
		this.total = 0;
		this.detail = null;
	}

	public Long getId() {
		return idPucharse;
	}

	public void setId(Long id) {
		this.idPucharse = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	// public int getQuantity() {
	// return quantity;
	// }
	//
	// public void setQuantity(int quantity) {
	// this.quantity = quantity;
	// }

}