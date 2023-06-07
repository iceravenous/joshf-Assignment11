package com.codercampus.Assignment11.web;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.service.TransactionService;

@Controller
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/transactions")
	public String getTransactions (ModelMap model) {
		List<Transaction> transactionList = transactionService.findAll();
//		List<Transaction> sortedList = transactionList.stream()
//				.sorted(Comparator.naturalOrder())
//				.collect(Collectors.toList());
		Collections.sort(transactionList, Comparator.comparing(Transaction::getDate));
		Transaction transaction = new Transaction();
		
		
		model.put("transaction", transaction);
		model.put("transactions", transactionList);
		System.out.println(transactionList);

		return "transactions";
	}
	
	@GetMapping("/transactions/{transactionId}")
	public String getATransaction(@PathVariable Integer transactionId, ModelMap model) {
		Transaction transaction = transactionService.findById(transactionId);
		model.put("transaction", transaction);
		System.out.println("Transaction number: " + transactionId);
		System.out.println(transaction);
		return "atransaction";
		
	}
}
