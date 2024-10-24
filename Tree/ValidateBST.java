// { Driver Code Starts
import java.io.*;
import java.util.*;

import TreeNode;

class ValidateBST {
    public static void main(String[] args){
        
        TreeNode root = new TreeNode(-2147483648);
        root.left = new TreeNode(-2147483648);
       
        System.out.println(isValidBST(root)); // Output: 2

    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    
    public static boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isValidBSTHelper(TreeNode node, int min, int max) {
        if (node == null) return true;

        // If the current node's data 
        // is not in the valid range, return false
        if (node.val < min || node.val > max) return false;

        // Recursively check the left and 
        // right subtrees with updated ranges
        return isValidBSTHelper(node.left, min, node.val - 1) &&
               isValidBSTHelper(node.right, node.val + 1, max);
    }
    

}
