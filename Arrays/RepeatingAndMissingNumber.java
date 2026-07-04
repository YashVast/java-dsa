import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatingAndMissingNumber {

    //BRUTE FORCE --> TC: O(n2) SC: O(1)
    // public static void main(String args[]){
    //     int[] arr = {4,3,6,2,1,1};
    //     int n = 6;
    //     List<Integer> result = repeatingAndMissingNumber(arr,n); 

    //     for(int i=0; i<result.size(); i++){
    //         System.out.println(result.get(i));
    //     }
    // }
    // public static List<Integer> repeatingAndMissingNumber(int[] arr, int n){
    //     List<Integer> list = new ArrayList<>();
    //     int repeating = -1;
    //     int missing = -1;

    //     for(int i=1; i<=n; i++){
    //         int count = 0;
    //         for(int j=0; j<n; j++){
    //             if(arr[j] == i){
    //                 count++;
    //             }
    //         }
    //         if(count == 0){
    //             missing = i;
    //         }
    //         if(count == 2){
    //             repeating = i;
    //         }
    //     }
    //     list.add(missing);
    //     list.add(repeating);
    //     return list;
    // }

    //BETTER --> TC: O(2n) SC: O(n)
    // public static void main(String args[]){
    //     int[] arr = {4,3,6,2,1,1};
    //     int n = 6;
    //     List<Integer> result = repeatingAndMissingNumber(arr, n);

    //     for(int i=0; i<result.size(); i++){
    //         System.out.println(result.get(i));
    //     }
    // }
    // public static List<Integer> repeatingAndMissingNumber(int[] arr, int n){
    //     List<Integer> list = new ArrayList<>();
    //     int[] freqArray = new int[n+1];
    //     int missing = -1;
    //     int repeating = -1;
        
    //     for(int i=0; i<n; i++){
    //         freqArray[arr[i]]++;
    //     }
    //     for(int i=1; i<=n; i++){
    //         if(freqArray[i] == 0){
    //             missing = i;
    //         }
    //         if(freqArray[i] == 2){
    //             repeating = i;
    //         }
    //     }
    //     list.add(missing);
    //     list.add(repeating);
    //     return list;
    // }


    //OPTIMAL --> TC: O(n) SC: O(1)
    public static void main(String args[]){
        int[] arr = {4,3,6,2,1,1};
        int n = 6;
        List<Integer> result = repeatingAndMissingNumber(arr,n);

        for(int i=0; i<result.size(); i++){
            System.out.println(result.get(i));
        }
    } 
    public static List<Integer> repeatingAndMissingNumber(int[] arr, int n){
        List<Integer> list = new ArrayList<>();
        long s = 0;
        long s2 = 0;
        long sn = (long)(n * (n+1))/2;
        long s2n = (long)n * (n+1) * (2L*n +1)/6;
        for(int i=0; i<n; i++){
            s += arr[i]; 
            s2 += (long)arr[i] * (long)arr[i];  
        }
        long val1 = s - sn;
        long val2 = s2 - s2n;
        val2 = val2/val1;

        long x = (val1 + val2)/2;
        long y = x - val1;

        list.add((int)x);
        list.add((int)y);
        return list;
    }
}
