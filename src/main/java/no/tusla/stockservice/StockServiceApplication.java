package no.tusla.stockservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;


@EnableDiscoveryClient
@SpringBootApplication
@EnableResourceServer
public class StockServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockServiceApplication.class, args);
	}
	
}


 