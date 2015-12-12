//********************************************************************
//  Bullseye.java       Author: Lewis/Loftus
//
//  Demonstrates the use of loops to draw.
//********************************************************************

import javax.swing.*;

public class Flakes
{
   //-----------------------------------------------------------------
   //  Creates the main frame of the program.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      JFrame frame = new JFrame ("Snow Flake");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

      //SierpinskiGasketPanel panel = new SierpinskiGasketPanel();
      FlakePanel panel = new FlakePanel();
      JScrollPane scroll = new JScrollPane(panel);
      frame.getContentPane().add(scroll);
      frame.pack();
      frame.setVisible(true);
   }
}
