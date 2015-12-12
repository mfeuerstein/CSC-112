/**********************************************************
 * Program Name   : Example3_1.java
 * Author         : Michael Feuerstin
 * Date           : February 24, 2012
 * Course/Section : CSC 112-001
 * Program Description: This class tests the methods of the
 *    ArrayListClass and its child class, UnorderedArrayList,
 *    as well as the DataElement class and its child class,
 *    IntElement.  This version includes reading and writing
 *    numbers from a file.
 *
 **********************************************************/

/*
     UML Diagram
     -----------
     Class Name: Example3_1
     -------------------------------
     Class Variables :
     +scan: static Scanner
     +fileScan: Scanner
     +recordScan: Scanner
     +stringList: UnorderedArrayList
     +num: IntElement
     +record: String
     +fw: FileWriter
     +bw: BufferedWriter
     ---------------
     Class Methods :
     +main(String[]): static void

     Program Logic
     -------------
     1.  Set scanner fileScan to read from a file
     2.  Begin reading from the file
     3.  Get the next line from the file
     4.  Set scanner recordScan to read the line
     5.  While reading the next line
            a)Convert the next integer from record
		    b)Insert the int into the list
     6.  Close the file
     7.  Display the list
     8.  Sort and Display the list
     9.  Add another number to the list
     10. Expand the list, and print out the amount of
         room left in the list
     11. Ask for five more numbers to be added to the list
     12. Display the updated list
     13. Sort and display the updated list
     14. Write intList over the file, and
         define the filewriter object fw and buffered writer
     15. Reset record
     16. For each number in the list
     17. Add the number at the specified position to record
     18. Write the record line to the file
     19. Acknowledge that the file has been chaged
     20. Flush and lose the writer
*/

import java.io.*;
import java.util.*;

public class Example3_1
{
	static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException
    {
		//local constants
		final int SIZE = 15;

        //local variables
        UnorderedArrayList intList
           = new UnorderedArrayList(SIZE);  //array of integers
        IntElement num = new IntElement();  //an int element, holds an int
        Scanner fileScan;                   //scanner for reading from a file
        Scanner recordScan;                 //scanner for reading a line
        String record;                      //string to hold a line for reading/writing
        FileWriter fw;                      //file writer
		BufferedWriter bw;                  //buffered writer

        //main
        //----

		//Set scanner fileScan to read from a file
        fileScan = new Scanner(new File("ints.txt"));

        //Begin reading from the file
        while (fileScan.hasNext())
        { // begin outer while loop

           // Get the next line from the file
           record = fileScan.nextLine();

           // Set scanner recordScan to read the line
           recordScan = new Scanner (record);
           recordScan.useDelimiter(" ");

           //while reading the next line
           while(recordScan.hasNext())
           { // begin inner while loop

              //Convert the next integer from record
              num.setNum(recordScan.nextInt());

              //Insert the int into the list
              intList.insert(num);
		   }
        }

        //close the file
        fileScan.close();

        //Display the list
        System.out.print("The list you "
                       + "entered is: ");
        intList.print();
        System.out.println();

        //Sort the list and display the list
        intList.sort();
        System.out.println();
		System.out.print("The ordered list is: ");
		intList.print();
        System.out.println();

        //Add another number to the list
        System.out.print("Enter another number: ");
        num.setNum(scan.nextInt());
        intList.insert(num);

        //Expand the list, and print the amount of room left
        System.out.println("The file now has room for " + (intList.maxListSize()
                         - intList.listSize()) + " more numbers");

        //Ask for five more numbers to be added
        System.out.print("\n" +"Enter five more integers on a single"
                       + " line to be added to the array: ");
        for(int i = 0; i < 5; i++)
        {
           num.setNum(scan.nextInt());
           intList.insert(num);
		}

		//Display the updated list
        System.out.print("\nThe updated list is: ");
        intList.print();
        System.out.println();

        //Sort and display the updated list
        intList.sort();
        System.out.print("The updated ordered list is: ");
        intList.print();

        //Write intList over the file, and
        //define the filewriter object fw and buffered writer
        fw = new FileWriter("ints.txt",false /*clears the contents*/);
        bw = new BufferedWriter(fw);

        //Reset record
        record = "";

        //for each number in the list
        for(int i =0; i < intList.listSize(); i++)

           //add the number to record
           record += intList.retrieveAt(i) + " ";

        //Write the record line to the file
        bw.write(record);

        //Acknowledge that the file has been chaged
        System.out.println("\nFile has been updated");
        System.out.println("\n\n");

        //Close and flush the buffered writer
        bw.flush();
        bw.close();
    }
}

/*    OUTPUT
The list you entered is: 72 48 33 11 81 25 64 52 29 14 0 12 99 22 92


The ordered list is: 0 11 12 14 22 25 29 33 48 52 64 72 81 92 99

Enter another number: 10
List Expanded
The file now has room for 14 more numbers

Enter five more integers on a single line to be added to the array: 5 4 3 2 1

The updated list is: 0 11 12 14 22 25 29 33 48 52 64 72 81 92 99 10 5 4 3 2 1

The updated ordered list is: 0 1 2 3 4 5 10 11 12 14 22 25 29 33 48 52 64 72 81
92 99

File has been updated



Press any key to continue . . .


*/

