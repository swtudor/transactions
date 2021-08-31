package com.daugherty.transactions.domain;

import java.time.LocalDate;

public class Transaction {
    private int id;
    private LocalDate transactionDate;
    private String name;
    private int amount;
    private Category transactionCategory;

    public Transaction(){}

    public Transaction(int id, LocalDate transactionDate, String name, int amount, Category transactionCategory) {
        this.id = id;
        this.transactionDate = transactionDate;
        this.name = name;
        this.amount = amount;
        this.transactionCategory = transactionCategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Category getTransactionCategory() {
        return transactionCategory;
    }

    public void setTransactionCategory(Category transactionCategory) {
        this.transactionCategory = transactionCategory;
    }
}
