
//Postfix Calculator

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class PostfixCalculator
{
    static String strToken;
    static boolean expressionOk;

    public static void main(String[] args) throws
                                    FileNotFoundException,
                                    IOException
    {
        StackClass postfixStack = new StackClass(100);

        String inputLine;

        StringTokenizer tokenizer;

        BufferedReader inputStream = new BufferedReader(new
                              FileReader("Ch6_RpnData.txt"));
        PrintWriter outfile = new PrintWriter(new
                                FileWriter("Ch6_RpnOutput.out"));


        inputLine = inputStream.readLine();

        while(inputLine != null)
        {
            postfixStack.initializeStack();
            expressionOk = true;

            evaluateExpression(postfixStack, outfile,
                               inputLine);
            printResult(postfixStack, outfile);

            inputLine = inputStream.readLine(); //Begin
                                     //processing the next expression
        }//end while

        outfile.close();
    }//end main


    public static void evaluateExpression(StackClass pStack,
                                          PrintWriter outp,
                                          String inpLine)
                                           throws IOException
    {
        DoubleElement num = new DoubleElement();
        StringTokenizer tokenizer;

        tokenizer = new StringTokenizer(inpLine);
        strToken = tokenizer.nextToken();

        while(strToken.charAt(0) != '=')
        {
            if(Character.isDigit(strToken.charAt(0)))
            {
                num.setNum(Double.parseDouble(strToken));
                outp.print(num + " ");

                if(!pStack.isFullStack())
                    pStack.push(num);
                else
                {
                    System.out.print("Stack overflow. "
                                   + "Program terminates!");
                    System.exit(0);
                }
            }
            else
            {
                outp.print(strToken + " ");
                evaluateOpr(pStack, outp);
            }

            if(expressionOk) //if no error
                strToken = tokenizer.nextToken();
            else
            {
                while(tokenizer.hasMoreTokens())
                      outp.print(tokenizer.nextToken() + " ");

                strToken = "=";
            }
        } //end while (!= '=')
    } //end evaluateExpression


    public static void evaluateOpr(StackClass pStack,
                                   PrintWriter outp)
    {
        DoubleElement op1 = new DoubleElement();
        DoubleElement op2 = new DoubleElement();
        DoubleElement answer = new DoubleElement();
        DoubleElement temp = new DoubleElement();

        if(pStack.isEmptyStack())
        {
            outp.print(" (Not enough operands) ");
            expressionOk = false;
        }
        else
        {
            op2 = (DoubleElement) pStack.top();
            pStack.pop();

            if(pStack.isEmptyStack())
            {
                outp.print(" (Not enough operands) ");
                expressionOk = false;
            }
            else
            {
                op1 = (DoubleElement) pStack.top();
                pStack.pop();

                switch(strToken.charAt(0))
                {
                case '+':   answer.setNum(op1.getNum() + op2.getNum());
                            pStack.push(answer);
                            break;
                case '-':   answer.setNum(op1.getNum() - op2.getNum());
                            pStack.push(answer);
                            break;
                case '*':   answer.setNum(op1.getNum() * op2.getNum());
                            pStack.push(answer);
                            break;
                case '/':   if(op2.getNum() != 0)
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
                default:    outp.print(" (Illegal operator) ");
                            expressionOk = false;
                } //end switch
            } //end else
        } //end else
    } //end evaluateOpr

    public static void printResult(StackClass pStack, PrintWriter outp)
    {
        DoubleElement result = new DoubleElement();
        DoubleElement temp = new DoubleElement();

        DecimalFormat twoDecimal = new DecimalFormat("0.00");

        if(expressionOk) //if no error, print the result
        {
            if(!pStack.isEmptyStack())
            {
                temp = (DoubleElement) pStack.top();
                result.setNum(temp.getNum());
                pStack.pop();

                if(pStack.isEmptyStack())
                    outp.println(strToken + " "
                                + twoDecimal.format(result.getNum()));
                else
                    outp.println(strToken
                               + " (Error: Too many operands)");
            }//end if
            else
                outp.println(" (Error in the expression)");
        }
        else
            outp.println(" (Error in the expression)");

        outp.println("_________________________________");
    }
}


