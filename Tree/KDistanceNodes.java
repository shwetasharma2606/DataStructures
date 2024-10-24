// { Driver Code Starts
import java.io.*;
import java.util.*;

import TreeNode;

class KDistanceNodes {
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
        List<Integer> ans = distanceK(root, root.left, 2);
        if(ans!=null)
            System.out.println(ans); // Output: 2

    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        TreeNode[] parent = new TreeNode[501];
        fillParent(parent, root, null);
        Set<Integer> visited = new HashSet<>();
        distanceKHelper(target, k,ans,parent, visited);
        return ans;
    }

    public static void fillParent(TreeNode[] parent, TreeNode root, TreeNode par){
        if(root==null) return;
        if(par!=null){
            parent[root.val] = par;
        }
        fillParent(parent, root.left, root);
        fillParent(parent, root.right, root);
    }

    public static void distanceKHelper(TreeNode target, int k, List<Integer> ans, TreeNode[] parent, Set<Integer> visited) {
        if(target==null) return;
        if(visited.contains(target.val)) return;
        visited.add(target.val);
        if(k==0){
            ans.add(target.val);
            return;
        }

        distanceKHelper(parent[target.val], k-1, ans, parent, visited);
        distanceKHelper(target.left, k-1, ans, parent, visited);
        distanceKHelper(target.right, k-1, ans, parent, visited);
    }

}
