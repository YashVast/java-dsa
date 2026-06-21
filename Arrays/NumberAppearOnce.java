import java.util.HashMap;
import java.util.Map;

public class NumberAppearOnce {
    //BRUTE FORCE --> TC:O(n2) SC: O(11)
    // public static void main(String args[]){
    //     int[] arr = {1,1,2,2,3,3,4,5,5};
    //     System.out.println(numberAppearOnce(arr));
    // }
    // public static int numberAppearOnce(int[] arr){
    //     if(arr==null){
    //         throw new IllegalArgumentException("array is null");
    //     }
    //     int n = arr.length;

    //     for(int i=0; i<n; i++){
    //         int counter = 0;
    //         int num = arr[i];
    //         for(int j=0; j<n; j++){
    //             if(arr[j]==num){
    //                 counter++;
    //             }
    //         }
    //         if(counter==1){
    //             return num;
    //         }
    //     }
    //     throw new IllegalArgumentException("unknown exception");
    // }

    //BETTER --> TC: O(n) SC:O(n)
    // public static void main(String args[]){
    //     int[] arr = {1,1,2,2,3,3,4,5,5};
    //     System.out.println(numberAppearOnce(arr));
    // }
    // public static int numberAppearOnce(int[] arr){
    //     if(arr==null){
    //         throw new IllegalArgumentException("array is null");
    //     }
    //     int n = arr.length;
    //     Map<Integer,Integer> map = new HashMap<>();

    //     for(int num:arr){
    //         map.put(num,map.getOrDefault(num, 0)+1);
    //     }

    //     for(int key: map.keySet()){
    //         if(map.get(key)==1){
    //             return key;
    //         }
    //     }

    //     //entrySet is better because map.get(key) loops one more time
    //     // for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
    //     //     if (entry.getValue() == 1) {
    //     //         return entry.getKey();
    //     //     }
    //     // }
    //     throw new IllegalArgumentException("No element appears exactly once");
    // }


    //OPTIMAL --> TC:O(n) SC:O(1)
    public static void main(String args[]){
        int[] arr = {1,1,2,2,3,3,4,5,5};
        System.out.println(numberAppearOnce(arr));
    }
    public static int numberAppearOnce(int[] arr){
        if(arr==null){
            throw new IllegalArgumentException("array is null");
        }
        int xor = 0;
        for (int num : arr) {
            xor ^= num;
        }
        return xor;
    }
}
