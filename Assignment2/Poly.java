public class Poly
{
  public static void main(String args[])
  {
     int root1, root2, root3;
     String pol = "x^3 "; //to store polynomial
     
     //accepting three roots from user
     System.out.println("Enter the first root:");
     root1 = IO.readInt();
     System.out.println("Enter the second root:");
     root2 = IO.readInt();
     System.out.println("Enter the third root:");
     root3 = IO.readInt();
     
     if(root1 + root2 + root3 == 0) //if zero do not include it in pol
	;

     else
     {
	if(-1*(root1 + root2 + root3) > 0) //if positive include + sign in pol
	   pol = pol + "+ ";
     
        pol = pol + (-1*(root1 + root2 + root3)) + "x^2 ";
     }
 
     if(root1*root2 + root2*root3 + root3*root1 == 0) //if zero do not include it in pol
	;

     else
     {
	if(root1*root2 + root2*root3 + root3*root1 > 0) //if positive include + sign in pol
           pol = pol + "+ ";
     
        pol = pol + (root1*root2 + root2*root3 + root3*root1) + "x ";
     }
     
     if(root1*root2*root3 == 0) //if zero do not include it in pol
	;

     else
     {
	if(-1*root1*root2*root3 > 0) //if positive include + sign in pol
	   pol = pol + "+ ";
       
        pol = pol + (-1*root1*root2*root3);
     }
     
     //printing output 
     System.out.println("The polynomial is:");
     System.out.println(pol);
     
  }
} 
     
     