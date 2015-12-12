/**********************************************************
 * Program Name   : ChangeBase.java
 * Author         : Michael Feuerstein
 * Date           : April 4, 2012
 * Course/Section : CSC 112-001
 * Program Description:  This class asks the user for
 *    two numbers. The first Number then gets converted to
 *    the base of of the second number and displayed.
 *
 **********************************************************/

/*
     UML Diagram
     -----------
     Class Name: ChangeBase
     -------------------------------
     Class Variables :
     +scan: static Scanner
     ---------------
     Class Methods :
     +main(String[]): static void
     +changeBase(long, long): static void

     Program Logic - main
     --------------------
     1.  Get a number
     2.  Get a base(up to 16)
     3.  Call changeBase to convert the
         number to the specified base
         and display it

     Program Logic - changeBase
     --------------------------
     1.  Re-call the method, with num/base and base
         Until num = 0
     2.  Check if Base is too big
     3.  Check is converted number is
         larger than 9
     4.  Convert Number to the specified base
         and display it

         1) Num < 10 are displayed as numbers
         2) Num >= 10 are displayed as letters
*/

import java.util.Scanner;

public class ChangeBase
{
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args)
    {
        long num;     //Base 10 Number to be converted
        long base;    //Base used for the number conversion

        //Get a number
        System.out.print("Enter number: ");
        num = scan.nextLong();

        //Get a base(up to 16)
        System.out.print("Enter base(up to 16): ");
        base = scan.nextLong();

        //Convert the number to the specified base
        //and display it
        System.out.print("\n" + num + " Base 10 = ");
        changeBase(num, base);
        System.out.println(" Base " + base + "\n");
    }

        //Takes two numbers, the first number is converted
        //to the base of the second number.
        //The result is then displayed
    public static void changeBase(long num, long base)
    {

		char letter = 55;    //Letter used to denote converted
		                     //base numbers greater than 10.
		                     //A = 10

        //If num is not zero
        if(num > 0)
        {
			//Divide num by base and re call the method
			//This recurring stops when a 0 is returned
            changeBase(num/base, base);

            //Checks if base is too big for
            //Letter representation
            if(base > 16)
            {
				//Display error message and quit
				System.err.println("Base is too big");
				scan.nextLine();
				System.exit(1);
			}

		    //Checks if the converted base number is
		    //10 or greater
            else if(num % base > 9)
			{
				//Return a letter representation
				//of the converted number
				//Where : A = 10... G = 16
				letter += num % base;
				System.out.print(letter);
		    }

            //Converted number is less than 10
            else

                //Print the number out
                System.out.print(num % base);
        }

   }
}

/*    OUTPUT

Enter number: 20000
Enter base(up to 16): 16

20000 Base 10 = 4E20 Base 16

*/
