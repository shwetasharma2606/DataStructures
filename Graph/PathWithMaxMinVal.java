// { Driver Code Starts
import java.io.*;
import java.util.*;

import javax.naming.NameAlreadyBoundException;

//DFS
//https://leetcode.ca/2018-12-06-1102-Path-With-Maximum-Minimum-Value/
//Similar to Swim in rising water LEETCODE 778
class PathWithMaxMinVal {
    public static void main(String[] args){
        char[][] grid = {{'X','X','X','X','X','X'},{'X','*','O','O','O','X'},{'X','O','O','#','O','X'},{'X','X','X','X','X','X'}};
        System.out.println(getFood(grid));//Output :  3

        char[][] grid1 = {{'X','X','X','X','X'},{'X','*','X','O','X'},{'X','O','X','#','X'},{'X','X','X','X','X'}};
        //System.out.println(getFood(grid1));//Output :  -1

        char[][] grid2 = {{'X','X','X','X','X','X','X','X'},{'X','*','O','X','O','#','O','X'},{'X','O','O','X','O','O','X','X'},{'X','O','O','O','O','#','O','X'},{'X','X','X','X','X','X','X','X'}};
        //System.out.println(getFood(grid2));//Output :  6
    }

    public int maximumMinimumPath(int[][] grid) {

    }
    }
