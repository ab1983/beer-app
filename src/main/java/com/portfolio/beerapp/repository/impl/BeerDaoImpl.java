package com.portfolio.beerapp.repository.impl;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.portfolio.beerapp.entity.Beer;
import com.portfolio.beerapp.repository.BeerDao;

@Repository
public class BeerDaoImpl extends BaseDao<Beer, BigInteger> implements BeerDao {

	

	@Override
	public List<BigInteger> findAllBeerIds() {
		TypedQuery<BigInteger> tq = this.entityManager.createQuery("select t.id from Beer t", BigInteger.class);
		List<BigInteger> ids = tq.getResultList();
		return ids;
	}

	@Override
	public Beer findBeerById(BigInteger id) {
		return this.getSjr().getOne(id);
	}


}
