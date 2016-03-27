package bootcamp.finalproject.services;

import bootcamp.finalproject.entities.Stock;
import bootcamp.finalproject.entities.Stock.State;

public interface StockService {
	
	boolean existsStock(long productId, int amount);
	void recalculateStock(long productId, int amount, boolean subtraction);
	Stock findByProductIdAndState(long productId, Enum<State> state);
}
