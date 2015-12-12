import java.io.*;

public class BinaryTreePM
{

	TreeNode node;  		//new nodes
	TreeNode root;  		//root of Tree
	boolean isEmpty;		//is the tree empty?

  /***********  Constructors  *******************/


  public BinaryTreePM()
  {//create an empty tree
   		isEmpty = true;			//the tree starts out empty
   		root = null;			//root of tree is null
  }// end constructor


  /***************  Methods  ********************/

 public void insertValue(int data)
 {
	 //initiate call to recursive insert function
     root = insert(root, data);  //updates root if tree is empty
 }

 private TreeNode insert(TreeNode newNode, int data)
 {
	//recursive insert function
    if (newNode == null) //base case - reached null pointer
    {
      newNode = new TreeNode(data); //insert node
    }
    else //general case - find position
    {
      if (data <= newNode.getItem())
      {
		//if data is less than current node - move to left
        newNode.setLeft(insert(newNode.getLeft(), data));
      }
      else
      {
		//if data is greater than current node - move to right
        newNode.setRight(insert(newNode.getRight(), data));
      }
    }

    return(newNode); // in any case, return the new pointer to the caller
  }


  public void display()
  {
	 if(root == null)			//don't print if tree is empty
	 {
		 System.out.println("The tree is empty.");
     }
 	 else //initiate call to recursive print function
 	 {
		 node = root;  			//get root of tree
		 displayInOrder(node);  //starting with root, display tree
 	 }
  }//end display


  public void displayInOrder(TreeNode node)
  {
	 //recursive display in order
	 //if there is data to the left
	  if (node.getLeft() != null)
	  {
		//keep moving to the left until no more data
	  	displayInOrder(node.getLeft());
  	  }
	  //print out node
	  System.out.println(node.getItem());
      //now move to the right
	  if (node.getRight() != null)
	  {
		  //keep traveling right until no more data
		  displayInOrder(node.getRight());
      }

  }//end display Node



} // end BinaryTree