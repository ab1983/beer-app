package com.portifolio.beerapp;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.portfolio.beerapp.AppTestConfig;
import com.portfolio.beerapp.entity.Beer;
import com.portfolio.beerapp.exception.BeerException;
import com.portfolio.beerapp.service.BeerService;
import com.portfolio.beerapp.to.BeerTo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={AppTestConfig.class})
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application.properties")
@DataJpaTest 
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Transactional
public class BeerAppApplicationTests {

	@Autowired
	private BeerService beerService;
	
	
	@Test
	public void nextRandomBeerTest() {
		try {
			BigInteger id = beerService.getRandomBeerId();
			assertNotNull("getRandomBeerId not null", id);
			
			Beer beer = beerService.findBeerById(id);
			assertNotNull("findBeerById not null", beer);
			
			BeerTo beerTo = beerService.convertToBeer(beer);
			assertNotNull("convertToBeer not null", beerTo);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	public void getRandomBeerIdTest() {
		BigInteger id = beerService.getRandomBeerId();
		assertTrue("getRandomBeerIdTest is contained in BeerIds", beerService.getBeerIds().contains(id));		
	}
	
	@Test(expected=BeerException.class)
	public void findBeerByIdErrorTest() throws BeerException {
		beerService.findBeerById(BigInteger.valueOf(-1));
	}	
	

}
