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

_HINTS:_ 
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
- In the main method of the `TransactionsApplication.java` class:
    - add the `@SpringBootApplication` annotation *above* the main method.
    - Remove all the other code you've got in the main method
    - Insert `SpringApplication.run(TransactionsApplication.class, args);` *into* the main method.
- Run the test `TransactionsApplicationTests.java`. What happens?