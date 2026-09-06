import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FruitIntoBaskets {
    // BRUTE FORCE:
    // TC: O(n*2)
    // SC: O(4) --> O(1)
    // public static void main(String args[]){
    //     int[] arr = {3,3,3,1,2,1,1,2,3,3,4};
    //     System.out.println(maxFruits(arr));
    // }
    // public static int maxFruits(int[] arr){
    //     int n = arr.length;
    //     int maxLength = 0;
    //     Set<Integer> set = new HashSet<>();

    //     for(int i=0; i<n; i++){
    //         set.clear();
    //         for(int j=i; j<n; j++){
    //             set.add(arr[j]);

    //             if(set.size()>2){
    //                 break;
    //             }
    //             maxLength = Math.max(maxLength,j-i+1);
    //         }
    //     }
    //     return maxLength;
    // }

    // BETTER --> 
    // TC: O(n)+O(n) = O(2n)
    // SC: O(3)+O(4) = O(7)
    // public static void main(String args[]){
    //     int[] arr = {3,3,3,1,2,1,1,2,3,3,4};
    //     System.out.println(maxFruits(arr));
    // }
    // public static int maxFruits(int[] arr){
    //     int n = arr.length;
    //     int left = 0;
    //     int right = 0;
    //     int maxLength = 0;
    //     Map<Integer,Integer> map = new HashMap<>();

    //     while(right<n){
    //         if(map.containsKey(arr[right])){
    //             map.put(arr[right],map.get(arr[right])+1);
    //         }
    //         else{
    //             map.put(arr[right],1);
    //         }
    //         if(map.size()>2){
    //             while(map.size()>2){
    //                 map.put(arr[left],map.get(arr[left])-1);
    //                 if(map.get(arr[left]) == 0){
    //                     map.remove(arr[left]);
    //                 }
    //                 left++;
    //             }
    //         }
    //         maxLength = Math.max(maxLength,right-left+1);
    //         right++;
    //     }
    //     return maxLength;
    // }


    // iss vali approach mai humne window jo last max mila tha uspe hi fix krdi hai.
    // OPTIMAL -->
    // TC: O(n)
    // SC: O(3)+O(4) = O(1)
    public static void main(String args[]){
        int[] arr = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(maxFruits(arr));
    }
    public static int maxFruits(int[] arr){
        int n = arr.length;
        int left = 0;
        int right = 0;
        int maxLength = 0;
        Map<Integer,Integer> map = new HashMap<>();

        while(right<n){
            if(map.containsKey(arr[right])){
                map.put(arr[right],map.get(arr[right])+1);
            }
            else{
                map.put(arr[right],1);
            }
            if(map.size()>2){
                if(map.containsKey(arr[left])){
                    map.put(arr[left],map.get(arr[left])-1);
                    if(map.get(arr[left]) == 0){
                        map.remove(arr[left]);
                    }
                    left++;
                }
            }
            if(map.size()<=2){
                maxLength = Math.max(maxLength,right-left+1);
            }
            right++;
        }
        return maxLength;
    }
}
