
import java.util.PriorityQueue;

public class NthLargestElement{
    //TC --> O(n log k)
    //SC --> O(k)
    // public static void main(String args[]){
    //     int[] arr = {1,2,3,4,5,6,7,7,8,8};
    //     int k = 3;
    //     System.out.println(nthLargest(arr, k));
    // }
    // public static int nthLargest(int[] arr, int k){
    //     if (arr == null) {
    //         throw new IllegalArgumentException("Array cannot be null");
    //     }

    //     if (arr.length == 0) {
    //         throw new IllegalArgumentException("Array cannot be empty");
    //     }

    //     if (k <= 0 || k > arr.length) {
    //         throw new IllegalArgumentException(
    //             "k must be between 1 and " + arr.length
    //         );
    //     }
    //     PriorityQueue<Integer> queue = new PriorityQueue<>();

    //     for(int num: arr){
    //         queue.offer(num);

    //         if(queue.size()>k){
    //             queue.poll();
    //         }
    //     }
    //     return queue.peek();
    // }


    public static void main(String args[]){
        int[] arr = {1,2,3,4,5,6,7,7,8,8};
        int k = 3;

        System.out.println(nthLargest(arr,k));
    }
    public static int nthLargest(int[] arr, int k){
        if(arr.length==0 || arr.length<k || k<=0){
            throw new IllegalArgumentException("Array or given value of k is not valid");
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int num:arr){
            queue.offer(num);
            if(queue.size()>k){
                queue.poll();
            }
        }
        return queue.peek();
    }
}