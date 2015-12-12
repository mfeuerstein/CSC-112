/**********************************************************
 * Program Name   : CandyMachine.java
 * Author         : Michael Feuerstin
 * Date           : February 3, 2012
 * Course/Section : CSC 112-001
 * Program Description: A program for giving the user a
 *    selection of candies to buy from a machine
 *
 **********************************************************/

/*
     UML diagram
     -----------
     Class:  CandyMachine
     -------------
     Class Variables:
     +scan: Scanner
     +cashRegister: CashRegister
     +candy:   Dispenser
     +chips:   Dispenser
     +gum:     Dispenser
     +cookies: Dispenser
     +choice:  int
     +amount:  int
     +amount2: int
     +change:  float
     +item:    int
     ---------------
     Class Methods:
     +main(String[]): static void
     +showSelection(): static void
     +sellProduct(Dispenser,CashRegister): static void
     -------------------------------------------------

     Program Logic for main
	 ----------------------
	 1.  Create objects and variables
	 2.  Display the menu and recieve the choice
	 3.  Handle the choice using a switch structure
	     inside a while loop for all 4 products
	 4.  Repeat step 2 at the end of the while loop

	 Program Logic for showSelection
	 -------------------------------
	 1.  Display 4 candy choices

	 Program Logic for sellProduct
	 -----------------------------
	 1.  Declare variables
	 2.  Check if product is in the machine
	     a) no - tell the user there is nothing left
	     b) yes - proceed with next step
	 3.  Ask for deposit and process it
	 4.  Check amount
	     a) while too little, ask for more or quit
	     b) if amount given cannot be changed,
	        return money and quit purchase
	     c) if amount given is too much, return change
	        and process order
	     d) else amount given is just right, process order
	 5.  Display machine balance

*/

import java.io.*;
import java.util.Scanner;

public class CandyMachine
{

	//create an object of the scanner class
	static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException
    {

         //create create cash register and dispenser objects
         CashRegister  cashRegister = new CashRegister();   //Step 1
         Dispenser candy = new Dispenser(100,50);           //Step 2
         Dispenser chips = new Dispenser(100,65);           //Step 2
         Dispenser gum = new Dispenser(75,45);              //Step 2
         Dispenser cookies = new Dispenser(100,85);         //Step 2

         int choice; //variable to hold the selection       //Step 3

         //Display the menu and recieve the choice
         showSelection();                                   //Step 4
         choice = scan.nextInt();                           //Step 5

         //Handle the choice using a switch structure
    	 //inside a while loop for all 4 products
         while(choice != 9)                                 //Step 6
         {
            switch(choice)                                  //Step 6a
          {
          case 1: sellProduct(candy, cashRegister);
                  break;
          case 2: sellProduct(chips, cashRegister);
                  break;
          case 3: sellProduct(gum, cashRegister);
                  break;
          case 4: sellProduct(cookies, cashRegister);
                  break;
          default: System.out.println("Invalid Selection");
          }//end switch

            //Repeat step 2 at the end of the while loop
            showSelection();                                //Step 6b
            choice = scan.nextInt();                        //Step 6c

        }//end while
    }//end main


    public static void showSelection()
    {
		//Display 4 candy choices
        System.out.println("*** Welcome to Shelly's Candy Shop ***");
        System.out.println("To select an item, enter ");
        System.out.println("1 for Candy");
        System.out.println("2 for Chips");
        System.out.println("3 for Gum");
        System.out.println("4 for Cookies");
        System.out.println("9 to exit");
    }//end showSelection


    public static void sellProduct(Dispenser product,
                                   CashRegister cRegister)
                                             throws IOException
    {
         //Declare variables
         int amount;   //variable to hold the amount entered
         int amount2;  //variable to hold the extra amount needed
         String change; //change to be returned to the customer
         int item = product.getProductCost(); //cost of product

         //Check if product is in the machine
         if(product.getCount() > 0)  //if dispenser is not empty
         {
			//Ask for deposit and process it
            System.out.println("Please deposit "
                                + item
                                + " cents or 0 to exit purchase");
            amount = scan.nextInt();

            //Check amount

	        //while too little, ask for more or quit
            while(amount < product.getProductCost() && amount != 0)
            {
               System.out.println("Please deposit another "
                           + (item - amount)
                           + " cents or 0 to exit purchase");
               amount2 = scan.nextInt();

               if(amount2 == 0)
                  amount = 0;

               amount = amount + amount2;
            }

            //if amount given cannot be changed,
			//return money and quit purchase
            if(amount > (cRegister.currentBalance() + item))

               System.out.println("Cannot accept amount given");

            //enough money was given
            else if(amount >= product.getProductCost())
            {
               //if amount given is too much, return change
			   //and process order
			   if(amount > item)
			   {
				   amount = amount - item;
                   change = cRegister.formatChange(amount);
                   System.out.println("Collect your item and "
                                + change
                                + " of change at the bottom, enjoy");
		       }

               //else amount given is just right, process order
		       else
                   System.out.println("Collect your item at the "
                                    + "bottom and enjoy.");

               cRegister.acceptAmount(product.getProductCost());
               product.makeSale();

            }
            else
               System.out.println("The amount is not enough. "
                                + "Collect what you deposited.");

            //Display machine balance
            System.out.println("Machine Balance: "
				   + cRegister.formatChange(cRegister.currentBalance()));
            System.out.println("*-*-*-*-*-*-*-*-*-*-"
                             + "*-*-*-*-*-*-*-*-*-*" + "\n");
         }
         else
            System.out.println("Sorry this item is sold out.");

    }//end sellProduct


}

/* Sample Output
*** Welcome to Shelly's Candy Shop ***
To select an item, enter
1 for Candy
2 for Chips
3 for Gum
4 for Cookies
9 to exit
1
Please deposit 50 cents or 0 to exit purchase
55
Collect your item and $0.05 of change at the bottom, enjoy
Machine Balance: $5.50
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
*/