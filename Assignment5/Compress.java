public class Compress
{
  public static void main(String args[])
  {
    System.out.println("Enter a string");
    String s = IO.readString();

    int l = s.length();
    if(l==0)//error check if user clicks enter without typing anything
    {
	IO.reportBadInput();
	return;
    }
    for(int i=0; i<l; i++)
    {
	if(Character.isDigit(s.charAt(i)))//error check for digits in the string
	{
		IO.reportBadInput();
		return;
	}
    }
  
    String compressedStr = ""; //compressed string
    int place = 0; //the place where a sequence of identical data begins
    int rep = 0; //repetition of the character
    if(l==1) //only one character
    {
	compressedStr = s.charAt(0)+"";
    }
    else
    {
    for(int i=1; i<l; i++)
    {
	if(i==(l-1)&&s.charAt(i)==s.charAt(i-1))//if it is the last character of the word and the last character of a similar sequence, include in calculation
	{
		compressedStr+=(l-place)+""+s.charAt(i);
	}
	else if(s.charAt(i)!=s.charAt(i-1))//if this character is not equal to the last, we have reached the end of one sequence
	{
		
		rep = i - place;//number of times the character is repeated
		place = i;//start of next sequence
		
		if(rep==1) //character not repeated
			compressedStr+=s.charAt(i-1);
		else
			compressedStr+=""+rep+""+s.charAt(i-1);//character is repeated

		if(i==(l-1))//last character of the word and the last character of its own sequence (i.e. character not repeated which is at the end of word)
		{
			compressedStr += s.charAt(i);	
		}
	}
	
    }
    }
    System.out.println("The compressed string is:");
    IO.outputStringAnswer(compressedStr);
 }
}