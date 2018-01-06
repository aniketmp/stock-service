package no.tusla.stockservice.repository;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import no.tusla.stockservice.model.Stock;

import no.tusla.stockservice.model.json.Model;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class StockRepositoryPopulator implements ApplicationListener<ContextRefreshedEvent>,
    ApplicationContextAware {

  private final Resource sourceData;

  private ApplicationContext applicationContext;

  public StockRepositoryPopulator() {
    sourceData = new ClassPathResource("tires-in-storage.json");
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = applicationContext;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    if (event.getApplicationContext().equals(applicationContext)) {
      JpaRepository stockRepository =
          BeanFactoryUtils.beanOfTypeIncludingAncestors(applicationContext, JpaRepository.class);

      if (stockRepository != null && stockRepository.count() == 0) {
        populate(stockRepository);
      }
    }

  }

  @SuppressWarnings("unchecked")
  public void populate(JpaRepository repository) {
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    Model model = null;

    try {
      model = mapper.readValue(sourceData.getInputStream(), Model.class);
    } catch (IOException e) {
      e.printStackTrace();
    }

    if (model != null) {
      model.getModelX().stream()
          .forEach(modelx -> {
                repository.save(new Stock("Model X", modelx.getSeason(), modelx.getTiremodel(),
                    Double.parseDouble(modelx.getPrice())));
              }
          );
      model.getModelY().stream()
          .forEach(modely -> {
                repository.save(new Stock("Model Y", modely.getSeason(), modely.getTiremodel(),
                    Double.parseDouble(modely.getPrice())));
              }
          );
      model.getModelZ().stream()
          .forEach(modelz -> {
                repository.save(new Stock("Model Z", modelz.getSeason(), modelz.getTiremodel(),
                    Double.parseDouble(modelz.getPrice())));
              }
          );
    }
    System.out.println("Records inserted successfully!");
  }

}