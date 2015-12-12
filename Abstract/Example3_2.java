//Test Program String Array List

import java.io.*;
import java.util.*;

public class Example3_2
{
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException
    {
        UnorderedArrayList stringList =
                             new UnorderedArrayList(50);
        UnorderedArrayList tempList =
                            new UnorderedArrayList();

        StringElement strObject = new StringElement();
        int counter;
        int position;

        StringTokenizer tokenizer;

        System.out.println("Processing the "
                         + "string list");
        System.out.print("Enter 5 strings on "
                       + "the same line: ");
        System.out.flush();

        tokenizer = new
                   StringTokenizer(keyboard.readLine());

        for(counter = 0; counter < 5; counter++)
        {
            strObject.setString(tokenizer.nextToken());
            stringList.insert(strObject);
        }

        tempList.copyList(stringList);

        System.out.println();
        System.out.print("Line 16: The list you "
                       + "entered is: ");
        stringList.print();
        System.out.println();

        System.out.print("Line 19: Enter the item to "
                       + "be deleted: ");
        //System.out.flush();
        strObject.setString(keyboard.readLine());
        System.out.println();

        stringList.remove(strObject);
        System.out.println("Line 24: After removing "
                         + strObject
                           + " the list is:");

        stringList.print();
        System.out.println();

        System.out.print("Line 27: Enter the position of "
                       + "the string to be deleted: ");
        //System.out.flush();
        position = Integer.parseInt(keyboard.readLine());
        System.out.println();

        stringList.removeAt(position);
        System.out.println("Line 32: After removing the "
                         + "element at position "
                         + position
                         + ", stringList:");

        stringList.print();
        System.out.println();

        System.out.print("Line 35: Enter the search "
                       + "item: ");
        //System.out.flush();

        strObject.setString(keyboard.readLine());
        System.out.println();

        if(stringList.seqSearch(strObject) != -1)
           System.out.println("Line 40: Item found in "
                            + "the list");
        else
           System.out.println("Line 42: Item not found");

        System.out.print("List 43: tempList: ");
        tempList.print();
        System.out.println();
    }
}

/*    OUTPUT
Line 7: Processing the string list
Line 8: Enter 5 strings on the same line: Hello Winter Spring Summer Fall

Line 16: The list you entered is: Hello Winter Spring Summer Fall

Line 19: Enter the item to be deleted: Hello

Line 24: After removing Hello the list is :
Winter Spring Summer Fall

Line 27: Entered the position of the string to be deletedL 3

Line 32: After removing the element at position 3, stringList:
Winter Spring Summer

Line 35: Enter the search item: Spring

Line 40: Item found in the list
Line 43: tempList: Hello Winter Spring Summer Fall

*/