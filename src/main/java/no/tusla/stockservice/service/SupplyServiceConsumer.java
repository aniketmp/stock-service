package no.tusla.stockservice.service;

import java.io.IOException;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

import no.tusla.stockservice.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


public class SupplyServiceConsumer {

	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private RestTemplate restTemplate;

	public List<Stock> getStocks(String model, String season)
			throws RestClientException, IOException {
		List<ServiceInstance> instances = discoveryClient.getInstances("supplyservice");
		ServiceInstance serviceInstance = instances.get(0);
		String baseUrl = serviceInstance.getUri().toString();

		baseUrl = baseUrl + "/v1/supply/" + model + "/" + season;
		System.out.println("Supply service URL:" + baseUrl);
		Stock[] json = null;
		try {
			URI uri = UriComponentsBuilder.fromUriString(baseUrl)
					.build()
					.toUri();

			json = restTemplate.getForObject(uri, Stock[].class);

		} catch (Exception ex) {
			System.out.println(ex);
		}

		System.out.println("Response from supply service:" + json);
		return Arrays.asList(json);
	}

}
