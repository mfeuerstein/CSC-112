public class CharElement extends DataElement
{
    protected char ch;

        //default constructor
    public CharElement()
    {
        ch = '\0';
    }

        //constructor with a parameter
    public CharElement(char x)
    {
        ch = x;
    }

        //copy constructor
    public CharElement(CharElement otherElement)
    {
        ch = otherElement.ch;
    }

        //Method to set the value of the instance variable ch
        //Postcondition: ch = x;
    public void setChar(char x)
    {
        ch = x;
    }

        //Method to return the value of the instance variable ch
        //Postcondition: The value of ch is returned
    public char getChar()
    {
        return ch;
    }

    public boolean equals(DataElement otherElement)
    {
        CharElement temp = (CharElement) otherElement;

        return (ch == temp.ch);
    }

    public int compareTo(DataElement otherElement)
    {
        CharElement temp = (CharElement) otherElement;

        return ((int)ch - (int) temp.ch);
    }

    public void makeCopy(DataElement otherElement)
    {
          CharElement temp = (CharElement) otherElement;

          ch = temp.ch;
    }

    public DataElement getCopy()
    {
        CharElement temp = new CharElement(ch);
        return temp;
    }

    public String toString()
    {
        return String.valueOf(ch);
    }
}