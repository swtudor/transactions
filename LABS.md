# 3-day Java & Spring Workship Labs

## Lab 1:
Download this code, examine it, run it. Add comments throughout to identify some of the things you rememberfrom the morning
review sessions (methods, classes, variables, parameters, datatypes, etc)

## Lab 2:
create a new class in the service package called Evaluator. In that class, create a method that will query the tranactions repo
and return a total of the current months NEEDS. Should return an int

## Lab 3: 
Create a new domain class called Summary. This will have fields for month and total. 
Refactor the Evaluator class so that it will receive a Category and return an ArrayList of Summary objects containing the breakdown
for each category



## Springify
Add the `@SpringBootApplication` annotation above the main method.
Insert `SpringApplication.run(TransactionsApplication.class, args);` into the main method. Run the test `TransactionsApplicationTests.java`. What happens?