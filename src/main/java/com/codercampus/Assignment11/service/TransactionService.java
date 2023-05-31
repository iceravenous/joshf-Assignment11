package com.codercampus.Assignment11.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;

@Service
public class TransactionService {

	private Map<Integer, Transaction> transaction = new HashMap<>();
	@Autowired
	private TransactionRepository transactionRepository;
	

	public List<Transaction> findAll() {
		return transactionRepository.findAll();
	}


	public Transaction findById(Integer transactionId) {
		return transactionRepository.findById(transactionId-1);
		
	}




}
