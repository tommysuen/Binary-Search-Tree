
public class BSTConverter {

	public static void main(String[] args){
		// TODO Auto-generated method stub

		System.out.println("---PART 1---");
		System.out.println("1. Printing Sorted Tree of Integers:");
		Solution<Integer> S = new Solution<Integer>();
		Integer[] a = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};  
		TreeNode<Integer> aSortedTree = S.sortedArrayToBST(a);
		BinTreePrinter.printNode(aSortedTree);  //This will print out a balanced binary tree.
		if (S.isValidBST(aSortedTree)){
			System.out.println("2. Congratulations, you have a balanced tree.");
			System.out.println("3. The size of the tree is " + S.getSizeOfBST(aSortedTree));
			System.out.println("4. The depth of the tree is " + S.getDepthOfBST(aSortedTree));
		}

		System.out.println("\n---PART 2---");
		System.out.println("5. Printing a new Unsorted Tree of Strings:");
		Solution<String> S2 = new Solution<String>();
		String[] names = {"B", "A", "C", "E", "D", "F", "G","H"}; //keep strings short, for printing purposes
		TreeNode<String> aUnsortedStrTree = S2.sortedArrayToBST(names);  

		BinTreePrinter.printNode(aUnsortedStrTree);  //BinTreePrinter prints binary trees, not nec. BSTs
		if (S2.isValidBST(aUnsortedStrTree))
			System.out.println("6. The list of Strings is a valid BST");
		else
			System.out.println("6. The list of Strings is NOT a valid BST");
	}
}

class Solution<T extends Comparable<T>> {
	   //Definition for binary tree
		
	  
	   
	   
	   
	   public TreeNode<T> sortedArrayToBST(T[] num) {
	      if (num.length == 0)
	         return null;

	      return sortedArrayToBST(num, 0, num.length - 1);
	   }

	   public TreeNode<T> sortedArrayToBST(T[] num, int start, int end) {
			if (start > end)
				return null;
				
			// TODO - IMPLEMENT THE REMAINDER OF THIS FUNCTION BY 
			// FINDING THE MIDDLE VALUE IN THE ARRAY, 
			// AND THEN RECURSIVELY CALLING sortedArrayToBST(...)
			int middle = (start + end) / 2;
			TreeNode<T> Array = new TreeNode<T>(num[middle]);
			Array.left = sortedArrayToBST(num, start, middle-1);
			Array.right = sortedArrayToBST(num, middle+1, end);
			return Array; }

	   //returns the longest path top to bottom of a BST, 
	   //remember an empty BST is defined to have depth -1.
	   public boolean isEmpty(TreeNode<T> aRootNode){
		   if (aRootNode == null)
			   return true;
		   else
			   return false;
		   
	   }
	   
	   public int getDepthOfBST(TreeNode<T> aRootNode) {
		   int countL, countR;
		   if (isEmpty(aRootNode) == true)
			   return -1;
		   if (aRootNode == null && getSizeOfBST(aRootNode) > 0)
			   return 0;
		   else {
			   countL = getDepthOfBST(aRootNode.left);
			   countR = getDepthOfBST(aRootNode.right);
			   
			   if (countL > countR)
				   return 1 + countL;
			   else
				   return 1 + countR;
			   
			   
		   }
		   
		   
	   }

	   //returns the number of nodes in a BST
	   public int getSizeOfBST(TreeNode<T> aRootNode) {

	   	 	if (aRootNode == null)
			   return 0;
		   else
			   return 1 + getSizeOfBST(aRootNode.left) + getSizeOfBST(aRootNode.right);
	      }

	   //returns true if aRootNode represents a valid Binary Search Tree
	   public boolean isValidBST(TreeNode<T> aRootNode) {
		   if (aRootNode.left == null || aRootNode.right == null)
			   return true;
		   else
			   if (aRootNode.left.data.compareTo(aRootNode.data) < 0 && aRootNode.right.data.compareTo(aRootNode.data) > 0)
			   {
			   isValidBST(aRootNode.left);
			   isValidBST(aRootNode.right);
			   return true;
			   }
		  
		   
		   return false;
		   
}
}
