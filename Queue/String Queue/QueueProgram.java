import java.io.*;
import java.util.*;

public class QueueProgram
{
    public static void main(String[] args)
    {
        String inPutFile = "QueueTest.txt";	//file name
		String line;					//one line of file
		int numChars;					//number of characters in line
		String value;					//character extracted from string
		int count = 0;					//count characters as extracted
		Scanner scan = new Scanner(System.in);


		//Instantiate a Queue
		LinkedQueueClass queue = new LinkedQueueClass( );

		        System.out.println("Reading file....");

				try
				  {
					//open the input stream
					FileReader fRead = new FileReader(inPutFile);
					BufferedReader bRead = new BufferedReader (fRead);

					//get data
					//read in the first line of the file
					line = bRead.readLine();

					//initialize a queue to empty
					queue.initializeQueue( );

					//while not yet at the end of the file
					while(line != null)
					{
						//get length of line
						numChars = line.length( );
						//start character count at zero
						count = 0;

						//extract characters and create queue
						while (count < numChars)
						{
							//get character
							value = line.substring(count, count+1);

							//add to queue
							queue.addQueue(value);

							//count character
							count++;
						}//end while count

						//get the next line in the current file
						line = bRead.readLine();

					 }//end while line

					 //close the input file
					 bRead.close ();

					 System.out.println( queue.front( ) + " front");
					 System.out.println( queue.back( ) + " back");
					 System.out.println( "There were " + count + " characters read from file");

					 System.out.print( "Enter string: ");
					 value = scan.nextLine();

					 if (value.equals(queue.front( )))
					 	System.out.println( " Equal string");
					 else
					 	System.out.println( " Not equal string");

					 //pop values off the queue and print to screen
					 System.out.println( "Contents of Queue:  ");
					 while (!queue.isEmptyQueue( ) )
					 {
					 	//return value at front of queue
					 	value = queue.front( );
					 	//pop value off queue
					 	queue.deleteQueue ( );
					 	//print out value removed
					 	System.out.print(value);
				  	  }//end while not empty

				  	  System.out.println( );

				}//end try

				catch(IOException exception)
				{
					System.out.println(exception.getMessage());
				}//end catch

    }//end main

}

