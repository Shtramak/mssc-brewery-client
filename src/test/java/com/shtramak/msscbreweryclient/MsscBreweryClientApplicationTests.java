package com.shtramak.msscbreweryclient;

import com.shtramak.msscbreweryclient.client.BreweryClient;
import com.shtramak.msscbreweryclient.model.BeerDto;
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
    public void getByIdWhenValidRequestReturnsBeerDto() {
        BeerDto beerById = breweryClient.getBeerById(UUID.randomUUID());
        assertNotNull(beerById);
    }

    @Test
    public void postWhenValidRequestReturnsURI(){
        BeerDto beerDto = BeerDto.builder().build();
        URI uri = breweryClient.postBeer(beerDto);
        System.out.println(uri);
    }

    @Test
    public void putWhenValidRequestHasSuccessStatus(){
        BeerDto beerDto = BeerDto.builder().id(UUID.randomUUID()).build();
        breweryClient.updateBeer(beerDto);
    }

    @Test
    public void deleteWhenValidRequestHasSuccessStatus(){
        breweryClient.deleteBeerById(UUID.randomUUID());
    }
}
