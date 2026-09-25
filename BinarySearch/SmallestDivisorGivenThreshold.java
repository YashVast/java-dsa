public class SmallestDivisorGivenThreshold{
    // BRUTE FORCE -->
    // TC: O(max*n)+O(n)
    // SC: O(1)
    // public static void main(String[] args) {
    //     int[] arr = {1, 2, 5, 9};
    //     int threshold = 6;
    //     System.out.println(smallestDivisor(arr, threshold));
    // }

    // public static int smallestDivisor(int[] arr, int threshold) {
    //     int largest = findLargest(arr);
    //     for (int divisor = 1; divisor <= largest; divisor++) {
    //         int sum = 0;
    //         for (int i = 0; i < arr.length; i++) {
    //             sum += (int) Math.ceil((double) arr[i] / divisor);
    //         }
    //         if (sum <= threshold) {
    //             return divisor;
    //         }
    //     }
    //     return -1;
    // }

    // public static int findLargest(int[] arr) {
    //     int largest = Integer.MIN_VALUE;
    //     for (int i = 0; i < arr.length; i++) {
    //         if (arr[i] > largest) {
    //             largest = arr[i];
    //         }
    //     }
    //     return largest;
    // }

    // OPTIMAL -->
    // TC: O(n log max)+O(n)
    // SC: O(1)
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 9};
        int threshold = 6;
        System.out.println(smallestDivisor(arr, threshold));
    }
    public static int smallestDivisor(int[] arr, int threshold){
        int largest = findLargest(arr);
        int low = 1;
        int high = largest;
        int ans = -1;

        while(low<=high){
            int mid = low+(high-low)/2;
            if(sumOfDivision(arr,mid)<= threshold){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    public static int findLargest(int[] arr){
        int largest = Integer.MIN_VALUE;
        for(int x: arr){
            if(x>largest){
                largest = x;
            }
        }
        return largest;
    }
    public static int sumOfDivision(int[] arr, int divisor){
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum += (int)Math.ceil((double)arr[i]/divisor);
        }
        return sum;
    }
}