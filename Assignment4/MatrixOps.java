public class MatrixOps
{
	public static double[][] multiply(double[][] matrix1, double[][] matrix2)
	{
		int numRowsA = matrix1.length; //number of rows for matrix1
		int numRowsB = matrix2.length; //number of rows for matrix2
		int numColsA = matrix1[0].length; //number of columns for matrix1
		int numColsB = matrix2[0].length; //number of columns for matrix2
		
		double[][] product = new double[numRowsA][numColsB]; //the array to store product of two matrices
		
		if(numColsA!=numRowsB)//error condition. Matrices cannot be multiplied
		{
			product = null;
			return product;
		}
		
		for(int i=0; i<numRowsA; i++)
		{
			for(int k=0; k<numColsB; k++)
			{
				int n = 0;
				product[i][k] = 0;
				
				while(n<numColsA)
				{
					product[i][k] += matrix1[i][n]*matrix2[n][k]; //calculates product by going across matrix1 and down matrix2
					n++;
				}
			}
		}
		
		return product;
	}
}