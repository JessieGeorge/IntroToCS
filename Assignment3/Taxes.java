public class Taxes
{
    public static void main(String[] args)
	{
	  int income; 
	  double tax = 0;
	  
	  System.out.println("Enter taxable income");
	  income = IO.readInt();
	  
	  if(income <= 0)
	  {
		IO.reportBadInput();
		return;
	  }
	  
	  if(income <= 8000)
	    tax = income*0.10;
	  else if(income <= 34000)
		tax = 800 + (income - 8000) * 0.15;
	  else if(income <= 82000)
	    tax = 800 + 3900 + (income - 34000) * 0.25;
	  else
		tax = 800 + 3900 + 12000 + (income - 82000) * 0.35;
		
	  System.out.println("The amount of tax you owe is:");
	  IO.outputDoubleAnswer(tax);
	}
}
	    
		
