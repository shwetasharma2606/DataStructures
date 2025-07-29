// { Driver Code Starts
import java.io.*;
import java.util.*;

import javax.naming.NameAlreadyBoundException;

class NumOfProvinces {
    public static void main(String[] args){
      int[][] arr = {{1,1,0},{1,1,0},{0,0,1}};

      //System.out.println(findCircleNum(arr));//Output 2

      int[][] arr1 = {{1,0,0},{0,1,0},{0,0,1}};

      //System.out.println(findCircleNum(arr1));//Output 3

      int[][] arr3= {{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},{0,1,0,1,0,0,0,0,0,0,0,0,0,1,0},{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},{0,1,0,1,0,0,0,1,0,0,0,1,0,0,0},{0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},{0,0,0,1,0,0,0,1,1,0,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0,0,0},{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0,0,0},{0,0,0,1,0,0,0,0,0,0,0,1,0,0,0},{0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1}};
      System.out.println(findCircleNum(arr3));//Output 8
    }
    
    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] parent = new int[n];
        for (int i=0; i< n; i++) {
            parent[i] = i;
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i!=j && isConnected[i][j]==1){
                    union(i, j, parent);
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i : parent) {
            set.add(find(i, parent));
        }
        return set.size();
    }
    public static int find(int c, int[] parent){
        if(parent[c]!=c){
            return find(parent[c], parent);
        }
        return c;
    }
    public static void union(int c, int b,int[] parent){
        int par1 = find(c,parent);
        int par2 = find(b,parent);
        parent[par1] = par2;
    }
}
