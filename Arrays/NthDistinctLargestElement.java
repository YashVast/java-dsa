import java.util.Iterator;
import java.util.TreeSet;

public class NthDistinctLargestElement{
    //TC --> O(n log d) + O(k)
    //SC --> O(d)
    // public static void main(String args[]){
    //     int[] arr = {1,2,3,4,5,6,7,7,8,8};
    //     int k = 3;
    //     System.out.println(nthDistinctLargest(arr, k));
    // }
    // public static int nthDistinctLargest(int[] arr, int k){
    //     if (arr == null) {
    //         throw new IllegalArgumentException("Array cannot be null");
    //     }

    //     if (arr.length == 0) {
    //         throw new IllegalArgumentException("Array cannot be empty");
    //     }

    //     TreeSet<Integer> set = new TreeSet<>();

    //     for(int num : arr){
    //         set.add(num);
    //     }
    //     if (k <= 0 || k > set.size()) {
    //         throw new IllegalArgumentException(
    //             "k must be between 1 and " + set.size()
    //         );
    //     }

    //     Iterator<Integer> iterator = set.descendingIterator();
    //     int count = 0;

    //     while(iterator.hasNext()){
    //         int num = iterator.next();
    //         count++;
    //         if(count == k){
    //             return num;
    //         }
    //     }
    //     throw new IllegalStateException("Unexpected error");
    // }


    //TC: O(n log n) SC: O(n)
    public static void main(String args[]){
        int[] arr = {1,1,2,2,3,3,3,4,4,5,5};
        int k = 3;
        System.out.println(nthLargest(arr,k));
    }
    public static int nthLargest(int[] arr, int k){
        if(arr==null){
            throw new IllegalArgumentException("array is null");
        }
        int n = arr.length;
        if(n==0){
            throw new IllegalArgumentException("array is empty");
        }
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0; i<n; i++){
            set.add(arr[i]);
        }  
        if(k<=0 || k>set.size()){
            throw new IllegalArgumentException("value of k is not valid");
        }
        Iterator<Integer> it = set.descendingIterator();
        int count = 0;

        while(it.hasNext()){
            int num = it.next();
            count++;
            if(count==k){
                return num;
            }
        }
        throw new IllegalArgumentException("unknown exception");
    }
}