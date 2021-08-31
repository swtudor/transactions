package com.daugherty.transactions;

import com.daugherty.transactions.domain.Transaction;
import com.daugherty.transactions.repository.InMemoryTranactionRepository;

import java.time.LocalDate;

public class TransactionsApplication {

	public static void main(String[] args) {
		InMemoryTranactionRepository repo = new InMemoryTranactionRepository();

		for(Transaction transaction: repo.getAll()){
			System.out.println(transaction.getTransactionDate() + " " + transaction.getName() + " " + transaction.getAmount() +  " " + transaction.getTransactionCategory());
		}
		System.out.println("There are currently " + repo.getAll().stream().filter(transaction -> transaction.getTransactionCategory().name().equals("NEEDS")).count() + " transactions labeled as NEEDS stored in total");

		int sum = 0;
		LocalDate now = LocalDate.now();
		for(Transaction transaction : repo.getAll()){
			if(transaction.getTransactionDate().getMonthValue() == now.getMonthValue()){
				sum = sum + transaction.getAmount();
			}
		}
		System.out.println("Total expenses for " + now.getMonth() + " is: "+sum);
	}

}
