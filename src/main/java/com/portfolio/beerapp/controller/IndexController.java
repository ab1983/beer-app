package com.portfolio.beerapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.portfolio.beerapp.exception.BeerException;

@Controller
public class IndexController {
	
	@GetMapping("/")
	public String index() throws BeerException {
		return "index";
	}	

}
