
//Program to test various operations on an ordered linked list

import java.io.*;
import java.util.*;

public class TestProgOrderedLinkedList
{
    static BufferedReader keyboard = new
           BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException
    {
        OrderedLinkedList list1
                          = new OrderedLinkedList();            //Line 1
        OrderedLinkedList list2
                          = new OrderedLinkedList();            //Line 2
        IntElement num = new IntElement();                      //Line 3
        StringTokenizer tokenizer;                              //Line 4

        System.out.println("Line 5: Enter integers ending "
                             + "with -999 in one line");        //Line 5
        tokenizer = new StringTokenizer(keyboard.readLine());   //Line 6
        num.setNum(Integer.parseInt(tokenizer.nextToken()));    //Line 7

        while(num.getNum() != -999)                             //Line 8
        {
            list1.insertNode(num);                              //Line 9
            num.setNum(
                Integer.parseInt(tokenizer.nextToken()));       //Line 10
        }

        System.out.println();                                   //Line 11

        System.out.println("Line 12: list1: ");                 //Line 12
        list1.print();                                          //Line 13
        System.out.println();                                   //Line 14
        System.out.println("Line 15: Length of list1: "
                         + list1.length());                     //Line 15

        list2.copyList(list1);                                  //Line 16

        System.out.println("Line 17: list2: ");                 //Line 17
        list2.print();                                          //Line 18
        System.out.println();                                   //Line 19
        System.out.println("Line 20: Length of list2: "
                              + list2.length());                //Line 20

        System.out.print("Line 21: Enter the number "
                                + "to be deleted: ");           //Line 21
        System.out.flush();
        num.setNum(Integer.parseInt(keyboard.readLine()));      //Line 22
        System.out.println();                                   //Line 23

        list2.deleteNode(num);                                  //Line 24

        System.out.println("Line 25: After deleting "
                         + "the node, list2: ");                //Line 25
        list2.print();                                          //Line 26
        System.out.println();                                   //Line 27

        System.out.println("Line 28: Length of list2: "
                          + list2.length());                    //Line 28

        System.out.println();                                   //Line 29
        System.out.println("Line 30: list1: ");                 //Line 30
        list1.print();                                          //Line 31
        System.out.println();                                   //Line 32
        System.out.println("Line 33: Length of list1: "
                          + list1.length());                    //Line 33
    }
}

/*    Output

Line 5: Enter integers ending wiht -999 in one line

19 26 29 45 53 66 78 -999

Line 12: List 1:
19 26 29 45 53 66 78 

Line 15: Length of list 1: 7

Line 17: List 2:
19 26 29 45 53 66 78 

Line 20: Length of list 2: 7

Line 21: Enter number to be deleted: 29

Line 25: After deleting the node, List 2:
19 26 45 53 66 78

Line 28: Length of list 2: 6

Line 30: List 1:
19 26 29 45 53 66 78 

Line 33: Length of list 1: 7

/*