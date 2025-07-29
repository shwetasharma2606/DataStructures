// { Driver Code Starts
import java.io.*;
import java.util.*;

import javax.naming.NameAlreadyBoundException;

//Topological Sort
//https://leetcode.ca/2019-01-09-1136-Parallel-Courses/

class ParallelCourses {
    public static void main(String[] args){
        int[][] rel = {{1,3},{2,3}};
        System.out.println(minimumSemesters(3, rel));
        String s = "";
        s.ch

        int[][] rel1 = {{1,2},{2,3},{3,1}};
        System.out.println(minimumSemesters(3, rel1));

    }

    public static int minimumSemesters(int n, int[][] relations) {
        int ans = 0;
        List<Integer>[] graph = new List[n];
        int[] indeg = new int[n];
        
        for (int[] is : relations) {
            int pr = is[0]-1;
            int ne = is[1]-1;
            indeg[ne]++;
            if(graph[pr]==null){
                graph[pr] = new ArrayList<Integer>();
            }
            graph[pr].add(ne);
        }
        Deque<Integer> q = new ArrayDeque<>();
        
        for (int i = 0; i < indeg.length; i++) {
            if(indeg[i]==0) q.offer(i);
        }
        int count=0;
        while(!q.isEmpty()){
            ans++;
            for (int k = q.size(); k > 0; --k) {
                int curr = q.poll();
                count++;
                if(graph[curr]!=null){
                    for(int elem: graph[curr]){
                        if(--indeg[elem]==0){
                            q.offer(elem);
                        }
                    }
                }
                
            }
        }
        return count==n?ans:-1;

    }
    }
