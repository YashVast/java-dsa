import java.util.HashMap;
import java.util.Map;

public class MajorityElement_I {
    //BRUTE --> TC: O(n2) SC: O(1) 
    // public static void main(String args[]){
    //     int[] arr = {2,2,3,3,1,2,2};
    //     System.out.println(majorityElement(arr));
    // }
    // public static int majorityElement(int[] arr){
    //     int n = arr.length;
    //     for(int i=0;i<n;i++){
    //         int counter = 0;
    //         for(int j=0; j<n;j++){
    //             if(arr[j]== arr[i]){
    //                 counter++;
    //             }
    //         }
    //         if(counter>n/2){
    //             return arr[i];
    //         }
    //     }
    //     return -1;
    // }

    //BETTER --> TC: O(n)+O(n) SC: O(n)
    // public static void main(String args[]){
    //     int[] arr = {2,2,3,3,1,2,2};
    //     System.out.println(majorityElement(arr));
    // }
    // public static int majorityElement(int[] arr){
    //     int n = arr.length;
    //     Map<Integer,Integer> map = new HashMap<>();

    //     for(int i=0; i<n; i++){
    //         if(map.containsKey(arr[i])){
    //             map.put(arr[i],map.get(arr[i])+1);
    //         }
    //         else{
    //             map.put(arr[i], 1);
    //         }
    //     }
    //     for(int key:map.keySet()){
    //         if(map.get(key)>n/2){
    //             return key;
    //         }
    //     }
    //     return -1;
    // }

    //OPTIMAL --> TC: O(n) SC: O(1)
    //Moore's Voting Algorithm
    public static void main(String args[]){
        int[] arr = {7,7,5,7,5,1,5,7,5,5,7,7,5,5,5,5};
        System.out.println(majorityElement(arr));
    }
    public static int majorityElement(int[] arr){
        int n = arr.length;
        int count = 0;
        int candidate = 0;

        for(int num:arr){
            if(count == 0){
                candidate = num;
                count = count+1;
            }
            else if(num==candidate){
                count++;
            }
            else{
                count--;
            }
        }
        count = 0;
        for(int num: arr){
            if(num==candidate){
                count++;
            }
        }
        if(count>n/2){
            return candidate;
        }
        return -1;
    }
}
