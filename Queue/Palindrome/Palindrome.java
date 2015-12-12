/**********************************************************
 * Program Name   : Palindrome.java
 * Author         : Michael Feuerstein
 * Date           : April 17, 2012
 * Course/Section : CSC 112-001
 * Program Description: Converts a string to caps and checks
 *    if it is a palindrome.
 *
 **********************************************************/

import java.util.Scanner;

public class Palindrome
{
    public static void main(String[] args)
    {
        String line;
        boolean isPalindrome;
        LinkedStackClass S;
        LinkedQueueClass Q;
        Scanner scan = new Scanner(System.in);

        //Enter the line of text
        System.out.print("Enter String: ");
        line = scan.nextLine();

        while(line != null)
        {
			//Instantiate the stack and queue
			S = new LinkedStackClass();
			Q = new LinkedQueueClass();

			//Convert each character from the
			//line of text to upper case
			line = line.toUpperCase();

            //Store the line
            for(int i = 0; i < line.length(); i++)
            {
                //Push the stack
                S.push(new CharElement(line.charAt(i)));

                //Add to queue
                Q.addQueue(new CharElement(line.charAt(i)));
            }

            //Init palindrome bool
            isPalindrome = true;

            //Check if the line is a palindrome
            for(int i = 0; i < line.length(); i++)
            {
                //Check letters
				if(!S.top().equals(Q.front()))
				{
					isPalindrome = false;
					break;
				}

                //Delete checked letters
				S.pop();
				Q.deleteQueue();

			}

			//Display the results
			if(isPalindrome)
			    System.out.println("\n" + line + " is a palindrome");
			else
			    System.out.println("\n" + line + " is not a palindrome");

            //Ask to go again
			System.out.print("\nEnter String: ");
			line = scan.nextLine();
        }
    }
}

/*  Sample Output

Enter String: palindrome

PALINDROME is not a palindrome

Enter String: level

LEVEL is a palindrome

*/