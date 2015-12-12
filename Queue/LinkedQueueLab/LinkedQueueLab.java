/**********************************************************
 * Program Name   : LinkedQueueLab.java
 * Author         : Michael Feuerstein
 * Date           : April 17, 2012
 * Course/Section : CSC 112-001
 * Program Description: This class tests the methods of the
 *    LinkedQueueClass. Three linked Data Element Queues
 *    are created and filled with strings. Queues 2 and 3
 *    are copies of Queue 1. Contents displayed at the end.
 *
 **********************************************************/

/*
     UML Diagram
     -----------
     Class Name: LinkedQueueLab
     --------------------------
     Class Variables :
     +record: String
     +inFile: Scanner
     +queue1: LinkedQueueClass
     +queue2: LinkedQueueClass
     +queue3: LinkedQueueClass
     ---------------
     Class Methods :
     +main(String[]): static void

     Program Logic
     -------------
     1.  Read the line of text from
         the file
     2.  Add the String tokens from
         the line to the queue
     3.  Copy queue1 into queue2
     4.  Instantiate queue3 with queue1
     5.  Add an additional string to queue1
     6.  Display the contents of
         queue1, queue2 and queue3
*/

import java.io.*;
import java.util.Scanner;

public class LinkedQueueLab
{
    public static void main(String[] args)throws
                                    FileNotFoundException,
                                    IOException
    {
		String record = "";        //String line of file data
		Scanner inFile = new Scanner(new File("QueueInfo.text")); //Scanner for file
        LinkedQueueClass queue1 = new LinkedQueueClass();         //Linked DataElement queue 1
        LinkedQueueClass queue2 = new LinkedQueueClass();         //Linked DataElement queue 2
        LinkedQueueClass queue3;                                  //Linked DataElement queue 3

            //Read the line of text from
            //the file
        record = inFile.nextLine();

            //Add the String tokens from
            //the line to the queue
        while(record != null)
        {
			//Add the string token
		    queue1.addQueue(new StringElement(record));

		    //Get the next token if it exists
		    if(inFile.hasNext())
		        record = inFile.next();

		    else
		        record = null;
		}

            //Copy queue1 into queue2
        queue2.copyQueue(queue1);

            //Instantiate queue3 with queue1
        queue3 = new LinkedQueueClass(queue1);

            //Add an additional string to queue1
        queue1.addQueue(new StringElement("?"));

            //Display and delete the contents
            //of queue1
        System.out.print("queue1: ");

        while(!queue1.isEmptyQueue())
        {
            System.out.print(queue1.front() + " ");
            queue1.deleteQueue();
        }

        System.out.println();

            //Display and delete the contents
            //of queue2
        System.out.print("queue2: ");

        while(!queue2.isEmptyQueue())
        {
            System.out.print(queue2.front() + " ");
            queue2.deleteQueue();
        }

        System.out.println();

            //Display and delete the contents
            //of queue1
        System.out.print("queue3: ");

        while(!queue3.isEmptyQueue())
        {
            System.out.print(queue3.front() + " ");
            queue3.deleteQueue();
        }

        System.out.println();
    }
}

/*  Sample Output

queue1: This Queue Class Works ?
queue2: This Queue Class Works
queue3: This Queue Class Works

*/