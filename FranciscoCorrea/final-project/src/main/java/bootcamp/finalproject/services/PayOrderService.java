package bootcamp.finalproject.services;

import java.sql.Date;

import bootcamp.finalproject.entities.PayOrder;

public interface PayOrderService {
	PayOrder savePayOrder(PayOrder payOrder);
	void setPaymentDate(Date date);
}
