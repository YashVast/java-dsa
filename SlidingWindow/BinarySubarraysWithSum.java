import java.util.HashMap;
import java.util.Map;

public class BinarySubarraysWithSum {

    // BRUTE FORCE --> 
    // TC: O(n*2)
    // SC: O(1)
    // public static void main(String args[]){
    //     int[] arr = {1,0,1,0,1};
    //     int goal = 2;
    //     System.out.println(numberOfSubarrays(arr,goal)); 
    // }
    // public static int numberOfSubarrays(int[] arr, int goal){
    //     int n = arr.length;
    //     int count = 0;

    //     for(int i=0; i<n; i++){
    //         int sum = 0;
    //         for(int j=i; j<n; j++){
    //             sum += arr[j];
    //             if(sum == goal){
    //                 count++;
    //             }
    //         }
    //     }
    //     return count;
    // }

    // BETTER --> 
    // TC: O(n)
    // SC: O(n)
    // public static void main(String args[]){
    //     int[] arr = {1,0,1,0,1};
    //     int goal = 2;
    //     System.out.println(numberOfSubarrays(arr,goal)); 
    // }
    // public static int numberOfSubarrays(int[] arr, int goal){
    //     int n = arr.length;
    //     int count = 0;
    //     int prefixSum = 0;
    //     Map<Integer,Integer> map = new HashMap<>();
    //     map.put(0,1);

    //     for(int i=0; i<n; i++){
    //         prefixSum += arr[i];
    //         int remove = prefixSum-goal;

    //         if(map.containsKey(remove)){
    //             count += map.get(remove);
    //         }
    //         if(map.containsKey(prefixSum)){
    //             map.put(prefixSum,map.get(prefixSum)+1);
    //         }
    //         else{
    //             map.put(prefixSum,1);
    //         }
    //     }
    //     return count;
    // }


    // OPTIMAL --> 
    // TC: O(2 * 2n)
    // SC: O(1)
    public static void main(String args[]){
        int[] arr = {1,0,1,0,1};
        int goal = 2;
        System.out.println(countOfSubarrays(arr,goal) - countOfSubarrays(arr,goal-1)); 
    }
    public static int countOfSubarrays(int[] arr, int goal){
        int n = arr.length;
        int count = 0;
        int left = 0;
        int right = 0;
        int sum = 0;

        while(right<n){
            if(goal < 0){
                return 0;
            }
            sum += arr[right];
            while(sum > goal){
                sum -= arr[left];
                left++;
            }
            count += right-left+1;
            right++;
        }
        return count;
    }
}
