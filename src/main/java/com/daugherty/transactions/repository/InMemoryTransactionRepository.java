package com.daugherty.transactions.repository;

import com.daugherty.transactions.domain.Category;
import com.daugherty.transactions.domain.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class InMemoryTransactionRepository implements TransactionRepository{
    private static final ArrayList<Transaction> transactionList = new ArrayList<>();

    static{
        resetData();
    }

    @Override
    public List<Transaction> getAll() {
        return transactionList;
    }

    @Override
    public Optional<Transaction> getById(int id) {
        return transactionList.stream().filter(transaction-> transaction.getId() == id).findFirst();
    }

    @Override
    public Optional<Transaction> create(Transaction transaction) {
        var newId = transactionList.size() + 1;
        var newTransaction = new Transaction(newId, LocalDate.now(), transaction.getName(), transaction.getAmount(), transaction.getCategory());
        transactionList.add(newTransaction);

        return getById(newId);
    }

    @Override
    public List<Transaction> getByMonth(Month month) {
        return transactionList.stream().filter(transaction -> transaction.getDate().getMonth().equals(month)).collect(Collectors.toList());
    }


    public static void resetData(){
        LocalDate now = LocalDate.now();
        transactionList.clear();

        transactionList.add(new Transaction(1, now, "Housing", 850, Category.NEEDS));
        transactionList.add(new Transaction(2, now, "Auto", 350, Category.NEEDS));
        transactionList.add(new Transaction(3, now, "Food", 200, Category.NEEDS));
        transactionList.add(new Transaction(4, now, "Utilities", 400, Category.NEEDS));
        transactionList.add(new Transaction(5, now, "Meals Out", 100, Category.WANTS));
        transactionList.add(new Transaction(6, now, "Subscriptions", 100, Category.WANTS));
        transactionList.add(new Transaction(7, now, "Entertainment", 50, Category.WANTS));
        transactionList.add(new Transaction(8, now, "401K", 25, Category.SAVINGS));
        transactionList.add(new Transaction(9, now, "Emergency Fund", 25, Category.SAVINGS));
        transactionList.add(new Transaction(10, now, "Debt", 50, Category.SAVINGS));

        transactionList.add(new Transaction(11, now.minusMonths(1), "Housing", 850, Category.NEEDS));
        transactionList.add(new Transaction(12, now.minusMonths(1), "Auto", 350, Category.NEEDS));
        transactionList.add(new Transaction(13, now.minusMonths(1), "Food", 125, Category.NEEDS));
        transactionList.add(new Transaction(14, now.minusMonths(1), "Utilities", 375, Category.NEEDS));
        transactionList.add(new Transaction(15, now.minusMonths(1), "Meals Out", 25, Category.WANTS));
        transactionList.add(new Transaction(16, now.minusMonths(1), "Subscriptions", 80, Category.WANTS));
        transactionList.add(new Transaction(17, now.minusMonths(1), "Entertainment", 100, Category.WANTS));
        transactionList.add(new Transaction(18, now.minusMonths(1), "401K", 25, Category.SAVINGS));
        transactionList.add(new Transaction(19, now.minusMonths(1), "Emergency Fund", 50, Category.SAVINGS));
        transactionList.add(new Transaction(20, now.minusMonths(1), "Debt", 50, Category.SAVINGS));

        transactionList.add(new Transaction(21, now.minusMonths(2), "Housing", 850, Category.NEEDS));
        transactionList.add(new Transaction(22, now.minusMonths(2), "Auto", 350, Category.NEEDS));
        transactionList.add(new Transaction(23, now.minusMonths(2), "Food", 275, Category.NEEDS));
        transactionList.add(new Transaction(24, now.minusMonths(2), "Utilities", 250, Category.NEEDS));
        transactionList.add(new Transaction(25, now.minusMonths(2), "Meals Out", 50, Category.WANTS));
        transactionList.add(new Transaction(26, now.minusMonths(2), "Subscriptions", 50, Category.WANTS));
        transactionList.add(new Transaction(27, now.minusMonths(2), "Entertainment", 25, Category.WANTS));
        transactionList.add(new Transaction(28, now.minusMonths(2), "401K", 100, Category.SAVINGS));
        transactionList.add(new Transaction(29, now.minusMonths(2), "Emergency Fund", 30, Category.SAVINGS));
        transactionList.add(new Transaction(30, now.minusMonths(2), "Debt", 75, Category.SAVINGS));
    }

}
