public class TwoSmallest
{
	public static void main(String[] args)
	{
		double sentinel;
		double num;
		double smallest;
		double second_smallest;
		
		System.out.println("Enter the terminating value");
		sentinel = IO.readDouble();
		
		System.out.println("Enter a number");
		num = IO.readDouble();
		smallest = num;
		
		if(num==sentinel) //if the first number is the sentinel you cannot have two smallest numbers
		{
			IO.reportBadInput();
			return;
		}
		
		System.out.println("Enter a number");
		num = IO.readDouble();
		
		if(num==sentinel) //if the second number is the sentinel you cannot have two smallest numbers
		{
			IO.reportBadInput();
			return;
		}
	    
		if(num<smallest)
		{
			second_smallest = smallest;
			smallest = num;
		}
		
		else //number is greater than or equal to smallest
			second_smallest = num;

		while(num!=sentinel)
		{
			if(num<smallest)
			{
				second_smallest = smallest;
				smallest = num;
			}
			
			else if(num == smallest) //in case there is repetition of the smallest number in the sequence
				second_smallest = num;
					
			else if(num>smallest && num<second_smallest)
				second_smallest = num;
			
				
			System.out.println("Enter a number");
			num = IO.readDouble();
		}
		
		System.out.println("Smallest number is:");
		IO.outputDoubleAnswer(smallest);
		
		System.out.println("Second smallest number is:");
		IO.outputDoubleAnswer(second_smallest);
	}
}