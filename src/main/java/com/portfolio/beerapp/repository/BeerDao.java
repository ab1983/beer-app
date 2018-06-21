package com.portfolio.beerapp.repository;

import java.math.BigInteger;
import java.util.List;

import com.portfolio.beerapp.entity.Beer;

public interface BeerDao {
	public List<BigInteger> findAllBeerIds();
	public Beer findBeerById(BigInteger id);
}
