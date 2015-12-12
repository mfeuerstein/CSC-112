/**********************************************************
 * Program Name   : BinaryTree.java
 * Author         : Michael Feuerstein
 * Date           : May 8, 2012
 * Course/Section : CSC 112-001
 * Program Description: Creates, manages and manipulates
 *    a binary tree of DataElements.
 *
 **********************************************************/

/*
     UML Diagram
     -----------
     Class Name: BinaryTree
     ----------------------
     Class Variables :
     #BinaryTreeNode: class
     #root: BinaryTreeNode
     -----------------------
     Class Methods :
     +BinaryTree()
     +BinaryTree(BinaryTree)
     +isEmpty(): boolean
     +inorderTraversal(): void
     +preorderTraversal(): void
     +postorderTraversal(): void
     +treeHeight(): int
     +treeNodeCount(): int
     +treeLeavesCount(): int
     +treeBramchCount(): int
     +destroyTree(): void
     +copyTree(BinaryTree): void
     -copy(BinaryTreeNode): BinaryTreeNode
     -inorder(BinaryTreeNode): void
     -preorder(BinaryTreeNode): void
     -postorder(BinaryTreeNode): void
     -height(BinaryTreeNode): int
     -max(BinaryTreeNode): int
     -nodeCount(BinaryTreeNode): int
     -leafCount(BinaryTreeNode): int
     -branchCount(BinaryTreeNode): int
*/

public class BinaryTree
{

         //Definition of the node
    protected class BinaryTreeNode
    {
        DataElement info;
        BinaryTreeNode llink;
        BinaryTreeNode rlink;
    }

    protected BinaryTreeNode root;

       //default constructor
       //Postcondition: root = null;
    public BinaryTree()
    {
         root = null;
    }

       //copy constructor
    public BinaryTree(BinaryTree otherTree)
    {
         if(otherTree.root == null) //otherTree is empty
            root = null;
         else
            root = copy(otherTree.root);
    }

       //Method to determine whether the binary tree is empty.
       //Postcondition: Returns true if the binary tree is empty;
       //               otherwise, returns false.
    public boolean isEmpty()
    {
         return (root == null);
    }

       //Method to do an inorder traversal of the binary tree.
       //Postcondition: The nodes of the binary tree are output
       //               in the inorder sequence.
    public void inorderTraversal()
    {
         inorder(root);
    }

       //Method to do a preorder traversal of the binary tree.
       //Postcondition: The nodes of the binary tree are output
       //               in the preorder sequence.
    public void preorderTraversal()
    {
         preorder(root);
    }

       //Method to do a postorder traversal of the binary tree.
       //Postcondition: The nodes of the binary tree are output
       //               in the postorder sequence.
    public void postorderTraversal()
    {
         postorder(root);
    }

       //Method to determine the height of the binary tree.
       //Postcondition: The height of the binary tree is returned.
    public int treeHeight()
    {
         return height(root);
    }

       //Method to determine the number of nodes in the
       //binary tree.
       //Postcondition: The number of nodes in the binary tree
       //               is returned.
    public int treeNodeCount()
    {
         return nodeCount(root);
    }

       //Method to determine the number of leaves in the
       //binary tree.
       //Postcondition: The number of leaves in the binary tree
       //               is returned.
    public int treeLeavesCount()
    {
         return leavesCount(root);
    }

       //Method to determine the number of brancheses in the
       //binary tree.
       //Postcondition: The number of branches in the binary tree
       //               is returned.
    public int treeBranchCount()
    {
         return branchCount(root);
    }

       //Method to destroy the binary tree.
       //Postcondition: root = null
    public void destroyTree()
    {
        root = null;
    }

        //Method to make a copy of the binary tree
       //specified by otherTree points.
       //Postcondition: A copy of otherTree is assigned to
       //               this binary tree.
    public void copyTree(BinaryTree otherTree)
    {

         if(this != otherTree) //avoid self-copy
         {
            root = null;

            if(otherTree.root != null) //otherTree is nonempty
               root = copy(otherTree.root);
         }

    }

