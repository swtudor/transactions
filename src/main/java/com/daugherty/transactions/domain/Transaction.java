package com.daugherty.transactions.domain;

import java.time.LocalDate;

public class Transaction {
    private int id;
    private LocalDate date;
    private String name;
    private int amount;
    private Category category;

    public Transaction(){}

    public Transaction(int id, LocalDate date, String name, int amount, Category category) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.amount = amount;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
