// { Driver Code Starts
import java.io.*;
import java.util.*;

class MaxXOR {
    public static void main(String[] args){
        
       int[] a = {3,10,5,25,2,8};
       Node root = new Node();
       System.out.println(findMaximumXOR(a, root)); // Output: 2

    }

    static class Node{
        int val;
        Node left;
        Node right;
    }
    
    public static int findMaximumXOR(int[] nums, Node root) {
        int bits = 0;
        int max = Integer.MIN_VALUE;
        for(int num:nums){
            max = Math.max(max, num);
        }
       bits = (int)(Math.log(max) / Math.log(2));

       for(int num:nums){
            insertNumInTrie(num, root, bits);
        }
        Node curr = root;
        int maxXOR = Integer.MIN_VALUE;
        for(int num:nums){
            curr = root; 
            for(int i=bits; i>0; i--){
                if((num&(1<<i))>=1){
                    if(curr.left!=null){
                        curr = curr.left;
                    }else if(curr.right!=null){
                        curr = curr.right;
                    }
                }else{
                    if(curr.right!=null){
                        curr = curr.right;
                    }else if(curr.left!=null){
                        curr = curr.left;
                    }
                }
            }
            maxXOR = Math.max(maxXOR, (num^curr.val));
        }
        return maxXOR;
    }

    public static void insertNumInTrie(int num, Node root, int bits){
        Node curr = root;
        for(int i=bits; i>0; i--){
            //System.out.println(num + "______"+  (1<<i));
            //System.out.println("&  "+  (num&(1<<i)));
            if((num&(1<<i))>=1){
                if(curr.right==null) curr.right = new Node();
                curr = curr.right;
            }else{
                if(curr.left==null) curr.left = new Node();
                curr = curr.left;
            }
        }
        curr.val = num;
    }

}
