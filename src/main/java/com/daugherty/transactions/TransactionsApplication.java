package com.daugherty.transactions;

import com.daugherty.transactions.domain.Category;
import com.daugherty.transactions.service.TransactionService;

import java.time.LocalDate;

public class TransactionsApplication {

	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		TransactionService service = new TransactionService();

		// Lab 3, print the last three months total expenses
		System.out.println("Total expenses for " + now.getMonth() + " is: " + service.sumOfTransactionsByMonth(now.getMonth()));
		System.out.println("Total expenses for " + now.minusMonths(1).getMonth() + " is: " + service.sumOfTransactionsByMonth(now.minusMonths(1).getMonth()));
		System.out.println("Total expenses for " + now.minusMonths(2).getMonth() + " is: " + service.sumOfTransactionsByMonth(now.minusMonths(2).getMonth()));

		// Lab 4: add lot's of functionality
		int needsPercentage = service.monthlyPercentageOfIncomeByCategory(now.getMonth(), Category.NEEDS, 2300);
		System.out.println("Needs is "+ needsPercentage +"% of "+ now.getMonth() +  " income");
		System.out.println("Used: " + service.monthlyPercentageOfIncome(now.getMonth(), 2300) +"% of "+ now.getMonth() +  " income");

	}

}
