package bootcamp.finalproject;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import bootcamp.finalproject.entities.Category;
import bootcamp.finalproject.entities.Product;
import bootcamp.finalproject.entities.Stock;
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
			Category a, b;
			a = categoryRepository.save(new Category("Muebles", "Muebles de madera"));
			b = categoryRepository.save(new Category("Computación", "Articulos de computación"));
			
			productRepository.save(new Product("Cama", new BigDecimal(1500.00), a));
			productRepository.save(new Product("Silla", new BigDecimal(450.25), a));
			productRepository.save(new Product("Notebook", new BigDecimal(6500.50), b));
			
			productRepository.findAll().forEach(
					pro -> { 
						stockRepository.save(new Stock(pro, Stock.State.PUBLISHED, 15));
						stockRepository.save(new Stock(pro, Stock.State.SOLD, 0));
						}
				);
			
		};
	}
	
}
