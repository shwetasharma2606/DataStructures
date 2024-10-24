// { Driver Code Starts
import java.io.*;
import java.util.*;

import TreeNode;

class LCA {
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
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root.val==p.val) return p;
        if(root.val==q.val) return q;
        TreeNode left = lowestCommonAncestor(root.left, p,q);
        TreeNode right = lowestCommonAncestor(root.right, p,q);
        if(left!=null && right!=null) return root;
        return left!=null?left:right;
    }
    

}
