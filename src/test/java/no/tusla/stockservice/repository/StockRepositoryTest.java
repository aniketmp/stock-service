package no.tusla.stockservice.repository;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import no.tusla.stockservice.model.Stock;


/*@RunWith(SpringRunner.class)
@DataJpaTest
public class StockRepositoryTest {
 
      @Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private StockRepository stockRepository;
    
    @Test
	public void contextLoads() {
	}
    
    @Test
    public void whenFindByName_thenReturnEmployee() {
        // given
        Stock stock = new Stock("Model X","summer","premier",(double) 200);
        entityManager.persist(stock);
        entityManager.flush();
     
        // when
        List<Stock> found = stockRepository.findByModelAndSeason(stock.getModel(), stock.getSeason());
     
        // then
        //check empty list    assertThat(found, not(IsEmptyCollection.empty()));
    }

}*/
