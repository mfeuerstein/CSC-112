//********************************************************************
//  PushCounter.java       Authors: Lewis/Loftus
//
//  Demonstrates a graphical user interface and an event listener.
//********************************************************************

import javax.swing.JFrame;

public class PushCounter
{
   //-----------------------------------------------------------------
   //  Creates the main program frame.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
	  PushCounterPanel p1 = new PushCounterPanel(200,150);
	  PushCounterPanel p2 = new PushCounterPanel(200,400);

      JFrame frame = new JFrame ("Push Counter");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(p1);
      frame.addContentPane().add(p2);

      frame.pack();
      frame.setVisible(true);
   }
}
