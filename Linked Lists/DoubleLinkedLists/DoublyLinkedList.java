/**********************************************************
 * Program Name   : DoublyLinkedList.java
 * Author         : Michael Feuerstin
 * Date           : March, 9 2012
 * Course/Section : CSC 112-001
 * Program Description: Creates and manages a linked list
 *    whose nodes contain the address of the nodes before
 *    and after it.
 *
 **********************************************************/

/*   UML Diagram
     -----------
     Class: DoublyLinkedList
     --------------
     Class Variables
     #count: int
     #first: DoublyLinkedListNode
     #last:  DoublyLinkedListNode
     -------------------
     Class Methods
     +DoublyLinkedListNode
     +DoublyLinkedList()
     +DoublyLinkedList(DoublyLinkedList)
     +isEmpty(): boolean
     +initializeList(): void
     +length(): int
     +print(): void
     +reversePrint(): void
     +search(DataElement): boolean
     +front(): DataElement
     +back(): DataElement
     +inserNode(DataElement): void
     +DeleteNode(DataElement): void
     +copy(DoublyLinkedList): void
     +copyList(DoublyLinkedList): void
*/

class DoublyLinkedList
{
    public class DoublyLinkedListNode
    {
        DataElement info;
        DoublyLinkedListNode next;
        DoublyLinkedListNode back;
    }

    protected int count;                  //variable to store the
                                          //number of nodes
    protected DoublyLinkedListNode first; //reference variable
                                          //to point to the first node
    protected DoublyLinkedListNode last;  //eference variable
                                          //to point to the last node

        //default constructor
        //Initializes the list to an empty state.
        //Postcondition: first = null; last = null; count = 0
    public DoublyLinkedList()
    {
        first= null;
        last = null;
        count = 0;
    }

        //copy constructor
    public DoublyLinkedList(DoublyLinkedList otherList)
    {
        copy(otherList);
    }

        //Method to determine whether the list is empty.
        //Postcondition: Returns true if the list is empty,
        //               false otherwise.
    public boolean isEmptyList()
    {
        return(first == null);
    }


        //Method to initialize the list to an empty state.
        //Postcondition: first = null; last = null; count = 0
    public void initializeList()
    {
        first = null;
        last = null;
        count = 0;
    }

        //Method to return the number of nodes in the
        //list.
        //Postcondition: The value of count is returned.
    public int length()
    {
        return count;
    }

    //Method to output the info contained in each node.
    public void print()
    {
        DoublyLinkedListNode current; //variable to traverse the list

        current = first;  //set current to point to the first node


        while(current != null)
        {
           System.out.print(current.info + "  ");
           current = current.next;
        }//end while
    }

        //Method to output the info contained in each node
        //in the reverse order
    public void reversePrint()
    {
          DoublyLinkedListNode current; //variable to traverse
                               //the list

          current = last;  //set current to point to the last node

          while(current != null)
          {
              System.out.print(current.info + "  ");
              current = current.back;
          }//end while
    }//end reversePrint

        //Method to determine whether searchItem is in
        //the list.
        //Postcondition: Returns true if searchItem is found
        //               in the list, false otherwise.
    public boolean search(DataElement searchItem)
    {
        boolean found;
        DoublyLinkedListNode current; //variable to traverse the list

        found = false;
        current = first;

        while(current != null && !found)
            if(current.info.compareTo(searchItem) >= 0)
               found = true;
            else
           current = current.next;

        if(found)
           found = current.info.equals(searchItem); //test for equality

        return found;
    }//end search

        //Method to return the first element of the list.
        //Precondition: The list must exist and must not be
        //              empty.
        //Postcondition: If the list is empty, the program
        //               terminates; otherwise, the first
        //               element of the list is returned.

    public DataElement front()
    {
        DataElement temp = first.info.getCopy();
        return temp;
    }

        //Method to return the last element of the list.
        //Precondition: The list must exist and must not
        //              be empty.
        //Postcondition: If the list is empty, the
        //               program terminates; otherwise,
        //               the last element of the list is
        //               returned.
    public DataElement back()
    {
        DataElement temp = last.info.getCopy();
        return temp;
    }

