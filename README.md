#Solution Description

###Problem
   
You own a paint factory. There are N different colors you can mix, and each color can be prepared "matte" or "glossy".
So, you can make 2N different types of paint.
Each of your customers has a set of paint types they like, and they will be satisfied if you have at least one of those types prepared. 
At most one of the types a customer likes will be a "matte".
You want to make N batches of paint, so that:
* There is exactly one batch for each color of paint, and it is either matte or glossy.
* For each customer, you make at least one paint type that they like.
* The minimum possible number of batches are matte (since matte is more expensive to make).
* Find whether it is possible to satisfy all your customers given these constraints, and if it is, what paint types you should make.
* If it is possible to satisfy all your customers, there will be only one answer which minimizes the number of matte batches.

###Input

C the number of test cases in the input file.
For each test case, there will be:
* integer N, the number of paint colors.
* integer M, the number of customers.

M lines, one for each customer, each containing:
* integer T >= 1, the number of paint types the customer likes;
* T pairs of integers "X Y", one for each type the customer likes, where:
    * X is the paint color between 1 and N inclusive, 
    * Y is either 0 to indicate glossy, or 1 to indicated matte. 

###Output

C lines, one for each test case in the order they occur in the input file, 
each containing the string ```"Case #X: "```
where X is the number of the test case, starting from 1, followed by:
* The string "IMPOSSIBLE", if the customers' preferences cannot be satisfied; 
* OR N space-separated integers, one for each color from 1 to N, which are 
    * 0 if the corresponding paint should be prepared glossy, 
    * 1 if it should be matte.

###Assumptions 

* Application used Java 8 and maven;
* Simple solution as possible;
* No pair will occur more than once for a single customer;
* Each customer will have at least one color that they like (T >= 1);
* Each customer will like at most one matte color. (At most one pair for each customer has Y = 1);
* The largest dataset contain:
    * C = 5
    * 1 <= N <= 2000
    * 1 <= M <= 2000
* Minimize the number of mattes

### Build, run and test the application

To build and test in the console: 

    $ maven clean test package
    
For help use this command:

    java -jar ./target/paintshop-1.0-SNAPSHOT-jar-with-dependencies.jar --help

To run the application

    java -jar ./target/paintshop-1.0-SNAPSHOT-jar-with-dependencies.jar testcases.file > output.file

Keep mind that input file and output file is not mandatory. 
If options isn't provided, the console input and output will be used.


###Algorithm

The algorithm has the following steps:

* Start solution with all colors are glossy.
* Iterate through all customers:
    * If a customer can be satisfied by changing a color to matte, do it. Iterate through all customers again.
    * If a customer cannot be satisfied by swapping a color to matte return there is no solution.
* If all customers are satisfied by the solution return solution, otherwise iterate through all customers again.

Time complexity: ```O(M * N)```
Memory complexity: ~```N*4b + N*M*4b```
    Where N: number of colors
          M: number of customers

