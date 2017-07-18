Assignment 1

Overview
For this assignment, you will develop programs (expressed as flowcharts) to solve several problems. For each program, you must show your problem analysis (inputs/outputs/errorconditions), the flowchart describing your algorithm, and the test cases needed to test your program thoroughly.

Since your submission will include diagrams/drawings of flowcharts, you must submit your answers in a PDF file (Portable Document Format) called assign1.pdf. We recommend that you use PowerPoint or a similar presentation application (such as the free software OpenOffice), as this will make it easy to draw the flowcharts and also to combine them with text for the problem analysis and test cases. As you are working on the assignment, you can save your work as a normal PowerPoint file (.ppt or .pptx). Before submitting the assignment, choose the "Export to PDF" option and submit the resulting .pdf file. You MAY NOT draw your flowcharts on paper and scan them.

Each problem will list the set of operations that may be used in your program. You MAY NOT use operations other than these, even if you have seen them in some existing programming language. You may, however, create procedures for sequences of operations that you perform repeatedly in your algorithm. You must draw the flowchart for each such procedure.

We will not be picky about the exact wording you use for the steps in your algorithm. For example, you may write

let the user type a number and store it into the variable x
instead of

read x
Any clear, understandable form is acceptable. However, your statements must follow these rules:

They must be precise: all information and variables manipulated at each step of your algorithm must be specified explicitly. For example, "add everything up" is not acceptable, since it does not explicitly specify what values are to be added, and also because it does not state where the result is to be stored.
They must be organized: The flow of control in your program must be absolutely clear.
They must only use operations from the permitted set.
You must do at least 1 error check per flow chart, you may terminate the program on finding an error condition
Problems
Problem 1
Resistor are a integral part of electronics. A resistor's value is encoded in colored bands painted around the component itself. Write a program to calculate the resistance value (in ohms) of a three band resistor, given the following rules :

The first 2 bands may be of any of the following colors - black, brown, red, orange, yellow, green, blue, violet, gray, white.
Each of the colors above correspond to the digits 0-9 respectively (i.e. black = 0, white = 9)
The third band may be of any color from the above list from black to violet
The third band's color represents the multiplier and goes from 1 = black to 10,000,000 = violet with each progressive color being 10 x more of a multiplier
For example, a resistor with three bands of the following colors: Red, Red, Green would have the following calculation: 2(red) 2(red) x 100,000(green) = 2,200,000 ohms.

Your program may use the following operations:

Output information (text, numbers, etc.)
Input a real number, integer, or boolean value, or color
Store a numeric, color, or boolean value into a variable
Perform arithmetic operations: add, subtract, multiply, divide, integer quotient, integer remainder
Perform numeric comparisons: equals, does not equal, less than (or equal to), greater than (or equal to)
Perform boolean operations: and, or, not
Make decisions
Loop (go back to an earlier point in the program)
Problem 2
Given 2 points on a cartesian coordinate system, write a program that outputs the equation for a line that passes through both points. (Hint: find the slope and y intercept)

Available operations:

read a number
Store a numeric or boolean value into a variable
Output information (text, numbers, etc.)
Perform arithmetic operations: add, subtract, multiply, divide, integer quotient, integer remainder
Perform numeric comparisons: equals, does not equal, less than (or equal to), greater than (or equal to)
Make decisions
Problem 3
Write a program that lets the user enter a sequence of numbers. The program should stop when it notices that the most recently entered number is the sum of all the numbers that were entered previously, and output the number of positive entries.

3
4
6
-2
8
19

after which the program would stop and output 5 (because the user made 5 positive entries).

Note that the program is not counting distinct numbers entered - if the same number is entered multiple times, it should be counted multiple times. The user should NOT be asked for the length of the sequence in advance.

Your program may use the following operations:

Output information (text, numbers, etc.)
Input a real number, integer, or boolean value
Store a numeric or boolean value into a variable
Perform arithmetic operations: add, subtract, multiply, divide, integer quotient, integer remainder
Perform numeric comparisons: equals, does not equal, less than (or equal to), greater than (or equal to)
Perform boolean operations: and, or, not
Make decisions
Loop (go back to an earlier point in the program)