/**********************************************************
 * Program Name   : PartTimeEmployee.java
 * Author         : Michael Feuerstin
 * Date           : February, 8 2012
 * Course/Section : CSC 112-001
 * Program Description: Creates and manages instances of an
 *    employee, child of the person.java class
 *
 **********************************************************/

/*
     UML Diagram
     -----------
     Class:  PartTimeEmployee.java
     --------------
     Class Variables
     -OVERTIME: int
     -OVERTIME_PAY: double
     -payRate: double
     -hoursWorked: double
     -------------------
     Class Methods
     +PartTimeEmployee()
     +PartTimeEmployee(String, String,
               String, double, double)
     +Person.java methods
     +toString(): String
     +getDisplay(double): void
     +calculatePay(): double
     +setNameRateHours(String, String,
      String, double, double): void
     +getPayRate(): double
     +getHoursWorked(): double
     +formatCash(int): String
*/

import java.text.*;

public class PartTimeEmployee extends Person
{
	//local constants
	private final int OVERTIME = 40; //hours worked until overtime
	private	final double OVERTIME_RATE = 1.5; //overtime rate
    private double payRate;     //store the pay rate
    private double hoursWorked; //store the hours worked

        //Default constructor
        //Set the first name, last name, payRate, and
        //hoursWorked to the default values.
        //The first name and last name are initialized to an empty
        //string by the default constructor of the superclass.
        //Postcondition: firstName = ""; lastName = "";
        //               payRate = 0; hoursWorked = 0;
    public PartTimeEmployee()
    {
        super();
        payRate = 0;
        hoursWorked = 0;
    }

        //Constructor with parameters
        //Set the first name,middle, last name, payRate, and
        //hoursWorked according to the parameters.
        //Parameters first, middle and last are passed to the
        //superclass.
        //Postcondition: firstName = first; middleName = middle
        //                        lastName = last;
        //               payRate = rate; hoursWorked = hours;
    public PartTimeEmployee(String first, String middle, String last,
                           double rate, double hours)
    {
        super(first, middle, last);
        payRate = rate;
        hoursWorked = hours;
    }

        //Method to return the string consisting of the
        //first name, last name, and the wages in the form:
        //firstName lastName wages are $$$$.$$
    public String toString()
    {
        return (super.toString() + " wages are: " + calculatePay());
    }

        //Method to return the string consisting of the
        //first name, last name, and the wages in the form:
        //firstName lastName wages are $$$$.$$
    public void getDisplay(double wages)
    {
        System.out.println("\n" + "Employee Information" + "\n");
              /*+ "--------------------" + "\n"
              + "Name    : " + getFirstName() + " "
              + getMiddleName()
              + " " + getLastName() + "\n\n"
              + "Pay Rate: " + formatCash(payRate)
              + "\n\n" + "Hours   : " + hoursWorked
              + "\n\n" + "Wages   : " + formatCash(wages));*/
    }

        //Method to calculate and return the wages
    public double calculatePay()
    {
		//if employee worked overtime, then calc overtime pay
		if(hoursWorked > OVERTIME)

			return ((hoursWorked - OVERTIME) * payRate
			* OVERTIME_RATE + payRate * OVERTIME);

	    else
        return (payRate * hoursWorked);
    }

        //Method to set the first name, last name, payRate,
        //and hoursWorked according to the parameters.
        //The parameters first and last are passed to the
        //superclass.
        //Postcondition: firstName = first; lastName = last;
        //               payRate = rate; hoursWorked = hours;
    public void setNameRateHours(String first, String middle, String last,
                                 double rate, double hours)

    {
        setName(first, middle, last);
        payRate = rate;
        hoursWorked = hours;
    }

        //Method to return the pay rate
        //Postcondition: The value of payRate is returned
    public double getPayRate()
    {
        return payRate;
    }

        //Method to return the number of hours worked
        //Postcondition: The value of hoursWorked is returned
    public double getHoursWorked()
    {
        return hoursWorked;
    }

        //Method to format change for a customer
	    //the change is returned as a string
	public String formatCash(double cash)
	{
		DecimalFormat fmt = new DecimalFormat("0.00"); //money format
		String money; //money string to return

        money = "$" + fmt.format(cash);

		return money;
    }

}
