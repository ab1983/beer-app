package com.portfolio.beerapp.exception;

public class BeerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BeerException(String message) {
		super(message);
	}

	public BeerException(String message, Throwable e) {
		super(message, e);
	}
}
