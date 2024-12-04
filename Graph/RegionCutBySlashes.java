// { Driver Code Starts
import java.io.*;
import java.util.*;

import javax.naming.NameAlreadyBoundException;
//Explaination Video :  https://www.youtube.com/watch?v=Wafu5vOxPRE
class RegionCutBySlashes {
    static int[] par;
    static int[] rank;
    static int count;
    public static void main(String[] args){
        String[] grid1 = {" /","/ "};//Output 2
        String[] grid2 = {" /","  "};//Output 1
        String[] grid3 = {"/\\","\\/"}; //Output 5
        System.out.println(regionsBySlashes(grid1));
        System.out.println(regionsBySlashes(grid2));
        System.out.println(regionsBySlashes(grid3));
    }
    public static int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int dots = n+1;
        par = new int[dots*dots];
        rank = new int[dots*dots];
        count=1;
        //LOGIC :  every cycle will create another region

        //Initializing parent array
        for(int i=0; i<par.length; i++ ){
            par[i]=i;
        }

        //connecting out boundary dots
        for(int i=0; i<dots; i++){
            for(int j=0; j<dots; j++){
                if(i==0 || j==0 || i==dots-1 || j==dots-1){
                    int cellNo = dots*i +j;
                    if(cellNo!=0)
                        union(0, cellNo);
                }
            }
        }

        //looping over grid and finding cycles
        for (int i=0;i<grid.length; i++) {
            char[] chArr = grid[i].toCharArray();
            for (int j=0; j<chArr.length; j++) {
                if(chArr[j]=='/'){
                    int cell1 = (i+1)*dots + j;
                    int cell2 = (i)*dots + j+1;
                    union(cell1, cell2);
                }else if(chArr[j]=='\\'){
                    int cell1 = (i)*dots + j;
                    int cell2 = (i+1)*dots + j+1;
                    union(cell1, cell2);
                }else{
                    //DO nothing for blank
                }
            }
        }

        return count;
    }
    public static int find(int x){
        if(par[x]!=x){
            par[x] = find(par[x]);
        }
        return par[x];
    }
    public static void union(int x, int y){
        int parX = find(x);
        int parY = find(y);
        if(parX != parY) {
            if(rank[parX] < rank[parY]){
                par[parX] = parY;
            }else if(rank[parX] > rank[parY]){
                par[parY] = parX;
            }else{
                par[parX] = parY;
                rank[parY]++;
            }
        }else{
            count++;
        }
    }
    
}
