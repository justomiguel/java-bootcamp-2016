package userapi;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<List<User>> findByFirstName(String firstName);
	Optional<User> findByNickName(String nickName);
}
