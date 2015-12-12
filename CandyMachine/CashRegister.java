/**********************************************************
 * Program Name   : CashRegister.java
 * Author         : Michael Feuerstin
 * Date           : February 3, 2012
 * Course/Section : CSC 112-001
 * Program Description: Creates and manages a cash register
 *    sets cash on hand in machine
 *
 **********************************************************/

/*
     UML diagram
     -----------
     Class:  CashRegister
     -------------
     Class Variables:
     -cashOnHand: int
     +fmt: Decimal Format
     +temp: float
     +change: String
     ---------------
     Class Methods:
     +CashRegister(int)
     +CashRegister()
     +currentBalance():  int
     +acceptAmount(int): void
     +formatChange(int): float
*/

import java.text.*;

public class CashRegister

{
    private int cashOnHand;   //variable to store the cash
                              //in the register

        //Constructor with parameters
        //To set the cash in the register to a specific amount
        //Postcondition: cashOnHand = cashIn;
    public CashRegister(int cashIn)
    {
        if(cashIn >= 0)
         cashOnHand = cashIn;
        else
             cashOnHand = 500;
    }

        //Default constructor with parameters
        //To set the cash in the register 500 cents
        //Postcondition: cashOnHand = 500;
    public CashRegister()
    {
         cashOnHand = 500;
    }

        //Method to show the current amount in the cash register
        //Postcondition: The value of the instance variable
        //cashOnHand is returned
    public int currentBalance()
    {
      return cashOnHand;
    }

        //Method to receive the amount deposited by
        //the customer and update the amount in the register.
        //Postcondition: cashOnHand = cashOnHand + amountIn
    public void acceptAmount(int amountIn)
    {
        cashOnHand = cashOnHand + amountIn;
    }

        //Method to format change for a customer
	    //the change is returned as a string
	public String formatChange(int cash)
	{
		DecimalFormat fmt = new DecimalFormat("0.00"); //money format
		float temp;    //varibale to store change as a float
		String change; //change to give back to the customer

		temp = (float) cash / 100
				 + (cash % 100)/100;

        change = "$" + fmt.format(temp);

		return change;
    }

}
