package finalproject.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import finalproject.entity.Purchase;
@Transactional
@Repository
public interface PurchaseRepository extends CrudRepository<Purchase, Long>{

}
