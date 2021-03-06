/**********************************************************
 * Program Name   : LinkedQueueClass.java
 * Author         : Michael Feuerstein
 * Date           : April 17, 2012
 * Course/Section : CSC 112-001
 * Program Description: This class creates and manages a
 *    data element linked list queue.
 *
 **********************************************************/

/*
     UML Diagram
     -----------
     Class Name: LinkedQueueClass
     ----------------------------
     Class Variables :
     #QueueNode: class
     -queueFront: QueueNode
     -queueRear: QueueNode
     ---------------
     Class Methods :
     +LinkedQueueClass
     +LinkedQueueClass(LinkedQueueClass)
     -copy(LinkedListClass): void
     +initializeQueue(): void
     +isEmptyQueue(): boolean
     +isFullQueue(): boolean
     +front(): DataElement
     +back(): DataElement
     +deleteQueue(): void
     +copyQueue(LinkedQueueClass): void
*/

public class LinkedQueueClass
{
          //Definition of the node
    protected class QueueNode
    {
        DataElement info;
        QueueNode link;
    }

    private QueueNode queueFront; //reference variable to the
                                  //first element of the queue
    private QueueNode queueRear;  //reference variable to the
                                  //last element of the queue
        //default constructor
    public LinkedQueueClass()
    {
        initializeQueue();
    }

        //copy constructor
    public LinkedQueueClass(LinkedQueueClass otherQueue)
    {
		copy(otherQueue);

    }//end copy constructor
        //Copies the the data from a given
        //LinkedQueueClass into this Queue
    private void copy(LinkedQueueClass otherQueue)
    {
        QueueNode newNode;
        QueueNode current;

            //Check if otherQueue is empty
        if(otherQueue.queueFront == null)
        {
			initializeQueue();
		}

            //Otherwise Copy otherQueue
		else
		{
			current = otherQueue.queueFront;

			queueFront = new QueueNode();
			queueFront.info = current.info.getCopy();
			queueFront.link = null;
			queueRear = queueFront;
			current = current.link;

			while(current != null)
			{
				newNode = new QueueNode();
				newNode.info = current.info.getCopy();
				newNode.link = null;
				queueRear.link = newNode;
				queueRear = newNode;
				current = current.link;
			}
		}
    }

        //Method to initialize the queue to an empty state.
        //Postcondition: queueFront = null; queueRear = null
     public void initializeQueue()
     {
          queueFront = null;
          queueRear = null;
     }

        //Method to determine whether the queue is empty.
        //Postcondition: Returns true if the queue is empty;
        //               otherwise, returns false.
     public boolean isEmptyQueue()
     {
          return (queueFront == null);
     }


        //Method to determine whether the queue is full.
        //Postcondition: Returns true if the queue is full;
        //               otherwise, returns false.
     public boolean isFullQueue()
     {
          return false;
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

          DataElement temp = queueFront.info.getCopy();
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

          DataElement temp = queueRear.info.getCopy();
          return temp;
     }


        //Method to add queueElement to the queue.
        //Precondition: The queue exists.
        //Postcondition: The queue is changed and queueElement
        //               is added to the queue.
     public void addQueue(DataElement newElement)
     {
          QueueNode newNode;

          newNode = new QueueNode();  //create the node

          newNode.info = newElement.getCopy();  //store the info
          newNode.link = null;   //initialize the link field to null

          if(queueFront == null) //if initially the queue is empty
          {
             queueFront = newNode;
             queueRear = newNode;
          }
          else   //add newNode at the end
          {
             queueRear.link = newNode;
             queueRear = queueRear.link;
          }
     }//end addQueue


        //Method to remove the first element of the queue.
        //Precondition: The queue exists and is not empty.
        //Postcondition: The queue is changed and the first
        //               element is removed from the queue.
     public void deleteQueue() throws QueueUnderflowException
     {
          if(isEmptyQueue())
             throw new QueueUnderflowException();

          queueFront = queueFront.link; //advance queueFront

          if(queueFront == null)  //if after deletion the queue is
             queueRear = null;  //empty, set queueRear to null
     } //end deleteQueue


        //Method to make a copy of otherQueue.
        //Postcondition: A copy of otherQueue is created and
        //               assigned to this queue.
    public void copyQueue(LinkedQueueClass otherQueue)
    {
		if(this != otherQueue)  //avoid self-copy
            copy(otherQueue);
    }
}