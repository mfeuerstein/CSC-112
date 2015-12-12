//Program Highest GPA

import java.io.*;
import java.text.*;
import java.util.*;

public class HighestGPA3
{
    public static void main(String[] args) throws IOException
    {
                                                             //Step 1
        double GPA;
        double highestGPA = 0.0;

        StringElement name = new StringElement();
        String inputLine;

        Scanner fileScan, stringScan;

        StackClass nameStack = new StackClass(100);
        DecimalFormat twoDigits = new DecimalFormat("0.00"); //Step 2

        try
        {                                                    //Step 3
            fileScan = new Scanner(new File("Ch6_HighestGPAData.txt"));
            inputLine = fileScan.nextLine();                 //Step 5

            while(fileScan.hasNextLine())                        //Step 6
            {
                stringScan = new Scanner(inputLine);
                GPA = stringScan.nextDouble();
                //GPA =  Double.parseDouble(fileScan.next());  //Step 6.b
                name.setString(stringScan.next());
                //name.setString(fileScan.next());             //Step 6.c
                System.out.println(GPA + "  " + name);
                if(GPA > highestGPA)                         //Step 6.d
                {
                    nameStack.initializeStack();             //Step 6.d.i

                    try
                    {
                        nameStack.push(name);                //Step 6.d.ii
                    } //end try
                    catch(StackOverflowException sofe)
                    {
                        System.out.println(sofe.toString());
                        System.exit(0);
                    } //end catch

                    highestGPA = GPA;                        //Step 6.d.iii
                } // end if
                else                                         //Step 6.e
                    if(GPA == highestGPA)
                        try
                        {
                            nameStack.push(name);
                        } //end try
                        catch(StackOverflowException sofe)
                        {
                            System.out.println(sofe.toString());
                            System.exit(0);
                        } //end catch
                inputLine = fileScan.nextLine();                 //Step 6.f
            } //end while loop

            System.out.println("Highest GPA = "
                     + twoDigits.format(highestGPA));         //Step 7
            System.out.println("The students holding the "
                             + "highest GPA are:");

            while(!nameStack.isEmptyStack())                  //Step 8
            {
                System.out.println(nameStack.top());
                nameStack.pop();
            } //end while

            System.out.println();

        } //end try

        catch(FileNotFoundException fnfe)                     //Step 4
        {
           System.out.println(fnfe.toString());
        }//end catch
        catch(Exception e)
        {
           System.out.println(e.toString());
        } //end catch

    }//end main

} //end class

/*    OUTPUT

Highest GPA = 3.90
The students holding the highest GPA are:
Herman
Doc
Minnie
Andy
Louise

*/