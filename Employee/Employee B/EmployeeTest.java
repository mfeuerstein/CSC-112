/**********************************************************
 * Program Name   : EmployeeTest.java
 * Author         : Michael Feuerstin
 * Date           : February 8, 2012
 * Course/Section : CSC 112-001
 * Program Description: Tests the methods of the child class,
 *    PartTimeEmployee.java, by creating an employee and calculating
 *    their wages based on hours worked, pay rate and overtime.
 *
 **********************************************************/

import java.io.*;
import java.util.Scanner;

/*
     UML Diagram
     -----------
     Class Name: TestProgPerson.java
     -------------------------------
     Class Variables
     +scan: static Scanner
     +SIZE: int
     +choice: int
     +first: String
     +middle: String
     +last: String
     +payRate: double
     +hoursWorked: int
     +wages: double
     +count: int
     +emp: partTimeEmployee
     ---------------
     Class Methods
     +main(String[]): static void
     +sort(PartTimeEmployee, int): static void

     Program Logic - main
     --------------------
     1.  Ask to get an employee
         a) If yes, enter while
         b) If no, exit program
     2.  Initialize wages to 0
     3.  Input the first, middle and last names
         of an employee
     4.  Create an object of the Employee class
         and store in array at postion count
     5.  If employee worked overtime, then calculate
         overtime pay
     6.  Calculate employee's wages
     7.  Increment count
     8.  Ask to get another employee
     9.  Display the array of objects after entering is finished
     10. Sort the array by alphabetical order
     11. Display the newly ordered array

     Program Logic - sort
     --------------------
     1. Compare and sort each name in the array
     2. Fill any holes in the array caused by
        Multiple instances of the same name
     3. Return the alphabetized array

*/
public class EmployeeTest
{
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args)
	{
        //local constants
        final int SIZE = 20; //size of employee array

		//local variables
		int choice;          //int value for entering while loop
		String first;        //employee's first name
		String middle;       //employee's middle name
		String last;         //employee's last name
		double payRate;      //employee's pay rate
		int hoursWorked;     //number of hours employee has worked
		double wages;        //employee's wages
		int count = 0;       //count of employees in employee array
		PartTimeEmployee emp[] = new PartTimeEmployee[SIZE];
		                     //array of employees

		//ask to get an employee
		System.out.print("Get an employee? 1 - yes  2 - no: ");
		choice = scan.nextInt();

        //enter while loop and process employee
        while(choice == 1)
        {
		   //reset wages
		   wages = 0;

		   //Input the first, middle and last names of an employee
		   System.out.println("\nPlease enter the following information\n");
		   System.out.print ("Enter the first name: ");
           first = scan.next();
           System.out.print ("Enter the middle name: ");
           middle = scan.next();
		   System.out.print ("Enter the last name: ");
           last = scan.next();

           //Input the payRate and hoursWorked
           System.out.print ("Enter the hourly rate of pay: ");
           payRate = scan.nextDouble();
           System.out.print ("Enter the # of hours worked : ");
           hoursWorked = scan.nextInt();

           //Create an object of the Employee class
           //and store in array at postion count
           emp[count] = new PartTimeEmployee(first,middle,last,payRate,hoursWorked);

           //calculate employee's wages
           wages += emp[count].calculatePay();

           //Increment count
           count++;

           //ask to get another employee
           System.out.print ("\nGo Again? 1 - yes  2 - no: ");
           choice = scan.nextInt();

	    }

        //Display the array of objects after entering is finished
        System.out.println("\n\n" + "unsorted" + "\n" + "--------");
		for(int pos = 0; pos < count; pos++)

		   System.out.println("\n" + emp[pos] + "\n" + "------------------");

        //Sort the array by alphabetical order
		emp = sort(emp, count);

        //Display the newly ordered array
        System.out.println("\n" + "sorted" + "\n" + "------");
        for(int pos = 0; pos < count; pos++)

		  System.out.println("\n" + emp[pos] + "\n" + "------------------");

		System.out.println("\n\n");
    }

          //sorts each employee in the employee array by
          //alphabetical order of the employee names
    public static PartTimeEmployee[] sort(PartTimeEmployee[] emp,int count)
    {
		//local variables
		PartTimeEmployee temp[]
		          = new PartTimeEmployee[20]; //empty employee array
		int addCount;                         //count of name order placement


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
Get an employee? 1 - yes  2 - no: 1

Please enter the following information

Enter the first name: Mike
Enter the middle name: A
Enter the last name: Jones
Enter the hourly rate of pay: 10
Enter the # of hours worked : 40

Go Again? 1 - yes  2 - no: 1

Please enter the following information

Enter the first name: MIke
Enter the middle name: A
Enter the last name: Johns
Enter the hourly rate of pay: 10
Enter the # of hours worked : 50

Go Again? 1 - yes  2 - no: 1

Please enter the following information

Enter the first name: Mike
Enter the middle name: A
Enter the last name: Adams
Enter the hourly rate of pay: 15
Enter the # of hours worked : 40

Go Again? 1 - yes  2 - no: 2


unsorted
--------

Mike A Jones wages are: $400.00
------------------

MIke A Johns wages are: $550.00
------------------

Mike A Adams wages are: $600.00
------------------

sorted
------

Mike A Adams wages are: $600.00
------------------

MIke A Johns wages are: $550.00
------------------

Mike A Jones wages are: $400.00
------------------


*/