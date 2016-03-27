package bootcamp.finalproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import bootcamp.finalproject.entities.Stock;
import bootcamp.finalproject.entities.Stock.State;

public interface StockRepository extends JpaRepository<Stock, Long>{
	public Stock findByProductProductIdAndState(long productId, Enum<State> state);
}
