package com.shtramak.msscbreweryclient.client;

import com.shtramak.msscbreweryclient.model.BeerDto;
import com.shtramak.msscbreweryclient.model.CustomerDto;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(prefix = "brewery.client", ignoreUnknownFields = false)
public class BreweryClient {
    private final String BEER_PATH = "/api/v1/beers/";
    private final String CUSTOMER_PATH = "/api/v1/customers/";
    @Setter
    private String host;

    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(UUID beerId) {
        return restTemplate.getForObject(host + BEER_PATH + beerId, BeerDto.class);
    }

    public CustomerDto getCustomerById(UUID customerId) {
        return restTemplate.getForObject(host + CUSTOMER_PATH + customerId, CustomerDto.class);
    }

    public URI postBeer(BeerDto beerDto) {
        return restTemplate.postForLocation(host + BEER_PATH, beerDto);
    }

    public URI postCustomer(CustomerDto customerDto) {
        return restTemplate.postForLocation(host + CUSTOMER_PATH, customerDto);
    }

    public void updateBeer(BeerDto beerDto) {
        restTemplate.put(host + BEER_PATH + beerDto.getId(), beerDto);
    }

    public void updateCustomer(CustomerDto customerDto) {
        restTemplate.put(host + CUSTOMER_PATH + customerDto.getId(), customerDto);
    }

    public void deleteBeerById(UUID beerId) {
        restTemplate.delete(host + BEER_PATH + beerId);
    }

    public void deleteCustomerById(UUID customerId) {
        restTemplate.delete(host + CUSTOMER_PATH + customerId);
    }
}
