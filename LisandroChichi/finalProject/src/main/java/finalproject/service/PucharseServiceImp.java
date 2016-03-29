package finalproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import finalproject.entity.Product;
import finalproject.entity.Purchase;
import finalproject.repository.ProductRepository;
import finalproject.repository.PurchaseRepository;

@Component
public class PucharseServiceImp implements PurchaseService {

	@Autowired
	CartService cartService;

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	PurchaseRepository purchaseRepository;

	@Override
	public double calcularTotal(long idCart) {
		double total = 0;
		List<Product> allProducts = (List<Product>) productRepository.findAll();

		for (Product p : allProducts) {
			if (p.getCart().getId().equals(idCart)) {
				total += p.getPrice();
			}
		}

		return total;
	}

	@Override
	public String detalleCompra(long idCart) {
		String detail = "";

		detail += "for cart id: " + idCart;

		List<Product> allProducts = (List<Product>) productRepository.findAll();
		for (Product p : allProducts) {
			if (p.getCart().getId().equals(idCart)) {
				detail += "-- product name: " + p.getName()
						+ "-- product description: " + p.getDescription();
			}
		}
		detail +="--"+ calcularTotal(idCart);
		return detail;
	}

	@Override
	public Purchase persistPurchase(Purchase purchase) {
		return purchaseRepository.save(purchase);
	}

	@Override
	public void removeById(long idPurchase) {
		// TODO Auto-generated method stub
		purchaseRepository.delete(idPurchase);
	}
}
