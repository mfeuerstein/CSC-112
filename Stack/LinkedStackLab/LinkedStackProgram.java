/**********************************************************
 * Program Name   : LinkedStackProgram.java
 * Author         : Michael Feuerstein
 * Date           : April 6, 2012
 * Course/Section : CSC 112-001
 * Program Description:  Tests the methods of the
 *    LinkedStackClass.
 *
 **********************************************************/

/*
     UML Diagram
     -----------
     Class Name: LinkedStackProgram
     ---------------------------
     Class Variables :
     -StackNode: class
     -stackTop: StackNode
     ---------------
     Class Methods :
     +main(String[]): static void

     Program Logic - main
     --------------------
     1.  Create Linked Stacks
     2.  Push IntElements into intStack
     3.  Copy intStack into tempStack,
         display and pop its contents
     4.  Display the top element of intStack
     5.  Create a new stack the same as intStack
     6.  Copy intStack2 into intStack3
     7.  Push new elements into intStack3
     8.  Display and pop contents of intStack2
     9.  Display and pop contents of intStack3
     10. Show and explain why intStack2 has no content
*/

public class LinkedStackProgram
{
    public static void main(String[] args)
    {
		//Create Linked Stacks
        LinkedStackClass intStack = new LinkedStackClass();
        LinkedStackClass tempStack = new LinkedStackClass();
        LinkedStackClass intStack2;
        LinkedStackClass intStack3 = new LinkedStackClass();;

        //Push IntElements into intStack
        try
        {
            intStack.push(new IntElement(23));
            intStack.push(new IntElement(45));
            intStack.push(new IntElement(38));
        }
        catch(StackOverflowException sofe)
        {
            System.out.println(sofe.toString());
            System.exit(0);
        }

        //Copy intStack into tempStack,
        //display and pop its contents
        tempStack.copyStack(intStack);

        System.out.print("tempStack elements: ");

        while(!tempStack.isEmptyStack())  //print tempStack
        {
            System.out.print(tempStack.top() + " ");
            tempStack.pop();
        }

        System.out.println();

        //Display the top element of intStack
        System.out.println("The top element of intStack: "
                        + intStack.top());

        //Create a new stack the same as intStack.
        intStack2 = new LinkedStackClass(intStack);

        //Copy intStack2 into intStack3
        intStack3.copyStack(intStack2);

        //Push new elements into intStack3
        try
        {
            intStack3.push(new IntElement(15));
            intStack3.push(new IntElement(16));
	    }
        catch(StackOverflowException sofe)
        {
            System.out.println(sofe.toString());
            System.exit(0);
        }
        //Display and pop contents of intStack2
        System.out.print("intStack2 elements: ");

        while(!intStack2.isEmptyStack())  //print tempStack
        {
            System.out.print(intStack2.top() + " ");
            intStack2.pop();
        }

        //Display and pop contents of intStack3
        System.out.print("\nintStack3 elements: ");

        while(!intStack3.isEmptyStack())  //print tempStack
        {
            System.out.print(intStack3.top() + " ");
            intStack3.pop();
        }

        //Show and explain why intStack2 has no content
        System.out.println("\nWe now attempt to display the top of intStack2");
        System.out.println("The following error occurs because intStack2 is empty");
        System.out.println("Why is it empty?\n");

        System.out.println("The top element of intStack: "
                        + intStack2.top());

    }

}

/*    OUTPUT

tempStack elements: 38 45 23
The top element of intStack: 38
intStack2 elements: 38 45 23
intStack3 elements: 16 15
We now attempt to display the top of intStack2
The following error occurs because intStack2 is empty
Why is it empty?

Exception in thread "main" StackUnderflowException: Stack Underflow
        at LinkedStackClass.top(LinkedStackClass.java:107)
        at LinkedStackProgram.main(LinkedStackProgram.java:74)

*/
