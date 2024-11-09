// { Driver Code Starts
import java.io.*;
import java.util.*;

class CourseSchedule {
    public static void main(String[] args){
      /*            0
              /       \
             1         2
             |  \      |
             3-------- 4
              */
        /*int[][] prerequisites = new int[4][2];
        int[] a0 = {1,0};
        prerequisites[0] = a0;
        int[] a1 = {2,0};
        prerequisites[1] = a1;
        int[] a2 = {3,1};
        prerequisites[2] = a2;
        int[] a3 = {3,2};
        prerequisites[3] = a3; 
        System.out.println(canFinish(4,prerequisites)); // Output: true
        */

        /*int[][] prerequisites = new int[0][0];
        System.out.println(canFinish(2,prerequisites));*/  //Output : true

        int[][] prerequisites = new int[2][2];
        int[] a0 = {1,0};
        prerequisites[0] = a0;
        int[] a1 = {0,1};
        prerequisites[1] = a1;
        System.out.println(canFinish(2,prerequisites)); //Output : false
      

    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adjList = getAdjacencyList(prerequisites, numCourses);
        return !detectCycle(adjList, numCourses);
    }
    public static ArrayList<Integer>[] getAdjacencyList(int[][] input, int n){
        ArrayList<Integer>[] adjList = new ArrayList[n];
        for(int i=0; i<input.length; i++){
            ArrayList<Integer> list = null;
            if(adjList[input[i][1]]==null){
                 list = new ArrayList<>();
            }else{
                list = adjList[input[i][1]];
            }
            list.add(input[i][0]);
            adjList[input[i][1]] = list;
        }
        return adjList;
    }

    public static boolean detectCycle(ArrayList<Integer>[] adjList , int n){
        int[] visited = new int[n];
        for(int i=0; i<n; i++){
            if(detectCycleUtil(adjList, visited, i)){
                return true;
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Integer>[] adjList , int[] visited, int v){
        if(visited[v]==1) return true;
        if(visited[v]==2) return false;
        ArrayList<Integer> childs = adjList[v];
        visited[v] = 1;
        if(childs!=null){
            for (Integer integer : childs) {
                if(detectCycleUtil(adjList, visited, integer)){
                    return true;
                }
            }
        }
        visited[v] = 2;
        return false;
    }
}
