package com.daugherty.transactions;

import com.daugherty.transactions.service.TransactionService;

import java.time.LocalDate;

public class TransactionsApplication {

	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		TransactionService service = new TransactionService();
		System.out.println("Total expenses for " + now.getMonth() + " is: " + service.monthsSumOfTransactions(now.getMonth()));
		System.out.println("Total expenses for " + now.minusMonths(1).getMonth() + " is: " + service.monthsSumOfTransactions(now.minusMonths(1).getMonth()));
		System.out.println("Total expenses for " + now.minusMonths(2).getMonth() + " is: " + service.monthsSumOfTransactions(now.minusMonths(2).getMonth()));
	}

}
