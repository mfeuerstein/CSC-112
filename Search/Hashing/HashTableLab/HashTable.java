/**********************************************************
 * Program Name   : HashTable.java
 * Author         : Michael Feuerstein
 * Date           : April 25, 2012
 * Course/Section : CSC 112-001
 * Program Description:  This class explores the use of a
 *    hashing table. The table will include 28 four letter
 *    words split up into designated groups. The groups are
 *    determined according to a given hash key.
 *
 **********************************************************/

/*
     UML Diagram
     -----------
     Class Name: HashTable
     -------------------------------
     Class Variables :
     +scan:  Scanner
     +int: key
     +int: i
     +int: k
     +int: sum
     +st: StringElement
     +words: String[]
     +indexValue: int[]
     +table: OrderedLinkedList
     ---------------
     Class Methods :
     +main(String[]): static void

     Program Logic
     -------------
     1.  Ask for the hashing key
     2.  Instantiate the OrderedLinkedList,
         table, to hold the hashing table
     3.  Instantiate each of the elements
         in the list
     4.  Create the indexvalue array
     5.  Get the ASCUII and hash index values
         of each word
     6.  Convert each word to a StringElement,
         store them in the hash table, and
         display them in the table.
     7.  Ask for and enter the item to be found.
     8.  Calculate the row of the Hash Table that the item should be in.
         This will determine the appropriate linked list from the linked list array.
     9.  Do a sequential search of that row in the Hash Table.
         Keep in mind that each linked list is ordered.
     10. If you find it give an appropriate message.
         If not give an appropriate message.
*/

import java.io.*;
import java.util.Scanner;

public class HashTable
{// begin class

    public static void main(String[] args) throws IOException
    {// begin main

        Scanner scan = new Scanner(System.in);

        // define key, i, j and sum as integers
        int key, i, j, sum;

        //String for entering search / search item
        String search, word;

        //item found boolean
        boolean found;

        // define a new StringElement st
        StringElement st;

        // create an array of strings made up of words to go into the hashing table
        String [] words = {"love", "work", "clap", "wrap", "kind", "fine", "tree",
                           "bean", "save", "trap", "sign", "read", "seed", "wrap",
                           "ring", "sing", "song", "sang", "plan", "reak", "deep",
                           "trim", "swim", "flim", "flam", "beat", "seat", "rung"};

        // create an array of integers, indexvalue, to hold the hashing index for each word
        int indexValue[];

        OrderedLinkedList table[];

        // ask for the hashing key
        System.out.print("Enter hash key: ");
        key = scan.nextInt();

        // Instantiate the OrderedLinkedList, table, to hold the hashing table
         table = new OrderedLinkedList[key];

        // instantiate each of the elements in the list
        for(int a = 0; a < key; a++)
        {
		    table[a] = new OrderedLinkedList();
		}

        // create the indexvalue array
        indexValue = new int[words.length];

        //Data header
        System.out.println("\nData");
        System.out.println("----\n");


        // outer for loop to traverse the array of words
        for (i = 0; i < words.length; i++)
        {// begin outer for loop

            // set sum = 0
            sum = 0;

            // inner for loop to add the ascii values of the letters in each word
            for (j = 0; j < words[i].length(); j++)
            {// begin inner for loop

                // add the ASCII integer value of each character to sum
                sum += words[i].charAt(j);

            }// end inner for loop

            // create the indexvalue for each word
            indexValue[i] = sum % key;

            // display each word, its ASCII sum and index value
            System.out.println(words[i] + " / " + sum + " / " + indexValue[i]);

        }// end of outer for loop

        // print heading for Hashing table
        System.out.println("\nHashing Table");
        System.out.println("-------------");

        // outer for loop to display each line of the table
        for (i = 0; i< key; i++)
        {// beging outer for loop

            // inner for loop to display each word in that line
            for (j = 0; j < words.length; j++)
            {// begin inner fo loop

                // if statement to see if the word's index value is the same as the line number
                if(indexValue[j] == i)
                {// begin if

                    // convert the word to a StringElement
                    st = new StringElement(words[j]);

                    // insert the StringElement into the OrderedLinked List
                    table[i].insertNode(st);

                }// end of if statement

            }// end of inner for loop

            //  display the table number and :
            System.out.print("\n" + i + ": ");

            // display the line from list
            table[i].print();

        }// end of outer for loop

        //Ask to enter search
        System.out.print("\n\nEnter search? (y, n) : ");
        search = scan.next();

        while(search.equals("y"))
        {
            //Init sum to 0
            sum = 0;

            //Ask for and enter the item to be found
            System.out.print("\nEnter search item : ");
            word = scan.next();
            st = new StringElement(word);

            //Calculate the row of the Hash Table that the item should be in.

                //Get the ASCUII value of the search item
            for (j = 0; j < word.length(); j++)
            {
                // add the ASCII integer value of each character to sum
                sum += word.charAt(j);

            }// end inner for loop

                //Calculate the index value of the search item
            sum = sum % key;

            //Do a sequential search of that row in the Hash Table.
            found = table[sum].search(st);

            System.out.println();

            //If you find it give an appropriate message.
            if(found)

                System.out.println(word + " exists in row " + sum);

            else
                System.out.println(word + " does not exist");

            //Ask to search again
            System.out.print("\nSearch again? (y, n) : ");
            search = scan.next();
		}

    }// end main

}// end class

/*    Output

Enter hash key: 12

Data
----

love / 438 / 6
work / 451 / 7
clap / 416 / 8
wrap / 442 / 10
kind / 422 / 2
fine / 418 / 10
tree / 432 / 0
bean / 406 / 10
save / 431 / 11
trap / 439 / 7
sign / 433 / 1
read / 412 / 4
seed / 417 / 9
wrap / 442 / 10
ring / 432 / 0
sing / 433 / 1
song / 439 / 7
sang / 425 / 5
plan / 427 / 7
reak / 419 / 11
deep / 414 / 6
trim / 444 / 0
swim / 448 / 4
flim / 424 / 4
flam / 416 / 8
beat / 412 / 4
seat / 429 / 9
rung / 444 / 0

Hashing Table
-------------

0: ring rung tree trim
1: sign sing
2: kind
3:
4: beat flim read swim
5: sang
6: deep love
7: plan song trap work
8: clap flam
9: seat seed
10: bean fine wrap wrap
11: reak save

Enter search? (y, n) : y

Enter search item : clap

clap exists in row 8

Search again? (y, n) : y

Enter search item : tone

tone does not exist

Search again? (y, n) :

*/
