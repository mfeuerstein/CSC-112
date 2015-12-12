public class QueueNode
{
   		DataElement info;		//Data type of Queue Node
        QueueNode link;		//Reference to next node in queue

    //default constructor
    public QueueNode()
    {

    }

    //constructor with a parameter
    public QueueNode(DataElement data)
    {
        info = data;
    }

    //Method to set the value of the instance variable num.
    //Postcondition: info = data;
    public void setData(DataElement data)
    {
        info = data;
    }

    //Method to return the value of the instance variable num.
    //Postcondition: The value of num is returned.
    public DataElement getData()
    {
        return info;
    }

    public void setNext (QueueNode nextNode)
	//link to next node in Queue
		{
			//assign pointer to next node
			link = nextNode;

		}//end nextNode

	public QueueNode getNext()
	//get next link or go to the next node in Queue
		{
			//get the pointer
			return link;

		}//end getNext

}
