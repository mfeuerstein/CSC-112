//Test Program Integer Array List

import java.io.*;
import java.util.*;

public class Example3_1
{
    public static void main(String[] args) throws IOException
    {
        //Scanner scanF = new
          // Scanner(new File("ints.txt"));
        Scanner scan = new Scanner(System.in);

        UnorderedArrayList intList
                          = new UnorderedArrayList(1);
        UnorderedArrayList temp =
                            new UnorderedArrayList();

        IntElement num = new IntElement();

        int counter;
        int position;
        String record;

        System.out.println("Processing the "
                         + "integer list");
        System.out.print("Enter 8 integers on the "
                        + "same line: ");

        for(counter = 0; counter < 4; counter++)
        {
            num.setNum(scan.nextInt());
            intList.insert(num);
        }

        temp.copyList(intList);

        System.out.println();
        System.out.print("Line 16: The list you "
                       + "entered is: " + intList.min() +  " " + intList.max());
        //intList.print();
        System.out.println();

        System.out.print("Line 19: Enter the num to "
                       + "be deleted: ");                                                                   //Line 20
        num.setNum(scan.nextInt());
        System.out.println();

        intList.remove(num);
        System.out.println("Line 24: After removing "
                          + num
                          + " the list is:");
        intList.print();
        System.out.println();

        System.out.print("Line 27: Enter the position of "
                       + "the num to be deleted: ");
        position = scan.nextInt();
        System.out.println();

        intList.removeAt(position);
        System.out.println("Line 32: After removing the "
                          + "element at position "
                          + position
                          + ", intList:");

        intList.print();
        System.out.println();

        System.out.print("Line 35: Enter the search "
                        +  "item: ");                                                                      //Line 36

        num.setNum(scan.nextInt());
        System.out.println();

        if(intList.seqSearch(num) != -1)
           System.out.println("Line 40: Item found in "
                            + "the list");
        else
           System.out.println("Line 42: Item not found");

        System.out.print("List 43: The list temp: ");
        temp.print();
        intList.sort();
        System.out.print("The ordered list is: ");
        intList.print();
    }
}

/*    OUTPUT
Line 7: Processing the integer list
Line 8: Enter 8 integers on the same line: 23 54 32 78 27 87 45 66

Line 16: The list you entered is:  23 54 32 78 27 87 45 66

Line 19: Enter the num to be deleted: 32

Line 24: After removing 32 the list is:
23 54 78 27 87 45 66

LIne 27: Enter the position of the number to be deleted: 2

Line 32: After removing the element at position 2, intList:
23 54 27 87 45 66

Line 35: Enter the search item: 23

Line 40: Item found in the list
Line 43: The list temp: 23 54 32 78 27 87 45 66

*/

