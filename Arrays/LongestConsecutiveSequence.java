
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence{
    //BRUTE FORCE --> TC: O(n2) SC: O(1)
    // public static void main(String args[]){
    //     int[] arr = {102,4,100,1,101,3,2,1,1};
    //     System.out.println(longestSequence(arr));
    // }
    // public static int longestSequence(int[] arr){
    //     int n = arr.length;
    //     int maxCounter = 1;
    //     int counter = 0;
    //     for(int i=0; i<n; i++){
    //         int temp = arr[i];
    //         counter = 1;
    //         while(linearSearch(arr,temp+1)==true){
    //             temp = temp+1;
    //             counter = counter+1;
    //         }
    //         maxCounter = Math.max(maxCounter,counter);
    //     }
    //     return maxCounter;
    // }
    // public static boolean linearSearch(int[] arr, int temp){
    //     int n = arr.length;

    //     for(int i=0; i<n; i++){
    //         if(arr[i]==temp){
    //             return true;
    //         }
    //     }
    //     return false;
    // }


    //BETTER --> TC: O(n log n)+O(n) SC: O(1)
    // public static void main(String args[]){
    //     int[] arr = {100,102,100,101,101,4,3,2,3,2,1,1,1,2};
    //     System.out.println(longestSequence(arr));
    // }
    // public static int longestSequence(int[] arr){
    //     Arrays.sort(arr);
    //     int n = arr.length;
    //     int longest = 1;
    //     int countCurrent = 0;
    //     int lastSmaller = Integer.MIN_VALUE;

    //     for(int i=0; i<n; i++){
    //         if(arr[i]-1 == lastSmaller){
    //             countCurrent = countCurrent+1;
    //             lastSmaller = arr[i];
    //         }
    //         else if(arr[i] != lastSmaller){
    //             countCurrent = 1;
    //             lastSmaller = arr[i];
    //         }
    //         longest = Math.max(longest,countCurrent);
    //     }
    //     return longest;
    // }

    //OPTIMAL --> TC: O(n)+O(2n) SC: O(n)
    public static void main(String args[]){
        int[] arr = {100,102,100,101,101,4,3,2,3,2,1,1,1,2};
        System.out.println(longestSequence(arr));
    }
    public static int longestSequence(int[] arr){
        int n = arr.length;
        if(n==0){
            return 0;
        }
        int longest = 1;
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<n; i++){
            set.add(arr[i]);
        }
        for(int num:set){
            if(!set.contains(num-1)){
                int currentNum = num;
                int count = 1;

                while(set.contains(currentNum+1)){
                    count++;
                    currentNum++;
                }
                longest = Math.max(longest,count);
            }
        }
        return longest;
    }
}