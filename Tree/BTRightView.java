// { Driver Code Starts
import java.io.*;
import java.util.*;

class BTRightView {
    public static void main(String[] args){
        
       TreeNode root = new TreeNode(1);
       root.left = new TreeNode(2);
       root.right = new TreeNode(3);
       root.left.right = new TreeNode(5);
       root.right.right = new TreeNode(4);
       System.out.println(rightSideView(root)); // Output: 3

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
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        rightSideViewHelper(root,0,ans);
        return ans;
    }
    public static void rightSideViewHelper(TreeNode root, int level,List<Integer> ans ) {
        if(root==null) return;
        if(ans.size()>level && ans.get(level)!=null)
            ans.set(level, root.val);
        else
            ans.add(level, root.val);
        rightSideViewHelper(root.left, level+1,ans);
        rightSideViewHelper(root.right, level+1,ans);
    }

}
