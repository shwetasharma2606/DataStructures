// { Driver Code Starts
import java.io.*;
import java.util.*;

class SrcToDestPaths {
    public static void main(String[] args){
      /*            0
              /       \
             1         2
             |  \      |
             3-------- 4
              */
        ArrayList<int[]> adjList = new ArrayList<>();
        int[] a0 = {1,2};
        adjList.add(a0);
        int[] a1 = {3,4,0};
        adjList.add(a1);
        int[] a2 = {4};
        adjList.add(a2);
        int[] a3 = {1,4};
        adjList.add(a3);
        int[] a4 = {3,2};
        adjList.add(a4);
        //System.out.println(adjList);
       System.out.println(findPaths(adjList, 0, 4, 5)); // Output: [[0, 1, 3, 4], [0, 1, 4], [0, 2, 4]]

    }
    public static ArrayList<ArrayList<Integer>> findPaths(ArrayList<int[]> adjList, int src, int dest, int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> soFar = new ArrayList<Integer>();
        soFar.add(src);
        dfs(src, dest, adjList, ans, soFar, new boolean[n]);
        return ans;
    }

    public static void dfs(int src,int dest, ArrayList<int[]> adjList, ArrayList<ArrayList<Integer>> ans, 
             ArrayList<Integer> soFar, boolean[] visited ){
        if(src==dest) {
            ArrayList<Integer> r = new ArrayList<>();
            for(int a : soFar){
                r.add(a);
            }
            ans.add(r);
            return;
        }
        visited[src]=true;
        int[] neighbours = adjList.get(src);
        for(int i=0; i<neighbours.length; i++){
            if(!visited[neighbours[i]]){
                soFar.add(neighbours[i]);
                dfs(neighbours[i],dest, adjList, ans, soFar, visited);
                soFar.remove(soFar.size()-1);
            }          
        }
        
        visited[src]=false;
        
    }
}
