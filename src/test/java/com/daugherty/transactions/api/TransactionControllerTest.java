package com.daugherty.transactions.api;

import com.daugherty.transactions.domain.Category;
import com.daugherty.transactions.domain.Transaction;
import com.daugherty.transactions.service.TransactionService;
import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TransactionControllerTest {
    ArrayList<Transaction> transactionList = new ArrayList<>();
    LocalDate now = LocalDate.now();
    String baseUrl;

    @LocalServerPort
    private int port;

    @Mock
    private TransactionService mockService;

    @InjectMocks
    private TransactionController mockController = new TransactionController(mockService);

    @Autowired
    private MockMvc mockMvc;

    @BeforeAll
    public void setUp(){
        // populate baseUrl
        baseUrl = "http://localhost:"+port + "/transactions";

        // stub the list
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
        when(mockService.getAll()).thenReturn((transactionList));
    }

    @Test
    public void wireTest() throws Exception{
        mockMvc.perform(get(baseUrl+"/test"))
                .andExpect(status().isOk());
    }

    @Test
    public void getAllTest() throws Exception{
        MvcResult result = mockMvc.perform(get(baseUrl))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertNotNull(result);
    }


}
