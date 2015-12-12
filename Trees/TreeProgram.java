import java.io.*;
import java.util.*;

public class TreeProgram
/*This program reads integers from an external file and places them in
  a binary tree in order.  It then prints out the contents of the tree in order.*/

{
    public static void main(String[] args)
    {
        String inPutFile = "test.txt";		//file name
        String line;						//one line of file
        String strValue;					//character extracted from string
        int value;							//integer converted from character
        StringTokenizer inLine;				//tokenized string

		//Instantiate a Tree
		BinaryTreePM tree = new BinaryTreePM( );

        System.out.println("Reading file....");

		try
		  {

			//open the input stream
			FileReader fRead = new FileReader(inPutFile);
			BufferedReader bRead = new BufferedReader (fRead);

			//get data
			//read in the first line of the file
			line = bRead.readLine();


			//while not yet at the end of the file
			while(line != null)
			{

				//parse the new line 1 "word" at a time
		 		inLine = new StringTokenizer(line);

				//get "word"
		 		strValue = inLine.nextToken();

				//convert to integer
				value = Integer.parseInt(strValue);

				//insert in tree
				tree.insertValue(value);

				//get the next line in the current file
				line = bRead.readLine();

			 }//end while line

			 //close the input file
			 bRead.close ();
			 System.out.println("File closed.");
			 System.out.println( );


			 //display contents of tree
			 tree.display( );
			 System.out.println( );

		}//end try

		catch(IOException exception)
		{
			System.out.println(exception.getMessage());
		}//end catch



    }//end main
}//end class