// { Driver Code Starts
import java.io.*;
import java.util.*;

import TreeNode;
//https://leetcode.ca/2020-06-06-1650-Lowest-Common-Ancestor-of-a-Binary-Tree-III/
class LCA3 {
    public static void main(String[] args){
        
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        TreeNode ans = lowestCommonAncestor(root,root.left, root.right);
        if(ans!=null)
            System.out.println(ans.val); // Output: 2

    }

    static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode parent; 
        public TreeNode(int val){
            this.val = val;
        }
    }
    
    public static TreeNode lowestCommonAncestor( TreeNode p, TreeNode q) {
        TreeNode nodeP=p, nodeQ=q;
        while(nodeP!=nodeQ){
            if(nodeP==null)nodeP=q;
            else nodeP = nodeP.parent;
            if(nodeQ==null)nodeQ=p;
            else nodeQ = nodeQ.parent;
        }
        return nodeP;

        /* Simplifies and clean code
         * Node a = p, b = q;
        while (a != b) {
            a = a.parent == null ? q : a.parent;
            b = b.parent == null ? p : b.parent;
        }
        return a;
         */
    }
    

}


Given a binary string of length n,consisting of 0s and 1s, perform the following operations 0 or 1 time, choose any subsequence, sort it replace original subsequence with sorted subsequence

Now we are given an array of substring of length n, consisting of 0,1,?. Each ? can be replaced with 0 or 1 arbitrarily
For each string in arr, after replacing each '?' character with either 'O' or '1', determine if it is possible to rearrange binary using the operation described any number of times. If it is possible, store "YES" as the corresponding answer, otherwise store "NO", both without quotes.