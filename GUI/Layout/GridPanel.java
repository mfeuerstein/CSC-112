//********************************************************************
//  GridPanel.java       Authors: Lewis/Loftus
//
//  Represents the panel in the LayoutDemo program that demonstrates
//  the grid layout manager.
//********************************************************************

import java.awt.*;
import javax.swing.*;

public class GridPanel extends JPanel
{
   //-----------------------------------------------------------------
   //  Sets up this panel with some buttons to show how grid
   //  layout affects their position, shape, and size.
   //-----------------------------------------------------------------
   public GridPanel()
   {
      setLayout (new GridLayout (3, 2));

      setBackground (Color.green);

      JButton b1 = new JButton ("BUTTON 1");
      JButton b2 = new JButton ("BUTTON 2");
      JButton b3 = new JButton ("BUTTON 3");
      JButton b4 = new JButton ("BUTTON 4");
      JButton b5 = new JButton ("BUTTON 5");

      b1.setSize(50, 30);
      b2.setSize(50, 30);
      b3.setSize(50, 30);
      b4.setSize(50, 30);
      b5.setSize(50, 30);

      add (b1);
      add (b2);
      add (b3);
      add (b4);
      add (b5);
   }
}

