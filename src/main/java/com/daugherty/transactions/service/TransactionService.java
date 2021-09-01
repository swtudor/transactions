package com.daugherty.transactions.service;

import com.daugherty.transactions.domain.Category;
import com.daugherty.transactions.domain.Transaction;
import com.daugherty.transactions.repository.InMemoryTransactionRepository;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransactionService {
    private InMemoryTransactionRepository repo = new InMemoryTransactionRepository();

    public List<Transaction> getAll(){
        return repo.getAll();
    }

    public Optional<Transaction> getById(int id){
        return repo.getById(id);
    }

    public Optional<Transaction> create(Transaction transaction){
        return repo.create(transaction);
    }

    public int sumOfTransactionsByMonth(Month month){
        int sum = 0;
        for(Transaction transaction : repo.getByMonth(month)){
            sum += transaction.getAmount();
        }
        return sum;
    }

    public int sumOfTransactionsByMonth(Month month, Category category){
        int sum = 0;
        for(Transaction transaction : repo.getByMonth(month)){
            if(transaction.getTransactionCategory().equals(category)){
                sum += transaction.getAmount();
            }
        }
        return sum;
    }

    public List<Transaction> listTransactionsByCategory(Category category){
        return repo.getAll().stream().filter(transaction -> transaction.getTransactionCategory().equals(category)).collect(Collectors.toList());
    }

    public int monthlyPercentageOfIncomeByCategory(Month month,Category category, int income){
        int categorySum = sumOfTransactionsByMonth(month, category);
        return categorySum * 100 / income;
    }

    public int monthlyPercentageOfIncome(Month month, int income){
        int monthSum = sumOfTransactionsByMonth(month);
        return monthSum * 100 / income;
    }


}
