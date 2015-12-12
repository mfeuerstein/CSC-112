/**********************************************************
 * Program Name   : Dispenser.java
 * Author         : Michael Feuerstin
 * Date           : February 3, 2012
 * Course/Section : CSC 112-001
 * Program Description: Creates and manages an inventory
 *    sets price and stock
 *
 **********************************************************/

/*
     UML diagram
     -----------
     Class:  Dispenser
     -------------
     Class Variables:
     -numberOfItems: int
     -cost: int
     ---------------
     Class Methods:
     +Dispenser()
     +Dispenser(int,int)
     +getCount():   int
     +getProduct(): int
     +makeSale():   void
*/

public class Dispenser
{
    private int numberOfItems;   //variable to store the number of
                                 //items in the dispenser
    private int cost;    //variable to store the cost of an item

       //Default constructor to set the cost and number of
       //items to the default values
       //Postconditions: numberOfItems  = 50;
       //                cost = 50;
    public Dispenser()
    {
         numberOfItems = 50;
         cost = 50;
    }

       //Constructor with parameters to set the cost and number
       //of items in the dispenser specified by the user
       //Postconditions: numberOfItems  = numberOfItems;
       //                cost = setCost;
    public Dispenser(int setNoOfItems, int setCost)
    {
       if(setNoOfItems >= 0)
            numberOfItems = setNoOfItems;
       else
            numberOfItems = 50;

       if(setCost >= 0)
         cost = setCost;
       else
         cost = 50;
    }

       //Method to show the number of items in the machine
       //Postconditions: The value of the data member
       //                numberOfItems  is returned
    public int getCount()
    {
       return numberOfItems;
    }

       //Method to show the cost of the item
       //Postconditions: The value of the data member
       //                cost is returned
    public int getProductCost()
    {
       return cost;
    }

       //Method to reduce the number of items by 1
       //Postconditions: numberOfItems = numberOfItems - 1;
    public void makeSale()
    {
       numberOfItems--;
    }
}
