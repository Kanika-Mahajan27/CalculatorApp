package com.nagarro.services.impl;

import org.springframework.stereotype.Service;

import com.nagarro.services.CalculatorService;

@Service
public class CalculatorServiceImpl implements CalculatorService {

	@Override
	public double add(double a, double b) {
		return a+b;
	}

	@Override
	public double subtract(double a, double b) {
		return a-b;
	}

	@Override
	public double multiply(double a, double b) {
		return a*b;
	}

	@Override
	public double divide(double a, double b) {

			return a/b;	
	}	
}
