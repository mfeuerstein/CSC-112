/**********************************************************
 * Program Name   : StringElement.java
 * Author         : Michael Feuerstein
 * Date           : April 17, 2012
 * Course/Section : CSC 112-001
 * Program Description: An extension of the abstract class
 *    DataElement, utilizes the abstract classes from
 *    DataElement to create manage and manipulate a String.
 *
 **********************************************************/

/*
     UML Diagram
     -----------
     Class Name: StringElement
     ---------------------------
     Class Variables :
     #String: String
     ---------------
     Class Methods :
     +StringElement()
     +StringElement(String)
     +StringElement(StringElement)
     +setString(String): void
     +getString(): String
     +equals(DataElement): boolean
     +compareTo(DataElement): int
     +makeCopy(DataElement): void
     +getCopy(): DataElement
     +toString(): String
*/

public class StringElement extends DataElement
{
    protected String str;

      //default constructor
    public StringElement()
    {
        str = null;
    }

      //constructor with a parameter
    public StringElement(String x)
    {
        str = x;
    }
      //copy constructor
    public StringElement(StringElement otherElement)
    {
        str = otherElement.str;
    }

      //Method to set the value of the instance variable String.
      //Postcondition: String = x;
    public void setString(String x)
    {
        str = x;
    }

      //method to compare two int elements
      //returns a boolean
    public boolean equals(DataElement otherElement)
    {
        StringElement temp = (StringElement) otherElement;
        return (str.compareTo(temp.str) == 0);
    }

      //method to comapre the difference between two
      //String elements
      //returns the difference
    public int compareTo(DataElement otherElement)
    {
        StringElement temp = (StringElement) otherElement;
        return (str.compareTo(temp.str));
    }

      //Accepts an String element and makes a copy of it
    public void makeCopy(DataElement otherElement)
    {
        StringElement temp = (StringElement) otherElement;
        str = temp.str;
    }
      //Returns a copy of this class
    public DataElement getCopy()
    {
        StringElement temp = new StringElement(str);
        return temp;
    }

      //prints out the class data
    public String toString()
    {
        return str;
    }
}
