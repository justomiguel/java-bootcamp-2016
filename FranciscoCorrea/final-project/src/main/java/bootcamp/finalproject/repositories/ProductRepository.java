package bootcamp.finalproject.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import bootcamp.finalproject.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	public Product findByName(String name);
	public Optional<Product> findByProductId(long id);
	public List<Product> findByNameStartingWith(String name);
	public List<Product> findByCategoryName(String category);
}
