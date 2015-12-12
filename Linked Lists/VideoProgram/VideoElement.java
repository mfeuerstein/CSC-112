

public class VideoElement extends DataElement
{
      //Instance Variables
    private String videoTitle;  //variable to store the name
                                //of the movie
    private String movieStar1;  //variable to store the name
                                //of the star
    private String movieStar2;  //variable to store the name
                                //of the star
    private String movieProducer;   //variable to store the name
                                    //of the producer
    private String movieDirector;   //variable to store the name
                                    //of the director
    private String movieProductionCo;   //variable to store the name
                                        //of the production company
    private int copiesInStock;  //variable to store the number of
                                //copies in stock


        //default constructor
        //Instance variables are initialized to their default values.
        //Postcondition: videoTitle = ""; movieStar1 = "";
        //         movieStar2 = ""; movieProducer = "";
        //         movieDirector = "";
        //         movieProductionCo = "";
        //         copiesInStock = 0;
    public VideoElement()
    {
        videoTitle = "";
        movieStar1 = "";
        movieStar2 = "";
        movieProducer = "";
        movieDirector = "";
        movieProductionCo = "";
        copiesInStock = 0;
    }

            //Method to set the details of a video.
            //Instance variables  are set according to the parameters.
            //Postcondition: videoTitle = title; movieStar1 = star1;
            //               movieStar2 = star2; movieProducer = producer;
            //               movieDirector = director;
            //               movieProductionCo = productionCo;
            //               copiesInStock = setInStock;
    public void setVideoInfo(String title, String star1,
                             String star2, String producer,
                             String director, String productionCo,
                             int setInStock)
    {
        videoTitle = title;
        movieStar1 = star1;
        movieStar2 = star2;
        movieProducer = producer;
        movieDirector = director;
        movieProductionCo = productionCo;
        copiesInStock = setInStock;
    }

        //Method to check the number of copies in stock.
        //Postcondition: The value of the instance variable
        //                copiesInStock is returned.
    public int getNoOfCopiesInStock()
    {
        return copiesInStock;
    }

        //Method to check in a video.
        //Postcondition: The number of copies in stock is incremented
        //               by one.
    public void checkIn()
    {
        copiesInStock++;
    }

        //Method to rent a video.
        //Postcondition: If there is a video in stock, its number of
        //               copies in stock is decremented by one;
        //               otherwise, an appropriate message is printed.
    public void checkOut()
    {
        if(getNoOfCopiesInStock() > 0)
            copiesInStock--;
        else
            System.out.println("Currently out of stock.");
    }

            //Method to print the title of a movie.
    public void printTitle()
    {
        System.out.println("Video Title: " + videoTitle);
    }

