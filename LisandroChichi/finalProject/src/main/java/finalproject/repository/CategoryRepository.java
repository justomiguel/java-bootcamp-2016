package finalproject.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import finalproject.entity.Category;

@Transactional
@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
