package repository;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import entity.Cart_product;
import entity.Category;
import entity.Product;
import entity.Purchase;

@Transactional
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	public List<Product> findByCategory(Category category);

	public List<Product> findByName(String name);

	public Product findById(int id);
}
