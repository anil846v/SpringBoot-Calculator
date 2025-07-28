package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
	
	double addition(double n1,double n2) {
		return (n1 + n2);
	}
	double subtraction(double n1,double n2) {
		return (n1 - n2);
	}
	double multiplication(double n1,double n2) {
		return (n1 * n2);
	}
	double division(double n1,double n2) {
		if(n2 == 0) {
			throw new ArithmeticException("division by zero not poassible");
		}
		return (n1 / n2);
	}
	public double modulus(double n1,double n2) {
		return n1 % n2;
	}
}
