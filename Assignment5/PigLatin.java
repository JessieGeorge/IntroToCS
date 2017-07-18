public class PigLatin
{
  public static void main(String args[])
  {
	String word; //word entered by user
	String pig = ""; //word in piglatin
	System.out.println("Enter a word");
	word = IO.readString();
	
	int l = word.length();
	if(l==0) //error for no word
	{
		IO.reportBadInput();
		return;
	}
	for(int i=0; i<l; i++)
	{
		if(!Character.isLetter(word.charAt(i))) //error for non-letters
		{
			IO.reportBadInput();
			return;
		}
	}


	char ch = word.charAt(0); //the letter that the word starts with
	char[] vowels={'A','E','I','O','U','a','e','i','o','u'};
	boolean beginsWithVow = false; //checks if the word starts with a vowel
	for(int i=0; i<10; i++) //loop to go through the array of vowels
	{
		if(ch==vowels[i])
		{
			beginsWithVow = true;
			break;
		}
	}
	if(beginsWithVow)
		pig = word+"way"; //rule when the word begins with a vowel
	else
		pig = word.substring(1)+word.charAt(0)+"ay"; //rule when the word begins with a consonant
	IO.outputStringAnswer(pig);
  }

}