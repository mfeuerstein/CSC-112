//Program to test various operations of a stack

public class StackProgram
{
    public static void main(String[] args)
    {
        StackClass intStack = new StackClass(50);
        StackClass tempStack = new StackClass();

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
    }
}

/*    OUTPUT

tempStack elements: 38 45 23
The top element of intStack: 38

*/
