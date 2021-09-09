package com.daugherty.transactions.api;

import com.daugherty.transactions.domain.Category;
import com.daugherty.transactions.domain.Transaction;
import com.daugherty.transactions.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @GetMapping("/test")
    String testEndpoint(){
        return "Test Success!";
    }

    @GetMapping
    List<Transaction> getAll(){return transactionService.getAll();}

    @GetMapping("/month/{month}")
    List<Transaction> getAllByMonth(@PathVariable(name="month")String monthName){
        return transactionService.getByMonth(Month.valueOf(monthName.toUpperCase()));
    }

    @GetMapping("/category")
    List<Transaction> getCategory(@RequestParam String category){
        return transactionService.listTransactionsByCategory(Category.valueOf(category.toUpperCase()));
    }

    @GetMapping("sum/{month}")
    ResponseEntity<Integer> getMonthlySum(@PathVariable(name = "month") String monthName,
                                          @RequestParam(required = false) String category){
        try{
            int response;
            if(category == null){
                response =transactionService.sumOfTransactionsByMonth(Month.valueOf(monthName.toUpperCase()));
            }else{
                response = transactionService.sumOfTransactionsByMonth(Month.valueOf(monthName.toUpperCase()), Category.valueOf(category.toUpperCase()));
            }
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/percentage/{month}")
    ResponseEntity<Integer> getMonthlyPercentage(@PathVariable(name="month") String month,
                                                 @RequestParam int income,
                                                 @RequestParam(required = false) String category){
        try{
            int response;
            if(category == null){
                response = transactionService.monthlyPercentageOfIncome(Month.valueOf(month.toUpperCase()), income);
            }else{
                response = transactionService.monthlyPercentageOfIncome(Month.valueOf(month.toUpperCase()), Category.valueOf(category.toUpperCase()), income);
            }return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping
    ResponseEntity<Transaction> create(@RequestBody Transaction transaction){
        if(transaction == null){
            return new ResponseEntity<Transaction>(HttpStatus.BAD_REQUEST);
        }
        try{
            var created =  transactionService.create(transaction);
            if(created.isEmpty()){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<Transaction>(created.get(), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
