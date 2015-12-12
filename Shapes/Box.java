
public class Box extends Rectangle
{
    private double height;

    public Box()	//default constructor
    {
	      super();
	      height = 0.0;
    }

    public Box(double l, double w, double h)
    {
 	      super(l,w);
	      height = h;
    }

    public void setDimension(double l, double w, double h)
    {
        super.setDimension(l, w);

        if(h >= 0)
          height = h;
        else
          height = 0;
    }

    public double getHeight()
    {
        return height;
    }

    public double area()
    {
        return  2 * (getLength() * getWidth()
                   + getLength() * height
                   + getWidth() * height);
    }

    public double volume()
    {
        return super.area() * height;
    }

    public void print()
    {
        super.print();
        System.out.print("; Height = " + height);
    }
}
