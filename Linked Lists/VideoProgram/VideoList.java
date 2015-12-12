

public class VideoList extends UnorderedLinkedList
{
        //default constructor
    public VideoList()
    {
        super();
    }

        //copy constructor
    public VideoList(VideoList otherList)
    {
        super(otherList);
    }

      //Insert video in order
    public void insert(VideoElement insertItem)
    {
        LinkedListNode current;        //variable to traverse the list
        LinkedListNode trailCurrent;   //variable just before current
        LinkedListNode newNode;        //variable to create a node
        VideoElement temp = new VideoElement();

        boolean  found;

        newNode = new LinkedListNode(); //create the node
        newNode.info = insertItem.getCopy(); //store newItem
                                          //in the node
        newNode.link = null;    //set the link field of the node
                                //to null

        if(first == null)  //Case 1
        {
           first = newNode;
           count++;
        }
        else
        {
           trailCurrent = first;
           current = first;
           found = false;
           temp = (VideoElement) current.info;

           while(current != null && !found) //search the list
           {
			    temp = (VideoElement) current.info;

                if(temp.returnTitle().compareTo(insertItem.returnTitle()) >= 0)
                   found = true;
                else
                {
                   trailCurrent = current;
                   current = current.link;
                }
		   }

           if(current == first)   //Case 2
           {
              newNode.link = first;
              first = newNode;
              count++;
           }
           else          //Case 3
           {
              trailCurrent.link = newNode;
              newNode.link = current;
              count++;
           }
        }
	 }


        //Method to searche the video list for a
        //particular video, specified by the parameter title.
        //Postcondition: If the video is found, a reference to
        //            the node containing the video is returned;
        //            otherwise, the null reference is returned.
    private LinkedListNode searchVideoList(String title)
    {
        boolean found = false;   //set found to false
        LinkedListNode current = null;
        VideoElement temp = new VideoElement();

        if(first == null)  //the list is empty
            System.out.println("Cannot search an empty list. ");
        else
        {
            current = first;  //set current to point to first node
                                      //in the list
            found = false;    //set found to false

            while(current != null && !found)       //search the list
            {

                temp = (VideoElement) current.info;

                if(temp.checkTitle(title)) //item is found
                    found = true;
                else
                     current = current.link; //advance current to
                                                  //the next node
            }
        }//end else

        return current;
    }//end searchVideoList


        //Method to search the list to see whether a particular
        //video, specified by the parameter title, is in the store.
        //Postcondition: Returns true if the title is found;
        //               false otherwise.
    public boolean videoSearch(String title)
    {
          LinkedListNode location;

          location = searchVideoList(title);

          return (location != null);
    }

        //Searches all of the videos for any similar info
    public VideoList fullSearch(String item)
    {
		VideoList tempList = new VideoList();

        //boolean found = false;   //set found to false
        LinkedListNode current = null;
        VideoElement temp = new VideoElement();

        if(first == null)  //the list is empty
            System.out.println("Cannot search an empty list. ");
        else
        {
            current = first;  //set current to point to first node
                                      //in the list
            //found = false;    //set found to false

            while(current != null)       //search the list
            {
                temp = (VideoElement) current.info;

                if(temp.checkInfo(item)) //item is found
                    tempList.insert(temp);

                current = current.link; //advance current to
                                        //the next node
            }
        }//end else

      return tempList;
    }

        //Method to determine whether the video specified by the
        //parameter title is available.
        //Postcondition: Returns true if at least one copy of the
        //               video is available, false otherwise.
    public boolean isVideoAvailable(String title)
    {
          LinkedListNode location;
        VideoElement temp;

          location = searchVideoList(title);

          if(location != null)
        {
            temp = (VideoElement) location.info;
              return (temp.getNoOfCopiesInStock() > 0);
        }
          else
              return false;
    }

