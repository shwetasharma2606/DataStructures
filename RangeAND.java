// { Driver Code Starts
import java.io.*;
import java.util.*;

class RangeAND {
    public static void main(String[] args){
        //0100, 0101
       System.out.println(rangeBitwiseAnd(4,5)); // Output: 2

    }
    public static int rangeBitwiseAnd(int left, int right) {
        int ans = 0;
        int shifts = 0;
        while(left!=right){
            shifts++;
            left = (left>>1);
            right = (right>>1);
        }
        ans = (left<<shifts);
        return ans;
    }

}
