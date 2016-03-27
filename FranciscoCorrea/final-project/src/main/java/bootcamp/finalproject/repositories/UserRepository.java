package bootcamp.finalproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import bootcamp.finalproject.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findByNickName(String nickName);
}
