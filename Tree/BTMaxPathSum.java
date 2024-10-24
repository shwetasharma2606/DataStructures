// { Driver Code Starts
import java.io.*;
import java.util.*;

import TreeNode;
//VERY GOOD https://www.youtube.com/watch?v=TO5zsKtc1Ic
class BTMaxPathSum {
    public static void main(String[] args){
        
       /*TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);*/   //ANS 42

        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(-1); //ANS : 2


       /* root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);*/
        System.out.println(maxPathSum(root)); // Output: 2

    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    
    static int max = Integer.MIN_VALUE;
    public  static int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return max;
    }
    public static int maxPathSumHelper(TreeNode root) {
        if(root==null) return 0;
        int ans = Integer.MIN_VALUE;
        int left = maxPathSumHelper(root.left);
        int right = maxPathSumHelper(root.right);
        ans = Math.max(Math.max(left,right) + root.val, root.val);
        ans = Math.max(ans, left+right+root.val);
        max = Math.max(ans,max);
        return Math.max(Math.max(left,right) + root.val, root.val);
    }

    public static int maxPathSumUtil(TreeNode root) {
        if(root==null) return 0;
        int ans = Integer.MIN_VALUE;
        int left = maxPathSumUtil(root.left);
        int right = maxPathSumUtil(root.right);
        ans = Math.max(left,right);
        ans = Math.max(ans, left+right+root.val);
        return ans;
    }
    

}
