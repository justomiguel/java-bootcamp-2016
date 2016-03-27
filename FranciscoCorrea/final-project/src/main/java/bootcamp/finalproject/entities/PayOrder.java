package bootcamp.finalproject.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "pay_order")
public class PayOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long payOrderId;
	
	@Column(nullable = false)
	private double price;
	
	@Column(nullable = false)
	private Date orderDate;
	
	private Date paidDate;
	
	protected PayOrder() {}
	
	public PayOrder(double price, Date orderDate) {
		this.price = price;
		this.orderDate = orderDate;
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
