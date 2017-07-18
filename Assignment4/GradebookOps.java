public class GradebookOps
{
	public static int findStudent(String studentName, String[] allStudentNames, boolean alphabetical)
	{
		for(int i=0;i<allStudentNames.length; i++){
			if (allStudentNames[i].equals(studentName))
				return i;
		}
		
		return -1;
	}

	public static double computeGrade(int studentIndex, int[][] scoreTable, int[] itemPointValues)
	{
		if(studentIndex<0||studentIndex>scoreTable.length) //the studentIndex doesn't exist in the scoreTable
		{
			System.out.println("Invalid Student Index."); //error message
			return -1.0;
		}
		int totalScore = 0; //the total score student earned (i.e. sum of non-excused scores)
		int totalPoints = 0; //the total points student could possibly have earned (i.e. sum of point values on non-excused graded items)
		int countGradedItems = 0; //the number of non-excused graded items
		
		for(int i=0; i<scoreTable[0].length; i++) //loop to go through all graded items for one student
		{
			if(scoreTable[studentIndex][i]!=-1) //if the score is non-excused, include in calculations
			{
				totalScore+= scoreTable[studentIndex][i];
				totalPoints+= itemPointValues[i];
				countGradedItems++;
			}
		}
		
		if(countGradedItems==0) //student excused from all graded items
			return -1;
		else
			return totalScore/(double)totalPoints*100.0; //the overall numerical percentage grade for one student
	}
	
	public static double[] computeAllGrades(int[][] scoreTable, int[] itemPointValues)
	{
		double[] grades = new double[scoreTable.length]; //the dimension of grades is the number of students
		
		for(int i=0; i<grades.length; i++)
		{
			grades[i] = computeGrade(i, scoreTable, itemPointValues); //compute grade for each student
		}
		
		return grades;
	}

	public static double computeClassAverage(int item, int[][] scoreTable)
	{
		double sum = 0; //sum of scores of non-excused students
		double countStudents = 0; //number of non-excused students
		
		for(int i=0; i<scoreTable.length; i++) //loop to go through all students for one graded item
		{
			if(scoreTable[i][item]!=-1) //if the student is not excused from this graded item, include in calculations
			{
				sum+= scoreTable[i][item];
				countStudents++;
		    }
		}
		
		if(countStudents == 0)//all students were excused from this graded item
			return -1;
		else
			return sum/countStudents; //average score of class
	}
}