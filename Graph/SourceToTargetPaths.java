// { Driver Code Starts
import java.io.*;
import java.util.*;

import javax.naming.NameAlreadyBoundException;

class SourceToTargetPaths {
    public static void main(String[] args){
        /*Input: graph = [[1,2],[3],[3],[]]
Output: [[0,1,3],[0,2,3]]*/
        /*int[][] adjList = new int[4][2];
        int[] a0 = {1,2};
        adjList[0] = a0;
        int[] a1 = {3};
        adjList[1] = a1;
        int[] a2 = {3};
        adjList[2] = a2;
        int[] a3 = {};
        adjList[3] = a3;*/

        /*Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]*/
        int[][] adjList = new int[5][2];
        int[] a0 = {4,3,1};
        adjList[0] = a0;
        int[] a1 = {3,2,4};
        adjList[1] = a1;
        int[] a2 = {3};
        adjList[2] = a2;
        int[] a3 = {4};
        adjList[3] = a3;
        int[] a4 = {};
        adjList[4] = a4;
        
        List<List<Integer>> ans = allPathsSourceTarget(adjList);
    }
   
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[graph.length];
        int n = graph.length;
        List<Integer> tempPath = new ArrayList<>();
        tempPath.add(0);
        dfs(graph, 0, n-1, ans, tempPath, visited);
        return ans;
        
    }
    public static void dfs(int[][] graph, int node, int target, List<List<Integer>> ans, List<Integer> tempPath, boolean[] visited ){
        if (node==target) {
            List<Integer> a = new ArrayList<>();
            for (int b : tempPath) {
                a.add(b);
            }
            ans.add(a);
            return;
        }
        visited[node] = true;
        
        int[] childs = graph[node];
        for (int i : childs) {
            if(!visited[i]){
                tempPath.add(i);
                dfs(graph, i, target, ans, tempPath, visited);
                tempPath.remove(tempPath.indexOf(i));
            } 
        }
        visited[node] = false;
    }
    
}
