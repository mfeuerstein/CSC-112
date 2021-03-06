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
     +OVERTIME: int
     +OVERTIME_RATE: double
     +choice: int
     +first: String
     +middle: String
     +last: String
     +payRate: double
     +hoursWorked: int
     +wages: double
     ---------------
     Class Methods
     +main(String[]): static void

     Program Logic
     -------------
     1.  Ask to get an employee
         a) If yes, enter while
         b) If no, exit program
     2.  Initialize wages to 0
     3.  Input the first, middle and last names
         of an employee
     4.  Create an object of the Employee class
     5.  If employee worked overtime, then calculate
         overtime pay
     6.  Calculate employee's wages
     7.  Display the employee's name, payRate,
         hoursWorked and grossPay
     8.  Ask to get another employee
*/

import javax.swing.*;
import java.awt.*;

public class EmployeeTest
{
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args)
	{


		//local variables
		int choice, again;       //int value for entering while loop
		String first;     //employee's first name
		String middle;    //employee's middle name
		String last;      //employee's last name
		double payRate;   //employee's pay rate
		int hoursWorked;  //number of hours employee has worked
		double wages = 0;     //employee's wages
		String result;

        do
        {

		   //Input the first, middle and last names of an employee
		   first = JOptionPane.showInputDialog ("Enter the first name: ");
		   middle = JOptionPane.showInputDialog ("Enter the middle name: ");
		   last = JOptionPane.showInputDialog ("Enter the last name: ");

           //Input the payRate and hoursWorked
           payRate = Double.parseDouble(JOptionPane.showInputDialog ("Enter the hourly rate of pay: "));
           hoursWorked = Integer.parseInt(JOptionPane.showInputDialog ("Enter the # of hours worked : "));

           //Create an object of the Employee class
           PartTimeEmployee emp =
           new PartTimeEmployee(first,middle,last,payRate,hoursWorked);

           //calculate employee's wages
           wages += emp.calculatePay();

           //Display the employee's name, payRate, hoursWorked and grossPay
           result = ("\n" + "Employee Information" + "\n"
                                   + "--------------------" + "\n"
                                   + "Name    : " + first +" " + middle
                                   + " " + last + "\n\n"
                                   + "Pay Rate: " + emp.formatCash(payRate)
                                   + "\n\n" + "Hours   : " + hoursWorked
                                   + "\n\n" + "Wages   : " + emp.formatCash(wages));
           JOptionPane.showMessageDialog (null, result);

           //ask to get another employee
           again = JOptionPane.showConfirmDialog (null, "Do Another?");

	    }
        while (again == JOptionPane.YES_OPTION);

    }
}

/* Sample Output
Get an employee? 1 - yes  2 - no: 1

Please enter the following information

Enter the first name: Mike
Enter the middle name: A
Enter the last name: Feuerstein
Enter the hourly rate of pay: 10
Enter the # of hours worked : 50

Employee Information
--------------------
Name    : Mike A Feuerstein

Pay Rate: $10.00

Hours   : 50

Wages   : $550.00

Go Again? 1 - yes  2 - no:

*/