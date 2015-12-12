

public class HashTableClass
{
    private DataElement [] HTable;      //array of references to implement 
                                        //the hash table
    private int [] indexStatusList;     //array indicating the status of a
                                        //position in the hash table
    private int length;                 //number of items in the hash table
    private int HTSize;                 //maximum size of the hash table


        //default constructor
        //Postcondition: Create the arrays HTable and
        //               indexStatusList of sizes 101;
        //               length = 0; HTSize =  101;
    public HashTableClass()
    {
        HTable = new DataElement[101];
        indexStatusList = new int[101];
        length = 0;
        HTSize = 101;
    }

        //constructor
        //Postcondition: Create the arrays HTable and
        //               indexStatusList of sizes specified
        //               by the parameter size; length = 0;
        //               HTSize = size.
    public HashTableClass(int size)
    {
        HTable = new DataElement[size];
        indexStatusList = new int[size];
        length = 0;
        HTSize = size;
    }


        //Method to insert an item in the hash table.
        //The first parameter specifies the initial hash index
        //of the item to be inserted.
        //The item to be inserted is specified by the parameter rec.
        //Postcondition: If an empty position is found in the
        //   hash table, rec is inserted and the length is
        //   incremented by one; otherwise, an appropriate error
        //   message is displayed.
    public void insert(int hashIndex, DataElement rec)
    {
        int pCount;
        int inc;

        pCount = 0;
        inc = 1;

        while(indexStatusList[hashIndex] == 1
              && (!HTable[hashIndex].equals(rec))
              && pCount < HTSize / 2)
        {
            pCount++;
            hashIndex = (hashIndex + inc ) % HTSize;
            inc = inc + 2;
        }

        if(indexStatusList[hashIndex] != 1)
        {
            HTable[hashIndex] = rec.getCopy();
            indexStatusList[hashIndex] = 1;
            length++;
        }
        else
            if(HTable[hashIndex].equals(rec))
                System.err.println("Error: No duplicates are allowed.");
            else
                System.err.println("Error: The table is full. "
                            + "Unable to resolve the collision.");
    }

        //Method to determine whether the item specified by
        //the parameter rec is in the hash table.
        //The parameter hashIndex specifies the initial hash
        //index of rec.
        //Postcondition: If rec is found, returns the position
        //               where rec is found; otherwise, returns -1.
    public int search(int hashIndex, DataElement rec)
    {
        int pCount;
        int inc;
        boolean found;

        pCount = 0;
        inc = 1;

        while(indexStatusList[hashIndex] != 0
              && (!HTable[hashIndex].equals(rec))
              && pCount < HTSize / 2)
        {
            pCount++;
            hashIndex = (hashIndex + inc ) % HTSize;
            inc = inc + 2;
        }

        if(indexStatusList[hashIndex] == 1 && HTable[hashIndex].equals(rec))
            return hashIndex;
        else
            return -1;
    }

        //Method to determine whether the item specified by rec
        //is the same as the item in the hash table at position
        //hashIndex.
        //Postcondition: Returns true if HTable[hashIndex] == rec;
        //               otherwise, returns false.
    public boolean isItemAtEqual(int hashIndex, DataElement rec)
    {
        if(0 <= hashIndex && hashIndex < HTSize)
           return(HTable[hashIndex].equals(rec));
        else
           return false;
    }

        //Method to retrieve the item at position hashIndex.
        //Postcondition: If the table has an item at position
        //   hashIndex, a reference of its copy is returned;
        //   otherwise null is returned.
    public DataElement retrieve(int hashIndex)
    {
        DataElement rec = null;

        if(0 <= hashIndex && hashIndex < HTSize)
            if(indexStatusList[hashIndex] == 1)
                rec = HTable[hashIndex].getCopy();
           
        return rec;
    }


        //Method to remove an item from the hash table.
        //Postcondition: Given the initial hashIndex, if rec
        //   is found in the table it is removed; otherwise,
        //   an appropriate error message is displayed.
    public void remove(int hashIndex, DataElement rec)
    {
        int pos = search(hashIndex, rec);

        if(pos != -1)
        {
            indexStatusList[pos] = -1;
            length--;
        }
        else
            System.err.println("The item to be deleted is not in the list.");
    }

        //Method to output the data.
    public void print()
    {
        for(int i = 0; i < HTSize; i++)
            if(indexStatusList[i] == 1)
                System.out.println(i + "  " + indexStatusList[i]
                                     + "  " + HTable[i]);
    }
}