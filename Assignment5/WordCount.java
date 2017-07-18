public class WordCount
{
  public static void main(String args[])
  {
	System.out.println("Enter a sentence");
	String s = IO.readString();
	s = s+' '; //to include the last word in our calculations
	System.out.println("Enter minimum word length");
	int minWordLen = IO.readInt();

	//error check for invalid minWordLen
	if(minWordLen<=0)
	{
		IO.reportBadInput();
		return;
	}
	
	int l = s.length(); //length of sentence
	int place = 0; //the place where a word starts
	int countWord = 0; //number of words with minimum length 
	for(int i=0; i<l; i++)
	{
	   if(s.charAt(i)==' ')//space indicates end of word
	   {
		if(WordLen(s.substring(place, i))>=minWordLen)//the length of this word is at least minimum length
			countWord++;

		place = i+1;//start of next word
	   }
	}

	System.out.println("Number of words in the sentence with at least minimum length:");
	IO.outputIntAnswer(countWord);
  }
  public static int WordLen(String w)
  {
	int l = w.length(); //length of word including non-letters
	int countLetr = 0; //length of word excluding non-letters
	for(int i=0; i<l; i++)
	{
	    if(Character.isLetter(w.charAt(i)))
		countLetr++;
	}
	return countLetr;
  }
}
	