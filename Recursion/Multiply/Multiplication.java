//Recursion: Factorial
import java.util.Scanner;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Multiplication
{
    static Scanner scan = new Scanner(System.in);

	public static void main(String[] args)
	{
		int num1, num2;
		int again;
		String result;

        /*do
        {
		    result = JOptionPane.showInputDialog ("Enter The 1 Number: ");
		    num1 = Integer.parseInt(result);
		    result = JOptionPane.showInputDialog ("Enter The 2 Number: ");
		    num2 = Integer.parseInt(result);
		    result = "\n" + num1 + " / " + num2 + " = " +  multiply(num1, num2);
		    JOptionPane.showMessageDialog (null, result);
            again = JOptionPane.showConfirmDialog (null, "Do Another?");
        }
        while (again == JOptionPane.YES_OPTION);*/
        System.out.print("Enter 2 Numbers: ");
        num1 = scan.nextInt();
        num2 = scan.nextInt();

        while(num1 != -1)
        {
			System.out.println("\n" + num1 + " * " + num2 + " = " +  multiply(num1, num2));
			System.out.print("\nEnter 2 Numbers: ");
			num1 = scan.nextInt();
            num2 = scan.nextInt();
	    }
	}

	public static int multiply(int num1, int num2)
	{
	    if(num2 == 0)
	        return 0;

		else if(num1 < 0 || num2 < 0)
		{
	        if(num1 < 0)
	 	        num1 = -num1;
            else
                num2 = -num2;

            if(num2 > num1)
                return 0;
            else
	 	       return -1 - multiply(num1 - num2, num2);
		}

		else
	    {
	        if(num2 > num1)
	 	         return 0;
	        else
	 	    	return 1 + multiply(num1 - num2, num2);
	 	}
	}
}

/*    OUTput
Factorial of 4 = 24
Factorial of 10 = 3628800
*/
