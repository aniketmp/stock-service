package no.tusla.stockservice.contract;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import no.tusla.stockservice.controller.StockController;
import no.tusla.stockservice.model.Stock;
import no.tusla.stockservice.service.StockService;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

public class ContractVerifierBase {

    @Mock
    private StockService stockService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(stockService.getAllStocks()).thenReturn(Collections.singletonList(new Stock("Model X", "summer", "stealth",1000.0)));
        Mockito.when(stockService.getStocksByModelAndSeason(Mockito.anyString(), Mockito.anyString())).thenReturn(Collections.singletonList(new Stock("Model X", "summer", "stealth",1000.0)));
        RestAssuredMockMvc.standaloneSetup(new StockController(stockService));
    }
}