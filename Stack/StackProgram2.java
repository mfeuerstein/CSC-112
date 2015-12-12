//Program to test various operations of a stack

public class LinkedStackProgram
{
    public static void main(String[] args)
    {
        LinkedStackClass intStack = new StackClass(50);
        LinkedStackClass tempStack = new StackClass();
        LinkedStackClass intStack2;

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

        tempStack.copyStack(intStack);  //copy intStack
                                        //into tempStack

        System.out.print("tempStack elements: ");

        while(!tempStack.isEmptyStack())  //print tempStack
        {
            System.out.print(tempStack.top() + " ");
            tempStack.pop();
        }

        System.out.println();

        System.out.println("The top element of intStack: "
                        + intStack.top());

        intStack2 = new StackClass(intStack);  //create a new stack the same as intStack.

        System.out.print("intStack2 elements: ");

        while(!intStack2.isEmptyStack())  //print tempStack
        {
            System.out.print(intStack2.top() + " ");
            intStack2.pop();
        }
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
We now attempt to display the top of intStack2
The following error occurs because intStack2 is empty
Why is it empty?


Exception in thread "main" StackUnderflowException: Stack Underflow
        at StackClass.top(StackClass.java:98)
        at StackProgram2.main(StackProgram2.java:51)


*/
