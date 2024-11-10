import java.io.*;
import java.util.*;

class ConnectedComponentsUndirectedGraphs {
    public static void main(String[] args){
        /*            0
                /       
               1  ------- 2
               
               3-------- 4
                */
          /*int[][] prerequisites = new int[4][2];
          int[] a0 = {0,1};
          prerequisites[0] = a0;
          int[] a1 = {1,2};
          prerequisites[1] = a1;
          int[] a2 = {3,4};
          prerequisites[2] = a2;
          System.out.println(countComponentsUNION(5,prerequisites)); // Output: 2*/

        //int[][] edges =  {{0,1},{1,2},{3,4}};//Output 2

        int[][] edges =  {{0,1},{1,2},{2,3},{3,4}};//Output 2
        System.out.println(countComponentsUNION(5,edges)); // Output: 2
        System.out.println(countComponentsDFS(5,edges)); // Output: 2
    }

    public static int countComponentsDFS(int n, int[][] edges) {
        ArrayList<Integer>[] adjList = getAdjacencyList(edges, n);
        int ans=0;
        boolean[] visited =  new boolean[n];
        for(int i=0; i<n; i++){
            int a = dfs(adjList, i,visited);
            System.out.println("FOr vertex : "+i +" a is : "+a);
            if(a>0) ans++;
        }
        return ans;
    }
    public static int dfs(ArrayList<Integer>[] adjList, int v, boolean[] visited ){
        if(visited[v]) return 0;
        ArrayList<Integer> neighbours = adjList[v];
        visited[v] = true;
        int res = 0;
        if(neighbours!= null){
            for (Integer integer : neighbours) {
                if(!visited[integer]) {
                    res+= dfs(adjList, integer, visited);
                }
                    
            }
        }
        return res+1;
        
    }

    public static ArrayList<Integer>[] getAdjacencyList(int[][] input, int n){
        ArrayList<Integer>[] adjList = new ArrayList[n];
        for(int i=0; i<input.length; i++){
            ArrayList<Integer> list = null;
            if(adjList[input[i][0]]==null){
                 list = new ArrayList<>();
            }else{
                list = adjList[input[i][0]];
            }
            list.add(input[i][1]);
            adjList[input[i][0]] = list;

            ArrayList<Integer> list1 = null;
            if(adjList[input[i][1]]==null){
                 list1 = new ArrayList<>();
            }else{
                list1 = adjList[input[i][1]];
            }
            list1.add(input[i][0]);
            adjList[input[i][1]] = list1;
        }
        return adjList;
    }

    public static int countComponentsUNION(int n, int[][] edges) {
        int ans = 0;
        int[] parent = new int[n];
        
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int[] is : edges) {
            parent[is[0]] = find(is[1], parent);
        }

        for (int i = 0; i < parent.length; i++) {
            if(parent[i]==i) ans++;
        }
        return ans;
    }
  
    public static int find(int v, int[] parent){
        if(parent[v]!=v){
            return find(parent[v], parent);
        }else{
            return v;
        }
    }
}
