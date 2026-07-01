import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountSubArraysWithXORAsK {

    //BRUTE FORCE --> TC: O(n2) SC: O(1)
    // public static void main(String args[]){
    //     int[] arr = {4,2,2,6,4};
    //     int k = 6;
    //     System.out.println(countSubArray(arr,k));
    // }
    // public static int countSubArray(int[] arr, int k){
    //     int n = arr.length;
    //     int counter = 0;

    //     for(int i=0; i<n; i++){
    //         int xor = 0;
    //         for(int j=i; j<n; j++){
    //             xor ^= arr[j];
    //             if(xor == k){
    //                 counter++;
    //             }
    //         }
    //     }
    //     return counter;
    // }

    //BRUTE FORCE --> TC: O(n2){Worst Case: O(n3)} SC: O(no. of subArrays)
    // public static void main(String args[]){
    //     int[] arr = {4,2,2,6,4};
    //     int k = 6;
    //     List<List<Integer>> list = countSubArrays(arr,k);

    //     for(int i=0; i<list.size(); i++){
    //         System.out.println(list.get(i));
    //     }
    // }
    // public static List<List<Integer>> countSubArrays(int[] arr, int k){
    //     int n = arr.length;
    //     List<List<Integer>> list = new ArrayList<>();
    //     int start = -1;
    //     int end = -1;
        
    //     for(int i=0; i<n; i++){
    //         int xor = 0;
    //         for(int j=i; j<n; j++){
    //             xor ^= arr[j];
    //             if(xor == k){
    //                 List<Integer> temp = new ArrayList<>();
    //                 start = i;
    //                 end = j;
    //                 for(int l=start; l<=end; l++){
    //                     temp.add(arr[l]);
    //                 }
    //                 list.add(temp);
    //             }
    //         }
    //     }
    //     return list;
    // }


    //OPTIMAL --> TC: O(n) SC: O(n)
    // public static void main(String args[]){
    //     int[] arr = {4,2,2,6,4};
    //     int k = 6;
    //     System.out.println(countSubArrays(arr,k));
    // }
    // public static int countSubArrays(int[] arr, int k){
    //     int n = arr.length;
    //     int xor = 0;
    //     int count = 0;
    //     Map<Integer,Integer> map = new HashMap<>();
    //     map.put(0,1);

    //     for(int i=0; i<n; i++){
    //         xor ^= arr[i];
    //         int x = xor ^ k;
    //         if(map.containsKey(x)){
    //             count += map.get(x);
    //         }
    //         if(map.containsKey(xor)){
    //             map.put(xor,map.get(xor)+1);
    //         }
    //         else{
    //             map.put(xor,1);
    //         }
    //     }
    //     return count;
    // }


    // TC: O(n + total length of returned subarrays)
    // SC: O(n + total size of returned subarrays)
    public static void main(String[] args) {

        int[] arr = {4, 2, 2, 6, 4};
        int k = 6;

        List<List<Integer>> result = getSubArrays(arr, k);

        for (List<Integer> subArray : result) {
            System.out.println(subArray);
        }
    }

    public static List<List<Integer>> getSubArrays(int[] arr, int k) {

        List<List<Integer>> result = new ArrayList<>();

        // prefixXor -> list of indices where it occurred
        Map<Integer, List<Integer>> map = new HashMap<>();

        // Prefix XOR = 0 before the array starts
        map.put(0, new ArrayList<>(Arrays.asList(-1)));

        int xor = 0;

        for (int i = 0; i < arr.length; i++) {

            xor ^= arr[i];

            int required = xor ^ k;

            if (map.containsKey(required)) {

                for (int prevIndex : map.get(required)) {

                    List<Integer> temp = new ArrayList<>();

                    for (int j = prevIndex + 1; j <= i; j++) {
                        temp.add(arr[j]);
                    }

                    result.add(temp);
                }
            }

            map.putIfAbsent(xor, new ArrayList<>());
            map.get(xor).add(i);
        }

        return result;
    }
}
