package com.shtramak.msscbreweryclient;

import com.shtramak.msscbreweryclient.client.BreweryClient;
import com.shtramak.msscbreweryclient.model.BeerDto;
import com.shtramak.msscbreweryclient.model.CustomerDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.util.UUID;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MsscBreweryClientApplicationTests {

    @Autowired
    BreweryClient breweryClient;

    @Test
    public void getBeerByIdWhenValidRequestReturnsBeerDto() {
        BeerDto beerById = breweryClient.getBeerById(UUID.randomUUID());
        assertNotNull(beerById);
    }

    @Test
    public void postBeerWhenValidRequestReturnsURI(){
        BeerDto beerDto = BeerDto.builder().build();
        URI uri = breweryClient.postBeer(beerDto);
        System.out.println(uri);
    }

    @Test
    public void updateBeerWhenValidRequestHasSuccessStatus(){
        BeerDto beerDto = BeerDto.builder().id(UUID.randomUUID()).build();
        breweryClient.updateBeer(beerDto);
    }

    @Test
    public void deleteBeerWhenValidRequestHasSuccessStatus(){
        breweryClient.deleteBeerById(UUID.randomUUID());
    }

    @Test
    public void getCustomerByIdWhenValidRequestReturnsBeerDto() {
        CustomerDto customerDto = breweryClient.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDto);
    }

    @Test
    public void postCustomerWhenValidRequestReturnsURI(){
        CustomerDto customerDto = CustomerDto.builder().build();
        URI uri = breweryClient.postCustomer(customerDto);
        System.out.println(uri);
    }

    @Test
    public void updateCustomerWhenValidRequestHasSuccessStatus(){
        CustomerDto customerDto = CustomerDto.builder().id(UUID.randomUUID()).build();
        breweryClient.updateCustomer(customerDto);
    }

    @Test
    public void deleteWhenValidRequestHasSuccessStatus(){
        breweryClient.deleteCustomerById(UUID.randomUUID());
    }
}
