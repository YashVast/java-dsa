import java.util.Map;
import java.util.HashMap;

public class LongestSubArraySumPositive {
    //BRUTE FORCE --> TC: O(n2) SC: O(1)
    // public static void main(String args[]){
    //     int[] arr = {1,2,3,1,1,1,1,4,2,3};
    //     int k =3;
    //     System.out.println(longestSubArraySum(arr,k));
    // }
    // public static int longestSubArraySum(int[] arr,int k){
    //     if(arr==null){
    //         throw new IllegalArgumentException("array is null");
    //     }
    //     int n = arr.length;
    //     int counter = 0;

    //     for(int i=0; i<n; i++){
    //         int num=0;
    //         for(int j=i; j<n; j++){
    //             num +=arr[j];
    //             if(num==k){
    //                 counter = Math.max(counter, j-i+1);
    //             }
    //         }
    //     }
    //     return counter;
    // }


    //BETTER --> TC: O(n) SC: O(n)
    // public static void main(String args[]){
    //     int[] arr = {1,2,3,1,1,1,1,4,2,3};
    //     int k =3;
    //     System.out.println(longestSubArraySum(arr,k));
    // }
    // public static int longestSubArraySum(int[] arr, int k){
    //     if(arr==null){
    //         throw new IllegalArgumentException("array is null");
    //     }
    //     int n = arr.length;
    //     Map<Integer,Integer> map = new HashMap<>();
    //     int sum = 0;
    //     int maxLength = 0;
    //     for(int i=0; i<n; i++){
    //         sum += arr[i];
    //         if(sum==k){
    //             maxLength = Math.max(maxLength,i+1);
    //         }
    //         int remaining = sum-k;
            
    //         if(map.containsKey(remaining)){
    //             int length = i-map.get(remaining);
    //             maxLength = Math.max(maxLength, length);
    //         }

    //         if(!map.containsKey(sum)){
    //             map.put(sum,i);
    //         }
    //     }
    //     return maxLength;
    // }

    
    //OPTIMAL --> TC: O(n) SC: O(1)
    public static void main(String args[]){
        int[] arr = {1,2,3,1,1,1,1,4,2,3};
        int k =3;
        System.out.println(longestSubArraySum(arr,k));
    }
    public static int longestSubArraySum(int[] arr, int k){
        if(arr==null){
            throw new IllegalArgumentException("array is null");
        }
        int n = arr.length;
        int left = 0;
        int right = 0;
        int sum = arr[0];
        int maxLength = 0;

        while(right<n){
            while(left<=right && sum>k){
                sum -= arr[left];
                left++;
            }
            if(sum==k){
                maxLength = Math.max(maxLength,right-left+1);
            }
            right++;
            if(right<n){
                sum += arr[right];
            }
        }
        return maxLength;
    }
}
