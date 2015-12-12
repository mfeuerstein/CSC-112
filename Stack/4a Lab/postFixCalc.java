/**********************************************************
 * Program Name   : mainProgVideoStore.java
 * Author         : Michael Feuerstein
 * Date           : March 21, 2012
 * Course/Section : CSC 112-001
 * Program Description:  This class invokes a GUI of the
 *    videoStorePanel.
 *
 **********************************************************/

/*
     UML Diagram
     -----------
     Class Name: mainProgVideoStore
     -------------------------------
     Class Variables :
     +scan: static Scanner
     +fileScan: Scanner
     +recordScan: Scanner
     +stringList: UnorderedArrayList
     +num: IntElement
     +record: String
     +fw: FileWriter
     +bw: BufferedWriter
     ---------------
     Class Methods :
     +main(String[]): static void

     Program Logic
     -------------
     1.  Create a new VideoStorePanel
     2.  Create a new JScrollPane using the
         VideoStorePanel
     3.  Create  and show a new JFrame with
         the JScrollPanel as its content
*/

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class postFixCalc
{
    public static void main(String[] args)
    {
        //Create a new
        PostFixPanel calc = new PostFixPanel();

        //Create and show a new JFrame with
        //the JScrollPanel as its content
        JFrame frame = new JFrame ("Calculator");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(calc);
        frame.pack();
        frame.setVisible(true);
    }
}

/*

Sample Output is in "Video Store Sample Output" word file

*/