package no.tusla.stockservice.controller;

import java.util.List;


import no.tusla.stockservice.service.StockService;
import no.tusla.stockservice.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping(value = "v1")
public class StockController {

  private StockService stockService;

  @Autowired
  public StockController(StockService stockService) {
    this.stockService = stockService;
  }

  @RequestMapping(value = "/stocks/{model}/{season}", method = RequestMethod.GET)
  public List<Stock> getStocksByModelAndSeason(@PathVariable("model") String model,
      @PathVariable("season") String season) {
    return stockService.getStocksByModelAndSeason(model, season);
  }

  @RequestMapping(value = "/stocks/{id}", method = RequestMethod.DELETE)
  public String deleteStocksById(@PathVariable("id") long id) {
    stockService.deleteStockById(id);
    return "Stock Deleted Successfully!";
  }

  @RequestMapping(value = "/stocks/all", method = RequestMethod.GET)
  public List<Stock> getAllStocks() {
    return stockService.getAllStocks();
  }

  @Value("${message:Hello default}")
  private String message;

  @RequestMapping("/message")
  String getMessage() {
    return this.message;
  }

  @GetMapping("/")
  public String index() {
    return "Welcome to Tusla's Stock Service V1!";
  }

}
