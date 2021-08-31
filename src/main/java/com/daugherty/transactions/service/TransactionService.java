package com.daugherty.transactions.service;

import com.daugherty.transactions.domain.Transaction;
import com.daugherty.transactions.repository.InMemoryTranactionRepository;

import java.time.Month;

public class TransactionService {
    private InMemoryTranactionRepository repo = new InMemoryTranactionRepository();

    public int monthsSumOfTransactions(Month month){
        int sum = 0;
        for(Transaction transaction : repo.getByMonth(month)){
            sum += transaction.getAmount();
        }
        return sum;
    }
}
