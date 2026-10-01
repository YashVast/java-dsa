public class MedianOfTwoSortedArraysOfDifferentSizes{
    // BRUTE FORCE -->
    // TC: O(n+m)
    // SC: O(n+m)
    // public static void main(String[] args){
    //     int[] arr1 = {1,3,4,7,10,12};
    //     int[] arr2 = {2,3,6,15};
    //     System.out.println(findMedian(arr1,arr2));
    // }
    // public static double findMedian(int[] arr1, int[] arr2){
    //     int n1 = arr1.length;
    //     int n2 = arr2.length;
    //     int[] result = new int[n1+n2];
    //     int index = 0;
    //     int left = 0;
    //     int right = 0;

    //     while(left<n1 && right<n2){
    //         if(arr1[left]<=arr2[right]){
    //             result[index++] = arr1[left++];
    //         }
    //         else{
    //             result[index++] = arr2[right++];
    //         }
    //     }
    //     while(left<n1){
    //         result[index++] = arr1[left++];
    //     }
    //     while(right<n2){
    //         result[index++] = arr2[right++];
    //     }
    //     int n = n1+n2;
    //     if(n%2 == 1){
    //         return result[n/2];
    //     }
    //     return (result[n/2]+result[n/2-1])/2.0;
    // }

    // BETTER -->
    // TC: O(n+m)
    // SC: O(n+m)
    public static void main(String[] args){
        int[] arr1 = {1,3,4,7,10,12};
        int[] arr2 = {2,3,6,15};
        System.out.println(findMedian(arr1,arr2));
    }
    public static double findMedian(int[] arr1, int[] arr2){
        int n1 = arr1.length;
        int n2 = arr1.length;
        
    }
}