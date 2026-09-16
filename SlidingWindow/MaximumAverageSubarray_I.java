public class MaximumAverageSubarray_I{

    // BRUTE FORCE -->
    // TC: O(n^2)
    // SC: O(1)
    // public static void main(String args[]){
    //     int[] arr = {1,12,-5,-6,50,3};
    //     int k = 4;
    //     System.out.println(maximumAverage(arr,k));
    // }
    // public static double maximumAverage(int[] arr, int k){
    //     int n = arr.length;
    //     int maxSum = 0;
    //     double average = 0.0;

    //     for(int i=0; i<n; i++){
    //         int sum = 0;
    //         int length = 0;
    //         for(int j=i; j<n; j++){
    //             length++;
    //             sum += arr[j];
    //             if(length == k){
    //                 maxSum = Math.max(maxSum,sum);
    //                 break;
    //             }
    //         }
    //     }
    //     average = (double)maxSum/k;
    //     return average;
    // }

    // OPTIMAL -->
    // TC: O(n)
    // SC: O(1)
    public static void main(String args[]){
        int[] arr = {1,12,-5,-6,50,3};
        int k = 4;
        System.out.println(maximumAverage(arr,k));
    }
    public static double maximumAverage(int[] arr, int k){
        int n = arr.length;
        int sum = 0;
        int maxSum = 0;
        double average = 0.0;
        for(int i=0; i<k; i++){
            sum += arr[i];
        }
        maxSum = Math.max(maxSum,sum);

        for(int i=k; i<n; i++){
            sum += arr[i];
            sum -= arr[i-k];
            maxSum = Math.max(maxSum,sum);
        }
        average = (double)maxSum/k;
        return average;
    }
}