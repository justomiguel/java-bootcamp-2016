package bootcamp.finalproject.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import bootcamp.finalproject.entities.Cart;
import bootcamp.finalproject.entities.Cart.CartStatus;

public interface CartRepository extends JpaRepository<Cart, Long> {
	public Optional<Cart> findByUserNickNameAndCartStatus(String nickName, Enum<CartStatus> status);
}
