package shopingCart;

public class ShoppingCartProxy implements ShoppingCartService{
	
	ShoppingCartService service;

	public ShoppingCartProxy(ShoppingCartService service) {
		this.service = service;
	}

	public Boolean addProduct(Product product) {

		return service.addProduct(product);
	}

	public Boolean updateProduct(String oldName,String newName,double price) {

		return service.updateProduct(oldName,newName,price);
	}

	public Boolean deleteProduct(String name,int qty) {

		return service.deleteProduct(name,qty);
	}

	public Product searchProducts(String name) {

		return service.searchProducts(name);
	}
}