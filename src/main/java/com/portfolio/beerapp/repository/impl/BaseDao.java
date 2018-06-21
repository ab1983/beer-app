package com.portfolio.beerapp.repository.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class BaseDao<T, ID extends Serializable> {


	@PersistenceContext
	EntityManager entityManager;
	
	/**
	 * This method creates a new SimpleJpaRepository which provides JpaRepository functionalities to use in
	 * a custom repository. 
	 * @return SimpleJpaRepository
	 */
	public SimpleJpaRepository<T, ID> getSjr() {
		try {
			return new SimpleJpaRepository<T, ID>((Class<T>) Class.forName(((ParameterizedType) getClass().getGenericSuperclass())
			        .getActualTypeArguments()[0].getTypeName()),entityManager);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}


}