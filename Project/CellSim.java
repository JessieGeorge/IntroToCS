import java.awt.Color;
public class CellSim{
	
	private static CellSimGUI C; 

	//black = blank cell. red = X agent. blue = Y agent. 
	private static Color black = new Color(0, 0, 0);
	private static Color red = new Color(255, 0, 0);
	private static Color blue = new Color(0, 0, 255);

	public static void main(String[] args){

		//Create a n x n 2-D character array representing the tissue sample
		// You can pick n

		System.out.println("Enter size of grid");
		int n = IO.readInt();
		
		//error condition for invalid dimension i.e. n must be positive
		if(n<=0)
		{
			IO.reportBadInput();
			return;
		}
		C = new CellSimGUI(n,50);

		System.out.println("Enter threshold");
		int threshold = IO.readInt();
		//error condition for invalid threshold
		if(threshold<0||threshold>100)
		{
			IO.reportBadInput();
			return;
		}
		
		System.out.println("Enter maximum number of rounds the simulation should run before giving up");
		int maxRounds = IO.readInt();
		//error condition for invalid maxRounds i.e. maxRounds must be positive
		if(maxRounds<=0)
		{
			IO.reportBadInput();
			return;
		}

		System.out.println("Enter frequency of printing");
		int freq = IO.readInt();
		//error condition for invalid frequency i.e. frequency must be positive
		if(freq<=0)
		{
			IO.reportBadInput();
			return;
		}

		System.out.println("Enter percentage of X agents");
		int percentX = IO.readInt();
		//error condition for invalid percentX
		if(percentX<0||percentX>100)
		{
			IO.reportBadInput();
			return;
		}

		System.out.println("Enter percentage of blank cells");
		int percentBlank = IO.readInt();
		//error condition for invalid percentBlank
		if(percentBlank<0||percentBlank>100)
		{
			IO.reportBadInput();
			return;
		}

		char[][] tissue = new char[n][n];
		
		int roundCounter = 0;//to check if we've finished max number of rounds
		int freqCounter = 0;//to check if it's time to print
		int cellMovesCounter = 0;//to count the total number of cell movements

		//Write your code to test your methods here
	    	assignCellTypes(tissue,percentBlank,percentX);
		System.out.println("This is the tissue:");
		printTissue(tissue);//printing the tissue for the first time
		//the code below is used to save the initial tissue such that we can print it after simulation
		char[][] initialTissue = new char[n][n];
		for(int row=0; row<n; row++)
		{
			for(int col=0; col<n; col++)
			{
				initialTissue[row][col] = tissue[row][col];
			}
		}

		if(!boardSatisfied(tissue,threshold)) //only if the board is not satisfied to begin with, should we move cells around
		{
			
			while(roundCounter<maxRounds)//less than because roundCounter starts from 0
			{
				//this code is inside the loop so that we can use break as soon as we know that there are no blanks in the unsatisfied board
				int numBlank = (int)Math.round(percentBlank/100.0 * (n*n));//number of blank cells
				if(numBlank == 0) //board unsatisfied and no blanks to move around cells
				{	
					System.out.println("This tissue will never be fully satisfied because there are no empty spaces to move unsatisfied agents");
					System.out.println();
					break;
				}

				cellMovesCounter += moveAllUnsatisfied(tissue, threshold);
				freqCounter++;
				roundCounter++;
			
				if(boardSatisfied(tissue,threshold))//if it's already satisfied break EVEN IF frequency is reached
					break;

				if(freqCounter == freq)
				{
					System.out.println("This is the tissue after "+freq+" rounds:");
					printTissue(tissue);
					freqCounter = 0;//the count should begin again
				}
				
				
			}
			
		}

		System.out.println("SIMULATION COMPLETE!");
		System.out.println("The Initial Board");
		printTissue(initialTissue);
		System.out.println("The Final Board");
		printTissue(tissue);
		if(boardSatisfied(tissue, threshold))
		{
			System.out.println("The board is satisfied.");
			System.out.println("The total number of rounds required to satisfy all agents = "+roundCounter);
		}
		else
		{
			System.out.println("The board is NOT satisfied.");
			int numSatAgents = 0; //number of satisfied agents
			int numTotalAgents = 0; //total number of agents
			double percSat = 0; //percentage of satisfied agents

			//nested loop access each cell of the tissue
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<n;j++)
				{
					if(tissue[i][j]!=' ')//the cell is not blank, therefore it is an agent
					{	
						numTotalAgents++;
						if(isSatisfied(tissue,i,j,threshold))//the agent is satisfied
							numSatAgents++;
					}
				}
			}
			percSat = (double)numSatAgents/numTotalAgents*100;
			System.out.println("The percentage of satisfied agents = "+percSat+"%");
		}
		System.out.println("The total number of movements that occured in the simulation = "+cellMovesCounter);	
	
	}
	
	/**
	* Given a tissue sample, prints the cell make up in grid form
	*
	* @param tissue a 2-D character array representing a tissue sample
	* 
	***/
	public static void printTissue(char[][] tissue){
		//Your code goes here
		int n = tissue.length;

		System.out.println();
		for(int row=0; row<n; row++)
		{
			for(int col=0; col<n; col++)
			{
				System.out.print("["+tissue[row][col]+"] "); //prints the cell type with square brackets for clarity
			}
			System.out.println();
		}
		System.out.println();
	}
	
	/**
	* Given a blank tissue sample, populate it with the correct cell makeup given the parameters. 
	* Cell type 'X' will be represented by the character 'X'
	* Cell type 'O' will be represented by the character 'O'
	* Vacant spaces will be represented by the character ' '
	*
	* Phase I: alternate X and O cells throughout, vacant cells at the "end" (50% credit)
	*		e.g.:	'X' 'O' 'X' 'O' 'X'
	*			'O' 'X' 'O' 'X' 'O'
	*			'X' 'O' 'X' 'O' 'X'
	*			' ' ' ' ' ' ' ' ' '
	*			' ' ' ' ' ' ' ' ' '
	*
	* Phase II: Random assignment of all cells (100% credit)
	*
	* @param tissue a 2-D character array that has been initialized
	* @param percentBlank the percentage of blank cells that should appear in the tissue
	* @param percentX Of the remaining cells, not blank, the percentage of X cells that should appear in the tissue. Round up if not a whole number
	*
	**/
	public static void assignCellTypes(char[][] tissue, int percentBlank, int percentX){
	
		//Your code goes here
		
		
		int n = tissue.length;
		int numBlank = (int)Math.round(percentBlank/100.0 * (n*n)); //the number of blank cells that should be in the tissue
		int numX = (int)Math.round(percentX/100.0 * (n*n - numBlank)); //the number of X cells that should be in the tissue
		
		int countBlank = 0; //counts the number of blank cells so far
		int countX = 0; //counts the number of X cells so far
		int countO = 0; //counts the number of O cells so far
		int countTotal = 0; //counts the total number of cells used so far (i.e. sum of blank, X, and O cells)

		while(countTotal!=n*n) //runs the loop until all cells in the array are used (i.e. each cell is either ' ', 'X' or 'O')
		{
			int row = (int)(Math.random()*10); //chooses a random row in the array
			int col = (int)(Math.random()*10); //chooses a random column in the array
			
			//error condition for invalid rows and columns (i.e. if they don't exist in the array)
			if(row<0||row>=n||col<0||col>=n)
				continue;
			
			//if the cell is empty, we proceed to fill it
			if(tissue[row][col] == '\0')
			{
				if(countBlank!=numBlank) //we do not have enough blanks in the array so put a blank in this cell
				{
					tissue[row][col] = ' ';
					C.setCell(row, col, black);
					countBlank++;
				}
				else //we have enough blanks in the array so now put Xs and Os
				{
					if(countX!=numX) //we do not have enough Xs in the array so put an X in this cell
					{
						tissue[row][col] = 'X';
						C.setCell(row, col, red);
						countX++;
					}
					
					else //we have enough Xs in the array so put an O in this cell
					{
						tissue[row][col] = 'O';
						C.setCell(row, col, blue);
						countO++;
					}
				}
			}
			countTotal = countBlank + countX + countO; //calculate total number of used cells
		}
		
		//the tissue has been filled in. now print it.
		
		
	}
	 		
        /**
        * Given a tissue sample, and a (row,col) index into the array, determines if the agent at that location is satisfied.
        * Note: Blank cells are always satisfied (as there is no agent)
        *
        * @param tissue a 2-D character array that has been initialized
        * @param row the row index of the agent
        * @param col the col index of the agent
        * @param threshold the percentage of like agents that must surround the agent to be satisfied
        * @return boolean indicating if given agent is satisfied
        *
        **/
        public static boolean isSatisfied(char[][] tissue, int row, int col, int threshold){
	
	if(tissue[row][col]==' ')//cell is blank, therefore satisfied
		return true;

	else{
	int n = tissue.length;//the size of tissue array
	int numSameCell = 0;//number of cells around the given cell that are of the same type as the given cell
	int numFilledBox = 0;//number of filled boxes around the given cell i.e. number of X cells and O cells but not empty cells

	for(int k=1; k<=8; k++) //a cell can be surrounded by a maximum of 8 cells, so the loop control variable k goes from 1 to 8
	{
		int newRow = row;//the row of the cell nearby with which we will compare this cell
		int newCol = col;//the column of the cell nearby with which we will compare this cell
		
		//To show the eight different permutations of newRow and newCol we will use a switch statement based on the variable k that is switch(k).
		//In each case given below we will use the ++ or -- operator to modify the values of newRow and newCol.
		switch(k)
		{
			case 1:
			{
				newRow++;
				break;
			}
			case 2:
			{
				newRow--;
				break;
			}
			case 3:
			{
				newCol++;
				break;
			}
			case 4:
			{
				newCol--;
				break;
			}
			case 5:
			{
				newRow++;
				newCol++;
				break;
			}
			case 6:
			{
				newRow--;
				newCol--;
				break;
			}
			case 7:
			{
				newRow++;
				newCol--;
				break;
			}
			case 8:
			{
				newRow--;
				newCol++;
				break;
			}

		} //end of switch

		//check for invalid indexes
		if(newRow<0||newRow>=n||newCol<0||newCol>=n)
			continue; //don't bother comparing cells
		
		if(tissue[newRow][newCol]==tissue[row][col])//the two compared cells hold the same type of agents
		{
			numSameCell++;
			numFilledBox++;
		}
		else if(tissue[newRow][newCol]==' ')
		{
			//do nothing. blank cells do not contribute to satisfaction of cell
		}
		else//the two compared cells hold opposite type of agents
		{
			numFilledBox++;
		}
	}//end of for
	if(numFilledBox==0)//this cell is surrounded by empty cells therefore it is unsatisfied
		return false;
	double percNeigh; //percentage of neighbors that are the same type as the given cell
	percNeigh = (double)numSameCell/numFilledBox*100.0;

	if(percNeigh>=threshold) //cell is satisfied
		return true; 

	else
		return false; //cell is not satisfied
	}//end of the first else

        }
    
        /**
        * Given a tissue sample, determines if all agents are satisfied.
        * Note: Blank cells are always satisfied (as there is no agent)
        *
        * @param tissue a 2-D character array that has been initialized
        * @return boolean indicating whether entire board has been satisfied (all agents)
        **/
        public static boolean boardSatisfied(char[][] tissue, int threshold){
		int n = tissue.length;
		boolean isStabilized = true; // If all cells on the board are satisfied, it will remain true. If even one cell on the board is unsatisfied, it will change to false

		//logic to check if the tissue is fully satisfied
		//the nested loops are used to access each cell in the tissue
		OUTERLOOP: for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				//check if the cell at row i and column j is satisfied
				if(isSatisfied(tissue, i, j, threshold))
				{
					//do nothing. the cell is satisfied.
				}
				else //cell is unsatisfied
				{
					isStabilized = false; //tissue is not fully satisfied
					break OUTERLOOP;
				}
			}
		}	   

		return isStabilized;
        }
    
        /**
        * Given a tissue sample, move all unsatisfied agents to a vacant cell
    	*
    	* @param tissue a 2-D character array that has been initialized
    	* @param threshold the percentage of like agents that must surround the agent to be satisfied
    	* @return an integer representing how many cells were moved in this round
    	**/
    	public static int moveAllUnsatisfied(char[][] tissue, int threshold)
	{
		int numCellsMoved = 0; //number of cells moved in this round
		int n = tissue.length; //size of tissue array
		int[] unsatInd = new int[n*n]; //array to store the indexes of all unsatisfied cells. the size of this array is the size of the tissue.
		int len = 0; //to store the length of unsatInd[] that has been used for meaningful data not including the default values stored in unsatInd.
		//the nested loops are used to access each cell in the tissue
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				//check if the cell at row i and column j is satisfied
				if(isSatisfied(tissue, i, j, threshold))
				{
					//do nothing. the cell is satisfied.
				}

				else //cell is unsatisfied
				{
					unsatInd[len] = i*10+j;
					//For example if the first unsatisfied cell was in (3,2) it will be stored in unsatInd[0] as 32.
					//if the second unsatisfied cell was in (4,1) it will be stored in unsatInd[1] as 41. 
	
					len++; 
				}
			}
		}

		//loop to access data in unsatInd array
		for(int index=0; index<len; index++)
		{
			int row = unsatInd[index]/10;
              		int col = unsatInd[index]%10;
			//For example if the value 32 is stored in the array then it will break up such that row=3 and col=2


			//logic to relocate each unsatisfied cell
			OUTERLOOP: for(int i=0; i<n; i++)
			{
				for(int j=0; j<n; j++)
				{
					if(tissue[i][j]==' ')//the first empty cell in the tissue
					{
						//swapping black box with red or blue box
						if(tissue[row][col]=='X')
							C.setCell(i, j, red);
						else
							C.setCell(i, j, blue);

						C.setCell(row, col, black);

						//swapping the unsatisfied cell with the blank cell
						tissue[i][j]=tissue[row][col];
						tissue[row][col]=' ';
						numCellsMoved++;

						break OUTERLOOP;
					}
				}
			}
		}
		
		return numCellsMoved;
    
    	}
}