//count of odd integers equals k.

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfNiceSubarrays {

    // BRUTE FORCE -->
    // TC: O(n*2)
    // SC: O(1)
    // public static void main(String args[]){
    //     int[] arr = {1,1,2,1,1};
    //     int k = 3;
    //     System.out.println(countSubarrays(arr,k));
    // }
    // public static int countSubarrays(int[] arr, int k){
    //     int n = arr.length;
    //     int count = 0;

    //     for(int i=0; i<n; i++){
    //         int oddCount = 0;
    //         for(int j=i; j<n; j++){
    //             if(arr[j]%2 != 0){
    //                 oddCount++;
    //             }
    //             if(oddCount==k){
    //                 count++;
    //             }
    //         }
    //     }
    //     return count;
    // }

    // // BETTER -->
    // // TC: O(n)
    // // SC: O(n)
    // public static void main(String args[]){
    //     int[] arr = {1,1,2,1,1};
    //     int k = 3;
    //     System.out.println(countSubarrays(arr,k));
    // }
    // public static int countSubarrays(int[] arr, int k){
    //     int n = arr.length;
    //     int count = 0;
    //     int oddCount = 0;
    //     Map<Integer,Integer> map = new HashMap<>();
    //     map.put(0,1);

    //     for(int i=0; i<n; i++){
    //         if(arr[i] %2 != 0){
    //             oddCount++;
    //         }
    //         if(map.containsKey(oddCount-k)){
    //             count += map.get(oddCount-k);
    //         }
    //         if(map.containsKey(oddCount)){
    //             map.put(oddCount,map.get(oddCount)+1);
    //         }
    //         else{
    //             map.put(oddCount,1);
    //         }
    //     }
    //     return count;
    // }

    // OPTIMAL -->
    // TC: O(2 * 2n)
    // SC: O(1)
    public static void main(String args[]){
        int[] arr = {1,1,2,1,1};
        int k = 3;
        System.out.println(countSubarrays(arr,k) - countSubarrays(arr, k-1));
    }
    public static int countSubarrays(int[] arr, int k){
        int n = arr.length;
        int count = 0;
        int left = 0;
        int right = 0;
        int sum = 0;

        while(right<n){
            if(k<0){
                return 0;
            }
            sum += arr[right]%2;
            while(sum>k){
                sum -= arr[left]%2;
                left++;
            }
            count += right-left+1;
            right++;
        }
        return count;
    }
}
