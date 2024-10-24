// { Driver Code Starts
import java.io.*;
import java.util.*;

class SingleNumber2 {
    public static void main(String[] args){
        
       int[] a = {2,2,3,2};
       System.out.println(singleNumber(a)); // Output: 2

    }
    
    public static int singleNumber(int[] nums) {
        int p=0; int ans = 0;
        int currentSetBits = 0;
        for(int i=0; i<32; i++){
            currentSetBits=0;
            for (int num:nums){
                if((num&(1<<i))>=1){
                    currentSetBits++;
                }
            }
            currentSetBits  = currentSetBits%3;
            ans = ans + currentSetBits*(int)Math.pow(2,p);
            p++;
        }
        return ans;
    }

}
