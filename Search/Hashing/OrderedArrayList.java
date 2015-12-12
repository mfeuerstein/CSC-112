public class OrderedArrayList extends ArrayListClass
{
        //default constructor
    public OrderedArrayList()
    {
        super();
    }

        //constructor with a parameter
    public OrderedArrayList(int size)
    {
        super(size);
    }

        //copy constructor
    public OrderedArrayList(OrderedArrayList otherList)
    {
        super(otherList);
    }

        //Method to determine whether searchItem is in the list.
        //Postcondition: If searchItem is found, returns the location
        //               in the array where searchItem is found;
        //               otherwise, returns -1.
    public int seqSearch(DataElement searchItem)
    {
          int loc;
          boolean found = false;

          for(loc = 0; loc < length; loc++)
              if(list[loc].compareTo(searchItem) >= 0)
              {
                    found = true;
                    break;
              }

          if(found)
          {
			  if(list[loc].equals(searchItem))

                  return loc;
              else

                  return -1;
		  }

          else
              return -1;
    } //end binSearch


        //Method to insert insertItem in the list at the proper
        //place. However, first the list is searched to
        //see if the item to be inserted is already in the list.
        //Postcondition: insertItem is inserted and length++
        //           If insertItem is already in the list or the list
        //           is full, an appropriate message is output.
    public void insert(DataElement insertItem)
    {
        int first = 0;
        int last = length - 1;
        int mid = 0;

        boolean found = false;

        if(length == 0)   //list is empty
        {
            list[0] = insertItem.getCopy();
            length++;
        }
        else
            if(length == maxSize)
                System.err.println("Cannot insert into a full list.");
            else
            {
                while(first <= last && !found)
                {
                    mid = (first + last) / 2;

                    if(list[mid].equals(insertItem))
                        found = true;
                    else
                        if(list[mid].compareTo(insertItem) > 0)
                            last = mid - 1;
                        else
                            first = mid + 1;
                }//end while

                if(found)
                    System.err.println("The insert item is already in the list. "
                                     + "Duplicates are not allowed.");
                else
                {
                    if(list[mid].compareTo(insertItem) < 0)
                        mid++;

                    insertAt(mid, insertItem);
                }
            }
    }//end insert


    public int binarySearch(DataElement item)
    {
        int first = 0;
        int last = length - 1;
        int mid = -1;

        boolean found = false;

        while(first <= last && !found)
        {
            mid = (first + last) / 2;

            if(list[mid].equals(item))
               found = true;
            else
               if(list[mid].compareTo(item) > 0)
                  last = mid - 1;
               else
                  first = mid + 1;
        }

        if(found)
           return mid;
        else
            return -1;
    }//end binarySearch

        //Method to remove an item from the list.
        //The parameter removeItem specifies the
        //item to be removed.
        //Postcondition: If removeItem is found in the list, it is
        //               removed from the list and length is
        //               decremented by one.
    public void remove(DataElement removeItem)
    {
        int loc;

          if(length == 0)
              System.err.println("Cannot delete from an empty list.");
          else
          {
              loc = binarySearch(removeItem);

              if(loc != -1)
                    removeAt(loc);
              else
                    System.out.println("The item to be deleted is "
                                 + "not in the list.");
          }
    }//end remove
}