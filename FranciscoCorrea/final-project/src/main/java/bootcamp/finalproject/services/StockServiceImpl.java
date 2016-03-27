package bootcamp.finalproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bootcamp.finalproject.entities.Stock;
import bootcamp.finalproject.entities.Stock.State;
import bootcamp.finalproject.repositories.StockRepository;


@Service
public class StockServiceImpl implements StockService {

	@Autowired
	StockRepository stockRepository;
	
	@Override
	public boolean existsStock(long productId, int amount) {
		Stock stock = findByProductIdAndState(productId, Stock.State.PUBLISHED);
		return stock.getAmount() - amount >= 0;
	}

	@Override
	public void recalculateStock(long productId, int amount, boolean subtraction) {
		Stock stock = findByProductIdAndState(productId, Stock.State.PUBLISHED);
		int currentStock = stock.getAmount();
		if(subtraction) {
			stock.setAmount(currentStock - amount);
		} else {
			stock.setAmount(currentStock + amount);
		}
		
		stockRepository.save(stock);
	}

	@Override
	public Stock findByProductIdAndState(long productId, Enum<State> state) {
		return stockRepository.findByProductProductIdAndState(productId, state);
	}

}
