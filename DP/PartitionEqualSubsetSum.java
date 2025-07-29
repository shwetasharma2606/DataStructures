// { Driver Code Starts
import java.io.*;
import java.util.*;

class PartitionEqualSubsetSum {
    public static void main(String[] args){
        int[] nums  = {1,5,11,5};
        System.out.println(canPartition(nums));
        int[] nums1  = {1,2,3,5};
        System.out.println(canPartition(nums1));
    

    }
    
    public static boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int i : nums) {
            totalSum += i;
        }
        if(totalSum%2==1){
            return false;
        }
        int[][] dp = new int[(totalSum/2)+1][nums.length+1];
        return canPartitionUtil(totalSum/2, 0, nums,dp);
        
    }
    public static boolean canPartitionUtil(int target, int index, int[] nums, int[][] dp){
        if(target==0) return true;
        if(target<0 || index==nums.length) return false;
        if(dp[target][index]!=0) return dp[target][index]==1;
        
        boolean ans = (canPartitionUtil(target-nums[index], index+1, nums, dp) || canPartitionUtil(target, index+1, nums,dp));
        dp[target][index] = ans?1:-1;
        return ans;
    }

}
