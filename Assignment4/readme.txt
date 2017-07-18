Assignment 4

Overview
For this assignment, you will develop Java methods as part of a single software application.  You will not have to submit test cases, although you should test your code thoroughly using a good set of test cases.

Error conditions
 

Method's return type	Return value on error
void	none, do not perform action
int, double	-1
boolean	false
any object type	null
Problems
Problem 1
Write your code in the file GradebookOps.java.

Problem description

You will build part of an application that records and manages the grades of students in a course (similar to Sakai's Gradebook, though considerably less complex). The exams, quizzes, homeworks, etc. on which the student receives scores will be referred to as "graded items". These will be numbered starting at zero, and all students in a course will have the same set of graded items. The application will keep track of:

The point value of each graded item. A score on this item will be "out of" the point value. For example, a score of 24 on an item with a point value of 50 is "24 out of 50", which is equivalent to 48%.
The name of each student.
The score earned by each student on each graded item. Students can be excused from particular items; an item from which a student has been excused should not count towards their overall grade (neither positively nor negatively).
The overall numerical percentage grade of each student.
The application will support the following operations:

Display all students' scores and grades
Display one student's scores and grade
Assign score
Get class average on a particular graded item
Sort students alphabetically
Sort students by overall grade (descending order)
The file grades.txt contains a sample set of grades. You may edit this file if you wish. If you add entries to it, be sure they follow the same format as the entries already in the file.

The following rules apply:

You may assume that bad inputs will NOT be given when asking for graded item numbers or scores. We will not input item numbers less than zero or greater than the number of the last item. We will not input scores below zero (except when excusing a student from an item, see below) or greater than 100.
However, we WILL sometimes test using names of students that are not in the gradebook.
Your program must be case-insensitive (strings should be compared using equalsIgnoreCase() or compareToIgnoreCase()).
A student's overall numerical percentage grade is computed by dividing the total points they earned (sum of their non-excused scores) by the total points they could possibly have earned (sum of point values of their non-excused graded items), then multiplying by 100 (to make it a percentage).
Code structure

The user interface has been written for you in GradebookApp.java. This program handles all keyboard and file input, and all screen output. You will complete the methods in GradebookOps.java, which are designed to perform actions such as searching and sorting the gradebook.

GradebookApp first reads the gradebook from grades.txt, then calls your computeAllGrades() method to compute each student's overall numerical percentage grade. It then shows the user a menu from which they can choose various options. In most cases, GradebookApp will call methods from GradebookOps to execute the option chosen by the user.

There are four key arrays used in the program:

itemPointValues: array of integers holding the point values of graded items. We will refer to the length of this array as g, the number of graded items.
allStudentNames: array of strings holding the names of students. We will refer to the length of this array as s, the number of students in the course.
scoreTable: 2D array of integers holding the score of each student on each graded item. The size of the first dimension of this array is s, the number of students. The size of the second dimension of this array is g, the number of graded items. So for example, scoreTable[5][12] would hold the score of student #5 on graded item #12.
grades: array of real numbers holding the overall numerical percentage grades of each student. The length of this array is s, the number of students.
Scores will normally be integers between 0 and the point value for the graded item. If a student is excused from an item, their score will be recorded in the scoreTable array as -1. In grades.txt, excused grades are shown as "exc". Likewise, GradebookApp prints "exc" when it sees that a student has a score of -1, indicating that they have been excused.

Overall grades will be real numbers between 0 and 100.

Implementation

Complete the following methods of GradebookOps:

public static double computeGrade(int studentIndex, int[][] scoreTable, int[] itemPointValues):
Compute the overall numerical percentage grade for the semester for the given student. studentIndex is the index in allStudentNames of the student's name, or equivalently the row index in scoreTable of the student's scores.
public static double[] computeAllGrades(int[][] scoreTable, int[] itemPointValues):
Compute the overall numerical percentage grades for the semester for all students in the class. Return the results in an array of length s.
public static double computeClassAverage(int item, int[][] scoreTable):
Compute the class average score (not percentage) for the specified graded item. The average score should be "out of" the point value for the graded item (not out of 100%). Students who have been excused should not count towards the average.
Remember to test each of your methods thoroughly by running GradebookApp.

Problem 2
Write your code in the file MatrixOps.java. .

Consider the following definitions from matrix algebra:

A vector is a one-dimensional set of numbers, such as [42 9 20].
The dot product of two equal-length vectors A and B is computed by multiplying the first entry of A by the first entry of B, the second entry of A by the second entry of B, etc., and then summing these products. For example, the dot product of [42 9 20] and [2 28 79] is 42*2 + 9*28 + 20*79 = 1916.
A matrix is a two-dimensional set of numbers. For example, here is a matrix with 4 rows and 3 columns (each row or column can be treated as a vector):
	42   9  20
	 2  28  79
	19  -3   1
	37  55  64
	
Two matrices A and B may be "multiplied" into a "product matrix" in the following manner: The number in row i and column j of the product matrix is the dot product of row i of matrix A and column j of matrix B. Since you must have equal-length vectors in order to compute a dot product, it follows that the number of columns in matrix A must be the same as the number of rows in matrix B. The product matrix will have as many rows as matrix A, and as many columns as matrix B. Example:
	 1   2         7   8   9         (1*7 + 2*10)  (1*8 + 2*11)  (1*9 + 2*12)         27  30  33
	 3   4    *   10  11  12    =    (3*7 + 4*10)  (3*8 + 4*11)  (3*9 + 4*12)    =    61  68  75
	 5   6                           (5*7 + 6*10)  (5*8 + 6*11)  (5*9 + 6*12)         95 106 117
	
More explanations of matrix multiplication may be found here or here.

Complete the following method of MatrixOps:

public static double[][] multiply(double[][] A, double[][] B): Multiply matrices A and B. Return the product matrix. This method must work for matrices of any size (i.e., with any number of rows and/or columns). Treat "rows" as the first dimension and "columns" as the second dimension.
Use MatrixDriver.java to test your method. MatrixDriver will ask you for the names of files containing matrices to multiply. Sample files m1.txt and m2.txt are provided for your use. If your method works for this pair of matrices, that does NOT mean it will always work. You MUST create your own text files containing matrices, formatted like these samples, but with different numbers of rows and columns, in order to test your code.

Example:

java MatrixDriver

Enter name of file containing first matrix:
m1.txt
Enter name of file containing second matrix:
m2.txt
product matrix:
0.0	-5.0
-6.0	-7.0
 