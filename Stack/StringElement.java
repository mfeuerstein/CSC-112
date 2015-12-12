public class StringElement extends DataElement
{
    protected String str;

      //default constructor
    public StringElement()
    {
        str = null;
    }
      //constructor with a parameter
    public StringElement(String s)
    {
        str = s;
    }
      //copy constructor
    public StringElement(StringElement otherString)
    {
        str = otherString.str;
    }
      //Method to set the value of the instance variable str.
      //Postcondition: str = x;
    public void setString(String x)
    {
        str = x;
    }

    public boolean equals(DataElement otherElement)
    {
        StringElement temp = (StringElement) otherElement;
        return (str.compareTo(temp.str) == 0);
    }

    public int compareTo(DataElement otherElement)
    {
        StringElement temp = (StringElement) otherElement;
        return (str.compareTo(temp.str));
    }

    public void makeCopy(DataElement otherElement)
    {
        StringElement temp = (StringElement) otherElement;
        str = new String(temp.str);
    }

    public DataElement getCopy()
    {
        StringElement temp = new StringElement(str);
        return temp;
    }

    public String toString()
    {
        return str;
    }
}

