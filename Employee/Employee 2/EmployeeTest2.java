/**********************************************************
 * Program Name   : EmployeeTest2.java
 * Author         : Michael Feuerstin
 * Date           : February 15, 2012
 * Course/Section : CSC 112-001
 * Program Description: Tests the methods of the child class,
 *    PartTimeEmployee.java, by creating an array of employee
 *    and calculating their wages based on hours worked,
 *    pay rate and overtime. Employee information will be read
 *    from a file and will be written to another file after
 *    being sorted in alphabetical order.
 *
 **********************************************************/

import java.io.*;
import java.util.*;

/*
     UML Diagram
     -----------
     Class Name: EmployeeTest2.java
     -------------------------------
     Class Variables:
     +SIZE: int
     +first: String
     +middle: String
     +last: String
     +payRate: double
     +hoursWorked: double
     +wages: double
     +count: int
     +emp[]: PartTimeEmployee[]
     +fRead: FileWriter
     +bRead: BufferedWriter
     +fWrite: FileWriter
     +bWrite: BufferedWriter
     +fileLine: String
     +tok: StringTokenzier
     ---------------
     Class Methods:
     +main(String[]): static void
     +sort(PartTimeEmployee, int): static void
     ----------------------------
     Class Files:
     +Employees.txt: txt
     +SortedEmployees.txt: txt

     Program Logic - main
     --------------------
     1.  Open files for reading and writing
     2.  Get the first line of the file
     3.  While there are lines in the file
         (employee information),
         do:
           a) Initialize wages
           b) Create a string tokenizer
           c) Read employee info from a file
              and store them
           d) Create an employee object in the
              employee array at position count
           e) Calculate the employee's wages
           f) Increment count and get next line
              (employee)
     4.  Display the array of objects after entering is finished
     5.  Sort the array by alphabetical order
     6.  Display the newly ordered array
     7.  Write ordered employee info to a file
     8.  Catch IO exception

     Program Logic - sort
     --------------------
     1. Compare and sort each name in the array
     2. Fill any holes in the array caused by
        Multiple instances of the same name
     3. Return the alphabetized array

*/
public class EmployeeTest2
{
	static Scanner fileScan = new Scanner(System.in);
	static Scanner recordScan = new Scanner(System.in);

	public static void main(String[] args)
	{
        //local constants
        final int SIZE = 20;    //size of employee array
        final int NUM_TOK = 5;  //number of name tokens
        final int NAME_TOK = 5; //number of double tokens
        final String QUIT = "0";    //quit value

		//local variables
		int choice;            //int value for entering while loop
		String first;          //employee's first name
		String middle;         //employee's middle name
		String last;           //employee's last name
		double payRate;        //employee's pay rate
		double hoursWorked;    //number of hours employee has worked
		double wages;          //employee's wages
		int count = 0;         //count of employees in employee array
		PartTimeEmployee emp[] = new PartTimeEmployee[SIZE];
		FileReader fRead;      //file reader
		BufferedReader bRead;  //buffered reader
		FileWriter fWrite;     //file writer
	    BufferedWriter bWrite; //buffered writer
        String fLine;          //input file line
        StringTokenizer tok;   //new tokenizer

      // ********** Lab 4c - #2 **********
      //  Enter information from an unsorted ASCII text file, Employees.txt
      try
	  {
		 //open file for reading
		 fRead = new FileReader("Employees.txt") ;
		 bRead = new BufferedReader(fRead);

		 //Open the output file for writing
	     fWrite = new FileWriter("SortedEmployees.txt");
         bWrite  = new BufferedWriter (fWrite);

		 //get first line of the file
		 fLine = bRead.readLine();

		 //while there are lines in the file
		 while(fLine != null)
		 {
		    //reset wages
		    wages = 0;

			//tokenize the input line
			tok = new StringTokenizer(fLine);

            first = tok.nextToken();
            middle = tok.nextToken();
            last = tok.nextToken();
            payRate = Double.parseDouble(tok.nextToken());
            hoursWorked = Double.parseDouble(tok.nextToken());

            //Create an object of the Employee class
            //and store in array at postion count
            emp[count] = new PartTimeEmployee(first,middle,last,payRate,hoursWorked);

            //calculate employee's wages
            wages += emp[count].calculatePay();

            //Increment count
            count++;

            //get next line
		   	fLine = bRead.readLine();
		 }

		 //Display the array of objects after entering is finished
         System.out.println("\n" + "unsorted" + "\n" + "--------");

		 for(int pos = 0; pos < count; pos++)

           System.out.println("\n" + emp[pos] + "\n" + "------------------");

         //Sort the array by alphabetical order
		 emp = sort(emp, count);

         //Display the newly ordered array
         System.out.println("\n" + "sorted" + "\n" + "------");

         for(int pos = 0; pos < count; pos++)

		    System.out.println("\n" + emp[pos] + "\n" + "------------------");

		 System.out.println("\n\n");

         //write sorted employee information to a file
         for(int pos = 0; pos < count; pos++)

		    bWrite.write("\n" + emp[pos] + "\n" + "------------------");

	     bWrite.flush ();
         bWrite.close ();


	  }//end try

	  catch(IOException ex)
	  {

		 //Display the nature of the exception and where it occured
		 System.out.println("Error");
		 ex.printStackTrace();

	  }

   }
          //sorts each employee in the employee array by
          //alphabetical order of the employee names
   public static PartTimeEmployee[] sort(PartTimeEmployee[] emp,int count)
   {
      //local variables
	  PartTimeEmployee temp[]
		        = new PartTimeEmployee[20]; //empty employee array
	  int addCount;                       //count of name order placement


	  //Compare and sort each name in the array
	  for(int pos = 0; pos < count; pos++)
      {
	     addCount = 0;

         for(int i = 0; i < count; i++)
		 {
		    if(emp[pos].compareTo(emp[i]) > 0)

			   addCount++;
		 }

		 temp[addCount] = emp[pos];
	  }

      //Fill any holes in the array caused by
      //Multiple instances of the same name
	  for(int pos = 0; pos < count; pos++)

	     if(temp[pos] == null)

		    temp[pos] = temp[pos - 1];

      //return the alphabetized array
   	  return temp;

   }
}

/* Sample Output

unsorted
--------

Mike A Feuerstein wages are: $400.00
------------------

Tom F Jones wages are: $1.00
------------------

Bill H Adams wages are: $400.00
------------------

Alexander Z Feuerstein wages are: $25.00
------------------

William H Macy wages are: $1000000.00
------------------

Tim F Jones wages are: $1100.00
------------------

Tim B Jones wages are: $1000.00
------------------

Johnny B Good wages are: $215000.00
------------------

Who Am I wages are: $100.00
------------------

I Am you wages are: $100.00
------------------

Alex Adrien Anderson wages are: $1.00
------------------

sorted
------

Bill H Adams wages are: $400.00
------------------

Alex Adrien Anderson wages are: $1.00
------------------

Alexander Z Feuerstein wages are: $25.00
------------------

Mike A Feuerstein wages are: $400.00
------------------

Johnny B Good wages are: $215000.00
------------------

Who Am I wages are: $100.00
------------------

Tim B Jones wages are: $1000.00
------------------

Tim F Jones wages are: $1100.00
------------------

Tom F Jones wages are: $1.00
------------------

William H Macy wages are: $1000000.00
------------------

I Am you wages are: $100.00
------------------


*/