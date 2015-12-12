//Recursion: Factorial
import java.util.Scanner;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Multiply
{
    static Scanner scan = new Scanner(System.in);

	public static void main(String[] args)
	{
		int num1, num2;
		int again;
		String result;

        /*do
        {
		    result = JOptionPane.showInputDialog ("Enter The Number: ");
		    num1 = Integer.parseInt(result);
		    result = "Factorial of " + num1 + " = " + fact(num1);
		    JOptionPane.showMessageDialog (null, result);
            again = JOptionPane.showConfirmDialog (null, "Do Another?");
        }
        while (again == JOptionPane.YES_OPTION);*/
        System.out.print("Enter 2 Numbers: ");
        num1 = scan.nextInt();
        num2 = scan.nextInt();

        while(num1 != -1)
        {
			System.out.println("\n" + num1 + " * " + num2 + " = " +  multiply(num1, num1, num2));
			System.out.print("\nEnter 2 Numbers: ");
			num1 = scan.nextInt();
            num2 = scan.nextInt();
	    }
	}

	public static int multiply(int num1, int num2, int exp)
	{
	   if(num1 == 0 || num2 == 0)
	      return 0;

	   if(num2 < 0)
	   {
		   num1 = num1 - num1 - num1;
           num2 = num2 - num2 - num2;
       }

	   if(num2 == 1 || exp == 1)
	 	    return num1;
	   else
	 		//return num1 * multiply(num1, num2 - 1);
	 		return multiply(num1 + multiply(num1, num2 - 1, exp) - exp, num2, exp - 1);
	}
}

/*    OUTput
Factorial of 4 = 24
Factorial of 10 = 3628800
*/
