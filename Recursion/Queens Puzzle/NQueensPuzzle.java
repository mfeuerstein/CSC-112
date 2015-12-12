
public class NQueensPuzzle
{
    private int noOfSolutions;
    private int noOfQueens;
    private int[] queensInRow;

       //default constructor
       //Postcondition: noOfSolutions = 0; noOfQueens = 8;
        //              The array queensInRow is instantiated to 
        //              store the 8-tuple
    public NQueensPuzzle()
    {
        noOfQueens = 8;
        queensInRow = new int[8];
        noOfSolutions = 0;
    }

        //constructor
        //Postcondition: noOfSolutions = 0; noOfQueens = queens;
        //               The array queensInRow is instantiated to 
        //               store the n-tuple
    public NQueensPuzzle(int queens)
    {
        noOfQueens = queens;
        queensInRow = new int[noOfQueens];
        noOfSolutions = 0;
    }


       //Method to determine if a queen can be placed
       //in row k and column i.
       //Postcondition: returns true if a queen can be placed in
       //               row k and column i; otherwise it returns
       //            false
    public boolean canPlaceQueen(int k, int i)
    {
        for(int j = 0; j < k; j++)
          if((queensInRow[j] == i)
            || (Math.abs(queensInRow[j] - i) == Math.abs(j-k)))
             return false;
        return true;
    }


       //Method to determine all solutions to the n-queens
       //puzzle using backtracking
       //The method is called with the value 0
       //Postcondition: All n-tuples representing solutions of
       //         n-queens puzzle are generated and printed
    public void queensConfiguration(int k)
    {
        for(int i = 0; i < noOfQueens; i++)
        {
            if(canPlaceQueen(k, i))
            {
                queensInRow[k] = i;  //place the kth queen in column i

                if(k == noOfQueens - 1)  //all queens are placed
                    printConfiguration(); //print the n-tuple
                else
                    queensConfiguration(k + 1); //determine the place for
                                            //the (k+1)th queen
            }
        }
    }

       //Method to output an n-tuple containing a solution
       //to the n-queens puzzle
    public void printConfiguration()
    {
        noOfSolutions++;
        System.out.print("(");
        for(int i = 0; i < noOfQueens - 1; i++)
            System.out.print(queensInRow[i] + ", ");

        System.out.println(queensInRow[noOfQueens - 1] + ")");
    }


       //Method to return the total number of solutions
       //Postcondition: The value of noOfSolution is returned
    public int solutionsCount()
    {
        return noOfSolutions;
    }
}