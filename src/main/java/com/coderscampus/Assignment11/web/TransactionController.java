package com.coderscampus.Assignment11.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TransactionController {

	
	
	
	
	@GetMapping("")
	public String getTransactions () {
		
//		model.put("transactions", model);
		
		return "transactions";
	}
}
