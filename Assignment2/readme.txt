Assignment 2

Problem 1 (Warmup)
Write your code in a file called Sum.java. Use the IO module to read inputs. Use System.out.println() to print your answer.

Ask the user for 2 integers. Output the sum of those 2 numbers. Example:

Enter the first number:
5
Enter the second root:
-3

Sum: 2

Problem 2
Write your code in a file called Poly.java. Use the IO module to read inputs. Use System.out.println() to print your answer.

Write a program that generates a canonical-form, degree-3 (cubic) polynomial given its roots. For example, if the roots are 5, -3, and 2, the polynomial equation is

(x - 5)(x + 3)(x - 2) = 0
The canonical form of the polynomial is therefore

x^3 - 4x^2 - 11x + 30
The above is just text, not code that could appear in a Java program.

Ask the user for three roots (integers). Output the canonical form of the polynomial with those roots (as text) using System.out.println(), as in the following example:

java Poly

Enter the first root:
5
Enter the second root:
-3
Enter the third root:
2

The polynomial is:
x^3 - 4x^2 - 11x + 30