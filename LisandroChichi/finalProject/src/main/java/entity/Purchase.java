package entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@ApiModel(value = "purchase entity", description = "Complete info of a entity purchase")
@Entity
@Table(name = "Purchase")
public class Purchase {

	@ApiModelProperty(value = "The id of the purchase", required = true)
	@Column(name = "id", nullable = false)
	@Id
	@GeneratedValue
	private int id;

	@ApiModelProperty(value = "The date of the purchase", required = true)
	@Column(name = "datepurchase", nullable = false)
	private Date datepurchase;

	@ApiModelProperty(value = "The user of the purchase", required = true)
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "iduser", nullable = false)
	private User user;
	

	@ApiModelProperty(value = "The total of the purchase", required = true)
	@Column(name = "total", nullable = false)
	private double total;

	@ApiModelProperty(value = "The detail of the purchase", required = true)
	@Column(name = "detail", nullable = false)
	private String detail;

	public Purchase() {
		// TODO Auto-generated constructor stub
	}

	public Purchase(int id, Date datepurchase, User user, double total,
			String detail) {
		this.id = id;
		this.datepurchase = datepurchase;
		this.user = user;
		this.total = total;
		this.detail = detail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatepurchase() {
		return datepurchase;
	}

	public void setDatepurchase(Date datepurchase) {
		this.datepurchase = datepurchase;
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

}