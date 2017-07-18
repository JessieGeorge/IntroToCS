public class Sum
{
 public static void main(String args[])
 {
    int num1, num2, sum; //to store first number, second number and sum respectively
    sum = 0; //initializing sum

    //accepting two numbers from user
    System.out.println("Enter the first number:");
    num1 = IO.readInt();
    System.out.println("Enter the second number:");
    num2 = IO.readInt();

    sum = num1 + num2; //calculating sum

    System.out.println("Sum: "+sum); //printing output
 }
}