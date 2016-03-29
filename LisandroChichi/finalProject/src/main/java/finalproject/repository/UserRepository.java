package finalproject.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import finalproject.entity.User;

@Transactional
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	@Query("select p from User p where p.username = :username")
	public User getUserByUsername(@Param("username")String username);


}
