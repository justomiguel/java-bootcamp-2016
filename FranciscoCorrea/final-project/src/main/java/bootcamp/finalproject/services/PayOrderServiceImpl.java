package bootcamp.finalproject.services;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bootcamp.finalproject.entities.PayOrder;
import bootcamp.finalproject.repositories.PayOrderRepository;


@Service
public class PayOrderServiceImpl implements PayOrderService {

	@Autowired
	private PayOrderRepository payOrderRepository;
	
	@Override
	public PayOrder savePayOrder(PayOrder payorder) {
		return payOrderRepository.saveAndFlush(payorder);
	}

	@Override
	public void setPaymentDate(Date date) {}

}
