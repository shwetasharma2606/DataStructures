// { Driver Code Starts
import java.io.*;
import java.util.*;

import javax.naming.NameAlreadyBoundException;

class GraphValidTree {
    public static int[] p;
    public static void main(String[] args){
      int[][] edges = {{0,1},{1,2},{2,3},{1,3},{1,4}}; //output false

      //int[][] edges = {{0,1},{0,2},{0,3},{1,4}};//output true
     
      System.out.println(validTree(5, edges));
    }
    
    public static boolean validTree(int n, int[][] edges) {
        p = new int[n];
        for (int i =0; i<n; i++) {
            p[i] = i;
        }

        for (int[] ed : edges) {
            int u = ed[0];
            int v = ed[1];
            if(find(u)==find(v)){
                return false;
            }
            p[find(u)]= find(v);
            --n;
        }
        return n==1;
    }

    public static int find(int node){
        if(p[node]!=node){
            p[node] = find(p[node]);
        }
        return p[node];
    }
}
