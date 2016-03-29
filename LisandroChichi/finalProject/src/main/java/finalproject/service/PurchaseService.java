package finalproject.service;

import finalproject.entity.Purchase;

public interface PurchaseService {

	public double calcularTotal(long idCart);
	
	public String detalleCompra(long idCart);

	public Purchase persistPurchase(Purchase purchase);
	
	public void removeById(long idPurchase);
	
}
