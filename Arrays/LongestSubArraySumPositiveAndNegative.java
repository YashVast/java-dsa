import java.util.Map;
import java.util.HashMap;

public class LongestSubArraySumPositiveAndNegative {
    //OPTIMAL --> TC:O(n) SC: O(n)
    public static void main(String args[]){
        int[] arr = {1, 2, -1, 1, 1, -1, 1, 4, -2, 3};
        int k = 3;
        System.out.println(longestSubArraySum(arr,k));
    }
    public static int longestSubArraySum(int[] arr, int k){
        int n = arr.length;
        int maxLength = 0;
        int sum = 0;

        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            sum += arr[i];
            if(sum==k){
                maxLength = Math.max(maxLength,i+1);
            }
            int remaining = sum-k;
            if(map.containsKey(remaining)){
                int length = i - map.get(remaining);
                maxLength = Math.max(maxLength,length);
            }
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        return maxLength;
    }
}