        //Method to check in a video returned by a customer.
        //Postcondition: If the video returned is from the
        //               store, its copiesInstock is incremented
        //               by one; otherwise, an appropriate message
        //               is printed.
    public void videoCheckIn(String title)
    {
        LinkedListNode location;
        VideoElement temp;

        location = searchVideoList(title);  //search the list

        if(location != null)
        {
            temp = (VideoElement) location.info;
            temp.checkIn();
         }
        else
            System.out.println("The store does not carry "
                             + "this video.");
    }


        //Method to check out a video, that is, rent a video.
        //Postcondition: If a video is available, its copiesInStock
        //               is decremented by one; otherwise, an
        //               appropriate message is printed.
    public void videoCheckOut(String title)
    {
        LinkedListNode location;
        VideoElement temp;

        location = searchVideoList(title);  //search the list

        if(location != null)
        {
            temp = (VideoElement) location.info;
            temp.checkOut();
        }
        else
            System.out.println("The store does not carry "
                             + "this video.");
    }

        //Method to determine whether the video specified by the
        //parameter title is in the store.
        //Postcondition: Returns true if the video is
        //               in the store, false otherwise.
    public boolean videoCheckTitle(String title)
    {
        LinkedListNode location;

        location = searchVideoList(title); //search the list

        return (location != null);
    }

        //Method to update the number of copies of a video
        //by adding the value of the parameter num. The
        //parameter title specifies the name of the video
        //for which the number of copies is to be updated.
        //Postcondition: If video is found; then
        //               copiesInStock = copiesInStock + num;
        //               otherwise, an appropriate message is
        //               printed.
    public void videoUpdateInStock(String title, int num)
    {
        LinkedListNode location;
        VideoElement temp;

        location = searchVideoList(title); //search the list

        if(location != null)
        {
            temp = (VideoElement) location.info;
            temp.updateInStock(num);
        }
        else
            System.out.println("The store does not carry "
                             + "this video.");
    }

        //Method to reset the number of copies of a video.
        //The parameter title specifies the name of the video
        //for which the number of copies is to be reset, and the
        //parameter num specifies the number of copies.
        //Postcondition: If video is found, then
        //               copiesInStock = num;
        //               otherwise, an appropriate message
        //               is printed.
    public void videoSetCopiesInStock(String title, int num)
    {
        LinkedListNode location;
        VideoElement temp;

        location = searchVideoList(title);

        if(location != null)
        {
            temp = (VideoElement) location.info;
            temp.setCopiesInStock(num);
        }
        else
            System.out.println("The store does not carry "
                             + "this video");
    }

        //Method to return the stock of movies for a
        //particular movie
        //Postcondition: If video is found, then
        //               copiesInStock = num;
        //               otherwise, an appropriate message
        //               is printed.
    public int getStock(String title)
    {
        LinkedListNode location;
        VideoElement temp;
        int stock = 0;

        location = searchVideoList(title);

        if(location != null)
        {
            temp = (VideoElement) location.info;
            stock = temp.getNoOfCopiesInStock();
        }

        return stock;
    }

      //Method to print the titles of all the videos in the store.
    public void videoPrintTitle()
    {
        LinkedListNode current;
        VideoElement temp;

        current = first;
        while(current != null)
        {
            temp = (VideoElement) current.info;
            temp.printTitle();
            current = current.link;
        }
    }

      //Method to print the info of all the videos in the store.
    public void print()
    {
        LinkedListNode current; //pointer to traverse the list
        VideoElement temp;

        current = first;    //set current so that it points to
                            //the first node
        while(current != null) //while more data to print
        {
            temp = (VideoElement) current.info;
            temp.printInfo();
            current = current.link;
        }
    }

      //Method to get the info for all the videos
      //Returns the string value of the info
    public String getInfo()
    {
        LinkedListNode current;
        VideoElement temp;
        String vidInfo = "";

        current = first;
        while(current != null)
        {
            temp = (VideoElement) current.info;
            vidInfo += temp.sendInfo();
            current = current.link;
        }

        return vidInfo;
    }
      //add a video to the list
    public void addVid(VideoElement newVid)
    {
		insertFirst(newVid);
    }

      //Deletes a video from the list
    public void deleteVid(String title)
    {
		deleteNode(searchVideoList(title).info);
    }
}
