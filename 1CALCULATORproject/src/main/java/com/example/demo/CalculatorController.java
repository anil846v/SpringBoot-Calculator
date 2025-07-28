package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
	@Autowired
	CalculatorService calculator;
	
	@GetMapping("/")
	public String prompt() {
		return "prompt";
	}
	//HERE BY DEFAULT THE METHOD IS SET AS GET WE WILL CHANGE IT TO GET IF WE WANT

	@PostMapping("/gotresult")
	public String calculate(@RequestParam("n1") double n1,@RequestParam("n2") double n2,@RequestParam("operation") String operation,Model m) {
		double result = 0;
		switch(operation) {
		case "ADDITION":
			 result = calculator.addition(n1, n2);
			break;
		case "SUBTRACTION":
			result  = calculator.subtraction(n1, n2);
			break;
		case "MULTIPLICATION":
			result = calculator.multiplication(n1, n2);
			break;
		case "DIVISION":
			if(n2 != 0) {
				result = calculator.division(n1, n2);
		}
			else {
				m.addAttribute("error","divide by 0 is not possible" );
				m.addAttribute("n1",n1);
			m.addAttribute("n2",n2);
			return "Error";
		}
			break;
		case "mod":
			result = calculator.modulus(n1, n2);
			break;
			default:
				m.addAttribute("error","Invalid Operation");
				return "Error";
		}
			m.addAttribute("n1",n1);
			m.addAttribute("n2",n2);
			m.addAttribute("operation",operation);
			m.addAttribute("result",result);
		
		return "result";		
	}
}

