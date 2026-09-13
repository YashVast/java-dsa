import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubarraysWithKDifferentIntegers{

    // BRUTE FORCE -->
    // TC: O(n*2)
    // SC: O(n)
    // public static void main(String args[]){
    //     int[] arr = {1,2,1,3,4};
    //     int k = 3;
    //     System.out.println(numberOfSubarrays(arr,k));
    // }
    // public static int numberOfSubarrays(int[] arr, int k){
    //     int n = arr.length;
    //     int count = 0;
    //     Map<Integer,Integer> map = new HashMap<>();

    //     for(int i=0; i<n; i++){
    //         map.clear();
    //         for(int j=i; j<n; j++){
    //             if(map.containsKey(arr[j])){
    //                 map.put(arr[j],map.get(arr[j])+1);
    //             }
    //             else{
    //                 map.put(arr[j],1);
    //             }
    //             if(map.size() == k){
    //                 count++;
    //             }
    //             if(map.size() > k){
    //                 break;
    //             }
    //         }
    //     }
    //     return count;
    // }

    // BETTER/OPTIMAL -->
    // TC: O(2*2n)
    // SC: O(n)
    public static void main(String args[]){
        int[] arr = {1,2,1,3,4};
        int k = 3;
        System.out.println(numberOfSubarrays(arr,k) - numberOfSubarrays(arr,k-1));
    }
    public static int numberOfSubarrays(int[] arr, int k){
        int n = arr.length;
        int left = 0;
        int right = 0;
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();

        while(right<n){
            if(map.containsKey(arr[right])){
                map.put(arr[right],map.get(arr[right])+1);
            }
            else{
                map.put(arr[right],1);
            }
            while(map.size()>k){
                map.put(arr[left],map.get(arr[left])-1);
                if(map.get(arr[left]) == 0){
                    map.remove(arr[left]);
                }
                left++;
            }
            count += right-left+1;
            right++;
        }
        return count;
    }
}