        //Method to make a copy of the binary tree to
        //which otherTreeRoot points.
        //Postcondition: A copy of the binary tree to which
        //               otherTreeRoot is created and the reference of
        //               the root node of the copied binary tree
        //               is returned.
    private BinaryTreeNode copy(BinaryTreeNode otherTreeRoot)
    {
         BinaryTreeNode temp;

         if(otherTreeRoot == null)
            temp = null;
         else
         {
            temp = new BinaryTreeNode();
            temp.info = otherTreeRoot.info.getCopy();
            temp.llink = copy(otherTreeRoot.llink);
            temp.rlink = copy(otherTreeRoot.rlink);
         }

         return temp;
    }//end copy

       //Method to do an inorder traversal of the binary
       //tree to which p points.
       //Postcondition: The nodes of the binary tree to which p
       //               points are output in the inorder sequence.
    private void inorder(BinaryTreeNode p)
    {
         if(p != null)
         {
            inorder(p.llink);
            System.out.print(p.info + " ");
            inorder(p.rlink);
         }
    }

       //Method to do a preorder traversal of the binary
       //tree to which p points.
       //Postcondition: The nodes of the binary tree to which p
       //               points are output in the preorder sequence.
    private void preorder(BinaryTreeNode p)
    {
         if(p != null)
         {
            System.out.print(p.info + " ");
            preorder(p.llink);
            preorder(p.rlink);
         }
    }

       //Method to do a postorder traversal of the binary
       //tree to which p points.
       //Postcondition: The nodes of the binary tree to which p
       //               points are output in the postorder sequence.
    private void postorder(BinaryTreeNode p)
    {
         if(p != null)
         {
            postorder(p.llink);
            postorder(p.rlink);
            System.out.print(p.info + " ");
         }
    }

       //Method to determine the height of the binary tree
       //to which p points.
       //Postcondition: The height of the binary tree to which p
       //               points is returned.
    private int height(BinaryTreeNode p)
    {
         if(p == null)
            return 0;
         else
            return 1 + max(height(p.llink), height(p.rlink));
    }

       //Method to determine the larger of x and y.
       //Postcondition: The larger of x and y is returned.
    private int max(int x, int y)
    {
         if(x >= y)
            return x;
         else
            return y;
    }

       //Method to determine the number of nodes in the binary
       //tree to which p points.
       //Postcondition: The number of nodes in the binary tree
       //               to which p points is returned.
    private int nodeCount(BinaryTreeNode p)
    {
		//Hit a leaf
		//Add 0 to node count
        if(p == null)
            return 0;

        //Hit a node
        //Add 1 to node count
        //else
        //{
           //if(p.llink == null)
             //  return 1 + nodeCount(p.rlink);

           //else if(p.rlink == null)
             //  return 1 + nodeCount(p.llink);

           else
               return 1 + nodeCount(p.llink) + nodeCount(p.rlink);
		//}
    }
       //Method to determine the number of leaves in the binary
       //tree to which p points.
       //Postcondition: The number of leaves in the binary tree
       //               to which p points is returned.
    private int leavesCount(BinaryTreeNode p)
    {
		//Hit a leaf
		//Add 1 to leaf count
		if(p == null)
		    return 0;

		else
		{
            if(p.llink == null && p.rlink == null)
		        return 1;

            else
                return leavesCount(p.llink) + leavesCount(p.rlink);
		 }
    }

       //Method to determine the number of branches in the binary
       //tree to which p points.
       //Postcondition: The number of branches in the binary tree
       //               to which p points is returned.
    private int branchCount(BinaryTreeNode p)
    {
		//Hit a leaf
		//Add 0 to node count
        if(p.llink == null && p.rlink == null)
            return 0;

        //Hit a node
        //Add 1 to node count
        else
        {
           if(p.llink == null)
               return 1 + branchCount(p.rlink);

           else if(p.rlink == null)
               return 1 + branchCount(p.llink);

           else
               return 1 + branchCount(p.llink) + branchCount(p.rlink);
		}
    }
}