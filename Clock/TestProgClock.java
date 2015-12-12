/**********************************************************
 * Program Name   : TestProgClock.java
 * Author         : Michael Feuerstin
 * Date           : January 27, 2012
 * Course/Section : CSC 112-001
 * Program Description: Tests all of the methods of the clock
 *    class
 *
 **********************************************************/

/*
     UML Diagram
     -----------
     Class Name: TestProgClock.java
     -------------------------------
     Class Variables
     +seconds: int
     +hours: int
	 +minutes: int
	 +scan: Scanner
     ---------------
     Class Methods
     +main(String[]): void

     Program Logic
	  -------------
Define hours, minutes and seconds as integers

Define clock1 with values
Define clock2 with default values
Display clock1
Display clock2

Is clock1 = clock2?

Give values to clock2 using setTime() method
Display clock2

Is clock1 = clock2?

Make a copy of clock1 and place that copy into clock2 using the makeCopy() method
Display clock1
Display clocl2

Is clock1 = clock2?

Enter hours, minutes and seconds
Give these values to clock3 using the copy constructor
Display clock3

Increment the seconds of clock3
Display clock3
*/

import java.io.*;
import java.util.Scanner;

public class TestProgClock
{

    public static void main(String[] args)
    {

       //local constants

       //local variables
       int seconds;                  //seconds on clock
       int hours;                    //hours on clock
       int minutes;                  //minutes on clock
       Scanner scan = new Scanner(System.in);

       /********************   Start main method  *****************/

       //create clock one
       Clock Clock1 = new Clock(12,27,30);

       //create clock two
       Clock Clock2 = new Clock();

       //display clock one
       System.out.println("clock1 =  " + Clock1);

       //display clock two
       System.out.println("clock2 =  " + Clock2);

       //if clock one equals clock 2
       if(Clock1.equals(Clock2))

          //display clock times are eqaul message
          System.out.println("They are equal");

       //else they are not equal
       else

          //display clock times not equals message
          System.out.println("They are not equal");

       //give new values to clock 2
       Clock2.setTime(12,38,45);

       //display clock one
	   System.out.println( "\n" + "clock1 =  " + Clock1);

	   //display clock two
	   System.out.println("clock2 =  " + Clock2);

	   //if clock one equals clock 2
	   if(Clock1.equals(Clock2))

	      //display clocks are eqaul message
	      System.out.println("They are equal");

	   //else they are not equal
	   else

	      //display not equals message
          System.out.println("They are not equal");

       //make a copy of clock 1 into clock 2
       Clock2.makeCopy(Clock1);

       //display clock one
	   System.out.println("\n" + "clock1 =  " + Clock1);

	   //display clock two
	   System.out.println("clock2 =  " + Clock2);

	   //if clock one equals clock 2
	   if(Clock1.equals(Clock2))

	      //display clocks are eqaul message
	      System.out.println("They are equal");

	   //else they are not equal
	   else

	      //display not equals message
          System.out.println("They are not equal");

       scan.nextLine();

       //ask user for times for clock 3
       System.out.print("\n" + "Enter the Hours for clock 3   : ");
       hours = scan.nextInt();
       System.out.print("Enter the Minutes for clock 3 : ");
       minutes = scan.nextInt();
       System.out.print("Enter the Seconds for clock 3 : ");
       seconds = scan.nextInt();

       //create clock 3
       Clock Clock3 = new Clock(hours,minutes,seconds);

       //display Clock 3
       System.out.println("\n" + "clock3 = " + Clock3);

       //increment seconds of clock 3
       Clock3.incrementSeconds();

       //display Clock 3
       System.out.println("clock3 = " + Clock3);
       System.out.println("\n\n\n\n");

    }//end main
}

/*sample output
clock1 =  12:27:30
clock2 =  00:00:00
They are not equal

clock1 =  12:27:30
clock2 =  12:38:45
They are not equal

clock1 =  12:27:30
clock2 =  12:27:30
They are equal

Enter the Hours for clock 3   : 1
Enter the Minutes for clock 3 : 2
Enter the Seconds for clock 3 : 3

clock3 = 01:02:03
clock3 = 01:02:04
*/



