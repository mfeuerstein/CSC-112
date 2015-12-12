// reversePrint method to be added to the class LinkedListClass()
// Displays a Linked List in reverse order
// Needed because LinkedListClass() does not have backward links
// and therefore cannot be printed iteratively in reverse order
// Precondition: the linked list must exist and not be empty
// Poscondition: linked list is displayed in reverse order

private void reversePrint(LinkedListNode current)
{
    if (current != null)
    {
        reversePrint(current.link);            // recursive call to print the tail
        System.out.print(current.info + " ");  // print the element
    }
}

public void printListReverse()
{
    reversePrint(first);                      // call private method printListReverse()
                                              // with current initialized as first
    System.out.println();                     // go to new line
}