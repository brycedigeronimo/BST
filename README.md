Author: Bryce Di Geronimo

CIS 313, Intermediate Data Structures
Fall 2018

CIS 313 Lab 2
This lab involves implementing a Binary Search Tree

Overview

You will implement a working Binary Search Tree in the BST.java class.You will relay input commands in lab2.java using a scanner.  In particular, you will implement the following functionality:

Insertion
To simplify things, we will not test your binary search tree with duplicate elements.Insertion should change one of the leaves of the tree from null to a node holding the inserted value.This should also preserve the ordering requirement that all nodes in the right side of a subtree are greater than the value in the root of that subtree, and all elements in the left side are lesser than the value in the root of the subtree.

Deletion
When deleting a value, delete the node which contains that value from the tree.If said node has no children, simply remove it by setting its parent to point to null instead of it.If said node has one child, delete it by making its parent point to its child.If said node has two children, then replace it with its successor, and remove the successor from its previous location in the tree.The successor of a node is the left-most node in the node’s right subtree.If the value specified by delete does not exist in the tree, then the structure is left unchanged.

Find
Find takes an int and returns the node in the tree which holds that value.If no such node exists in the tree, return null.

Traversals: preorder, postorder, inorder
Print out the elements in a binary search tree, space separated.You should do this for the preorder, postorder, and inordered representation of the elements.


Input Description
The input will be a text file, for example inSample.txt below will be provided.  The first line will contain an integer N, which is the number of lines to follow.  Each of the N lines contain a single word  specifying  delete,  insert,  inorder,  preorder,  or  postorder  (and  for  insert  and  delete,  also  a number).

You should create an empty binary search tree (with root null), and then perform a sequence of actions on that tree.

10
insert 30
insert 40
insert 20
insert 10
inorder
preorder
postorder
insert 35
delete 30
inorder

Output Description

The only output will be from the traverse commands.  Print each the data in each element in the BST separated by spaces in the correct order (depending on which traverse command was called).For example, using the sample input above, your program should output:
10 20 30 40
30 20 10 40
10 20 40 30
10 20 35 40

Extra Credit:

To receive points for the extra credit you will create two Binary Search Trees based on given input,and then you must determine if they have the same shape:
	•Create a new public class file called TreeCompare
	•TreeCompare will be similar to lab2.java
		–It will read in a list of commands from an input text file
		–The input text file will create two different BSTs
		–The input text file will start with a number N1
		–Then N1 lines of insert commands will follow to create the first BST
		–Then there will be a line with a number N2
		–Then N2 lines of insert commands will follow to create the second BST
	•After you have created the two BSTs, TreeCompare will compare the two trees
	•If the trees have the same shape, output ”The trees have the same shape.”
	•Otherwise, output ”The trees do not have the same shape.”

Here is an example of what the input text file may look like:

5
insert 10
insert 20
insert 30
insert 40
insert 50
5
insert 50
insert 40
insert 30
insert 20
insert 10

The corresponding output would then be:

The trees do not have the same shape.