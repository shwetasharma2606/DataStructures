// { Driver Code Starts
import java.io.*;
import java.util.*;

class NQueens {
    public static void main(String[] args){
        int n = 4;
        int[][] ans = new int[n][n];
        ArrayList<String[]> finalAns = new ArrayList<>();
        int queens = 0;
        nQueens(ans,n,0,finalAns);
        System.out.println(finalAns); // Output: 2

    }
    public static void nQueens(int[][] ans, int n, ArrayList<String[]> finalAns ) {
        for(int i=0; i<n; i++){
            for(int j=0; i<n; j++){
                
            }
        }
    }
    public static void nQueens(int[][] ans, int n, int queens, ArrayList<String[]> finalAns ) {
        for(int k=0; k<n; k++){
            ans[0][k]=1;
            queens++;
            for(int i=1; i<n; i++){
                for(int j=0; j<n; j++){
                    if(isValid(ans, i,j, n)){
                        ans[i][j] = 1;
                        queens++;
                        break;
                    }      
                }
            }
            if(queens==n) addAns(ans, n, finalAns);
            else{
                ans[0][k]=0;
                queens--;
            }
        }
        
        
    }
    public static void addAns(int[][] ans, int n, ArrayList<String[]> finalAns){
        String[] temp = new String[n];
        for(int i=0; i<n; i++){
            StringBuffer strB = new StringBuffer();
            for(int j=0; j<n; j++){
                if(ans[i][j]>0) strB.append("Q");
                else strB.append(".");
            }
            temp[i] = strB.toString();
        }
        finalAns.add(temp);
    }

    public static boolean isValid(int[][] ans, int row, int col, int n){
        for(int i=0; i<n; i++){
            if(ans[i][col]>0) return false;
        }
        for(int i=0; i<n; i++){
            if(ans[row][i]>0) return false;
        }
        int tR = row, tC = col;
        while(tR>=0  && tC>=0 ){
            if(ans[tR][tC]>0) return false;
            else{
                tR--;
                tC--;
            }
        }
        tR = row; tC = col;
        while(tR<n  && tC<n ){
            if(ans[tR][tC]>0) return false;
            else{
                tR++;
                tC++;
            }
        }

        tR = row; tC = col;
        while(tR>=0  && tC<n ){
            if(ans[tR][tC]>0) return false;
            else{
                tR--;
                tC++;
            }
        }

        tR = row; tC = col;
        while(tR<n  && tC>=0 ){
            if(ans[tR][tC]>0) return false;
            else{
                tR++;
                tC--;
            }
        }
        return true;
    }
}
