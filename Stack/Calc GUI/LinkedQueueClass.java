public class LinkedQueueClass
{
    //Definition of the node
    private QueueNode queueFront; //reference variable to the
                                  //first element of the queue
    private QueueNode queueRear;  //reference variable to the
                                  //last element of the queue

    //default constructor
    public LinkedQueueClass()
    {
        queueFront = null;
        queueRear = null;
    }//end constructor

     //Method to initialize the queue to an empty state.
     //Postcondition: queueFront = null; queueRear = null
     public void initializeQueue()
     {
          queueFront = null;
          queueRear = null;
     }//end initializeQueue

      //Method to determine whether the queue is empty.
      //Postcondition: Returns true if the queue is empty;
      //               otherwise, returns false.
     public boolean isEmptyQueue()
     {
          return (queueFront == null);
     }//end isEmptyQueue

     //Method to return the first element of the queue.
     //Precondition: The queue exists and is not empty.
     //Postcondition: If the queue is empty, the method throws
     //               QueueUnderflowException; otherwise,
     //               the value of the first element
     //               of the queue is returned.
     public DataElement front() throws QueueUnderflowException
     {
          if(isEmptyQueue())
             throw new QueueUnderflowException();
		  else
	  		{
          	return queueFront.getData();
			}
     }//end front






     //Method to return the last element of the queue.
     //Precondition: The queue exists and is not empty.
     //Postcondition: If the queue is empty, the method throws
     //               QueueUnderflowException; otherwise,
     //               the value of the last element
     //               of the queue is returned.
     public DataElement back() throws QueueUnderflowException
     {
          if(isEmptyQueue())
             throw new QueueUnderflowException();
         return queueRear.getData();
     }

     //Method to add queueElement to the queue.
     //Precondition: The queue exists.
     //Postcondition: The queue is changed and newNode
     //               is added to the queue.
     public void addQueue(DataElement newElement)
     {
          QueueNode newNode = new QueueNode(newElement);  //create the node

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

}//end Class
