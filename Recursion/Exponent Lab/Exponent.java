/**********************************************************
 * Program Name   : Exponent.java
 * Author         : Michael Feuerstein
 * Date           : March 31, 2012
 * Course/Section : CSC 112-001
 * Program Description:  This class asks the user for two
 *    numbers. The first number is raised to the power of
 *    the second number.
 *
 **********************************************************/

/*
     UML Diagram
     -----------
     Class Name: Exponent
     -------------------------------
     Class Variables :
     +scan: static Scanner
     ---------------
     Class Methods :
     +main(String[]): static void
     +power(double, double): static double
     +multiply(double, double): static double

     Program Logic - main
     --------------------
     1.  Ask user if they want to do a dision
         problem(or quit)
     2.  While user did not quit
         1) Get two numbers
         2) Divide number1 by number2 and
            Display the results of the division
         3) Ask user if they want to do another
            problem(or quit)

     Program Logic - power
     ---------------------
     1.  Check if base is zero
     2.  Check if exponent = 0
     3.  Check if exponent is negaitve
     4.  Return power raised to exponent

      rogram Logic - multiply
     ------------------------
     1.  Check if either number = 0
     2.  Check if number2 is negaive
     3.  Check if number 2 = 1
     4.  Return number1 times number 2
*/

import java.util.Scanner;

public class Exponent
{
    static Scanner scan = new Scanner(System.in);

	public static void main(String[] args)
	{
		double num1, num2, goAgain;
		double again;

        //Ask user if they want to do a power
        //equation (or quit)
        System.out.print("Do a power equation?(1 - yes , 0 - no): ");
	    goAgain = scan.nextInt();

        //While user did not quit
	    while(goAgain == 1)
	    {
            //Get two numbers
            System.out.print("Enter 2 Numbers: ");
            num1 = scan.nextInt();
            num2 = scan.nextInt();

            //Call power to raise num1 by num2
            //and display the result
			System.out.println("\n" + num1 + " ^ " + num2 + " = " +  power(num1, num2));

            //Ask user if they want do another
            //equation (or quit)
            System.out.print("\nDo another equation?(1 - yes , 0 - no): ");
	        goAgain = scan.nextInt();
		}
	}
        //Raises a number by an exponent
	public static double power(double base, double exp)
	{
        if(base == 0)
            return 0;

	    if(exp == 0)
	        return 1;

        //If the exponent is negaitve,
        //make the exponent positve and
        //alter the base so that the method will
        //return a negative exponent result
	    if(exp < 0)
	    {
			exp = -exp;
	        base = 1 / base;
        }

        //Returns a recursion of the base multiplied by
        //itself an exp number of times
	 	return base * power(base, exp - 1); //multiply(base, power(base, exp - 1));
	}

        //Multiplies two numbers together
	public static double multiply(double num1, double num2)
	{
	   //If either num = 0
	   //return 0
	   if(num1 == 0 || num2 == 0)
	      return 0;

       //If num2 is negative,
       //change the signs of num1 and num2
	   if(num2 < 0)
	   {
		   num1 = num1 - num1 - num1;
           num2 = num2 - num2 - num2;
       }

       //If num2 = 1
       //Return num1
	   if(num2 == 1)
	 	    return num1;

	   //Else return num1 plus num1
	   //a num2 number of times
	   else
           return num1 + multiply(num1, num2 - 1);
	}
}

/*  Sample Output

Do a power equation?(1 - yes , 0 - no): 1
Enter 2 Numbers: 2 3

2.0 ^ 3.0 = 8.0

Do another equation?(1 - yes , 0 - no): 1
Enter 2 Numbers: 2 0

2.0 ^ 0.0 = 1.0

Do another equation?(1 - yes , 0 - no): 1
Enter 2 Numbers: -2 2

-2.0 ^ 2.0 = 4.0

Do another equation?(1 - yes , 0 - no): 1
Enter 2 Numbers: -2 3

-2.0 ^ 3.0 = -8.0

Do another equation?(1 - yes , 0 - no): 1
Enter 2 Numbers: 2 -2

2.0 ^ -2.0 = 0.25

Do another equation?(1 - yes , 0 - no): 1
Enter 2 Numbers: -2 -3

-2.0 ^ -3.0 = -0.125

Do another equation?(1 - yes , 0 - no): 1
Enter 2 Numbers: 0 0

0.0 ^ 0.0 = 0.0

*/
