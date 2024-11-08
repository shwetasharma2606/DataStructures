// { Driver Code Starts
import java.io.*;
import java.util.*;

class CourseSchedule2 {
    public static void main(String[] args){
      /*            0
              /       \
             1         2
             |  \      |
             3-------- 4
              */
        int[][] prerequisites = new int[4][2];
        int[] a0 = {1,0};
        prerequisites[0] = a0;
        int[] a1 = {2,0};
        prerequisites[1] = a1;
        int[] a2 = {3,1};
        prerequisites[2] = a2;
        int[] a3 = {3,2};
        prerequisites[3] = a3; 
        System.out.println(findOrder(4,prerequisites)); // Output: [0,2,1,3]
        

        /*int[][] prerequisites = new int[0][0];
        System.out.println(findOrder(2,prerequisites));*/  //Output : [1,0]

        /*int[][] prerequisites = new int[2][2];
        int[] a0 = {1,0};
        prerequisites[0] = a0;
        int[] a1 = {0,1};
        prerequisites[1] = a1;
        System.out.println(findOrder(2,prerequisites)); //Output : []
*/
      

    }
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adjList = getAdjacencyList(prerequisites, numCourses);
        if(detectCycle(adjList, numCourses)){
            return new int[0];
        }
        Stack<Integer> stack = new Stack<Integer>();
        boolean[] visited = new boolean[numCourses];
        for(int i=0; i<numCourses; i++){
            dfs(adjList, visited, stack, i);
        }
        int[] ans = new int[numCourses];
        int idx=0;
        while(!stack.empty()){
            ans[idx++] = stack.pop();
        }
        return ans;
    }

    public static void dfs(ArrayList<Integer>[] adjList, boolean[] visited, Stack<Integer> stack, int course){
        if(visited[course] ){
            return;
        }
        ArrayList<Integer> preCourses = adjList[course];
        if(preCourses==null || preCourses.size()==0){
            visited[course] = true;
            stack.add(course);
            return;
            
        }
        visited[course] = true;
        for (int c : preCourses) {
            dfs(adjList, visited, stack, c);
        }
        stack.add(course);

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
