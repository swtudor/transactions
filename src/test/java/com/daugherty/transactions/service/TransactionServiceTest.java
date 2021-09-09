package com.daugherty.transactions.service;

import com.daugherty.transactions.domain.Category;
import com.daugherty.transactions.domain.Transaction;
import com.daugherty.transactions.repository.InMemoryTransactionRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public class TransactionServiceTest {
    ArrayList<Transaction> transactionList = new ArrayList<>();
    LocalDate now = LocalDate.now();

    @Mock
    private InMemoryTransactionRepository mockRepo;

    @InjectMocks
    private TransactionService mockService = new TransactionService(mockRepo);

    @BeforeAll
    public void setUp(){
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
        when(mockRepo.getAll()).thenReturn(transactionList);
        when(mockRepo.getByMonth(now.getMonth())).thenReturn(transactionList);

    }

    @AfterAll
    public void tearDown(){
        transactionList.clear();
    }
    @Test
    public void assertRepoInstantiated(){
        assertNotNull(mockService.getAll());
    }

    @Test
    public void testSumOfTransactionsByMonth_happyPath(){
        int actual = mockService.sumOfTransactionsByMonth(LocalDate.now().getMonth());
        assertEquals(2150, actual);
    }

}
