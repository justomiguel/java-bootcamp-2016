package service;

import product.Product;

public class ShoppingCartWebService implements ShoppingCartService{
	
	ShoppingCartService service = new ShoppingCartImp();

	public Boolean addProduct(Product product) {
		try{
		service.addProduct(product);
		}catch(Exception e){
			e.getMessage();
		}
		return true;
	}

	public Boolean deleteProduct(String name, int qty) {
		// TODO Auto-generated method stub
		service.deleteProduct(name, qty);
		return true;
	}

	public void updateProduct(String oldName, String newName, double price) {
		// TODO Auto-generated method stub
		service.updateProduct(oldName, newName, price);
	}

	public Product searchProducts(String name) {
		return service.searchProducts(name);
	}

}