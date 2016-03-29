package finalProject;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import finalproject.ApplicationMain;
import finalproject.controller.CartController;
import finalproject.controller.CategoryController;
import finalproject.controller.ProductController;
import finalproject.controller.PurchaseController;
import finalproject.controller.UserController;
import finalproject.entity.Cart;
import finalproject.entity.Category;
import finalproject.entity.Product;
import finalproject.entity.User;
import finalproject.repository.ProductRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationMain.class)
@WebAppConfiguration
public class FinalProjectTest {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CartController cartController;
	
	@Autowired
	UserController userController;
		
	@Autowired
	CategoryController categoryController;
	
	@Autowired
	ProductController productController;
	
	@Autowired
	PurchaseController purchaseController;

	private User user;
	
	private User user2;

	private Cart cart;

	private Product product1;

	private Product product2;

	private Category category;


	@Before
	public void loadData() {
		
		
		user = new User();
		user.setLastname("asdasd");
		user.setName("lisandro");
		user.setPassword("asdasd");
		user.setUsername("chicho2000");

		user = userController.createUser(user);
		
		user2 = new User();
		user2.setLastname("Chichi");
		user2.setName("Carlos");
		user2.setPassword("123123");
		user2.setUsername("chicho9999");

		user2 = userController.createUser(user2);
		
		//after login cart Created
		cart = new Cart();
		cart.setUser(user);
		cartController.createCart(cart);


		category = new Category();
		category.setCategory("Books");
		category = categoryController.persistCategory(category);

		product1 = new Product();
		product1.setName("Manzana");
		product1.setPrice(20.00);
		product1.setCategory(category);
		product1.setDescription("asdasdasd");
		product1.setCart(cart);

		product2 = new Product();
		product2.setName("Game of Throne A Dream of Spring ");
		product2.setDescription("Legendary book");
		product2.setPrice(50.00);
		product2.setCategory(category);
		product2.setCart(cart);
		
		/**
		 * added product to cart
		 */

		
		productController.persistProduct(product1);
		productController.persistProduct(product2);

	}

	
	
	@Test
	public void addProductToCartTest() {

		List<Product>allProducts= (List<Product>) productRepository.findAll();
		int productInCart=0;
		for (Product p : allProducts) {
			if (p.getCart().getId().equals(cart.getId())){
				productInCart++;
			}
		}
		    assertTrue(productInCart==2);
		  
	}
	
	@Test
	public void totalPriceOfTheProducts() {
		double total = purchaseController.calcularTotal(cart.getId());
		assertTrue(total==70.00);
		
	}
}