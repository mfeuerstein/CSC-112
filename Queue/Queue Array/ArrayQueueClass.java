

public class QueueClass
{
    private int maxQueueSize;
    private int count;
    private int queueFront;
    private int queueRear;
    private DataElement[] list;  //Array of references to the
                                 //objects that store queue elements

       //default constructor
       //Postcondition: Creates the array of references to the
       //               objects that store queue elements.
       //               maxQueueSize = 100;
       //               count = 0; queueFront = 0;
       //               queueRear = maxQueueSize – 1;
    public QueueClass()
    {
        maxQueueSize = 100;

        queueFront = 0;                 //initialize queueFront
        queueRear = maxQueueSize - 1;   //initialize queueRear
        count = 0;
        list = new DataElement[maxQueueSize];   //create the array
                                    //to implement the queue
    }

       //constructor with a parameter
       //Postcondition: Creates the array of references to the
       //               objects that store queue elements.
       //               maxQueueSize = queueSize;
       //               count = 0; queueFront = 0;
       //               queueRear = maxQueueSize – 1;
       //               If queueSize <= 0, maxQueueSize = 100;
    public QueueClass(int queueSize)
    {
        if(queueSize <= 0)
        {
           System.err.println("The size of the array to implement "
                            + "the queue must be positive.");
           System.err.println("Creating an array of size 100.");

           maxQueueSize = 100;
        }
        else
           maxQueueSize = queueSize; //set maxQueueSize to queueSize

        queueFront = 0;                 //initialize queueFront
        queueRear = maxQueueSize - 1;   //initialize queueRear
        count = 0;
        list = new DataElement[maxQueueSize];   //create the array
                                    //to implement the queue
    }


       //copy constructor
    public QueueClass(QueueClass otherQueue)
    {
         System.out.println("See Programming Exercise 1.");
    }

       //Method to initialize the queue to an empty state.
       //Postcondition: count = 0; queueFront = 0;
       //               queueRear = maxQueueSize - 1
    public void initializeQueue()
    {
         for(int i = queueFront; i < queueRear;
                                 i = (i + 1) % maxQueueSize)
         list[i] = null;

         queueFront = 0;
         queueRear = maxQueueSize - 1;
         count = 0;
    }

       //Method to determine whether the queue is empty.
       //Postcondition: Returns true if the queue is empty;
       //               otherwise, returns false.
    public boolean isEmptyQueue()
    {
         return (count == 0);
    }

       //Method to determine whether the queue is full.
       //Postcondition: Returns true if the queue is full;
       //               otherwise, returns false.
    public boolean isFullQueue()
    {
         return (count == maxQueueSize);
    }

       //Method to return the first element of the queue.
       //Precondition: The queue exists and is not empty.
       //Postcondition: If the queue is empty, the method throws
       //               QueueUnderflowException; otherwise, a
       //               reference to a copy of the first element
       //               of the queue is returned.
    public DataElement front() throws QueueUnderflowException
    {
         if(isEmptyQueue())
            throw new QueueUnderflowException();

         DataElement temp = list[queueFront].getCopy();
         return temp;
    }

       //Method to return the last element of the queue.
       //Precondition: The queue exists and is not empty.
       //Postcondition: If the queue is empty, the method throws
       //               QueueUnderflowException; otherwise, a
       //               reference to a copy of the last element
       //               of the queue is returned.
    public DataElement back() throws QueueUnderflowException
    {
         if(isEmptyQueue())
            throw new QueueUnderflowException();

         DataElement temp = list[queueRear].getCopy();
         return temp;
    }

       //Method to add queueElement to the queue.
       //Precondition: The queue exists and is not full.
       //Postcondition: The queue is changed and queueElement
       //               is added to the queue.
    public void addQueue(DataElement queueElement)
                            throws QueueOverflowException
    {
         if(isFullQueue())
            throw new QueueOverflowException();

         queueRear = (queueRear + 1) % maxQueueSize; //use the mod
                              //operator to advance queueRear
                              //because the array is circular
         count++;
         list[queueRear] = queueElement.getCopy();
    }


       //Method to remove the first element of the queue.
       //Precondition: The queue exists and is not empty.
       //Postcondition: The queue is changed and the first
       //               element is removed from the queue.
    public void deleteQueue() throws QueueUnderflowException
    {
         if(isEmptyQueue())
            throw new QueueUnderflowException();

         count--;
         list[queueFront] = null;
         queueFront = (queueFront + 1) % maxQueueSize; //use the mod
                                //operator to advance queueFront
                                //because the array is circular
    }

       //Method to make a copy of otherQueue.
       //Postcondition: A copy of otherQueue is created and
       //               assigned to this queue.
    public void copyQueue(QueueClass otherQueue)
    {
         System.out.println("See Programming Exercise 1.");
    }
}