            //Method to print the details of a video.
    public void printInfo()
    {
        System.out.println("Video Title: " + videoTitle);
        System.out.println("Stars: " + movieStar1 + " and "
                           + movieStar2);
        System.out.println("Producer: " + movieProducer);
        System.out.println("Director: " + movieDirector);
        System.out.println("Production Company: " + movieProductionCo);
        System.out.println("Copies in stock: " + copiesInStock);
        System.out.println();
    }
            //Method to print the details of a video.
    public String sendInfo()
    {
		String vidInfo = "";

        vidInfo += videoTitle + "\n";
        vidInfo += movieStar1 + "\n";
        vidInfo += movieStar2 + "\n";
        vidInfo += movieProducer + "\n";
        vidInfo += movieDirector + "\n";
        vidInfo += movieProductionCo + "\n";
        vidInfo += copiesInStock + "\n";

        return vidInfo;
    }
            //Method to determine whether title is the same as the
            //title of the video.
            //Postcondition: Returns the value true if title is the
            //               same as the title of the video,
            //               false otherwise.
    public boolean checkTitle(String title)
    {
        return(videoTitle.compareTo(title) == 0);
    }
          //Checks for any similar information
    public boolean checkInfo(String info)
    {
		boolean found = false;

		for(int i = 0; i < videoTitle.split(" ").length; i++)
		   for(int j = 0; j < info.split(" ").length; j++)
		      if(videoTitle.split(" ")[i].equals(info.split(" ")[j]))
              {
				 found = true;
                 break;
		      }
		for(int i = 0; i < movieStar1.split(" ").length; i++)
		   for(int j = 0; j < info.split(" ").length; j++)
		      if(movieStar1.split(" ")[i].equals(info.split(" ")[j]))
              {
				 found = true;
                 break;
		      }
 		for(int i = 0; i < movieStar2.split(" ").length; i++)
		   for(int j = 0; j < info.split(" ").length; j++)
		      if(movieStar2.split(" ")[i].equals(info.split(" ")[j]))
              {
				 found = true;
                 break;
		      }
		for(int i = 0; i < movieProducer.split(" ").length; i++)
		   for(int j = 0; j < info.split(" ").length; j++)
		      if(movieProducer.split(" ")[i].equals(info.split(" ")[j]))
              {
				 found = true;
                 break;
		      }
 		for(int i = 0; i < movieDirector.split(" ").length; i++)
		   for(int j = 0; j < info.split(" ").length; j++)
		      if(movieDirector.split(" ")[i].equals(info.split(" ")[j]))
              {
				 found = true;
                 break;
		      }
 		for(int i = 0; i < movieProductionCo.split(" ").length; i++)
		   for(int j = 0; j < info.split(" ").length; j++)
		      if(movieProductionCo.split(" ")[i].equals(info.split(" ")[j]))
              {
				 found = true;
                 break;
		      }

       return found;
    }

       //compare the title of two movies
    public String returnTitle()
    {
        return videoTitle;
    }

            //Method to increment the number of copies in stock by
            //adding the value of the parameter num.
            //Postcondition: copiesInStock = copiesInStock  + num
    public void updateInStock(int num)
    {
        copiesInStock += num;
    }

            //Method to set the number of copies in stock.
            //Postcondition: copiesInStock = num;
    public void setCopiesInStock(int num)
    {
        copiesInStock = num;
    }

        //Returns the title of the video
        //Postcondition: The value of the instance variable
        //               videoTitle is returned.
    public String getTitle()
    {
        return videoTitle;
    }

        //constructor with parameters
        //Instance variables are set according to the parameters
        //Postcondition: videoTitle = title; movieStar1 = star1;
        //         movieStar2 = star2; movieProducer = producer;
        //         movieDirector = director;
        //         movieProductionCo = productionCo;
        //         copiesInStock = setInStock;
    public VideoElement(String title, String star1,
                        String star2, String producer,
                        String director, String productionCo,
                        int setInStock)
    {
        videoTitle = title;
        movieStar1 = star1;
        movieStar2 = star2;
        movieProducer = producer;
        movieDirector = director;
        movieProductionCo = productionCo;
        copiesInStock = setInStock;
    }

    public boolean equals(DataElement otherElement)
    {
        VideoElement temp = (VideoElement) otherElement;

        return (videoTitle.compareTo(temp.videoTitle) == 0);
    }

    public int compareTo(DataElement otherElement)
    {
        VideoElement temp = (VideoElement) otherElement;

        return (videoTitle.compareTo(temp.videoTitle));
    }

    public void makeCopy(DataElement otherElement)
    {
        VideoElement temp = (VideoElement) otherElement;

        videoTitle = temp.videoTitle;
        movieStar1 = temp.movieStar1;
        movieStar2 = temp.movieStar2;
        movieProducer = temp.movieProducer;
        movieDirector = temp.movieDirector;
        movieProductionCo = temp.movieProductionCo;
        copiesInStock = temp.copiesInStock;
    }

    public DataElement getCopy()
    {
        VideoElement temp = new VideoElement(videoTitle, movieStar1,
                                movieStar2, movieProducer, movieDirector,
                                movieProductionCo, copiesInStock);
        return temp;
    }
}

