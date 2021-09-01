package com.daugherty.transactions.api;

import com.daugherty.transactions.domain.Transaction;
import com.daugherty.transactions.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionController {
    private TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @GetMapping("/transactions")
    List<Transaction> getAll(){return transactionService.getAll();}

}
