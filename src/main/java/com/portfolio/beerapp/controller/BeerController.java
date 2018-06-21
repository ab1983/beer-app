package com.portfolio.beerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.portfolio.beerapp.exception.BeerException;
import com.portfolio.beerapp.service.BeerService;
import com.portfolio.beerapp.to.BeerTo;

@Controller
@RequestMapping("/api/beer/")
public class BeerController {
	
	@Autowired
	private BeerService beerService;
	
	/**
	 * API method to find a new random beer from the datasource.
	 * @return BeerTo
	 * @throws BeerException
	 */
	@GetMapping(value = "/next-random")
	@ResponseBody
	public BeerTo nextRandom() throws BeerException {
		return beerService.nextRandomBeer();
	}	

}
