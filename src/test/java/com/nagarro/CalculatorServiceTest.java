package com.nagarro;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.nagarro.services.CalculatorService;
import com.nagarro.services.impl.CalculatorServiceImpl;

public class CalculatorServiceTest {

	 CalculatorService calculatorService = new CalculatorServiceImpl();

	    @Test
	    public void testAdd() {
	        double result = calculatorService.add(3.0, 2.0);
	        Assertions.assertEquals(5.0, result);
	    }

	    @Test
	    public void testSubtract() {
	        double result = calculatorService.subtract(5.0, 3.0);
	        Assertions.assertEquals(2.0, result);
	    }

	    @Test
	    public void testMultiply() {
	        double result = calculatorService.multiply(2.0, 3.0);
	        Assertions.assertEquals(6.0, result);
	    }

	    @Test
	    public void testDivide() {
	        double result = calculatorService.divide(6.0, 3.0);
	        Assertions.assertEquals(2.0, result);
	    }

	    
}
