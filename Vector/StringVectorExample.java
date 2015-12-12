//StringVectorExample

import java.io.*;
import java.util.*;

public class StringVectorExample
{
   public static void main(String[] args)
   {
      Vector stringList = new Vector();
      Vector z = new Vector();                   //Line 5
      Vector s = new Vector();//Line 6
     Vector a = new Vector();                   //Line 7
     Vector v = new Vector();                  //Line 8
    Vector b = new Vector();  //Line 1
    Scanner scan = new Scanner(System.in);

      System.out.println("Line 2: Empty stringList?: "
                        + stringList.isEmpty());         //Line 2
      System.out.println("Line 3: Size of stringList?: "
                        + stringList.size());            //Line 3
      System.out.println();                              //Line 4

      stringList.addElement(1);                   //Line 5
      stringList.addElement("Summer");                   //Line 6
      stringList.addElement("Fall");                     //Line 7
      stringList.addElement("Winter");                   //Line 8
      stringList.addElement(true);                    //Line 9

      System.out.println("Line 10: **** After adding "
                       + "elements to stringList ****"); //Line 10
      System.out.println("Line 11: Empty stringList?: "
                        + stringList.isEmpty());         //Line 11
      System.out.println("Line 12: Size of stringList?: "
                        + stringList.size());            //Line 12
      System.out.println("Line 13: stringList: "
                        + stringList);                   //Line 13

      System.out.println("Line 14: stringList contains Fall?: "
                        + stringList.contains("Fall"));  //Line 14
      System.out.println();                              //Line 15

      stringList.insertElementAt("Cool", 1);             //Line 16
      System.out.println("Line 17: **** After adding an "
                       + "element at position 1 ****");  //Line 17
      System.out.println("Line 18: stringList: "
                        + stringList);
      sort(stringList);
      System.out.println(stringList);

      System.out.println();                              //Line 19

      stringList.removeElement("Fall");                  //Line 20
      stringList.removeElementAt(2);                     //Line 21
      System.out.println("Line 22: **** After the remove "
                       + "operations ****");             //Line 22
      System.out.println("Line 23: stringList: "
                        + stringList);                   //Line 23
      System.out.println("Line 24: Size of stringList?: "
                        + stringList.size());            //Line 24
      System.out.println("Line 25: indexOf(\"Sunny\"): "
                        + stringList.indexOf("Sunny"));  //Line 25
   }

   public static void sort(Vector vec)
   {
	   Vector temp = new Vector(vec);

	   String list[] = new String[vec.size()];
	   String t = "";

	   //vec.copyInto(list);

       for(int i = 0; i < vec.size(); i++)
	      list[i] += vec.get(i);

       // Outer for loop varying i from 0 to length
       for(int i = 0; i < vec.size(); i++)
       {
           // Inner for loop varying j from i+1 to length
    	   for(int j = i + 1; j < vec.size(); j++)
           {
               // compare list[i] to list[j]
    		   if(list[i].compareTo(list[j]) > 0)
               {
                   // swap list[i] with list[j]
                   temp.setElementAt(vec.elementAt(i),i);
                   vec.setElementAt(vec.elementAt(j),i);
                   vec.setElementAt(temp.elementAt(i),j);

                   //vec.copyInto(list);
                   t = list[i];
				   list[i] = list[j];
                   list[j] = t;
               }
       	   }
       	}
   }
}
/*    Output

Line 2: Empty StringList?: true
Line 3: Size of stringList?:0

Line 10: **** After adding elements to stringList ****
Line 11: Empty stringList?: false
Line 12: Size of stringList?: 5
Line 13: stringList: [Spring, Summer, Fall, Winter, Sunny]
Line 14: stringList contains Fall?: true

Line 17: **** After adding an element at position 1 ****
Line 18: stringList: [Spring, Cool, Summer, Fall, Winter, Sunny]

Line 22: **** After the remove operations ****
Line 23: stringList: [Spring, Cool, Winter, Sunny]
Line 24: Size of stringList?: 4
Line 25: indesxOf("Sunny"): 3

*/
