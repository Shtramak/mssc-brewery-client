package com.shtramak.msscbreweryclient.client;

import com.shtramak.msscbreweryclient.model.BeerDto;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
@ConfigurationProperties(prefix = "brewery.client", ignoreUnknownFields = false)
public class BreweryClient {
    private final String BEER_PATH = "/api/v1/beers/";
    @Setter
    private String host;

    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(UUID beerId){
        return restTemplate.getForObject(host + BEER_PATH + beerId, BeerDto.class);
    }
}
