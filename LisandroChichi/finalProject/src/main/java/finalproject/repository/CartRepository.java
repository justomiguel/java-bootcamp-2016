package finalproject.repository;


import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import finalproject.entity.Cart;
@Transactional
@Repository
public interface CartRepository extends CrudRepository<Cart, Long > {

}
