// { Driver Code Starts
import java.io.*;
import java.util.*;

class PartitionMinDiff {
    public static void main(String[] args){
       // [7772197,4460211,-7641449,-8856364,546755,-3673029,527497,-9392076,3130315,-5309187,-4781283,5919119,3093450,1132720,6380128,-3954678,-1651499,-7944388,-3056827,1610628,7711173,6595873,302974,7656726,-2572679,0,2121026,-5743797,-8897395,-9699694]

       int[] a = {3,9,7,3};
        System.out.println(minimumDifference(a)); // Output: 2

    }

    public static int minimumDifference(int[] nums) {
        int n=nums.length;
        int totalSum = 0;
        for(int j=0; j<n; j++){
            totalSum += nums[j];
        }
        int minDiff = Integer.MAX_VALUE;
        int sum1=0,sum2=totalSum;
        for(int i=0; i<(1<<n); i++){
            int halfSum = halfSetBitsSum(nums,i);
            if(halfSum != -1){
                sum1=halfSum; sum2=totalSum-halfSum;
                minDiff = Math.min(minDiff, (Math.abs(sum1-sum2)));
            }
        }
        return minDiff;
    }

    public static int halfSetBitsSum(int[] nums, int j) {
        int n=nums.length;
        int sum=0;
        int cnt=0;
        for(int i=0; i<n; i++){
            if((j&(1<<i))>=1) {
                cnt++;
                sum+= nums[i];
            }
        }
        if(cnt==n/2) return sum;
        else return -1;
    }

}
