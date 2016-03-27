package bootcamp.finalproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import bootcamp.finalproject.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
