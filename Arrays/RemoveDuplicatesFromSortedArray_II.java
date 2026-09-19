// Input:  nums = [1,1,1,2,2,3]
// Output: k = 5
// nums = [1,1,2,2,3,_]

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicatesFromSortedArray_II {
    //BRUTE FORCE -->
    // TC: O(n^2)
    // SC: O(n)
    // public static void main(String[] args){
    //     int[] arr = {1,1,1,2,2,3};
    //     System.out.println(removeDuplicates(arr));
    // }
    // public static int removeDuplicates(int[] arr){
    //     int n = arr.length;
    //     List<Integer> temp = new ArrayList<>();

    //     for (int i = 0; i < n; i++) {
    //         int count = 1;
    //         for (int j = 0; j < i; j++) {
    //             if (arr[j] == arr[i]) {
    //                 count++;
    //             }
    //         }
    //         if (count <= 2) {
    //             temp.add(arr[i]);
    //         }
    //     }
    //     for (int i = 0; i < temp.size(); i++) {
    //         arr[i] = temp.get(i);
    //     }
    //     return temp.size();
    // }

    // //BETTER -->
    // // TC: O(n)+O(k)
    // // SC: O(k)
    // public static void main(String[] args){
    //     int[] arr = {1,1,1,2,2,3};
    //     System.out.println(removeDuplicates(arr));
    // }
    // public static int removeDuplicates(int[] arr){
    //     int n = arr.length;
    //     int[] temp = new int[n];
    //     int k = 0;    
    //     int count = 0;

    //     for(int i=0; i<n; i++){
    //         if(i>0 && arr[i] == arr[i-1]){
    //             count++;
    //         }
    //         else{
    //             count = 1;
    //         }

    //         if(count<=2){
    //             temp[k++] = arr[i];
    //         }
    //     }
    //     for(int i=0; i<k; i++){
    //         arr[i] = temp[i];
    //     }
    //     return k;
    // }

    //OPTIMAL -->
    // TC: O(n)
    // SC: O(1)
    public static void main(String[] args){
        int[] arr = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(arr));
    }
    public static int removeDuplicates(int[] arr){
        int n = arr.length;
        if(n<=2){
            return n;
        }
        int k =2;
        for(int i=k; i<n; i++){
            if(arr[i] != arr[k-2]){
                arr[k] = arr[i];
                k++; 
            }
        }
        return k;
    }
}
