// { Driver Code Starts
import java.io.*;
import java.util.*;

import javax.naming.NameAlreadyBoundException;

class NetworkDelayTime {
    public static void main(String[] args){
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        System.out.println(networkDelayTime(times, 4,2));//Output :  2

        int[][] times1 = {{1,2,1}};
        System.out.println(networkDelayTime(times1, 2,1));//Output :  1

        int[][] times2 = {{1,2,1}};
        System.out.println(networkDelayTime(times2, 2,2));//Output :  -1
    }
    //Dijkstra algo
    //https://leetcode.ca/2017-12-12-743-Network-Delay-Time/
    public static int networkDelayTime(int[][] times, int n, int k) {
        int[][] g = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(g[i], Integer.MAX_VALUE);
        }
        for (int[] e : times) {
            g[e[0]-1][e[1]-1] = e[2];
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k-1] = 0;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; ++i) {
            int t = -1;
            for (int j = 0; j < n; ++j) {
                if (!vis[j] && (t == -1 || dist[t] > dist[j])) {
                    t = j;
                }
            }
            vis[t] = true;
            for (int j = 0; j < n; ++j) {
                if(g[t][j]!=Integer.MAX_VALUE && dist[t]!= Integer.MAX_VALUE)
                    dist[j] = Math.min(dist[j], dist[t] + g[t][j]);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, dist[i]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    /* 
    static int[] parent;
    public static int networkDelayTime(int[][] times, int n, int k) {
        int ans = 0;
        parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        int[] dist = new int[n];
        for (int i = 0; i < dist.length; i++) {
            if(i!=k-1){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        boolean[] visited = new boolean[n];
        HashMap<Integer, ArrayList<Pair>> adjList = getAdjList(times);


        return ans;
    }
    public static class Pair{
        int node;
        int time;
        Pair(int node, int time){
            this.time = time;
            this.node = node;
        }
    }
    public static int v = 0;
    public void dfs(int n,int node, HashMap<Integer, ArrayList<Pair>> adjList, boolean[] visited, int[] dist){
        if(v== n-1) return;
        ArrayList<Pair> childs = adjList.get(node);
        visited[node] = true;
        for (Pair pair : childs) {
            if(!visited[pair.node]){
                if(dist[node]+pair.time < dist[pair.node]){
                    dist[pair.node] = dist[node]+pair.time;
                    v++;
                    parent[pair.node] = find(node);
                }
            }
        }
        

    }
    public static int find(int node){
        if(parent[node]!=node){
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }
    public static HashMap<Integer, ArrayList<Pair>> getAdjList( int[][] times){
        HashMap<Integer, ArrayList<Pair>> adjList = new HashMap<>();
        for (int[] is : times) {
            Pair pair = new Pair(is[1], is[2]);
            ArrayList<Pair> list = null;
            if(adjList.get(is[0]-1)==null){
                list = new ArrayList<>();
            }else{
                list = adjList.get(is[0]-1);
            }
            list.add(pair);
            adjList.put(is[0]-1, list);
        }
        return adjList;
    }*/
}
