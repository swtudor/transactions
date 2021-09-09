# 3-day Java & Spring Workshop Labs

## Lab 1:
Download this code, examine it, run it. Use comments to identify & label some of the things we discussed in the lecture:
- methods
- variables
- parameters
- classes
- objects
- access modifiers
- etc

Be prepared to show at least three things to the group.

## Lab 2:
In the Main class, write an algorithm that will print the sum of all expenses for the current month. Must show pseudocode even if you don't solve the problem.

*HINTS:* 
- the LocalDate object gives you built in ways to compare months
- you will need looping and conditional logic

##Lab 3: 
Create a new class in the service package called TransactionService. In that class, create a method that will receive a month and return the sum total of expenses for that month.
Replace the logic in the main method by calling your newly created method on the TransactionService and printing the results.
Print the results for this month, last month and two months ago, each on their own line.

This should fulfill the user story: `As a user, I need to see a sum total of all transactions by month` by printing the solution to the command line.

## Lab 4:
As a group, brainstorm some additional functionality for this application. Some ideas to get you  started:
- `As a user, I need to see a sum total of each category by month`
- `As a user, I need to see a list of each category's transactions by month`
- `As a user, I need to see a complete list of each category of transactions`
- `As a user, I need to calculate the percentage of income used by a single category in a month`
- `As a user, I need to calculate the percentage of income used total in a month`

Write a new method for at least one of these user stories. If you get more done, that's amazing! Excellent work!

## Lab 5: Springify
- In the main method of the `TransactionsApplication` class:
    - add the `@SpringBootApplication` annotation *above* the main method.
    - Insert `SpringApplication.run(TransactionsApplication.class, args);` *into* the main method.
    - Run the application. What happens?
    - Remove all the other code you've got in the main method & run again. What changes?
- Run the test `TransactionsApplicationTests`. What happens? Why did this work? Do we see other SpringBoot Annotations in the codebase?

## Lab 6: REST - Get All Transactions
In order to convert to a RESTful service (and to leverage Spring Boot for that), we will need to first add even more annotations.
Adding the annotations to the main method made this a Spring Application and configured it but we're not really using Spring Boot to do anything.
- add the `@Service` annotation to the `InMemoryTransactionRepository` class. **NOTE:** Why is this not marked with an `@Repository` annotation?
- add the `@Service` annotation to the `TransactionService` class. 
- In the `api` package, create a new class called `TransactionController`.
 
In order to create a REST controller, you will need to do a few things.
  - add the `@RestController` annotation above the class header.
  - Inside the `TransactionController` class, create a private `TransactionService` object
  - create a constructor and pass in a `TransactionService` object 
  - Add the annotation `@Autowired` above the constructor. WHat is this annotation doing? Why is it structured like that? 

Now create a single endpoint that returns all the Transactions as a List. 
  - write the method that returns `List<Transaction>` and uses the transactionService to return all the transactions.
  - Add the `@GetMapping("transactions")` annotation above the method signature.
  - Something is missing in these directions... can you figure out why this won't work?

When you have successfully created the method, launch the spring application and put the url `http://localhost:8080/transactions` into your browser.
What happens? (If you have Postman installed, launch it and create a new request for the same url)

##Lab 7: Add More endpoints
Create at least two more endpoints from the list below
- POST: `http://localhost:8080/transactions` - will create a new Transaction and add it to the list (*HINT*: you will need a @RequestBody annotation. Additionally, you may need to return a ResponseEntity object so that you can respond to a bad request body)
- GET: `http://localhost:8080/transactions/category?category=savings` - will filter the transaction list by category (*HINT:* you will need to use the `@RequestParam` annotation to pass in the category. You will also need to think through the conversion of a String to an enum) 
- GET: `http://localhost:8080/transactions/month/august` - will find all transactions for a given month. Note that this uses a `@PathVariable` variable instead of the `@RequestParam` from above

At minimum, write up the pseudocode for the following endpoints. Write them if you have time.
- GET: `http://localhost:8080/transactions/sum/august?category=needs` - will return the sum of all transactions from august with an optional filter for category. 
- GET: `http://localhost:8080/transactions/percentage/august?category=needs&income=3000` - will return the percentage of income used for a month with an optional filter for category

What are some other ways you can add functionality to this application? 

## Lab 8: Testing the service class 
- add junit to your pom.xml:
```xml
<dependency>
  <groupId>org.junit.jupiter</groupId>
  <artifactId>junit-jupiter-engine</artifactId>
  <scope>test</scope>
</dependency>
```
- create two new packages in `com.daugherty.transactions` package (in the test directory):
  - api
  - service
- next create three new classes in those packages:
  - api package ->  `TransactionControllerTest`
  - service package -> `TransactionServiceTest`  
  **NOTE:** the package names are the same as in the src.main.java directory above but that the class names all have Test added to the end. This is a convention, nothing more.

We will begin by writing the first unit tests for the `TransactionService` class. Open your newly created `TransactionServiceTest`. 
- add `@SpringBootTest` and `@TestInstance(TestInstance.Lifecycle.PER_CLASS)` annotations above the class header
- look at the `TransactionService` class and discover what you will need to mock in the unit test.
- add an instance of the object to the test class. Don't forget to add the `@Mock` above the object.
- You will also need to instantiate an object of the `TransactionService` class. Above that, add the `@InjectMocks` annotation.
- create a unit test that will `assertNotNull()` when you call the transactionService.getAll() method.

## Lab 9: Unit testing the API with Mockito
