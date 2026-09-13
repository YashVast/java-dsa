import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate_II {

    // BRUTE FORCE --> 
    // TC: O(n*2)
    // SC: O(1)
    // public static void main(String args[]){
    //     int[] arr = {1,2,3,1};
    //     int k = 3;
    //     System.out.println(containsDuplicate(arr,k));
    // }
    // public static boolean containsDuplicate(int[] arr, int k){
    //     int n = arr.length;
    //     for(int i=0; i<n; i++){
    //         int temp = arr[i];
    //         for(int j=i+1; j<n; j++){
    //             if(arr[j] == temp){
    //                 if(j-i <= k){
    //                     return true;
    //                 }
    //             }
    //         }
    //     }
    //     return false;
    // }

    // BETTER -->
    // TC: O(2n)
    // SC: O(n)
    // public static void main(String args[]){
    //     int[] arr = {1,2,3,1};
    //     int k = 3;
    //     System.out.println(containsDuplicate(arr,k));
    // }
    // public static boolean containsDuplicate(int[] arr, int k){
    //     int n = arr.length;
    //     int left = 0;
    //     int right = 0;
    //     Set<Integer> set = new HashSet<>();

    //     while(right<n){
    //         if(set.contains(arr[right]) && right-left <= k){
    //             return true;
    //         }
    //         else{
    //             set.add(arr[right]);
    //         }
    //         while(right-left >= k){
    //             set.remove(arr[left]);
    //             left++;
    //         }
    //         right++;
    //     }
    //     return false;
    // }

    // OPTIMAL -->
    // TC: O(n)
    // SC: O(n)
    public static void main(String args[]){
        int[] arr = {1,2,3,1};
        int k = 3;
        System.out.println(containsDuplicate(arr,k));
    }
    public static boolean containsDuplicate(int[] arr, int k){
        int n = arr.length;
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<n; i++){
            if(set.contains(arr[i])){
                return true;
            }
            set.add(arr[i]);
            if(set.size()>k){
                set.remove(arr[i-k]);
            }
        }
        return false;
    }
}
