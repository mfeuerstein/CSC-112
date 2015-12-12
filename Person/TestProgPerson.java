/**********************************************************
 * Program Name   : TestProgPerson.java
 * Author         : Michael Feuerstin
 * Date           : February 1, 2012
 * Course/Section : CSC 112-001
 * Program Description: Tests all of the methods of the Person
 *    class
 *
 **********************************************************/
import java.io.*;

/*
     UML Diagram
     -----------
     Class Name: TestProgPerson.java
     -------------------------------
     Class Variables
     +P1: Person
     +P2: Person
     +P3: Person
     +P4: Person
     +P5: Person
     ---------------
     Class Methods
     +main(String[]): void

     Program Logic
     -------------
********** Extend the TestProgPerson class on p. 44 by adding the following tests  *************
* Test the:
*   default, value and copy constructors
*   getLastName() methods
*   getFirstName() methods
*   getMiddleName() methods
*   boolen equals() method
*   algebraic compareTo() method
*   makeCopy and getCopy methods
****************************************************************


*/

public class TestProgPerson
{
    public static void main(String[] args)
    {
		//default, value and copy constructors
        Person P1 = new Person();

        Person P2 = new Person("Donald","D.","Duck");

        System.out.println("Default Value of P1: " + P1);

        P1.setName("Sleeping", "Well", "Beauty");
        System.out.println("setName Value of P1: " + P1);

        System.out.println("Original Value of P2: " + P2);

        P2.setName("Sandy", "Shady", "Smith");
        System.out.println("setName Value of P2: " + P2);

        Person P3 = new Person(P1);
        System.out.println("Constructor Value of P3: " + P3);

        //test getLastName() method, getFirstName() method
        // and getMiddleName() method
        System.out.println("P3 First Name  = " + P3.getFirstName()  + "\n" +
                           "P3 Middle Name = " + P3.getMiddleName() + "\n" +
                           "P3 Last Name   = " + P3.getLastName());

        //test boolen equals() method
        if(P1.equals(P2))

           System.out.println("P1 Name is Equivalent to P2 Name");

        else

           System.out.println("P1 Name is not Equivalent to P2");

		  if(P1.equals(P3))

           System.out.println("P1 name is Equivalent to P3 Name");

        else

           System.out.println("P1 Name is not Equivalent to P3 Name");

		  if(P2.equals(P3))

           System.out.println("P2 name is Equivalent to P3 Name");

        else

           System.out.println("P2 Name is not Equivalent to P3 Name");




		//test algebraic compareTo() method
        if(P1.compareTo(P2) < 0)

           System.out.println("P1's name comes before P2's name");

        else if(P1.compareTo(P2) > 0)

           System.out.println("P2's name comes before P1's name");

        else

           System.out.println("P1 and P2 have the same name");

        if(P1.compareTo(P3) < 0)

           System.out.println("P1's name comes before P3's name");

        else if(P1.compareTo(P3) > 0)

           System.out.println("P3's name comes before P1's name");
        else

           System.out.println("P1 and P3 have the same name");

        if(P2.compareTo(P3) < 0)

           System.out.println("P2's name comes before P3's name");

        else if(P2.compareTo(P3) > 0)

           System.out.println("P3's name comes before P2's name");

        else

           System.out.println("P2 and P3 have the same name");

       //test the makeCopy and getCopy methods
       Person P4 = new Person("Harry", "S.", "Truman" );
       System.out.println("Original Value of P4: " + P4);
       Person P5 = new Person("J.", "Edgar.", "Hoover" );
       System.out.println("Original Value of P5: " + P5);
       P5.makeCopy(P4);
       System.out.println("P5 copy of P4: " + P5);
       System.out.println("Temp copy of P5: " + P5.getCopy());


    }//end main
}

/*    OUTPUT
Default Value of P1:
setName Value of P1: Sleeping Well Beauty
Original Value of P2: Donald D. Duck
setName Value of P2: Sandy Shady Smith
Constructor Value of P3: Sleeping Well Beauty
P3 First Name  = Sleeping
P3 Middle Name = Well
P3 Last Name   = Beauty
P1 Name is not Equivalent to P2
P1 name is Equivalent to P3 Name
P2 Name is not Equivalent to P3 Name
P1's name comes before P2's name
P1 and P3 have the same name
P3's name comes before P2's name
Original Value of P4: Harry S. Truman
Original Value of P5: J. Edgar. Hoover
P5 copy of P4: Harry S. Truman
Temp copy of P5: Harry S. Truman
*/