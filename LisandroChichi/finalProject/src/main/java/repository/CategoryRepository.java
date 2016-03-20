package repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import entity.Category;
import entity.Purchase;

@Transactional
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
