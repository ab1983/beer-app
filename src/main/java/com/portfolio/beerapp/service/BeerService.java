package com.portfolio.beerapp.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.beerapp.entity.Beer;
import com.portfolio.beerapp.exception.BeerException;
import com.portfolio.beerapp.repository.BeerDao;
import com.portfolio.beerapp.to.BeerTo;

@Service
public class BeerService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BeerService.class);
	@Autowired
	private BeerDao beerDao;
	
	private List<BigInteger> beerIds;
	
	/**
	 * Method responsible for find a list of beerIds and return one beer randomly.
	 * @return BeerTo
	 * @throws BeerException 
	 */
	public BeerTo nextRandomBeer() throws BeerException {
		try {
			Beer beer = findBeerById(getRandomBeerId());
			BeerTo beerTo = convertToBeer(beer);
			return beerTo;
		} catch (Exception e) {
			String msg = "Error getting a next beer.";
			LOGGER.error(msg, e);
			throw new BeerException(msg);
		}
		
	}
	
	public Beer findBeerById(BigInteger id) throws BeerException {
		if(!getBeerIds().contains(id)) {
			String msg = "ID not found.";
			LOGGER.error(msg);
			throw new BeerException(msg);
		}
		Beer beer = beerDao.findBeerById(id);
		return beer;
	}
	
	/**
	 * Find a list of beerIds and pick one Id randomly from the range.
	 * @return BigInteger beerId
	 */
	public BigInteger getRandomBeerId() {
		List<BigInteger> beerIds = getBeerIds();
		int index = ThreadLocalRandom.current().nextInt(0, beerIds.size());
		BigInteger beerId = beerIds.get(index);
		LOGGER.info("Found a next beer ID:"+beerId);
		return beerId;
	}
	
	public BeerTo convertToBeer(Beer beer) {
		BeerTo beerTo = new BeerTo();
		beerTo.setName(beer.getName());
		beerTo.setDescription(beer.getDescription());
		beerTo.setAbv(beer.getAbv());
		if(beer.getBrevery() != null) {
			StringBuilder location = new StringBuilder();
			location.append(beer.getBrevery().getCity()+ "-" );
			location.append(Objects.toString(beer.getBrevery().getState(),""));
			location.append(" / "+beer.getBrevery().getCountry());
			beerTo.setLocation(location.toString());
		}
		return beerTo;
	}

	/**
	 * Keeping beerIds in memory so that repetitive access to the DB can be avoided.
	 * @return List<BigInteger> beerIds
	 */
	public List<BigInteger> getBeerIds() {
		if(beerIds == null) {
			beerIds = beerDao.findAllBeerIds();
		}		
		return beerIds;
	}

	
}
