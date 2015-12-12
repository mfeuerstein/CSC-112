import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class VideoStorePanel extends JPanel
{
	private JButton b1,b2,b3,b4,b5,b6,b7;
	private VideoList vList;
	private JTextField search;

	public VideoStorePanel(VideoList list)
	{
		vList = new VideoList(list);

             //set up menu panel
	    //setBackground (Color.blue);
        setPreferredSize (new Dimension(750, 550));

        setLayout (null);

             //set up main buttons
        b1 = new JButton ("Check if Video is in the store");
        b2 = new JButton ("Check out a video");
        b3 = new JButton ("Check in a video");
        b4 = new JButton ("List all Video Titles");
        b5 = new JButton ("List all Video Information");
        b6 = new JButton ("Add a Video");
        b7 = new JButton ("Delete a video");

        ButtonListener listener = new ButtonListener();
        b1.addActionListener(listener);
        b2.addActionListener(listener);
        b3.addActionListener(listener);
        b4.addActionListener(listener);
        b5.addActionListener(listener);
        b6.addActionListener(listener);
        b7.addActionListener(listener);

        b1.setLocation(125, 85);
        b2.setLocation(125, 145);
        b3.setLocation(125, 205);
        b4.setLocation(125, 265);
        b5.setLocation(125, 325);
        b6.setLocation(125, 385);
        b7.setLocation(125, 445);

        b1.setSize(500, 37);
        b2.setSize(500, 37);
        b3.setSize(500, 37);
        b4.setSize(500, 37);
        b5.setSize(500, 37);
        b6.setSize(500, 37);
        b7.setSize(500, 37);

             //set up search bar
	    JPanel sPan = new JPanel();
	    sPan.setBackground (Color.red);
        sPan.setPreferredSize (new Dimension(300, 150));
        search = new JTextField("Search",6);
        search.setBounds(600, 20, 100, 20);

        //search.setBackground(Color.white);
        sPan.add(search);

             //add elements to menu panel
        add (b1);
        add (b2);
        add (b3);
        add (b4);
        add (b5);
        add (b6);
        add (b7);
        add (search);
	}

   //*****************************************************************
   //  Represents a listener for button push (action) events.
   //*****************************************************************
   private class ButtonListener implements ActionListener
   {
      //--------------------------------------------------------------
      //  Chooses an appropriate action based on the button pressed
      //--------------------------------------------------------------
      public void actionPerformed (ActionEvent event)
      {
		 String title = "", result;
		 int choice;

             //User pressed button 1 - Check if the store carries a particular movie
         if (event.getSource() == b1)
         {
            title = JOptionPane.showInputDialog ("Enter the Title: ");

            if(vList.videoSearch(title))
				result = "Video is in store, " +  vList.getStock(title)     //DO: Add "None in stock" message if no copies are in stock
				       + " Copies are available";
			else
                result = "Video not in store.";

            JOptionPane.showMessageDialog (null, result);
	     }
	         //User pressed button 2 - check out a movie from the store
         if (event.getSource() == b2)
         {
            title = JOptionPane.showInputDialog ("Enter the Title: ");

            if(vList.videoSearch(title))
 			{
 				if(vList.isVideoAvailable(title))
 				{
					vList.videoCheckOut(title);
 				    result = "Enjoy your movie: " + title;

                    //save(videoList); DO
			    }
 			    else
                   result = "Currently " + title
                          + " is out of stock.";
		    }
            else
                result = "The store does not "
                       + "carry: " + title;

            JOptionPane.showMessageDialog (null, result);
	     }

             //User pressed button 3 - check in/return a movie to the store //DO: make sure that stock isnt at max
         if (event.getSource() == b3)
         {
			title = JOptionPane.showInputDialog ("Enter the Title: ");

            if(vList.videoSearch(title))
 			{
 			    vList.videoCheckIn(title);
 				result = "Thanks for returning "
                                         + title;

                    //save(videoList); DO
            }
            else
                result = "This video is not "
                                         + "from our store.";

            JOptionPane.showMessageDialog (null, result);
	     }

         if (event.getSource() == b4)
            JOptionPane.showMessageDialog (null, "Wrong Button");
         if (event.getSource() == b5)
            JOptionPane.showMessageDialog (null, "Wrong Button");
         if (event.getSource() == b6)
            JOptionPane.showMessageDialog (null, "Wrong Button");
         if (event.getSource() == b7)
            JOptionPane.showMessageDialog (null, "Wrong Button");
      }
   }
}