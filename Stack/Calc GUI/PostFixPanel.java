
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class PostFixPanel extends JPanel implements ActionListener
{
    private String strToken;
    private boolean expressionOk;

    private String inputLine;
    private String outputLine = "";

    private StackClass postfixStack = new StackClass(100);

    private JTextField inputTF;
    private JLabel outputLabel;
    private JButton clearB, evaluateB, exitB;
    private PreFixConverter conv;

    PostFixPanel()
    {
                   //Setting up the GUI
       //super("Postfix Calculator");
       setSize(400,200);
       JPanel pane = new JPanel();
       pane.setLayout(new GridLayout(5,1));

       JLabel welcomeLabel = new
                         JLabel("WELCOME TO POSTFIX CALCULATOR",
                                SwingConstants.CENTER);
       welcomeLabel.setForeground(Color.black);
       welcomeLabel.setFont(new Font("Courier", Font.BOLD, 20));

       JLabel inputLabel = new
                            JLabel("Enter a postfix expression ",
                                   SwingConstants.CENTER);
       inputLabel.setForeground(Color.black);
       inputLabel.setFont(new Font("Courier", Font.BOLD, 14));


       inputTF = new JTextField(10);
       inputTF.setFont(new Font("Courier", Font.BOLD, 16));

       outputLabel = new JLabel("",SwingConstants.CENTER);
       outputLabel.setFont(new Font("Courier", Font.BOLD, 16));
       outputLabel.setForeground(Color.black);

       Panel buttonPanel = new Panel();
       clearB = new JButton("Clear");
       evaluateB = new JButton("Evaluate");
       exitB = new JButton("Exit");

       inputTF.addActionListener(this);
       clearB.addActionListener(this);
       evaluateB.addActionListener(this);
       exitB.addActionListener(this);

       conv = new PreFixConverter();

       pane.add(welcomeLabel);
       pane.add(inputLabel);
       pane.add(inputTF);
       pane.add(outputLabel);
       pane.add(buttonPanel);
       buttonPanel.setLayout(new GridLayout(1,3,60,10));
       buttonPanel.add(clearB);
       buttonPanel.add(evaluateB);
       buttonPanel.add(exitB);


       add(pane);
    }

    public void actionPerformed(ActionEvent e)
    {
        if((e.getSource().equals(inputTF)) ||
           (e.getSource().equals(evaluateB)))
        {
            inputLine = inputTF.getText();
            System.out.println(inputLine);
            inputLine = conv.convert(inputLine);
            System.out.println(inputLine);

            if(inputLine != null)
            {
                evaluateExpression();

                printResult();
            }

            if(expressionOk == false)
                outputLabel.setForeground(Color.red);
            else
               outputLabel.setForeground(Color.blue);

            outputLabel.setText(outputLine);
            outputLine = "";
            inputLine="";
        }
        else
            if(e.getSource().equals(clearB))
            {
                inputTF.setText("");
                outputLabel.setText("");
                outputLine = "";
                inputLine="";

            }
            else
                if(e.getSource().equals(exitB))
                    System.exit(0);
   }

    public void evaluateExpression()

    {
        postfixStack.initializeStack();
        expressionOk = true;
        DoubleElement num = new DoubleElement();
        Scanner tokenizer;

        tokenizer = new Scanner(inputLine);
        strToken = tokenizer.next();

        while(strToken.charAt(0) != '=')
        {
            if(Character.isDigit(strToken.charAt(0)))
            {
                num.setNum(Double.parseDouble(strToken));
                outputLine += num + " ";

                if(!postfixStack.isFullStack())
                    postfixStack.push(num);
                else
                {
                    outputLine = "Stack overflow. "
                               + "Program terminates!";
                    System.exit(0);
                }
            }
            else
            {
                outputLine += strToken + " ";
                evaluateOpr();
            }

            if(expressionOk) //if no error
                strToken = tokenizer.next();
            else
            {
                while(tokenizer.hasNext())
                      outputLine = outputLine + tokenizer.next() + " ";

                strToken = "=";
            }
        } //end while (!= '=')
    } //end evaluateExpression

    public void evaluateOpr()
    {
        DoubleElement op1 = new DoubleElement();
        DoubleElement op2 = new DoubleElement();
        DoubleElement answer = new DoubleElement();
        DoubleElement temp = new DoubleElement();

        if(postfixStack.isEmptyStack())
        {
           outputLine = outputLine + " (Not enough operands) ";
           expressionOk = false;
        }
        else
        {
           op2 = (DoubleElement) postfixStack.top();
           postfixStack.pop();

           if(postfixStack.isEmptyStack())
           {
               outputLine = outputLine + " (Not enough operands) ";
               expressionOk = false;
           }
           else
           {
               op1 = (DoubleElement) postfixStack.top();
               postfixStack.pop();

               switch(strToken.charAt(0))
               {
                case '+':  answer.setNum(op1.getNum() + op2.getNum());
                           postfixStack.push(answer);
                           break;
               case '-':   answer.setNum(op1.getNum() - op2.getNum());
                           postfixStack.push(answer);
                           break;
                case '*':  answer.setNum(op1.getNum() * op2.getNum());
                           postfixStack.push(answer);
                           break;
               case '/':   if(op2.getNum() != 0)
                           {
                               answer.setNum(op1.getNum() / op2.getNum());
                               postfixStack.push(answer);
                           }
                           else
                           {
                               outputLine = outputLine + " Division by 0 ";
                               expressionOk = false;
                           }
                           break;
               default:    outputLine = outputLine + " (Illegal operator) ";
                           expressionOk = false;
               }//end switch
           }//end else
       }//end else
    }//end evaluateOpr

    public void printResult()
    {
            DoubleElement result = new DoubleElement();
            DoubleElement temp = new DoubleElement();

            DecimalFormat twoDecimal = new DecimalFormat("0.00");

            if(expressionOk) //if no error, print the result
            {
                if(!postfixStack.isEmptyStack())
                {
                    temp = (DoubleElement) postfixStack.top();
                    result.setNum(temp.getNum());
                    postfixStack.pop();

                    if(postfixStack.isEmptyStack())
                        outputLine += strToken + " "
                                    + twoDecimal.format(result.getNum());
                    else
                    {
                        outputLine += strToken
                                   + " (Error: Too many operands)";
                        expressionOk = false;
					}

                }//end if
                else
                {
                    outputLine += " (Error in the expression)";
                    expressionOk = false;
				}
            }
            else
                outputLine += " (Error in the expression)";
    }//end printResult

}//end PostfixCalculator


