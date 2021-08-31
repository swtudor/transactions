package com.daugherty.transactions.repository;

import com.daugherty.transactions.domain.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository {
    List<Transaction> getAll();
    Optional<Transaction> getById(int id);
    Optional<Transaction> create(Transaction transaction);
}
