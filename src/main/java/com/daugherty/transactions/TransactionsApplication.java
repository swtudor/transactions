package com.daugherty.transactions;

import com.daugherty.transactions.domain.Transaction;
import com.daugherty.transactions.repository.InMemoryTranactionRepository;

public class TransactionsApplication {

	public static void main(String[] args) {
		InMemoryTranactionRepository repo = new InMemoryTranactionRepository();

		for(Transaction transaction: repo.getAll()){
			System.out.println(transaction.getId());
		}
	}

}
