import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class mainProgVideoStore
{

    public static void main(String[] args)
    {
		//Scanner infile;

        VideoList videoList = new VideoList();
        try
        {
                        BufferedReader infile =
                new BufferedReader(new FileReader("videoDat.doc"));

            createVideoList(infile, videoList);
        }
        catch(FileNotFoundException fnfe)
        {
            System.out.println(fnfe.toString());
        }
        catch(IOException ioe)
        {
            System.out.println(ioe.toString());
        }

        VideoStorePanel menu = new VideoStorePanel(videoList);
		  JScrollPane sp = new JScrollPane (menu);
        JFrame frame = new JFrame ("VideoStore");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(sp);
        frame.pack();
        frame.setVisible(true);


            //displayMenu();

            //System.out.print("Enter the choice: ");
            //choice = Integer.parseInt(keyboard.readLine());
            //System.out.println();

            /*while(choice != 10)
            {

                case 5: videoList.videoPrintTitle();
                        break;
                case 6: videoList.print();
                        break;
                case 7: System.out.print("Enter Title : ");
                        title = keyboard.readLine();
                        if(videoList.videoCheckTitle(title) == true)
                           System.out.print("Video is already in stock");  //DO: consider comparing the entire video element
                        else
                           videoList.insert(createVideo(title));
                           save(videoList);
                        break;
                case 8: System.out.print("Enter the title to be deleted: ");
                        title = keyboard.readLine();
                        videoList.deleteVid(title);
                        save(videoList);                 //DO: add video deleted messages
                        break;                           //DO: check if video is there
                case 9: System.out.print("Enter a search item : ");
                         title = keyboard.readLine();
                         videoList.fullSearch(title).print();
                         break;

                //default: System.out.println("Invalid selection");
                }//end switch

                //displayMenu();
                System.out.print("Enter the choice: ");
                //choice = Integer.parseInt(keyboard.readLine());
                //System.out.println();
            }//end while
        }*/

    }

    public static void createVideoList(BufferedReader infile, VideoList list)
                                       throws IOException
    {
        String  Title;
        String  Star1;
        String  Star2;
        String  Producer;
        String  Director;
        String  ProductionCo;
        int   InStock;

        VideoElement newVideo = new VideoElement();

        Title = infile.readLine();

        while(Title != null)
        {
            Star1 = infile.readLine();
            Star2 = infile.readLine();
            Producer = infile.readLine();
            Director = infile.readLine();
            ProductionCo = infile.readLine();
            InStock = Integer.parseInt(infile.readLine());
            newVideo.setVideoInfo(Title,Star1,Star2,Producer,
                                Director,ProductionCo,InStock);
            list.insert(newVideo);

            Title = infile.readLine();
        }//end while
    }//end createVideoList

    public static VideoElement createVideo(String title)
    {
        String  Title;
        String  Star1;
        String  Star2;
        String  Producer;
        String  Director;
        String  ProductionCo;
        Scanner scan = new Scanner(System.in);
        int   InStock;

        VideoElement newVideo = new VideoElement();

        System.out.print("Enter Star1 : ");
        Star1 = scan.nextLine();
        System.out.print("Enter Star2 : ");
        Star2 = scan.nextLine();
        System.out.print("Enter Producer : ");
        Producer = scan.nextLine();
        System.out.print("Enter Director : ");
        Director = scan.nextLine();
        System.out.print("Enter Production Company : ");
        ProductionCo = scan.nextLine();
        System.out.print("Enter # in stock : ");
        InStock = scan.nextInt();
        newVideo.setVideoInfo(title,Star1,Star2,Producer,
                              Director,ProductionCo,InStock);
        return newVideo;
    }//end createVideoList

    public static void displayMenu()
    {
        System.out.println("Select one of the following: ");
        System.out.println("1: To check if a particular video "
                               + "is in the store");
        System.out.println("2: To check out a video");
        System.out.println("3: To check in a video");
        System.out.println("4: To see if a particular video "
                               + "is in the store");
        System.out.println("5: To print the titles of all videos");
        System.out.println("6: To print a list of all the videos");
        System.out.println("7: To add a video to the list");
        System.out.println("8: To delete a video from the list");
        System.out.println("9: To start a full search");
        System.out.println("10: To exit");
    }

    public static void save(VideoList list) throws IOException
    {
		FileWriter fw;                      //file writer
		BufferedWriter bw;                  //buffered writer

		fw = new FileWriter("videoDat.doc",false);
        bw = new BufferedWriter(fw);

        bw.write(list.getInfo());

          //Close and flush the buffered writer
		bw.flush();
        bw.close();

	}
}