//78 45 67 22 11 110 300 292 65 89 98 66 109 27 61 71
//10 20 30 35 77 68 15 87 54 57 195 78 25 111 37 83
//10 20 30 35 77 68 110 87 54 57 195 292 65 89 98 300

import java.io.*;
import java.util.*;

public class Ch8_PrExercise7
{
    static BufferedReader keyboard = new
                      BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException
    {
        HashTableClass intHashTable = new HashTableClass(19);

        IntElement num = new IntElement();
        StringTokenizer tokenizer;

        int key;

        System.out.println("Enter 16 integers in one line.");

        tokenizer = new StringTokenizer(keyboard.readLine());

        for(int i = 0; i < 16; i++)
        {
            num.setNum(Integer.parseInt(tokenizer.nextToken()));
            key = hashFunc(num);
            intHashTable.insert(key, num);
        }

        intHashTable.print();

        System.out.print("Enter item to be deleted: ");
        System.out.flush();
        num.setNum(Integer.parseInt(keyboard.readLine()));
        System.out.println();

        key = hashFunc(num);
        intHashTable.remove(key, num);

        intHashTable.print();

        System.out.print("Enter item to be searched: ");
        System.out.flush();
        num.setNum(Integer.parseInt(keyboard.readLine()));
        System.out.println();

        key = hashFunc(num);
        int pos = intHashTable.search(key, num);

        if(pos != -1)
            System.out.println("Item found in the list");
        else
            System.out.println("Item not in the list.");

        System.out.print("Enter item to be inserted: ");
        System.out.flush();
        num.setNum(Integer.parseInt(keyboard.readLine()));
        System.out.println();

        key = hashFunc(num);
        intHashTable.insert(key, num);

        intHashTable.print();
        
        System.out.print("Enter the position of the item to be retrieved: ");
        System.out.flush();
        key = Integer.parseInt(keyboard.readLine());
        System.out.println();

        num = (IntElement) intHashTable.retrieve(key);
        
        if(num != null)
           System.out.println("The item at position " + key + " = " + num);
        else
            System.out.println("There is no item at position " + key);
    }

    public static int hashFunc(IntElement num)
    {
        return num.getNum() % 19;
    }
}