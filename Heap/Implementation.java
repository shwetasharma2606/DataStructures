// { Driver Code Starts
import java.io.*;
import java.util.*;

//MAX HEAP
class Implementation {
    public static void main(String[] args){
       MaxHeap maxHeap = new MaxHeap(10);
       push(maxHeap,48);
       push(maxHeap,42);
       push(maxHeap,23);
       push(maxHeap,50);
       push(maxHeap,17);
       push(maxHeap,12);
       System.out.println(pop(maxHeap));
       push(maxHeap,50);

    }
    public static class MaxHeap{
        int[] heap;
        int size;
        int maxSize;
        public void MaxHeap(int maxSize){
            this.maxSize = maxSize;
            this.size=0;
            heap = new int[maxSize];
        }
    }
    public static void swap(MaxHeap maxHeap, int i, int j){
        int n = maxHeap.size;
        if(i<0 || j<0 || i>=n || j>=n) return;
        int[] arr = maxHeap.heap;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void heapify(MaxHeap maxHeap, int i) {
        int[] arr = maxHeap.heap;
        int n = maxHeap.size;
        while(i<n){
            int lc = 2*i +1;
            int rc = 2*i +2;
            int maxIdx = i;
            if(lc<n && arr[i]<arr[lc]){
                maxIdx = lc;
            }
            if(rc<n && arr[i]<arr[maxIdx]){
                maxIdx = rc;
            }
            if(maxIdx!=i){
                swap(arr, i, maxIdx);
            }
        }
    }

    public static void buildHeap(MaxHeap maxHeap) {
        int[] arr = maxHeap.heap;
        int n = maxHeap.size;
        int start = n-1/2;
        while(start>=0){
            heapify(arr, start);
            start--;
        }
    }

    public static int pop(MaxHeap maxHeap){
        int[] arr = maxHeap.heap;
        int ans = arr[0];
        if(arr.length>1) {       
            arr[0] = arr[arr.length-1];
            heapify(arr, 0);
        }
        maxHeap.size = maxHeap.size-1;
        return ans;
    }

    public static void increaseKey(MaxHeap maxHeap, int i, int key) {
        int[] arr = maxHeap.heap;
        int n = maxHeap.size;
        if(arr[i]>key) return;  // INVALID OPERATION
        arr[i] = key;
        while(i>0 && arr[i/2]<arr[i]){
            swap(arr, i/2, i);
            i/=2;
        }
    }

    public static void decreaseKey(MaxHeap maxHeap, int i, int key){
        int[] arr = maxHeap.heap;
        int n = maxHeap.size;
        if(arr[i]<key) return;  // INVALID OPERATION
        arr[i] = key;
        heapify(maxHeap, i);
    }

    public static void push(MaxHeap maxHeap, int val){
        int[] arr = maxHeap.heap;
        int n = maxHeap.size;
        if(n=maxHeap.maxSize) return;  //heap full
        arr[n] = val;
        maxHeap.size = n+1;
    }

}
