public class MinimumSizeSubarraySum{

    // BRUTE FORCE --> 
    // TC: O(n^2)
    // SC: O(1)
    // public static void main(String args[]){
    //     int[] arr = {2,3,1,2,4,3};
    //     int target = 7;
    //     System.out.println(minimumSizeSubarray(arr,target));
    // }
    // public static int minimumSizeSubarray(int[] arr, int target){
    //     int n = arr.length;
    //     int length = Integer.MAX_VALUE;

    //     for(int i=0; i<n; i++){
    //         int sum = 0;
    //         for(int j=i; j<n; j++){
    //             sum += arr[j];
    //             if(sum >=target){
    //                 length = Math.min(length,j-i+1);
    //             }
    //         }
    //     }
    //     return length;
    // }


    // OPTIMAL --> 
    // TC: O(n)
    // SC: O(1)
    public static void main(String args[]){
        int[] arr = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(minimumSizeSubarray(arr,target));
    }
    public static int minimumSizeSubarray(int[] arr, int target){
        int n = arr.length;
        int left = 0;
        int right = 0;
        int length = Integer.MAX_VALUE;
        int sum = 0;

        while(right<n){
            sum += arr[right];
            while(sum>=target){
                length = Math.min(length,right-left+1);
                sum -= arr[left];
                left++;
            }
            right++;
        }
        if(length == Integer.MAX_VALUE){
            return 0;
        }
        return length;
    }
}