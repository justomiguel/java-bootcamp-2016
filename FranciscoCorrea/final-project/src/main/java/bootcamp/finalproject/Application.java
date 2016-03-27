package bootcamp.finalproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import bootcamp.finalproject.entities.Category;
import bootcamp.finalproject.entities.Product;
import bootcamp.finalproject.entities.Stock;
import bootcamp.finalproject.entities.User;
import bootcamp.finalproject.repositories.CategoryRepository;
import bootcamp.finalproject.repositories.ProductRepository;
import bootcamp.finalproject.repositories.StockRepository;
import bootcamp.finalproject.repositories.UserRepository;

@SpringBootApplication
@ComponentScan("bootcamp.finalproject")
public class Application {
	
	public static void main( String[] args ) {
    	SpringApplication.run(Application.class, args);
    }
	
	@Bean
	public CommandLineRunner init(ProductRepository productRepository,
			CategoryRepository categoryRepository, UserRepository userRepository,
			StockRepository stockRepository) {
		return (clr) -> {
			userRepository.save(new User("Tato", "encryptedpass", "email@email.tv"));
			
			Category a, b;
			categoryRepository.save(new Category("Muebles", "Muebles de madera"));
			categoryRepository.save(new Category("Computación", "Articulos de computación"));
			
			a = categoryRepository.findOne((long)1);
			b = categoryRepository.findOne((long)2);
			
			productRepository.save(new Product("Cama", 1500, a));
			productRepository.save(new Product("Silla", 450.25, a));
			productRepository.save(new Product("Notebook", 6500.50, b));
			
			productRepository.findAll().forEach(
					pro -> stockRepository.save(new Stock(pro, Stock.State.PUBLISHED, 15))
				);
			
		};
	}
	
}
