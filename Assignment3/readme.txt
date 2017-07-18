Assignment 3

Problem 1
Write your code in the file Taxes.java. Write your test cases in assign3-testcases.txt.

You work for the Tax Collection Department of the country of Elbonia, which taxes personal income according to the following scheme:

The first $8,000 of taxable income is taxed at 10%.
The next $26,000 is taxed at 15%.
The next $48,000 is taxed at 25%.
All remaining income is taxed at 35%.
For example, an income of $40,000 would be subject to $6,200 of tax: 10% on the first $8,000 ($800 tax), 15% on the next $26,000 ($3,900 tax), and 25% on the last $6,000 ($1,500 tax).

Ask the user for their taxable income in Elbonian dollars (integer) and compute the amount of tax that they owe (real number).

Example:

java Taxes

8001

RESULT: 800.15
 

Problem 2
Write your code in the file TwoSmallest.java. Write your test cases in assign3-testcases.txt.

We wish to write a program that takes a set of numbers and determines which are the two smallest.

Ask the user for the following information, in this order:

A terminating value (real number). The user will enter this value again later, to indicate that he or she is finished providing input.
A sequence of real numbers. Keep asking for numbers until the terminating value is entered.
Compute and output the smallest and second-smallest real number, in that order. It is possible for the smallest and second-smallest numbers to be the same (if the sequence contains duplicate numbers).

Example:

java TwoSmallest

123 [this is the terminating value, not part of the set of numbers]
17
23.5
10
15.2
30
8
16
123 [this is the terminating value again, indicating that the user is done]

RESULT: 8.0
RESULT: 10.0
Problem 3
 

Write your code in the file NthPrime.java. Write your test cases in assign3-testcases.txt.

A prime number is one that has no divisors other than 1 and itself (no other number divides evenly into the prime number). The 1st (smallest) prime number is 2. The 2nd is 3, the 3rd is 5, etc.

Ask the user for a value n, and compute the nth prime number. You must perform this computation using loops. You MAY NOT hardcode a list of prime numbers into your program.

Examples:

java NthPrime

10

RESULT: 29 