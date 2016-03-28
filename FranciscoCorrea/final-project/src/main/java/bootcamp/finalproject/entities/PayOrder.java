package bootcamp.finalproject.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "Pay Order Entity", description = "Pay Order belonging to a purchase of cart")
@Entity
@Table(name = "pay_order")
public class PayOrder {
	
	@ApiModelProperty(value = "Pay Order Id", required = true)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long payOrderId;
	
	@ApiModelProperty(value = "Cart purchased", required = true)
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "cart_id")
	private Cart cart;
	
	@ApiModelProperty(value = "Price of the purchased cart", required = true)
	@Column(nullable = false)
	private double price;
	
	@ApiModelProperty(value = "Date of the purchase of the cart", required = true)
	@Column(nullable = false)
	private Date orderDate;
	
	@ApiModelProperty(value = "Payment Date", required = false)
	private Date paidDate;
	
	protected PayOrder() {}
	
	public PayOrder(Cart cart, double price, Date orderDate) {
		this.cart = cart;
		this.price = price;
		this.orderDate = orderDate;
	}

	public Cart getCart() {
		return cart;
	}
	
	public long getPayOrderId() {
		return payOrderId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getPaidDate() {
		return paidDate;
	}

	public void setPaidDate(Date paidDate) {
		this.paidDate = paidDate;
	}
	
}
