/**********************************************************
 * Program Name   : PostFixCalculator.java
 * Author         : Michael Feuerstein
 * Date           : April 13, 2012
 * Course/Section : CSC 112-001
 * Program Description:  Evaluates and calculates
 *   postFixCalculator data from an input file and prints out
 *   the results of each calculation to an output file.
 *
 **********************************************************/

/*
     UML Diagram
     -----------
     Class Name: PostFixCalculator
     ---------------------------
     Class Variables :
     +strToken: static String
     +expressionOk: static boolean
     -----------------------------
     main Variables:
     +postFixStack: StackClass
     +inputLine: String
     +tokenizer: StringTokenizer
     +inputStream: Scanner
     +outFile: PrintWriter
     ---------------------
     evaluateExpression Variables:
     +num: DoubleElement
     +tokenizer: StringTokenizer
     ---------------------------
     evaluateOpr Variables:
     +op1: DoubleElement
     +op2: DoubleElement
     +answer: DoubleElement
     --------------------
     printResult Variables:
     +result: DoubleElement
     +temp: DoubleElement
     +twoDecimal: DecimalFormat
     --------------------------
     Class Methods :
     +main(String[]): static void
     +evaluateExpression(StackClass, PrintWriter, String): static void
     +evaluateOpr(StackClass, PrintWriter): static void
     +printResult(StackClass, PrintWriter): static void

     Program Logic - main
     --------------------
     1.  Get the first expression of postFix data from file Scanner
     2.  While there are expressions
             1) Evaluate, calculate, and write out each expression
             2) Get the next Expression
     3.  Close the output file

     Program Logic - evaluateExpression
     ----------------------------------
     1.  Tokenize a line of postFix data
         and get the first token
     2.  While there is an expression
         1) Check whether the token is a number/operand
            a) Store it as a double
            b) Print it to the output file
            c) Push the element into the stack
         2) Else the token is an operator
            a) Print the operator to the output file
            b) Evaluate the operator
         3) Check for expression errors

     Program Logic - evaluateOperator
     --------------------------------
     1. Check if there are not enough
        operands in the expression
        1) Not enough:
           a) Print out error to output file
        2) Are enough:
           a) Get the operands
           b) Determine which math operation to perfrom
           c) Perfrom the operation and add the answer
              to the stack

     Program Logic - printResult
     ---------------------------
     1.  Check for expression errors
         1) There are no errors:
            a) Attempt to Print out the result of the expression
               to the output file
         2) There are errors:
            a) print out error message
               to the output file
*/

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class PostfixCalculator
{
    static String strToken;       //Token of postFix Data: digit, operator
    static boolean expressionOk;  //Boolean that represents whether an expresion
                                  //has an error

    public static void main(String[] args) throws
                                    FileNotFoundException,
                                    IOException
    {
        LinkedStackClass postfixStack
         = new LinkedStackClass();    //Stack of postFix number and expressions

        String inputLine;          //Line of postFix data from a file

        Scanner inputStream = new Scanner(new           //Read file Scanner
                              File("Ch6_RpnData.txt")); //Reads the postFix data in

        PrintWriter outfile = new PrintWriter(new       //Writes the results of the
                                FileWriter("Ch6_RpnOutput.txt")); //Post fix data to a file

        //Get the first line/expression of postFix data from file Scanner
        inputLine = inputStream.nextLine();

        //While there are lines data/expressions left to be calculated
        while(inputLine != null)       //note: Checking for hasNextLine did not catch the last line
        {
			//Initialize the postFixStack stack
			//and set the expressionOk bool to true
            postfixStack.initializeStack();
            expressionOk = true;

            //Evaluate the expression
            evaluateExpression(postfixStack, outfile,
                               inputLine);
            //Write the result of the expression
            //to the outfile
            printResult(postfixStack, outfile);

            //Get the next line of data/expression
		    if(inputStream.hasNextLine())
                inputLine = inputStream.nextLine();
            else
                break;

        }//end while

        //Close the output file
        outfile.close();

    }//end main

        //Evaluates an expressionf postFix data
        //The expression is then calculated and
        //printed out to an outputfile
    public static void evaluateExpression(LinkedStackClass pStack,
                                          PrintWriter outp,
                                          String inpLine)
                                           throws IOException
    {
        DoubleElement num = new DoubleElement();  //Operands in the expression
        Scanner stringScan;     //Makes tokens out of the lines postFix data

        //Tokenize a line of postFix data
        //and get the first token
        stringScan = new Scanner(inpLine);
        strToken = stringScan.next();

        //While not an equal sign
        while(strToken.charAt(0) != '=')
        {
			//Check whether the token is a number/operand
            if(Character.isDigit(strToken.charAt(0)))
            {
				//If it is, then store the number
				//as a double element
				//and print it to the output file
                num.setNum(Double.parseDouble(strToken));
                outp.print(num + " ");

                //Push double element into the stack
                pStack.push(num);

                /*//If the Stack is not full
                //then push the double element
                //into the stack
                if(!pStack.isFullStack())
                    pStack.push(num);

                //Else the stack is full,
                //print out an error message and quit
                else
                {
                    System.out.print("Stack overflow. "
                                   + "Program terminates!");
                    System.exit(0);
                }*/
            }

            //Else the token is an operator
            else
            {
				//Print the operator to the output file
				//And evaluate the operator
                outp.print(strToken + " ");
                evaluateOpr(pStack, outp);
            }

            //If there are no expression errors
            if(expressionOk)

                //Get the next token
                strToken = stringScan.next();

            //Else there was an expression error
            else
            {
    			//Print out the rest of the tokens
                while(stringScan.hasNext())
					outp.print(stringScan.next() + " ");

                //Set strToken to '='/End the main while
                strToken = "=";
            }
        } //end while (!= '=')
    } //end evaluateExpression

        //Evaluates which operator is used in a postFix expression
        //and calculates the answer to the expression.
    public static void evaluateOpr(LinkedStackClass pStack,
                                   PrintWriter outp)
    {
        DoubleElement op1 = new DoubleElement();    //First operand
        DoubleElement op2 = new DoubleElement();    //Second operand
        DoubleElement answer = new DoubleElement(); //Expression answer

        //Check if there are not enough
        //operands in the expression
        if(pStack.isEmptyStack())
        {
			//Print out error message and set
			//expressionOk to false
            outp.print(" (Not enough operands) ");
            expressionOk = false;
        }

        //Else there are enough operands
        else
        {
			//Get and pop the second operand
            op2 = (DoubleElement) pStack.top();
            pStack.pop();

            //Check if there are not enough
            //operands in the expression
            if(pStack.isEmptyStack())
            {
				//Print out error message and set
			    //expressionOk to false
                outp.print(" (Not enough operands) ");
                expressionOk = false;
            }

            //Else there are enough operands
            else
            {
				//Get and pop the second operand
                op1 = (DoubleElement) pStack.top();
                pStack.pop();

                //Determine which operator to use for the expression
                switch(strToken.charAt(0))
                {
                   // + Op: add num2 to num1 and push the answer into the stack
                   case '+':   answer.setNum(op1.getNum() + op2.getNum());
                               pStack.push(answer);
                               break;

                   // - Op: Subtract num2 from num1 and push the answer into the stack
                   case '-':   answer.setNum(op1.getNum() - op2.getNum());
                               pStack.push(answer);
                               break;
                   // * Op: Multiply num2 by num1 and push the answer into the stack
                   case '*':   answer.setNum(op1.getNum() * op2.getNum());
                               pStack.push(answer);
                               break;

                   // / Op: Divide num1 by num2 and push the answer into the stack
                   case '/':   //Check for division by zero
                               if(op2.getNum() != 0)
                               {
                                   answer.setNum(op1.getNum() / op2.getNum());
                                   pStack.push(answer);
                               }

                               else
                               {
                                   outp.print(" Division by 0 ");
                                   expressionOk = false;
                               }
                               break;
                   //None of the above operators are used,
                   //print out error message and set
                   //expressionOk to false
                   default:    outp.print(" (Illegal operator) ");
                               expressionOk = false;
                } //end switch
            } //end else
        } //end else
    } //end evaluateOpr

        //Prints out the result of postFix expression
        //to an outfile
    public static void printResult(LinkedStackClass pStack, PrintWriter outp)
    {
        DoubleElement result = new DoubleElement();   //Result of the last postFix
        DoubleElement temp = new DoubleElement();     //expression

        DecimalFormat twoDecimal = new DecimalFormat("0.00"); //decimalformat for the result

        //If ther are no error, print the result
        if(expressionOk)
        {
			//Check whether there is a result
            if(!pStack.isEmptyStack())
            {
				//Get the result from the postFixStack
                temp = (DoubleElement) pStack.top();
                result.setNum(temp.getNum());
                pStack.pop();

                //If result is the last operand,
                //print it out to the out file
                if(pStack.isEmptyStack())
                    outp.println(strToken + " "
                                + twoDecimal.format(result.getNum()));

                //Else there more operands in the stack,
                //print out error message to the output file
                else
                    outp.println(strToken
                               + " (Error: Too many operands)");
            }//end if

            //Else no result exists, print out error
            //message to the output file
            else
                outp.println(" (Error in the expression)");
        }
        //Else there is an error in the expression,
        //print out error message to the output file
        else
            outp.println(" (Error in the expression)");

        //Print out a line to the output file,
        //the line serves to divide the expressions
        outp.println("_________________________________");
    }
}

/* Sample Input

35 27 + 3 * =
26 28 + 32 2  - 5 ; / =
23 30 15 * / =
2 3 4 + =
23 0 / =
20 29 9 * ; =
25 23 - + =
34 24 12 7 / * + 23 - =

*/


/* Samp[le Output

35.0 27.0 + 3.0 * = 186.00
_________________________________
26.0 28.0 + 32.0 2.0 - 5.0 ;  (Illegal operator) / =  (Error in the expression)
_________________________________
23.0 30.0 15.0 * / = 0.05
_________________________________
2.0 3.0 4.0 + = (Error: Too many operands)
_________________________________
23.0 0.0 /  Division by 0 =  (Error in the expression)
_________________________________
20.0 29.0 9.0 * ;  (Illegal operator) =  (Error in the expression)
_________________________________
25.0 23.0 - +  (Not enough operands) =  (Error in the expression)
_________________________________
34.0 24.0 12.0 7.0 / * + 23.0 - = 52.14
_________________________________

*/
