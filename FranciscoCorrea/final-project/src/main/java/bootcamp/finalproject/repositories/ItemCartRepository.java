package bootcamp.finalproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import bootcamp.finalproject.entities.Cart;
import bootcamp.finalproject.entities.ItemCart;
import bootcamp.finalproject.entities.Product;

public interface ItemCartRepository extends JpaRepository<ItemCart, Long>{
	void deleteByCartAndProduct(Cart cart, Product product);
}
