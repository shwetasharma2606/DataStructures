// { Driver Code Starts
import java.io.*;
import java.util.*;

class CountPrimes {
    public static void main(String[] args){
        //0100, 0101
       System.out.println(countPrimes(10)); // Output: 2

    }
    public static int countPrimes(int n) {
        if(n==0) return 0;
        if(n==1) return 0;
        if(n==2) return 1;
        int ans=1;
        for(int i=3; i<=n; i++){
            if(isPrime(i)) ans++;
        }
        return ans;
    }
    public static boolean isPrime(int n){
        for(int i=2; i<=Math.sqrt(n); i++ ){
            if(n%i==0) return false;
        }
        return true;
    }

}
