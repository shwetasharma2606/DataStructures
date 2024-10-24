// { Driver Code Starts
import java.io.*;
import java.util.*;

import TreeNode;

class CountGoodNodes {
    public static void main(String[] args){
        
        /*TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);*///ANS : 4

        /*TreeNode root = new TreeNode(3);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(2);*/

        TreeNode root = new TreeNode(1);
        
        System.out.println(goodNodes(root)); // Output: 2

    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public static int ans = 0;
    public static int goodNodes(TreeNode root) {
        goodNodesHelper(root,root.val);
        return ans;
    }

    public static void goodNodesHelper(TreeNode root, int max) {
        if(root==null) return;
        if(root.val>=max){
            max = root.val;
            ans++;
        } 
        goodNodesHelper(root.left, max);
        goodNodesHelper(root.right, max);
    }
    

}
