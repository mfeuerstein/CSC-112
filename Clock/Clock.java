/**********************************************************
 * Program Name   : Clock.java
 * Author         : Michael Feuerstin
 * Date           : January 27, 2012
 * Course/Section : CSC 112-001
 * Program Description: Manages instances of a clock 
 *
 **********************************************************/
 
 /*   
     UML diagram
     -----------
     Class:  Clock
     -------------
     Class Variables
     -hr: int
     -min: int
     -sec: int
     ---------------
     Class Methods
     +Clock()
     +Clock(int, int, int)
     +setTime(int, int, int): void
     +getHours(): int
     +getMinutes(): int
     +getSeconds(): int
     +printTime(): void
     +getHours(): int
     +getMinutes(): int
	  +incrementSeconds(): int
	  +incrementMinutes(): int
	  +incrementHours(): int
	  +equalsTime(Clock): boolean
	  +makeCopy(Clock): void
	  +getCopy(Clock): Clock
*/
	  
public class Clock
{
    private int hr;  //store hours
    private int min; //store minutes
    private int sec; //store seconds

        //Constructor with parameters, to set the time
        //The time is set according to the parameters
        //Postcondition: hr = hours; min = minutes; sec = seconds
    public Clock(int hours, int minutes, int seconds)
    {
        setTime(hours, minutes, seconds);
    }

        //Default constructor
        //Postcondition: hr = 0; min = 0; sec = 0
    public Clock()
    {
        setTime(0, 0, 0);
    }

        //copy constructor
        //A new time is set according to the parameters of an existing time
        //Postcondition: hr = otherClock.hr; min = otherClock.min; sec = otherClock.sec
        //Example:  Clock myClock = new Clock(otherClock);
    public Clock(Clock otherClock)
    {
        hr = otherClock.hr;
        min = otherClock.min;
        sec = otherClock.sec;
    }

        //Method to set the time
        //The time is set according to the parameters
        //Postcondition: hr = hours; min = minutes; sec = seconds
    public void setTime(int hours, int minutes, int seconds)
    {
        if(0 <= hours && hours < 24)
            hr = hours;
        else
            hr = 0;

        if(0 <= minutes && minutes < 60)
            min = minutes;
        else
            min = 0;

        if(0 <= seconds && seconds < 60)
            sec = seconds;
        else
            sec = 0;
    }

        //Method to return the hours
        //Postcondition: the value of hr is returned
    public int getHours()
    {
          return hr;
    }

        //Method to return the minutes
        //Postcondition: the value of min is returned
    public int getMinutes()
    {
          return min;
    }

        //Method to return the seconds
        //Postcondition: the value of sec is returned
    public int getSeconds()
    {
          return sec;
    }

        //Method to print the time
        //Postcondition: Time is printed in the form hh:mm:ss
        //Example:  myClock.printTime();
    public void printTime()
    {
        if(hr < 10)
            System.out.print("0");
        System.out.print(hr + ":");

        if(min < 10)
            System.out.print("0");
        System.out.print(min + ":");

        if(sec < 10)
            System.out.print("0");
        System.out.print(sec);
    }

        //toString method to return the time
        //Postcondition: Time is returned as a string in the form hh:mm:ss
        //Example:  System.out.println(myTime);
    public String toString()
    {
        String str = "";

        if(hr < 10)
            str="0";
        str = str + hr + ":";

        if(min < 10)
            str = str + "0";
        str = str + min + ":";

        if(sec < 10)
            str = str + "0";
        str = str + sec;

        return str;
    }

        //Method to increment the time by one second
        //Postcondition: The time is incremented by one second
        //If the before-increment time is 23:59:59, the time
        //is reset to 00:00:00
    public void incrementSeconds()
    {
        sec++;
        if(sec > 59)
        {
            sec = 0;
            incrementMinutes(); //increment minutes
        }
    }

        //Method to increment the time by one minute
        //Postcondition: The time is incremented by one minute
        //If the before-increment time is 23:59:53, the time
        //is reset to 00:00:53
    public void incrementMinutes()
    {
        min++;
        if(min > 59)
        {
            min = 0;
            incrementHours(); //increment hours
        }
    }

        //Method to increment the time by one hour
        //Postcondition: The time is incremented by one hour
        //If the before-increment time is 23:45:53, the time
        //is reset to 00:45:53
    public void incrementHours()
    {
        hr++;
        if(hr > 23)
            hr = 0;
    }

        //Method to compare the two times
        //Postcondition: Returns true if this time is equal to
        //                otherTime; otherwise returns false
        //Example:  if(myClock.equals(yourClock)
        //              System.out.println("Equal\n");
    public boolean equals(Clock otherClock)
    {
        return(hr == otherClock.hr
                && min == otherClock.min
                && sec == otherClock.sec);
    }

        //Method to copy time
        //Postcondition: The instance variables of otherTime are
        //               copied into the correspoding data members
        //               of this time.
        //               hr = otherTime.hr; min = otherTime.min;
        //               sec = otherTime.sec;
        //Example: myClock.makeCopy(yourClock);
    public void makeCopy(Clock otherClock)
    {
        hr = otherClock.hr;
        min = otherClock.min;
        sec = otherClock.sec;
    }

        //Method to return a copy of time
        //Postcondition: A copy of the object is created
        //               and a reference of the copy is returned
        //Example:  myClock = yourClock.getCopy();
    public Clock getCopy()
    {
        Clock temp = new Clock();

        temp.hr = hr;
        temp.min = min;
        temp.sec = sec;

        return temp;
    }
}

