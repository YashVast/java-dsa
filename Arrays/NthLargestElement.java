
import java.util.PriorityQueue;

public class NthLargestElement{
    
    //TC: O(n log k) SC: O(k)
    public static void main(String args[]){
        int[] arr = {1,2,3,4,5,6,7,8,8};
        int k = 3;
        System.out.println(nthLargestElement(arr,k));
    }
    public static int nthLargestElement(int[] arr, int k){
        if(arr == null){
            throw new IllegalArgumentException("Array is null");
        }
        int n = arr.length;
        if(n==0){
            throw new IllegalArgumentException("Given Array empty");
        }
        if(k<=0 || k>n){
            throw new IllegalArgumentException("value of k is not valid");
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            queue.offer(arr[i]);
            if(queue.size()>k){
                queue.poll();
            }
        }
        return queue.peek();
    }
}