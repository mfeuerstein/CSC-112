/**********************************************************
 * Program Name   : ArrayListClass.java
 * Author         : Michael Feuerstin
 * Date           : February 16, 2012
 * Course/Section : CSC 112-001
 * Program Description: Creates, manages and organizes an
 *    array of data elements.
 *
 **********************************************************/

/*
     UML Diagram
     -----------
     Class Name: ArrayListClass
     -------------------------------
     Class Variables
     #length: int
     #maxSize: int
     #list: DataElement[]
     ---------------
     Class Methods
     +ArrayListClass()
     +ArrayListClass(int)
     +ArrayListClass(ArrayListClass)
     +isEmpty(): boolean
     +isFull(): boolean
     +listSize(): int
     +maxlistSize(): int
     +print(): void
     +isItemAtEqual(int, DataElement): boolean
     +insertAt(int, DataElement): void
     +insertEnd(int, DataElement): void
     +removeAt(int): void
     +retrieveAt(int): DataElement
     +replaceAt(int, DataElement): void
     +clearList(): void
     +reqSearch(DataElement): void
     +insert(DataElement): void
     +remove(DataElement): void
     +copyList(ArrayListClass): void
     +sort(): void
     +expand(): void
     +min(): DataElement
     +max(): DataElement
*/

public abstract class ArrayListClass
{
    protected int length;           //to store the length of the list
    protected int maxSize;          //to store the maximum size of the list
    protected DataElement[] list;   //array to hold the list elements


        //Default constructor
        //Creates an array of size 100
        //Postcondition: list points to the array, length = 0,
        //               and maxSize = 100
    public ArrayListClass()
    {
        maxSize = 100;

        length = 0;
        list = new DataElement[maxSize];
    }

        //Constructor with parameter
        //Creates an array of size specified by the parameter
        //size.
        //Postcondition: list points to the array, length = 0,
        //               and maxSize = size
    public ArrayListClass(int size)
    {
        if(size <= 0)
        {
            System.err.println("The array size must be positive. "
                             + "Creating an array of size 100. ");
             maxSize = 100;
        }
        else
            maxSize = size;

        length = 0;
        list = new DataElement[maxSize];
    }

         //copy constructor
    public ArrayListClass(ArrayListClass otherList)
    {
        maxSize = otherList.maxSize;
        length = otherList.length;
        list = new DataElement[maxSize];    //create the array

        for(int j = 0; j < length; j++)  //copy otherList
            list[j] = otherList.list[j].getCopy();
    }//end copy constructor


        //Method to determine whether the list is empty.
        //Postcondition: Returns true if the list is empty;
        //               otherwise, returns false.
    public boolean isEmpty()
    {
        return (length == 0);
    }

        //Method to determine whether the list is full.
        //Postcondition: Returns true if the list is full;
        //               otherwise, returns false.
    public boolean isFull()
    {
        return (length == maxSize);
    }

        //Method to return the number of elements in the list.
        //Postcondition: Returns the value of length.
    public int listSize()
    {
        return length;
    }

        //Method to return the maximum size of the list.
        //Postcondition: Returns the value of maxSize.
    public int maxListSize()
    {
        return maxSize;
    }

        //Method to output the elements of the list.
        //Postcondition: Elements of the list are output on the
        //standard output device.
    public void print()
    {
        for(int i = 0; i < length; i++)
            System.out.print(list[i] + " ");
        System.out.println();
    }

        //Method to determine whether item is the same as the item in
        //the list at the position specified by location.
        //Postcondition: Returns true if list[location] is
        //               same as location; otherwise, returns false.
    public boolean isItemAtEqual(int location, DataElement item)
    {
          return(list[location].equals(item));
    }

        //Method to insert insertItem in the list at the position
        //specified by location.
        //Postcondition: Starting at location, the elements of the list
        //               are shifted to make room for the new item,
        //               list[location] = insertItem;, and
        //               length++;
        //     If the list is full or location is out of range,
        //     an appropriate message is displayed.
    public void insertAt(int location, DataElement insertItem)
    {
        if(location < 0)
            System.err.println("The position of the item to be inserted "
                              + "is out of range");
        else
        {   if(length >= maxSize)  //list is full
            {
               expand();
               System.out.println("List Expanded");
		    }

            for(int i = length; i > location; i--)
                    list[i] = list[i - 1];  //move the elements down

            list[location] = insertItem.getCopy();  //insert the
                                        //item at the specified position
            length++;   //increment the length
	    }
    } //end insertAt

        //Method to inserts insertItem at the end of the list.
        //Postcondition: list[length] = insertItem; and length++;
    public void insertEnd(DataElement insertItem)
    {
        if(length >= maxSize)  //the list is full
        {
           expand();
           System.out.println("List Expanded");
		}

        list[length] = insertItem.getCopy();  //insert the
                                                  //item at the end
        length++; //increment the length

    } //end insertEnd

