public class Illustrate
{
   private int x;
   public static int y;
   private static int count;

   public Illustrate()
   {
        x = 0;
   }

   public Illustrate(int a)
   {
        x = a;
   }

   public void print()
   {
        System.out.println("x = " + x
                         + ", y = " + y
                         + ", count = " + count);
   }

   public static void incrementCount()
   {
        count++;
   }
}
