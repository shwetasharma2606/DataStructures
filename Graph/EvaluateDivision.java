// { Driver Code Starts
import java.io.*;
import java.util.*;

class EvaluateDivision {
    public static void main(String[] args){
        List<List<String>> equations = new ArrayList<>();
        equations.add(List.of("a", "b"));
        equations.add(List.of("b", "c"));
        double[] values = {2.0,3.0};
        List<List<String>> queries = new ArrayList<>();
        /*queries.add(List.of("a", "c"));
        queries.add(List.of("b", "a"));
        queries.add(List.of("a", "e"));*/
        queries.add(List.of("a", "a"));
        queries.add(List.of("x", "x"));

        calcEquation(equations, values, queries); //Output : false
      
//[["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]

    }
    public static class Pair{
        String node;
        double val;
        public Pair(String node, double val){
            this.node = node;
            this.val = val;
        }
    }
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //Making adjacency list
        HashMap<String,ArrayList<Pair>> adjList = new HashMap<>();
        for(int i=0; i<equations.size(); i++){
            List<String> list = equations.get(i);
            ArrayList<Pair> dest = null;
            if(adjList.containsKey(list.get(0))){
                dest = adjList.get(list.get(0));
            }else{
                dest = new ArrayList<>();
            }
            String a = list.get(1);
            double v = values[i];
            dest.add(new Pair(list.get(1), values[i]));
            //System.out.println("SRC : "+list.get(0)+"  DEST  : "+list.get(1) + " VAL : "+values[i]);
            adjList.put(list.get(0), dest);

            if(adjList.containsKey(list.get(1))){
                dest = adjList.get(list.get(1));
            }else{
                dest = new ArrayList<>();
            }
            dest.add(new Pair(list.get(0), (1/values[i])));
            //System.out.println("SRC : "+list.get(1)+"  DEST  : "+list.get(0) + " VAL : "+(1/values[i]));
            adjList.put(list.get(1), dest);
        }
        //making adj list end

        double[] ans = new double[queries.size()];
        int i=0;
        for (List<String> list : queries) {
            ans[i] = dfs(adjList, new HashMap<String, Boolean>(), list.get(0), list.get(1));
            System.out.println("FOR query :  "+list.get(0)+"~"+list.get(1) + " ans is : "+ans[i]);
            i++;
        }

        return ans;
    }

    public static double dfs(HashMap<String,ArrayList<Pair>> adjList , HashMap<String, Boolean> visited, String src, String dest){
        double ans = 1;
        if((visited.containsKey(src) && visited.get(src))) return 1;
        if(!adjList.containsKey(src) || !adjList.containsKey(dest)){
            return -1.0;
        }else if(src==dest) {
            return 1.0;
        }else{
            visited.put(src, true);
            ArrayList<Pair> d = adjList.get(src);
            for (Pair pair : d) {
                if(!visited.containsKey(pair.node) || !visited.get(pair.node)){
                    return ans  *= (pair.val * dfs(adjList, visited, pair.node, dest));
                }
                
            }
        }
        return ans;
    }
}
