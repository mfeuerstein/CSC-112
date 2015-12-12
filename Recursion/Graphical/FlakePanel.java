//Java program to draw SierpenskiGasket


import java.awt.*;
import javax.swing.*;


public class FlakePanel extends JPanel
{
	private int level = 0;
    private int xChange = 130;
    private int yChange = 260;

	public FlakePanel()
    {
	    setBackground (Color.white);
        setPreferredSize (new Dimension(380,380));
	    init();
    }


	public void init()
	{
		String levelStr = JOptionPane.showInputDialog
                         ("Enter the depth of recursion: ");

		level = Integer.parseInt(levelStr);
	}


	public void paint(Graphics g)
	{
		Point pointOne = new Point(20, 280);
		Point pointTwo = new Point(150,20);
		Point pointThree = new Point(280, 280);

		drawFlake(g, level, pointOne, pointTwo, pointThree);
	}


	private void drawFlake(Graphics  g, int lev,
                                Point p1, Point p2, Point p3)
	{
		Point midP1P2;
		Point midP2P3;
		Point midP3P1;

		if(lev >= 0)
		{
			midP1P2 = midPoint(p1, p2);
			midP2P3 = midPoint(p2, p3);
 			midP3P1 = midPoint(p3, p1);

 			xChange = xChange / 2;
 			yChange = yChange / 2;

			drawFlake(g, lev - 1, leftMid(midP1P2), midP1P2, rightMid(midP1P2));
			drawFlake(g, lev - 1, leftMid(midP2P3), midP2P3, rightMid(midP2P3));
			drawFlake(g, lev - 1, leftMid(midP3P1), midP3P1, rightMid(midP3P1));

			g.drawLine(p1.x, p1.y, p2.x, p2.y);
			g.drawLine(p2.x, p2.y, p3.x, p3.y);
			g.drawLine(p3.x, p3.y, p1.x, p1.y);
		}

	}

	private Point midPoint(Point pOne, Point pTwo)
	{
		Point mid = new Point((pOne.x + pTwo.x) / 2,
		                      (pOne.y + pTwo.y) / 2);

		return mid;
	}

	private Point leftMid(Point mid)
	{
			Point left = new Point((mid.x - 65),
			                        (mid.y + 130));

			return left;
	}

	private Point rightMid(Point mid)
	{
			Point right = new Point((mid.x + 65),
			                        (mid.y + 130));

			return right;
	}

}
