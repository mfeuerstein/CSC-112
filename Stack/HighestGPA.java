//Program Highest GPA

import java.io.*;
import java.text.*;
import java.util.*;

public class HighestGPA
{
    public static void main(String[] args)
    {
           //Step 1
        double GPA;
        double highestGPA = 0.0;

        StringElement name = new StringElement();
        String inputLine;
        StringTokenizer tokenizer;

        StackClass nameStack = new StackClass(100);
        DecimalFormat twoDigits =
                   new DecimalFormat("0.00"); //Step 2

        try
        {
            BufferedReader infile = new BufferedReader   //Step 3
               (new FileReader("Ch6_HighestGPAData.txt"));

            inputLine = infile.readLine();              //Step 5

            while(inputLine != null)                    //Step 6
            {
                tokenizer =
                    new StringTokenizer(inputLine);     //Step 6.a
                GPA =                                  //Step 6.b
                    Double.parseDouble(tokenizer.nextToken());
                name.setString(tokenizer.nextToken()); //Step 6.c

                if(GPA > highestGPA)                   //Step 6.d
                {
                    nameStack.initializeStack();        //Step 6.d.i

                    try
                    {
                        nameStack.push(name);        //Step 6.d.ii
                    } //end try
                    catch(StackOverflowException sofe)
                    {
                        System.out.println(sofe.toString());
                        System.exit(0);
                    }

                    highestGPA = GPA;               //Step 6.d.iii
                }
                else                               //Step 6.e
                    if(GPA == highestGPA)
                        try
                        {
                            nameStack.push(name);
                        } //end try
                        catch(StackOverflowException sofe)
                        {
                            System.out.println(sofe.toString());
                            System.exit(0);
                        }

                inputLine = infile.readLine();         //Step 6.f
            }

            System.out.println("Highest GPA = "
                     + twoDigits.format(highestGPA)); //Step 7
            System.out.println("The students holding the "
                             + "highest GPA are:");

            while(!nameStack.isEmptyStack())           //Step 8
            {
                System.out.println(nameStack.top());
                nameStack.pop();
            }
            System.out.println();
        } //end try
        catch(FileNotFoundException fnfe)  //Step 4
        {
           System.out.println(fnfe.toString());
        }
        catch(Exception e)
        {
           System.out.println(e.toString());
        }
    }
}

/*    OUTPUT

Highest GPA=3.90
The students holding the highest GPA are:
Doc
Minni
Andy

*/
