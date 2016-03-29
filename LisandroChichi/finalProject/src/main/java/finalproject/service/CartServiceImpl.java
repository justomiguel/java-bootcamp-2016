package finalproject.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import finalproject.entity.Cart;
import finalproject.repository.CartRepository;
import finalproject.repository.ProductRepository;
import finalproject.repository.UserRepository;

@Component
public class CartServiceImpl implements CartService{
	
	
	@Autowired
	CartRepository cr;
	@Autowired
	ProductRepository pr;
	@Autowired
	UserRepository us;
	

	@Override
	public Cart persistCart(Cart cart) {
		return cr.save(cart);
	}

	@Override
	public void deleteCart(long idCart) {
		cr.delete( idCart);
		
	}

	
	@Override
	public Cart findCartByID(long id) {
		return cr.findOne(id);
		
	}


	
	
	
}
