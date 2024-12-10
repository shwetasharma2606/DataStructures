// { Driver Code Starts
import java.io.*;
import java.util.*;

import javax.naming.NameAlreadyBoundException;

//BFS
//https://leetcode.ca/2020-08-25-1730-Shortest-Path-to-Get-Food/
class ShortestPathToGetFood {
    public static void main(String[] args){
        char[][] grid = {{'X','X','X','X','X','X'},{'X','*','O','O','O','X'},{'X','O','O','#','O','X'},{'X','X','X','X','X','X'}};
        System.out.println(getFood(grid));//Output :  3

        char[][] grid1 = {{'X','X','X','X','X'},{'X','*','X','O','X'},{'X','O','X','#','X'},{'X','X','X','X','X'}};
        //System.out.println(getFood(grid1));//Output :  -1

        char[][] grid2 = {{'X','X','X','X','X','X','X','X'},{'X','*','O','X','O','#','O','X'},{'X','O','O','X','O','O','X','X'},{'X','O','O','O','O','#','O','X'},{'X','X','X','X','X','X','X','X'}};
        //System.out.println(getFood(grid2));//Output :  6
    }

    private static int[] dirs = {-1, 0, 1, 0, -1};
    
    public static int getFood(char[][] grid) {
        int ans = 0;
        int r=-1,c=-1;
        int m = grid.length, n = grid[0].length;
        Deque<String> q = new ArrayDeque<>();
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='*'){
                    r=i;
                    c=j;
                    break;
                }
            }
            if(r>=0 || c>=0) break;
        }
        q.add(r+"_"+c);
        r=-1;c=-1;
        while(!q.isEmpty()){
            int size = q.size();
            ++ans;
            for(int i=0; i<size; i++){
                String cell = q.pop();
                int row = Integer.parseInt(cell.split("_")[0]);
                int col = Integer.parseInt(cell.split("_")[1]);
                //System.out.println("CURR CELL :  "+cell);
                for (int k = 0; k < 4; ++k) {
                    int x = row + dirs[k];
                    int y = col + dirs[k + 1];
                    //System.out.println("Neighbour CELL :  "+x+"__"+y + "   >>  "+grid[x][y]);
                    if (x >= 0 && x < m && y >= 0 && y < n) {
                        if(grid[x][y]=='#'){
                            return ans;
                        }else if(grid[x][y]=='O'){
                            grid[x][y]='X';
                            q.offer(x+"_"+y);
                        }
                    }
                }
                
            }
        }
        return -1;
    
    }
    }
