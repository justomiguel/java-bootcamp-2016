package repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import entity.Purchase;
import entity.User;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


}
