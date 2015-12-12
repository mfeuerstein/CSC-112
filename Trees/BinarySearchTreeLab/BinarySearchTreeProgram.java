/**********************************************************
 * Program Name   : BinarySearchTreeProgram.java
 * Author         : Michael Feuerstein
 * Date           : May 8, 2012
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
     Class Name: BinarySearchTreeProgram
     -----------------------------------
     Class Variables :
     +tree: BinarySearchTree
     +scan: Scanner
     +num: IntElement
     +object: IntElement
     -----------------------
     Class Methods :
     +main(String[]): static void

     Program Logic
     -------------

     1.  Enter a set of 15-20 numbers into a Binary Search Tree, tree1.
     2.  Recursively count the number of nodes in tree1 and display that number.
     3.  Recursively count the number of leaves in tree1 and display that number.
     4.  Recursively count the number of branches in tree1 and display that number.
     5.  Recursively give the height of tree1 and display that number.
     6.  Recursively do an InOrder traversal of tree1.
     7.  Recursively do a PreOrder traversal of tree1.
     8.  Recursively do a PostOrder traversal of tree1.
     9.  Copy tree1 into tree2, and display tree2.
     10. Use the copy constructor to create tree3
         as a copy of tree1, and display tree3.

*/

import java.util.Scanner;

public class BinarySearchTreeProgram
{
    public static void main(String[] args)
    {
		BinarySearchTree tree1 = new BinarySearchTree();
		BinarySearchTree tree2 = new BinarySearchTree();
		BinarySearchTree tree3;
		Scanner scan = new Scanner(System.in);
		Scanner tokens;
		IntElement num;
		String nLine;
		String token;
		int count;

		//Enter a set of 15-20 numbers into a Binary Search Tree, tree1
		num = new IntElement();

		System.out.print("How many Numbers?: ");
		count = scan.nextInt();

		for(int i = 0; i < count; i++)
		{
			System.out.print("# " + (i + 1) + " = ");
			num.setNum(scan.nextInt());
			tree1.insert(num);
		}

		/*//Input the first number
		System.out.print("Enter Number(or -999 to quit): ");
		num = new IntElement(scan.nextInt());

		//while inside the loop,
		//insert each number into the tree
		//and input the next one
		while(num.getNum() != -999)
		{
			//Insert the number into the tree
			tree1.insert(num);

			//Get the next number or quit
			System.out.print("\nEnter Number(or -999 to quit): ");
		    num = new IntElement(scan.nextInt());
		}*/

		/*//Input a line of numbers
		System.out.print("Enter Number Line, ending with -999: ");
		nLine = scan.nextLine();

		tokens = new Scanner(nLine);
		token = tokens.next();

		num = new IntElement(Integer.parseInt(token));

		//while inside the loop,
		//insert each number into the tree
		//and input the next one
		while(tokens.hasNext() && num.getNum() != -999)
		{
			//Insert the number into the tree
			tree1.insert(num);

		    token = tokens.next();

		    num = new IntElement(Integer.parseInt(token));
		}*/

		//Display the number of nodes
		System.out.println("\n\nNumber of Nodes: " + tree1.treeNodeCount());

		//Display the number of leaves
		System.out.println("\nNumber of Leaves: " + tree1.treeLeavesCount());

		//Display the number of bramches
		System.out.println("\nNumber of Branches: " + tree1.treeBranchCount());

		//Display the tree height
		System.out.println("\nHeight of the tree: " + tree1.treeHeight());
		System.out.println();

		//Display the tree using the inorder transversal
		System.out.println("\nIn Order Display");
		System.out.println("----------------");
		tree1.inorderTraversal();

        //Display the tree using the preorder transversal
		System.out.println("\n\nPre Order Display");
		System.out.println("-----------------");
		tree1.preorderTraversal();

        //Display the tree using the postorder transversal
		System.out.println("\n\nPost Order Display");
		System.out.println("-----------------");
		tree1.postorderTraversal();

        //Copy tree1 into tree2, and display tree2.
        tree2.copyTree(tree1);
		System.out.println("\n\nIn Order Display Tree2");
		System.out.println("----------------------");
		tree2.inorderTraversal();

		//Use the copy constructor to create tree3
		//as a copy of tree1, and display tree3.
		tree3 = new BinarySearchTree(tree1);
		System.out.println("\n\nIn Order Display Tree3");
		System.out.println("----------------------");
		tree3.inorderTraversal();
		System.out.println("\n\n\n");
    }
}

/* Sample Output

How many Numbers?: 18
# 1 = 13
# 2 = 7
# 3 = 24
# 4 = 52
# 5 = 30
# 6 = 45
# 7 = 11
# 8 = 42
# 9 = 73
# 10 = 5
# 11 = 18
# 12 = 22
# 13 = 0
# 14 = 27
# 15 = 8
# 16 = 2
# 17 = 6
# 18 = 75


Number of Nodes: 18

Number of Leaves: 7

Number of Branches: 11

Height of the tree: 6


In Order Display
----------------
0 2 5 6 7 8 11 13 18 22 24 27 30 42 45 52 73 75

Pre Order Display
-----------------
13 7 5 0 2 6 11 8 24 18 22 52 30 27 45 42 73 75

Post Order Display
-----------------
2 0 6 5 8 11 7 22 18 27 42 45 30 75 73 52 24 13

In Order Display Tree2
----------------------
0 2 5 6 7 8 11 13 18 22 24 27 30 42 45 52 73 75

In Order Display Tree3
----------------------
0 2 5 6 7 8 11 13 18 22 24 27 30 42 45 52 73 75

In Order Display Tree3
----------------------
0 2 5 6 7 8 11 13 18 22 24 27 30 42 45 52 73 75

*/