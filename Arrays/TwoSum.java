import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum{

    //BRUTE FORCE --> TC: O(n2) SC: O(1)
    // public static void main(String args[]){
    //     int[] arr = {2,6,8,5,11};
    //     int target = 14;

    //     System.out.println(twoSum(arr,target));
    //     // int[] result = twoSum(arr,target);
    //     // for(int x:result){
    //     //     System.out.print(x+" ");
    //     // }
    // }
    // public static boolean twoSum(int[] arr, int target){
    // // public static int[] twoSum(int[] arr, int target){
    //     int n = arr.length;

    //     for(int i=0; i<n; i++){
    //         for(int j=0; j<n; j++){
    //             if(i==j){
    //                 continue;
    //             }
    //             if(arr[i]+arr[j] == target){
    //                 return true;
    //                 // return new int[]{i,j};
    //             }
    //         }
    //     }
    //     return false;
    //     // return new int[]{-1,-1};
    // }

    //BETTER --> TC: O(n) SC: O(n)
    // public static void main(String args[]){
    //     int[] arr = {2,6,8,5,11};
    //     int target = 14;
    //     System.out.println(twoSum(arr,target));
    //     // int[] result = twoSum(arr,target);

    //     // for(int x:result){
    //     //     System.out.print(x+" ");
    //     // }
    // }
    // public static boolean twoSum(int[] arr, int target){
    // // public static int[] twoSum(int[] arr, int target){
    //     int n = arr.length;
    //     Map<Integer,Integer> map = new HashMap<>();

    //     for(int i=0; i<n; i++){
    //         int temp = target-arr[i];
    //         if(map.containsKey(temp)){
    //             return true;
    //             // return new int[]{map.get(temp),i};
    //         }
    //         map.put(arr[i],i);
    //     }
    //     return false;
    //     // return new int[]{-1,-1};
    // }

    //OPTIMAL --> TC:O(n log n)+ O(n)  SC: O(1)
    // public static void main(String args[]){
    //     int[] arr = {2,6,8,5,11};
    //     int target = 14;
    //     System.out.println(twoSum(arr,target));
    // }
    // public static boolean twoSum(int[]arr, int target){
    //     Arrays.sort(arr);
    //     int n = arr.length;
    //     int left = 0;
    //     int right = n-1;

    //     while(left<right){
    //         if(arr[left]+arr[right]>target){
    //             right--;
    //         }
    //         else if(arr[left]+arr[right]<target){
    //             left++;
    //         }
    //         else{
    //             return true;
    //         }
    //     }
    //     return false;
    // }
}