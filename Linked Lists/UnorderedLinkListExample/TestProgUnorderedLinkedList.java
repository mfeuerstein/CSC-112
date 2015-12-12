/**********************************************************
 * Program Name   : TestProgUnorderedLinkedList.java
 * Author         : Michael Feuerstin
 * Date           : March, 2 2012
 * Course/Section : CSC 112-001
 * Program Description: Tests the UnorderedLinkedList class,
 *    by creating and manipulating three linked lists filled
 *    IntElements.
 *
 **********************************************************/

/*   UML Diagram
     -----------
     Class:  TestProgUnorderedLinkedList
     --------------
     Class Variables
     +SIZE: int
     +scan: Scanner
     +count: int
     +list1: UnorderedLinkedList
     +list2: UnorderedLinkedList
     +list3: UnorderedLinkedList
     +num: IntElement
     -------------------
     Class Methods
     +main(String[]): static void
     +sort(vector): static void
     +remove(vector, Person): static void

     Program Logic
     -------------
1.   Create a Scanner object to read from the keyboard, keyScan
2.   Create 2 UnorderedLinkedLists, list1 and list2
3.   Create an IntElement number num
4.   Prompt for the entering of a set of IntElement objects, ending with -9999
     and placed in list1
5.   Create a loop to do that
8.   Display the list and its length
7.   Ask for a search number, search for it and give the results of the search
8.   Make a copy of list1, place it in list2, display it, and give it's length
9.   Ask for a number to be deleted from list2
10.  Try to delete it, display list2 and its length
11.  Create a new UnorderedLinkedList, list3, which is a copy of list2, using
     the copy constructor.
12.  Delete the first element from list3.
13.  Display list1, list2 and list3.
*/

import java.util.*;

public class TestProgUnorderedLinkedList
{
    public static void main(String[] args)
    {
		final int SIZE = 5;

       //Create a Scanner object to read from the keyboard, Scan
       Scanner scan = new Scanner(System.in);

       //Create 2 UnorderedLinkedLists, list1 and list2
       UnorderedLinkedList list1 = new UnorderedLinkedList();
       UnorderedLinkedList list2 = new UnorderedLinkedList();

       //Create an IntElement number num
       IntElement num = new IntElement();

       //Prompt for the entering of a set of IntElement objects, ending with -9999
       //and placed in list1
       //Create a loop to do that
       /*for(int i =0; i < SIZE; i++)
       {
          System.out.print("Enter a number : ");
          num.setNum(scan.nextInt());

          list1.insertLast(num);
       }
       num.setNum(-9999);
       list1.insertLast(num);
       */

       while(num.getNum() != -9999)
       {
		    System.out.print("Enter a number, ending with -9999 : ");
	        num.setNum(scan.nextInt());
            list1.insertLast(num);
       }

       //Display the list and its length
       System.out.print("\nContents of List 1 : ");
       list1.print();
       System.out.println("\nLength of List 1: " + list1.length());

       //Ask for a search number, search for it and give the results of the search
       System.out.print("\nEnter a number to be searched : ");
       num.setNum(scan.nextInt());

       if(list1.search(num))
          System.out.println("Item has been found");
       else
          System.out.println("Item not found");

       //Make a copy of list1, place it in list2, display it, and give it's length
       list2.copyList(list1);
       System.out.print("\nContents of List 2: ");
	   list2.print();
       System.out.println("\nLength of List 2: " + list2.length());

       //Ask for a number to be deleted from list2
       System.out.print("\nDelete which number from list2? : ");
       num.setNum(scan.nextInt());

       //Try to delete it, display list2 and its length
       list2.deleteNode(num);
       System.out.print("\nContents of List 2 post deletion: ");
	   list2.print();
       System.out.println("\nLength of List 2 post deletion: " + list2.length());

       //Create a new UnorderedLinkedList, list3, which is a copy of list2, using
       //the copy constructor.
       UnorderedLinkedList list3 = new UnorderedLinkedList(list2);

       //Delete the first element from list3.
       list3.deleteNode(list3.front());

       //Display list1, list2 and list3.
       System.out.println("\nContents of Lists 1, 2 and 3");
       System.out.print("\nList 1 : ");
       list1.print();
       System.out.print("\nList 2 : ");
       list2.print();
       System.out.print("\nList 3 : ");
       list3.print();
       System.out.println("\n\n");

    }
}

/*   Output
Enter a number, ending with -9999 : 1
Enter a number, ending with -9999 : -9999

Contents of List 1 : 1 -9999
Length of List 1: 2

Enter a number to be searched : 1
Item has been found

Contents of List 2: 1 -9999
Length of List 2: 2

Delete which number from list2? : -9999

Contents of List 2 post deletion: 1
Length of List 2 post deletion: 1

Contents of Lists 1, 2 and 3

List 1 : 1 -9999
List 2 : 1
List 3 :
*/