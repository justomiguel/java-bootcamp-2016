package bootcamp.finalproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import bootcamp.finalproject.entities.PayOrder;

public interface PayOrderRepository extends JpaRepository<PayOrder, Long>{

}
