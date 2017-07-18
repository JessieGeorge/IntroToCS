Assignment 7

Problem 1
Write your code in the file StringRec.java. For this problem, the following restrictions apply:

YOUR CODE MUST BE RECURSIVE.
Do not use loops (while, do/while, or for).
Do not declare any variables outside of a method. You may declare local variables inside a method.
Complete the following method:

public static String decompress(String compressedText): Decompress the input text, which has been compressed using the RLE algorithm (previous hw assignment):
 Run-length encoding (RLE) is a simple "compression algorithm" (an algorithm which takes a block of data and reduces its size, producing a block that contains the same information in less space). It works by replacing repetitive sequences of identical data items with short "tokens" that represent entire sequences. Applying RLE to a string involves finding sequences in the string where the same character repeats. Each such sequence should be replaced by a "token" consisting of:
the number of characters in the sequence
the repeating character
If a character does not repeat, it should be left alone. For example, consider the following string:
qwwwwwwwwweeeeerrtyyyyyqqqqwEErTTT
After applying the RLE algorithm, this string is converted into:
q9w5e2rt5y4qw2Er3T
In the compressed string, "9w" represents a sequence of 9 consecutive lowercase "w" characters. "5e" represents 5 consecutive lowercase "e" characters, etc.
You may assume that the character counts will be single-digit numbers (a character will not repeat more than 9 times consecutively).

Hint #1: remember that characters are represented by numeric codes. You can decrement a character variable as follows:

char c = '7';
c--;           // c will now hold the character '6'
Hint #2: You probably will not need to use this hint for this problem. However, a fast way to convert a digit character into the numeric value of the digit is to subtract the character code for the digit zero:

char c = '7';    // this has the character code 55, not 7
int x = c - '0'; // this produces the number 7
