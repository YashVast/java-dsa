
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class LargestSubArrayWithSum0{
    //BRUTE FORCE --> TC: O(n2) SC: O(1)
    // public static void main(String args[]){
    //     int[] arr = {15,-2,2,-8,1,7,10,23};
    //     System.out.println(largestSubArray(arr));
    // }
    // public static int largestSubArray(int[] arr){
    //     int n = arr.length;
    //     int length = 0;
    //     int maxLength = 0;

    //     for(int i=0; i<n; i++){
    //         int sum = 0;
    //         for(int j=i; j<n; j++){
    //             sum += arr[j];
    //             if(sum == 0){
    //                 length = j-i+1;
    //                 maxLength = Math.max(maxLength,length);
    //             }
    //         }
    //     }
    //     return maxLength;
    // }

    //BRUTE FORCE --> TC: O(n2) SC: O(n)
    // public static void main(String args[]){
    //     int[] arr = {15,-2,2,-8,1,7,10,23};
    //     List<Integer> result = largestSubArray(arr);

    //     for(int i=0; i<result.size(); i++){
    //         System.out.print(result.get(i)+" ");
    //     }
    // }
    // public static List<Integer> largestSubArray(int[] arr){
    //     int n = arr.length;
    //     int start = -1;
    //     int end = -1;
    //     int maxLength = 0;
    //     for(int i=0; i<n; i++){
    //         int sum = 0;
    //         for(int j=i; j<n; j++){
    //             sum +=arr[j];
    //             if(sum == 0){
    //                 if(j-i+1 > maxLength){
    //                     maxLength = j-i+1;
    //                     start = i;
    //                     end = j;
    //                 }
    //             }
    //         }
    //     }
    //     List<Integer> result = new ArrayList<>();

    //     if(start == -1){
    //         return result; 
    //     }

    //     for(int i=start; i<=end; i++){
    //         result.add(arr[i]);
    //     }
    //     return result;
    // }


    //OPTIMAL --> TC: O(n) SC: O(n)
    // public static void main(String args[]){
    //     int[] arr = {15,-2,2,-8,1,7,10,23};
    //     System.out.println(largestSubArray(arr));
    // }
    // public static int largestSubArray(int[] arr){
    //     int n = arr.length;
    //     Map<Integer,Integer> map = new HashMap<>();
    //     int sum = 0;
    //     int maxLength = 0;
    //     for(int i=0; i<n; i++){
    //         sum += arr[i];
            
    //         if(sum == 0){
    //             maxLength = i+1;
    //         }
    //         if(map.containsKey(sum)){
    //             int length = i-map.get(sum);
    //             maxLength = Math.max(maxLength,length);
    //         }
    //         else{
    //             map.put(sum,i);
    //         }
    //     }
    //     return maxLength;
    // }


    //OPTIMAL --> TC: O() SC: O()
    public static void main(String args[]){
        int[] arr = {15,-2,2,-8,1,7,10,23};
        List<Integer> result = largestSubArray(arr);

        for(int i=0; i<result.size(); i++){
            System.out.print(result.get(i)+ " ");
        }
    }
    public static List<Integer> largestSubArray(int[] arr){
        int n = arr.length;
        int sum = 0;
        int start = -1;
        int end = -1;
        int maxLength = 0;

        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            sum += arr[i];
            if(sum == 0){
                if(i+1 > maxLength){
                    maxLength = i+1;
                    start = 0;
                    end = i+1;
                }
            }
            if(map.containsKey(sum)){
                int prevIndex = map.get(sum);

                if(i-prevIndex> maxLength){
                    maxLength = i-prevIndex;
                    start = prevIndex+1;
                    end = i;
                }
            }
            else{
                map.put(sum,i);
            }
        }
        List<Integer> result = new ArrayList<>();

        if(start == -1){
            return result;
        }

        for(int i=start; i<=end; i++){
            result.add(arr[i]);
        }
        return result;
    }
}