package com.daugherty.transactions;

import com.daugherty.transactions.domain.Transaction;
import com.daugherty.transactions.repository.InMemoryTranactionRepository;

public class TransactionsApplication {

	public static void main(String[] args) {
		InMemoryTranactionRepository repo = new InMemoryTranactionRepository();

		for(Transaction transaction: repo.getAll()){
			System.out.println(transaction.getDate() + " " + transaction.getName() + " " + transaction.getAmount() +  " " + transaction.getCategory());
		}
		System.out.println("There are currently " + repo.getAll().stream().filter(transaction -> transaction.getCategory().name().equals("NEEDS")).count() + " transactions labeled as NEEDS stored in total");

	}

}
