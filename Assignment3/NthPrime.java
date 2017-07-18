public class NthPrime
{
	public static boolean prime(int num)
	{
		int fact = 2; //the number itself and 1 is always a factor
		for(int i=2; i<num; i++) //don't forget to declare i!!
		{
			if(num%i==0) //num has more than 2 factors
			{
				return false; 
			}
		}
		return true;
	}
	public static void main(String[] args)
	{
		int n;
		int countPrime = 0;
		int num = 2;
		
		System.out.println("Enter n");
		n = IO.readInt();
		
		if(n<=0)
		{
			IO.reportBadInput();
			return;
		}
		
		while(true)
		{
			if(prime(num))
			{
				countPrime++;
			}
			
			if(countPrime == n)
			{
				break;
			}
			
			num++;
		}
		
		System.out.println("The nth prime number is ");
		IO.outputIntAnswer(num);
		
	}
}
				