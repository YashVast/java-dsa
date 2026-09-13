import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate_I {

    //TC: O(n)
    //SC: O(n)
    // public static void main(String args[]){
    //     int[] arr = {1,2,3,1};
    //     System.out.println(containsDuplicate(arr));
    // }
    // public static boolean containsDuplicate(int[] arr){
    //     int n = arr.length;
    //     Set<Integer> set = new HashSet<>();

    //     for(int i=0; i<n; i++){
    //         if(set.contains(arr[i])){
    //             return true;
    //         }
    //         else{
    //             set.add(arr[i]);
    //         }
    //     }
    //     return false;
    // }

    //TC: O(n log n)
    //SC: O(1)
    public static void main(String args[]){
        int[] arr = {1,2,3,1};
        System.out.println(containsDuplicate(arr));
    }
    public static boolean containsDuplicate(int[] arr){
        int n = arr.length;
        Arrays.sort(arr);

        for(int i=1; i<n; i++){
            if(arr[i-1] == arr[i]){
                return true;
            }
        }
        return false;
    }
}
