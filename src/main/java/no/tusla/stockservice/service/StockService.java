package no.tusla.stockservice.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import no.tusla.stockservice.model.Stock;
import no.tusla.stockservice.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {

	@Autowired
	private StockRepository stockRepository;

	@Autowired
	private SupplyServiceConsumer supplyServiceConsumer;

	public List<Stock> getStocksByModelAndSeason(String model, String season) {
		List<Stock> stocks = stockRepository.findByModelAndSeason(model, season);
		if (stocks.isEmpty()) {
			System.out.println("Stocks found empty");
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			try {
				return supplyServiceConsumer.getStocks(model, season);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return stocks;
	}

	public List<Stock> getAllStocks() {
		return stockRepository.findAll();

	}

	public void deleteStockById(Long id) {
		stockRepository.delete(id);

	}
}
