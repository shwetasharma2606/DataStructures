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

       System.out.println(countPrimes(10)); // Output: 2

    }
    public static ArrayList<ArrayList<Integers>> findPaths(ArrayList<int[]> adjList, int src, int dest, int n) {
        ArrayList<ArrayList<Integers>> ans = new ArrayList<>();

    }

    public void dfs(int index,ArrayList<int[]> adjList, ArrayList<ArrayList<Integers>> ans, int dest, ArrayList<Integer> soFar, boolean[] visited ){
        if(visited[index]) return;
        if(index==dest) {
            soFar.add(index);
            ans.add(soFar);
            return;
        }
        ArrayList<Integer> neighbours = adjList.get(index);
        for(int i=0; i<neighbours.size(); i++){

        }
    }
    

}
