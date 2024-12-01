// { Driver Code Starts
import java.io.*;
import java.util.*;

import javax.naming.NameAlreadyBoundException;

class IsBipartite {
    public static void main(String[] args){
      /*int[][] graph = new int[4][2];//graph = [[1,3],[0,2],[1,3],[0,2]] OUTPUT : true
      int[] g0 = {1,3};
      int[] g1 = {0,2};
      int[] g2 = {1,3};
      int[] g3 = {0,2};
      graph[0] = g0;
      graph[1] = g1;
      graph[2] = g2;
      graph[3] = g3;*/

      int[][] graph1 = new int[4][3];//graph = [[1,2,3],[0,2],[0,1,3],[0,2]] OUTPUT : false
      int[] g0 = {1,2,3};
      int[] g1 = {0,2};
      int[] g2 = {0,1,3};
      int[] g3 = {0,2};
      graph1[0] = g0;
      graph1[1] = g1;
      graph1[2] = g2;
      graph1[3] = g3;
      isBipartite(graph1);
    }
    public static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static boolean isBipartite(int[][] graph) {
        if(graph.length==1) return true;
        int[] grp1 = new int[graph.length];
        grp1[0] = 1;
        boolean dfs= dfs(graph, 0,grp1);
        System.out.println("DFS :: "+dfs);

        int[] grp2 = new int[graph.length];
        grp2[0] = 1;
        boolean bfs = bfs(graph, 0, grp2);
        System.out.println("BFS :: "+bfs);
        return bfs && dfs;

      // return bfs(graph, 0, new int[graph.length]);
    }

    //group[i] = 1 if even -1 if odd 
    public static boolean bfs(int[][] graph, int node, int[] group){
        int[] connections = graph[node];
        /*if(node%2==0 && group[node]==0) group[node] = 1;
        else  if(node%2==1 && group[node]==0) group[node] = -1;*/
        for (int i : connections) {
            if(i%2==0){
                if(group[i]==-1) return false;
                group[i] = 1;
            }else{
                if(group[i]==1) return false;
                group[i] = -1;
            }
        }
        for (int i : connections) {
            if(group[i]==0)
                bfs(graph, i, group);
        }
        return true;
    }

    public static boolean dfs(int[][] graph, int node, int[] group){
        int[] connections = graph[node];
        if(node%2==0) group[node] = 1;
        else group[node] = -1;
         
        for (int i : connections) {
            if(i%2==0 && group[i]==1){
                return false;
            }else if(i%2==1 && group[i]==-1){
                return false;
            }else {
                if(group[i]==0)
                    dfs(graph, i, group);

            }
        }
        return true;
    }
    
}
