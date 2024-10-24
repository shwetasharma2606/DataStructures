// { Driver Code Starts
import java.io.*;
import java.util.*;

class Diameter {
    public static void main(String[] args){
        
       TreeNode root = new TreeNode(1);
       root.left = new TreeNode(2);
       root.right = new TreeNode(3);
       root.left.left = new TreeNode(4);
       root.left.right = new TreeNode(5);
       System.out.println(diameterOfBinaryTree( root)); // Output: 3

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    static int max = Integer.MIN_VALUE;
    public static int diameterOfBinaryTree(TreeNode root) {
        diameterOfBinaryTreeHelper(root);
        return max;
    }

    public static int diameterOfBinaryTreeHelper(TreeNode root) {
        if(root==null) return 0;
        int left = diameterOfBinaryTreeHelper(root.left);
        int right = diameterOfBinaryTreeHelper(root.right);
        max = Math.max(max, left+right);
        return Math.max(1+left, 1+right);
    }

}
