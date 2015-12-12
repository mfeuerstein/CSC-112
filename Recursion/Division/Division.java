/**********************************************************
 * Program Name   : Division.java
 * Author         : Michael Feuerstein
 * Date           : March 28, 2012
 * Course/Section : CSC 112-001
 * Program Description:  This class asks the user for two
 *    numbers and divides the nubers by utilizing recursion.
 *
 **********************************************************/

/*
     UML Diagram
     -----------
     Class Name: Division
     -------------------------------
     Class Variables :
     +scan: static Scanner
     ---------------
     Class Methods :
     +main(String[]): static void
     +divide(int, int): int

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

     Program Logic - divide
     ----------------------
     1.  Divide num1 by num2
            Case 1: num2 equals 0
                Return 0
            Case 2: One or both numbers are negative
                Return a negative/positive number
            Case 3: Both numbers are positive
                Return a positive number
*/

import java.util.Scanner;

public class Division
{
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args)
	{
	    int num1, num2, goAgain;   //Numbers to be divided

        //Ask user if they want to do a dision
        //problem (or quit)
        System.out.print("Do a division equation?(1 - yes , 0 - no): ");
	    goAgain = scan.nextInt();

        //While user did not quit
	    while(goAgain == 1)
	    {
	        //Enter 2 numbers to be divided
	        System.out.print("\nEnter the two Numbers: ");
	        num1 = scan.nextInt();
	        num2 = scan.nextInt();

	        //Display results
	        System.out.println(num1 + " / " + num2 + " = " + divide(num1, num2));

            //Ask user if they want do another
            //problem (or quit)
            System.out.print("\nDo another equation?(1 - yes , 0 - no): ");
	        goAgain = scan.nextInt();
	    }
	}
        //Divides num1 by num2
        //Returns the result
	public static int divide(int num1, int num2)
	{
		//Case 1 : num2 equals 0
	    if(num2 == 0)
	    {
			System.out.print("ERROR: Divide by 0\n");
			return 0;
		}

        //Case 2 : One or both numbers
        //         are negative
		else if(num1 < 0 || num2 < 0)
		{
	        if(num1 < 0)
	 	        num1 = -num1;
            else
                num2 = -num2;

            if(num2 > num1)    //Fix for large neg num2
                return 0;
            else
	 	        return -1 - divide(num1 - num2, num2);
		}

        //Case 3 : Both numbers are
        //         positive
		else
	    {
	        if(num2 > num1)
	 	        return 0;
	        else
	 	        return 1 + divide(num1 - num2, num2);
	 	}
    }
}

/*  Sample Output

Do a division equation?(1 - yes , 0 - no): 1

Enter the two Numbers: 10 2
10 / 2 = 5

Do another equation?(1 - yes , 0 - no): 1

Enter the two Numbers: 10 -2
10 / -2 = -5

Do another equation?(1 - yes , 0 - no): 1

Enter the two Numbers: -10 2
-10 / 2 = -5

Do another equation?(1 - yes , 0 - no): 1

Enter the two Numbers: -10 -2
-10 / -2 = 5

Do another equation?(1 - yes , 0 - no): 1

Enter the two Numbers: 2 10
2 / 10 = 0

Do another equation?(1 - yes , 0 - no): 1

Enter the two Numbers: 2 -10
2 / -10 = 0

Do another equation?(1 - yes , 0 - no): 1

Enter the two Numbers: -2 10
-2 / 10 = 0

Do another equation?(1 - yes , 0 - no): 1

Enter the two Numbers: -2 -10
-2 / -10 = 0

Do another equation?(1 - yes , 0 - no): 1

Enter the two Numbers: 10 -1
10 / -1 = -10

Do another equation?(1 - yes , 0 - no): 1

Enter the two Numbers: -10 1
-10 / 1 = -10

Do another equation?(1 - yes , 0 - no): 1

Enter the two Numbers: -10 -1
-10 / -1 = 10

Do another equation?(1 - yes , 0 - no): 1

Enter the two Numbers: 0 10
0 / 10 = 0

Do another equation?(1 - yes , 0 - no): 1

Enter the two Numbers: 10 0
ERROR: Divide by 0
10 / 0 = 0

Do another equation?(1 - yes , 0 - no): 1

Enter the two Numbers: 10 3
10 / 3 = 3

Do another equation?(1 - yes , 0 - no): 1

Enter the two Numbers: 10 -3
10 / -3 = -3

Do another equation?(1 - yes , 0 - no): 1

Enter the two Numbers: -10 3
-10 / 3 = -3

Do another equation?(1 - yes , 0 - no): 1

Enter the two Numbers: -10 -3
-10 / -3 = 3

Do another equation?(1 - yes , 0 - no): 1

Enter the two Numbers: 10 4
10 / 4 = 2

Do another equation?(1 - yes , 0 - no): 1

Enter the two Numbers: 10 -4
10 / -4 = -2

Do another equation?(1 - yes , 0 - no): 1

Enter the two Numbers: -10 4
-10 / 4 = -2

Do another equation?(1 - yes , 0 - no): 1

Enter the two Numbers: -10 -4
-10 / -4 = 2

Do another equation?(1 - yes , 0 - no): 1

Enter the two Numbers: 5525 -5
5525 / -5 = -1105

Do another equation?(1 - yes , 0 - no): 0

*/
