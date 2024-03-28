package com.nagarro.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nagarro.dto.CalculatorRequest;
import com.nagarro.services.CalculatorService;

@Controller
public class CalculatorController {

	@Autowired
	private CalculatorService calculatorService;
	
	@RequestMapping("/")
	public String home() {
		return "calculator.jsp";
	}
	
	@PostMapping("/calculator")
	public ResponseEntity<?> calculate(@RequestBody CalculatorRequest request) {
		double num1 = request.getNum1();
		double num2 = request.getNum2();
		double result = 0;
		String operation = request.getOperation();
		
		try {
			switch (operation) {
			case "add":
				result = calculatorService.add(num1, num2);
				break;
			case "subtract":
				result = calculatorService.subtract(num1, num2);
				break;
			case "multiply":
				result = calculatorService.multiply(num1, num2);
				break;
			case "divide":
				result = calculatorService.divide(num1, num2);
				break;
			default:
				throw new IllegalArgumentException("InvalidOperation");
			}
			BigDecimal roundedResult = BigDecimal.valueOf(result).setScale(3, RoundingMode.HALF_UP);
			return ResponseEntity.ok(roundedResult.toString());
		} catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", ex.getMessage()));
		}
	}
	
}
