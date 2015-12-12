public class TreeNode

{

  /******** Instance Data *************/

  private int item;				//Data field
  private TreeNode leftChild;	//Left Pointer
  private TreeNode rightChild;	//Right Pointer

  /******** Constructors **************/

  public TreeNode()
  {
	//Initializes an empty node
	item = 0;
	leftChild  = null;
    rightChild = null;
  }	// end constructor

  public TreeNode(int newItem)
  {
  	//Initializes tree node with item and no children.
    item = newItem;
    leftChild  = null;
    rightChild = null;
  } // end constructor

  public TreeNode(int newItem,
                  TreeNode left, TreeNode right)
  {
  // Initializes tree node with item and
  // the left and right children references.
    item = newItem;
    leftChild  = left;
    rightChild = right;
  }  // end constructor

  /************ Methods *******************/

  public int getItem()
  {
  // Returns the item field.
    return item;
  }  // end getItem

  public void setItem(int newItem)
  {
  // Sets the item field to the new value newItem.
  item  = newItem;
  }  // end setItem

  public TreeNode getLeft()
  {
  // Returns the reference to the left child.
    return leftChild;
  }  // end getLeft

  public void setLeft(TreeNode left)
  {
  // Sets the left child reference to left.
    leftChild  = left;
  }  // end setLeft

  public TreeNode getRight()
  {
  // Returns the reference to the right child.
    return rightChild;
  }  // end getRight

  public void setRight(TreeNode right)
  {
  // Sets the right child reference to right.
    rightChild  = right;
  }  // end setRight
}  // end TreeNode