        //Method to insert insertItem in the list.
        //Precondition: If the list is nonempty, it must
        //              be in order.
        //Postcondition: insertItem is inserted at the
        //       proper place in the list. Also, first points
        //       to the first node, last points to the
        //       last node of the new list, and count
        //       is incremented by 1.
    public void insertNode(DataElement insertItem)
    {
        DoublyLinkedListNode current; //variable to traverse the list
        DoublyLinkedListNode trailCurrent = null; //variable just
                                                  //before current
        DoublyLinkedListNode newNode;  //variable to create a node
        boolean found;

        newNode = new DoublyLinkedListNode(); //create the node

        newNode.info = insertItem.getCopy();  //store new item in the node
        newNode.next = null;
        newNode.back = null;

        if(first == null) //if the list is empty, newNode is the only node
        {
           first = newNode;
           last = newNode;
           count++;
        }
        else
        {
            found = false;
            current = first;

            while(current != null && !found) //search the list
                if(current.info.compareTo(insertItem) >= 0)
                    found = true;
                else
                {
                    trailCurrent = current;
                    current = current.next;
                }

            if(current == first) //insert new node before first
            {
                first.back = newNode;
                newNode.next = first;
                first = newNode;
                count++;
            }
            else
            {
                  //insert newNode between trailCurrent and current
                if(current != null)
                {
                    trailCurrent.next = newNode;
                    newNode.back = trailCurrent;
                    newNode.next = current;
                    current.back = newNode;
                }
                else
                {
                    trailCurrent.next = newNode;
                    newNode.back = trailCurrent;
                    last = newNode;
                }
                count++;
            }//end else
        }//end else
    }//end insertNode

        //Method to delete deleteItem from the list.
        //Postcondition: If found, the node containing
        //        deleteItem is deleted from the list. Also,
        //        first points to the first node of the new
        //        list, last points to the last node of the new
        //        list, and count is decremented by 1.
        //        Otherwise, an appropriate message
        //        is printed.
    public void deleteNode(DataElement deleteItem)
    {
        DoublyLinkedListNode current; //variable to traverse the list
        DoublyLinkedListNode trailCurrent; //variable just
                                       //before current

        boolean found;

        if(first == null)
            System.err.println("Cannot delete from an empty list.");
        else
            if(first.info.equals(deleteItem)) //node to be deleted is
                                         //the first node
            {
                current = first;
                first = first.next;

                if(first != null)
                    first.back = null;
                else
                    last = null;

                count--;
            }
            else
            {
                found = false;
                current = first;

                while(current != null && !found)  //search the list
                    if(current.info.compareTo(deleteItem) >= 0)
                        found = true;
                    else
                        current = current.next;

                if(current == null)
                    System.out.println("The item to be deleted "
                                     + "is not in the list.");
                else
                    if(current.info.equals(deleteItem))//check for equality
                    {
                        trailCurrent = current.back;
                        trailCurrent.next = current.next;

                        if(current.next != null)
                            current.next.back = trailCurrent;

                        if(current == last)
                            last = trailCurrent;

                        count--;
                    }
                    else
                        System.out.println("The item to be deleted "
                                         + "is not in list.");
            } //end else
    } //end deleteNode


        //Method to make a copy of otherList.
        //Postcondition: A copy of otherList is created
        //               and assigned to this list.
    private void copy(DoublyLinkedList otherList)
    {
        DoublyLinkedListNode newNode; //variable to create a node
        DoublyLinkedListNode current; //variable to traverse the list

        first = null;  //make this list empty

        if(otherList.first == null) //otherList is empty
        {
           first = null;
           last = null;
           count = 0;
        }
        else
        {
           count = otherList.count;
           current = otherList.first;       //current points to the
                                            //list to be copied

               //copy the first element
           first = new DoublyLinkedListNode();     //create the node
           first.info = current.info.getCopy();    //copy the info
           first.next = null;                   //set the next and
           first.back = null;                   //back fields of
                                                //the node to null
           last = first;           //make last point to the first node
           current = current.next; //make current point to the next
                                   //node of the list being copied

                //copy the remaining list
           while(current != null)
           {
               newNode = new DoublyLinkedListNode();
               newNode.info = current.info.getCopy();
               newNode.next = null;
               newNode.back = last;
               last.next = newNode;
               last = newNode;
               current = current.next;
           }//end while
        }//end else
    }//end copy

        //Method to make a copy of otherList.
        //Postcondition: A copy of otherList is created
        //               and assigned to this list.
    public void copyList(DoublyLinkedList otherList)
    {
        if(this != otherList)  //avoid self-copy
           copy(otherList);
    }
}