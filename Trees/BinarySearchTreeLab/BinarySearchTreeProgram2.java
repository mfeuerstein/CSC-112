/**********************************************************
 * Program Name   : BinarySearchTreeProgram2.java
 * Author         : Michael Feuerstein
 * Date           : May 11, 2012
 * Course/Section : CSC 112-001
 * Program Description: Tests the methods of the BinaryTree
 *    and BinarySearchTree classes. The user will enter an
 *    assortmant of numbers into a tree which will be then
 *    be displayed in different orders.
 *
 **********************************************************/

/*
     UML Diagram
     -----------
     Class Name: BinarySearchTreeProgram2
     ------------------------------------
     Class Variables :
     +tree1: BinarySearchTree
     +tree2: BinarySearchTree
     +scan: Scanner
     +Str: StringElement
     +found: boolean
     -----------------------
     Class Methods :
     +main(String[]): static void

    Program Logic

    1.  Enter a set of 15-20 names into a Binary Search Tree, tree1.
    2.  Recursively do an InOrder traversal of tree1 to see its contents.
    3.  Search for a word which is in the tree and give the results.
    4.  Search for a word which is NOT in the tree and give the results.
    5.  Delete a word which is in the tree.
    6.  Recursively do an InOrder traversal of tree1 to show it is gone.
    7.  Try to delete a word which is NOT in the tree.
    8.  Use the copy constructor to create tree2 as a copy of tree1.
    9.  Recursively do an InOrder traversal of tree2 to verify its contents.
   10.  Make SURE that the output from this program is included at the end.

*/

import java.util.Scanner;

public class BinarySearchTreeProgram2
{
    public static void main(String[] args)
    {
		BinarySearchTree tree1 = new BinarySearchTree();
		BinarySearchTree tree2 = new BinarySearchTree();
		Scanner scan = new Scanner(System.in);
		StringElement str;
		int count;
		boolean found;

		//Enter a set of 15-20 numbers into a Binary Search Tree, tree1
		str = new StringElement();

		System.out.print("How many Names?: ");
		count = scan.nextInt();

		for(int i = 0; i < count; i++)
		{
			System.out.print("Name " + (i + 1) + " = ");
			str.setString(scan.next());
			tree1.insert(str);
		}

		//Display the tree using the inorder transversal
		System.out.println("\nIn Order Display");
		System.out.println("----------------");
		tree1.inorderTraversal();

		//Search for a word which is in the tree and give the results.
		System.out.print("\n\nEnter a name from the tree :");
		str.setString(scan.next());
        System.out.println("\nName Found : " + tree1.search(str));

        //Search for a word which is NOT in the
        //tree and give the results.
		System.out.print("\nEnter a name not from the tree : ");
		str.setString(scan.next());
        System.out.println("\nName Found : " + tree1.search(str));

        //Delete a word which is in the tree.
		System.out.print("\nDelete a name in the tree : ");
		str.setString(scan.next());
        tree1.deleteNode(str);

 		//Display the tree using the inorder transversal
 		System.out.println("\nIn Order Display");
 		System.out.println("----------------");
		tree1.inorderTraversal();

		//Try to delete a word which is NOT in the tree.
		System.out.print("\n\nDelete a name not in the tree : ");
		str.setString(scan.next());
        tree1.deleteNode(str);

        //Copy tree1 into tree2, and display tree2.
        tree2.copyTree(tree1);
		System.out.println("\nIn Order Display Tree2");
		System.out.println("----------------------");
		tree2.inorderTraversal();
		System.out.println("\n\n\n");
    }
}

/* Sample Output

How many Names?: 3
Name 1 = tom
Name 2 = tim
Name 3 = tot

In Order Display
----------------
tim tom tot

Enter a name from the tree :tot

Name Found : true

Enter a name not from the tree : mat

Name Found : false

Delete a name in the tree : tom

In Order Display
----------------
tim tot

Delete a name not in the tree : ray
The delete item is not in the list.

In Order Display Tree2
----------------------
tim tot

*/