

public class SubClassSuperClassMethods
{
   public static void main(String[] args)
   {
      Rectangle myRectangle1 = new Rectangle();
      Rectangle myRectangle2 = new Rectangle(8, 6);

      Box myBox1 = new Box();
      Box myBox2 = new Box(10, 7, 3);

      System.out.print("myRectangle1: ");
      myRectangle1.print();
      System.out.println();
      System.out.println("Area of myRectangle1: "
                        + myRectangle1.area());
      System.out.print("myRectangle2: ");
      myRectangle2.print();
      System.out.println();
      System.out.println("Area of myRectangle2: "
                        + myRectangle2.area());

      System.out.print("myBox1: ");
      myBox1.print();
      System.out.println();
      System.out.println("Surface Area of myBox1: "
                        + myBox1.area());
      System.out.println("Volume of myBox1: "
                        + myBox1.volume());

      System.out.print("myBox2: ");
      myBox2.print();
      System.out.println();
      System.out.println("Surface Area of myBox2: "
                        + myBox2.area());
      System.out.println("Volume of myBox2: "
                        + myBox2.volume());
   }
}

/*    OUTPUT

Line 5: myRectangle1: Length = 0.0; width = 0.0
Line 8: Area of myRectangle1: 0.0
Line 9: myRectangle2: Length = 8.0; width = 6.0
Line 12: Area of myRectangle2: 48.0
Line 13: myBox1: Lenght = 0.0; Width =0.0; Height = 0.0
Line 16: Surface Area of myBox1 = 0.0
Line 17: Volume of myBox1 = 0.0
Line 18: myBox2: Lenght = 10.0; Width =7.0; Height = 3.0
Line 21: Surface Area of myBox2 = 242.0
Line 22: Volume of myBox2 = 210.0

*/

