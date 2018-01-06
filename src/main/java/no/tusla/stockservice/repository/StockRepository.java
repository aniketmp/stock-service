package no.tusla.stockservice.repository;

import no.tusla.stockservice.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    List<Stock> findByModelAndSeason(String model, String season);

}