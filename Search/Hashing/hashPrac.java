import java.util.Scanner;

public class hashPrac
{
    public static void main(String[] args)
    {
        final int SPOTS = 12;
        final String QUIT = "QUIT";

        String name;
        int val;
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the name: ");
        name = scan.nextLine().toUpperCase();

        while(!(name.equals(QUIT)))
        {
			val = 0;

			for(int i = 0; i < name.length(); i++)
            {
		    	val += name.charAt(i);
		    }

            System.out.println("\nASCUII Value of " + name + " is : " + val);
            System.out.println("Table  Value of " + name + " is : " + val % SPOTS + "\n");

            System.out.print("Enter the name: ");
            name = scan.nextLine().toUpperCase();
	    }
    }
}