        //Method to remove the item from the list at the position
        //specified by location.
        //Postcondition: The list element at list[location] is removed
        //    and length is decremented by 1.
        //    If location is out of range, an appropriate message
        //    is printed.
    public void removeAt(int location)
    {
        if(location < 0 || location >= length)
            System.err.println("The location of the item to be removed "
                             + "is out of range.");
        else
        {
            for(int i = location; i < length - 1; i++)
                  list[i] = list[i+1];

            list[length - 1] = null;

            length--;
        }
    } //end removeAt


        //Method to retrieve  the element from the list at the
        //position specified by location.
        //Postcondition: A copy of the element at the position
        //               specified by location is returned.
        //               If location is out of range, an
        //               appropriate message is printed and
        //               null is returned.
    public DataElement retrieveAt(int location)
    {
        if(location < 0 || location >= length)
        {
           System.err.println("The location of the item to be "
                            + "retrieved is out of range.");
           return null;
        }
        else
           return list[location].getCopy();

    } //end retrieveAt

        //Method to replace the element in the list at
        //the position specified by location with repItem.
        //Postcondition: list[location] = repItem
        //     If location is out of range, an appropriate
        //     message is printed.
    public void replaceAt(int location, DataElement repItem)
    {
        if(location < 0 || location >= length)
              System.err.println("The location of the item to be replaced "
                               + "is out of range.");
        else
           list[location].makeCopy(repItem);
    } //end replaceAt

          //Method to remove all the elements from the list.
          //Postcondition: length = 0
    public void clearList()
    {
        for(int i = 0; i < length; i++)
            list[i] = null;

          length = 0;

        System.gc();
    } //end clearList

        //Method to determine whether searchItem is in the list.
        //Postcondition: If searchItem is found, returns the location
        //               in the array where searchItem is found;
        //               otherwise, returns -1.
    public abstract int seqSearch(DataElement searchItem);


        //Method to insert insertItem in the list.
        //However, first the list is searched to see whether
        //the item to be inserted is already in the list.
        //Postcondition: insertItem is inserted and length++
        //           If insertItem is already in the list
        //           an appropriate message is output.
    public abstract void insert(DataElement insertItem);


        //Method to remove an item from the list.
        //The parameter removeItem specifies the item to
        //be removed.
        //Postcondition: If removeItem is found in the list, it is
        //               removed from the list and length is
        //               decremented by one.
    public abstract void remove(DataElement removeItem);

        //Method to make a copy of the other list.
        //Postcondition: This list is destroyed and a copy of
        //               otherList is assigned to this list.
    public void copyList(ArrayListClass otherList)
    {
          if(this != otherList) //avoid self-assignment
          {
              for(int j = 0; j < length; j++)  //destroy this list
                list[j] = null;
            System.gc();

                maxSize = otherList.maxSize;
            length = otherList.length;
            list = new DataElement[maxSize];    //create the array

            for(int j = 0; j < length; j++)     //copy otherList
                list[j] = otherList.list[j].getCopy();
          }
    }

    // sort method
    public void sort ()
    {
        // Create temporary DataElement
        DataElement temp;

        // Outer for loop varying i from 0 to length
    	for(int i = 0; i < length -1; i++)
        {
            // Inner for loop varying j from i+1 to length
    	    for(int j = i + 1; j < length; j++)
            {
                // compare list[i] to list[j]
    			if(list[i].compareTo(list[j]) > 0)
                {
                    // swap list[i] with list[j]
                    temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
		}   }
    }

    // expand method
    public void expand()
    {
        // Double maxSize
        maxSize *= 2;

        // Create a temporary DataElement twice as large as it is now
    	DataElement temp[] = new DataElement[maxSize];

        // for loop to copy the existing list to the temp list
    	for(int i = 0; i < length; i++)

    	   temp[i] = list[i];

        // replace list with temp
        list = temp;

        //collect the garbage (original array)
        System.gc();
    }

        //Method to return the smallest Element in the list.
        //Postcondition: Returns the smallest value.
    public DataElement min()
    {
		//set small to first data element value
		DataElement small = list[0];

        //loop for checking list values
    	for(int i = 1; i < length; i++)
        {
             //compare small to list[i] to see which is smaller
    	     if(small.compareTo(list[i]) > 0)

    	        //replace larger value with smaller one
    	        small = list[i];
	    }

    	//return smallest value
        return small;
    }

        //Method to return the largest Element in the list.
        //Postcondition: Returns the smallest value.
    public DataElement max()
    {
		//set small to first data element value
		DataElement large = list[0];

        //loop for checking list values
    	for(int i = 1; i < length; i++)
        {
             //compare small to list[i] to see which is smaller
    	     if(large.compareTo(list[i]) < 0)

    	        //replace larger value with smaller one
    	        large = list[i];
	    }

    	//return smallest value
        return large;
    }
}