
import java.util.HashMap;
import java.util.Map;

public class NumberOfSubArraysWithSumK{

    //BRUTE FORCE --> TC: O(n2) SC: O(1)
    // public static void main(String args[]){
    //     int[] arr = {1,2,3,-3,1,1,1,4,2,-3};
    //     int k = 3;
    //     System.out.println(numberOfSubArrays(arr,k));
    // }
    // public static int numberOfSubArrays(int[] arr, int k){
    //     int n = arr.length;
    //     int counter = 0;
    //     for(int i=0; i<n; i++){
    //         int sum = 0;
    //         for(int j=i; j<n; j++){
    //             sum += arr[j];
    //             if(sum==k){
    //                 counter++;
    //             }
    //         }
    //     }
    //     return counter;
    // }

    //OPTIMAL --> TC: O(n) SC: O(n)
    public static void main(String args[]){
        int[] arr = {1,2,3,-3,1,1,1,4,2,-3};
        int k = 3;
        System.out.println(numberOfSubArrays(arr,k));
    }
    public static int numberOfSubArrays(int[] arr, int k){
        int n = arr.length;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int prefixSum = 0;
        int count = 0;

        for(int i=0; i<n; i++){
            prefixSum += arr[i];
            int remove = prefixSum-k;
            
            if(map.containsKey(remove)){
                count += map.get(remove);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0)+1);
        }
        return count;
    }
}