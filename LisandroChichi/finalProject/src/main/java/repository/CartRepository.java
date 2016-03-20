package repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import entity.Cart;
import entity.Category;

@Transactional
@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

}
