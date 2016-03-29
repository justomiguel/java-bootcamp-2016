package finalproject.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import finalproject.entity.Product;

@Transactional
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

	@Query("select p from Product p where p.nameProduct = :name")
	public Product getProductByName(@Param("name")String name);
	@Query("select p from Product p where p.idProduct = :idProduct")
	public List<Product> getProductByCategory(@Param("idProduct")long idProduct);

}
