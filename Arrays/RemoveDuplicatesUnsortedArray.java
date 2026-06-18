import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesUnsortedArray{
    //TC: O(n) + O(n) = O(n) SC: O(n)
    public static void main(String args[]){
        int[] arr = {3,3,4,4,5,5,1,2,2,5};
        int[] result = removeDuplicates(arr);

        for(int num: result){
            System.out.print(num + " ");
        }
    }
    public static int[] removeDuplicates(int[] arr){
        int n = arr.length;
        Set<Integer> set = new HashSet<>();
        //O(n)
        for(int i=0; i<n; i++){
            set.add(arr[i]);
        }
        int[] result = new int[set.size()];
        int count = 0;
        //O(n)
        for(int num: set){
            result[count++] = num;
        }
        return result;
    }
}