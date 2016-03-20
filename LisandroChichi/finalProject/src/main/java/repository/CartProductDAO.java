package repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import entity.Cart_product;

@Transactional
@Repository
public interface CartProductDAO extends JpaRepository<Cart_product, Integer> {

    public List<Integer> findByIdCart(int idCart);

}
