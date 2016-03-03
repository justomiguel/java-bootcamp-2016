package shopingCart;


public interface ShoppingCartService {

	public Boolean addProduct(Product product);
	public Boolean deleteProduct(String name,int qty);
	public Boolean updateProduct(String oldName,String newName,double price);
	public Product searchProducts(String name);
	
	
}