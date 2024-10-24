// { Driver Code Starts
import java.io.*;
import java.util.*;

class SerDesBT {
    public static void main(String[] args){
        
       /*TreeNode root = new TreeNode(1);
       root.left = new TreeNode(2);
       root.right = new TreeNode(3);
       root.right.left = new TreeNode(4);
       root.right.right = new TreeNode(5);
       // Output: working*/
       TreeNode root = new TreeNode(4);
       root.left = new TreeNode(-7);
       root.right = new TreeNode(-3);

       root.right.left = new TreeNode(-9);
       root.right.right = new TreeNode(-3);

       root.right.right.left = new TreeNode(-4);

       root.right.left.left = new TreeNode(9);
       root.right.left.right = new TreeNode(-7);

       root.right.left.left.left = new TreeNode(6);
       root.right.left.left.left.left = new TreeNode(0);
       root.right.left.left.left.left.right = new TreeNode(-1);
       root.right.left.left.left.right = new TreeNode(6);
       root.right.left.left.left.right.left = new TreeNode(-4);

       root.right.left.right.left = new TreeNode(-6);
       root.right.left.right.left.left = new TreeNode(5);
       root.right.left.right.right = new TreeNode(-6);
       root.right.left.right.right.left = new TreeNode(9);
       root.right.left.right.right.left.left = new TreeNode(-2);


       String ser = serialize(root);
       System.out.println(ser); 
       TreeNode a = deserialize(ser);
       System.out.println("DESERIALIZED");
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
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        List<String> ans = new ArrayList<>();
        levelOrderHelper(root,0,ans);
        StringBuilder sb = new StringBuilder();
        for (String string : ans) {
            sb.append(string);
            sb.append("~");
        }
        return sb.toString();
    }
    public static void levelOrderHelper(TreeNode root, int level,List<String> ans ) {
        if(root==null) {
            if(ans.size()>level && ans.get(level)!=null)
                ans.set(level, ans.get(level)+"~"+"1001");
            else
                ans.add(level, "1001");
            
            return;
        }
        if(ans.size()>level && ans.get(level)!=null)
            ans.set(level, ans.get(level)+"~"+root.val);
        else
            ans.add(level, root.val+"");
        levelOrderHelper(root.left, level+1,ans);
        levelOrderHelper(root.right, level+1,ans);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data==null || data.length()==0 || data.equalsIgnoreCase("~")
        || data.equalsIgnoreCase("1001~")) return null;
        String[] nodes = data.split("~");
        TreeNode root = new TreeNode();
        if(nodes.length>0){
            root.val = Integer.parseInt(nodes[0]);
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode curr = null;
        int idx = 1;
        
        while(!stack.isEmpty()){
            int size = stack.size();
            while(size>0 ){
                curr = stack.pop();
                size--;
                int leftVal =1001;
                int rightVal =1001;
                if(idx<nodes.length)
                    leftVal = Integer.parseInt(nodes[idx++]);
                if(idx<nodes.length)
                    rightVal = Integer.parseInt(nodes[idx++]);
                
                TreeNode left = null;
                TreeNode right = null;
                if(leftVal!=1001){
                    left = new TreeNode(leftVal);
                    curr.left = left;
                }
                if(rightVal!=1001){
                    right = new TreeNode(rightVal);
                    curr.right = right;
                }
                if(right!=null) stack.add(right);
                if(left!=null) stack.add(left);
            }   
        }
        return root;
    }

}

