 // { Driver Code Starts
import java.io.*;
import java.util.*;

import javax.naming.NameAlreadyBoundException;

class ConnectingCitiesWithMinCost {
    public static int[] p;
    public static void main(String[] args){
      int[][] edges = {{1,2,5},{1,3,6},{2,3,1}}; //output 6

      int[][] edges1 = {{1,2,3},{3,4,4}};//output -1
     
      System.out.println(minimumCost(3, edges));
      System.out.println(minimumCost(4, edges1));
    }
    
    public static int minimumCost(int n, int[][] connections) {
        int ans = 0;
        Arrays.sort(connections, (a,b)->(a[2]-b[2]));
        p = new int[n];
        for (int i=0; i<n; i++) {
            p[i]=i;
        }

        for (int[] is : connections) {
            int u = is[0]-1;
            int v = is[1]-1;
            if(find(u)!=find(v)){
                ans+=is[2];
                p[find(u)] = find(v);
                if (--n == 1) {
                    return ans;
                }
            }
        }
        return -1;
    }

    public static int find(int x){
        if(p[x]!=x){
            p[x] = find(p[x]);
        }
        return p[x];
    }

}
