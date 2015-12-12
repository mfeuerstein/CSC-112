/**********************************************************
 * Program Name   : Person.java
 * Author         : Michael Feuerstin
 * Date           : February, 1 2012
 * Course/Section : CSC 112-001
 * Program Description: Creates and manages instances of a
 *    person's name
 *
 **********************************************************/
/*   UML Diagram
     -----------
     Class:  Person
     --------------
     Class Variables
     -firstName: String
     -middleName: String
     -lastName: String
     -------------------
     Class Methods
     +Person(String, String, String)
     +Person()
     +Person(Person)
     +toString(): String
     +setName(String, String, String): void
     +getFirst(): String
     +getMiddle(): String
     +getMiddle(): String
     +makeCopy(Person): void
     +getCopy(): Person
     +equals(Person): boolean
     +compareTo(Person): int
*/

public class Person
{
    private String firstName;  //store the first name
    private String middleName; //store the middle name
    private String lastName;   //store the last name

        //Constructor with parameters
        //Set firstName middleName and lastName according to the parameters
        //Postcondition: firstName = first; middleName =middle; lastName = last;
    public Person (String first, String middle, String last)
    {
        firstName  = first;
        middleName = middle;
        lastName   = last;
    }

        //Default constructor;
        //Initialize firstName middleName and lastName to empty string
        //Postcondition: firstName = ""; middleName = "" lastName = "";
    public Person()
    {
        firstName  = "";
        middleName = "";
        lastName   = "";
    }

        //Copy constructor;
	    //Initialize firstName, middleName and lastName by given Person
	    //Postcondition: firstName = ""; lastName = "";
    public Person(Person other)
	{
	    firstName  = other.firstName;
	    middleName = other.middleName;
	    lastName   = other.lastName;
    }

        //Method to output the first name and last name
        //in the form firstName lastName
    public String toString()
    {
          return (firstName + " " + middleName + " " + lastName);
    }

        //Method to set firstName and lastName according to
        //the parameters
        //Postcondition: firstName = first; lastName = last;
    public void setName(String first, String middle, String last)
    {
         firstName  = first;
         middleName = middle;
         lastName   = last;
    }

        //Method to return the firstName
        //Postcondition: the value of firstName is returned
    public String getFirstName()
    {
        return firstName;
    }

        //Method to return the middleName
	    //Postcondition: the value of middleName is returned
	public String getMiddleName()
	{
	    return middleName;
    }

        //Method to return the lastName
        //Postcondition: the value of lastName is returned
    public String getLastName()
    {
        return lastName;
    }

        // method to copy the contents of one person object to another existing person object
        // Example:  person2.makeCopy(person1);
    public void makeCopy(Person other)
    {
	    firstName  = other.firstName;
	    middleName = other.middleName;
	    lastName   = other.lastName;
    }

        // method to create a new or existing object the same as an existing object
        // Example:  Person person2 = person1.getCopy();
    public Person getCopy()
    {
        // create a temporary Person object
        Person temp = new Person();

        // create each of the first, middle and last names for Person temp
        temp.firstName  = firstName;
        temp.middleName = middleName;
        temp.lastName   = lastName;

        // return Person temp
        return temp;
    }

        // method to compare first, middle and last names of 2 Person objects
        // Example:
        // System.out.println(person1 + " is the same as " + person2 + " is " + person1.equals(person2);
    public boolean equals(Person other)
    {
        // string compare each of the first, middle and last names separately using the equals() method,
        // AND the results together and return the final boolean result
        if(firstName.equals(other.firstName) &&
           middleName.equals(other.middleName) &&
           lastName.equals(other.lastName))

           return true;

        else

           return false;
    }

        // method to compare 2 Person objects and tell if they are < 0.  = 0. or > 0
        // using string compares for each of last, first and middle names
        // Example:
        // if (person1.compareTo(person2) < 0)
        //     System.out.println(person1 + " comes first in alphabetical order before " + person2);
        // else if (person1.compareTo(person2) > 0)
        //     System.out.println(person2 + " comes first in alphabetical order before " + person1);
        // else
        //     System.out.println(person1 + " is the same as " + person2);
    public int compareTo (Person other)
    {
         // define 3 integers: lastComp, firstComp and middleComp
         int lastComp;
         int middleComp;
         int firstComp;

         // create lastComp by using the string compareTo() method to compare last names
         firstComp  = firstName.compareTo(other.firstName);
         middleComp = middleName.compareTo(other.middleName);
         lastComp   = lastName.compareTo(other.lastName);

         if (lastComp != 0)
            return lastComp;

         else if (firstComp != 0)
            return firstComp;

         else
            return middleComp;
    }

}
