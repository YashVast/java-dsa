public class MaximumPointsObtainFromCards {
    // TC: O(k)
    // SC: O(1)
    public static void main(String args[]){
        int[] arr = {6,2,3,4,7,2,1,7,1};
        int k = 4;
        System.out.println(maxPoints(arr,k));
    }
    public static int maxPoints(int[] arr, int k){
        int n = arr.length;
        int leftSum = 0;
        int rightSum = 0;
        int maxSum = 0;

        //O(k)
        for(int i=0; i<k; i++){
            leftSum += arr[i];
            maxSum = leftSum;
        }
        int rIndex = n-1;
        //O(k)
        for(int i=k-1; i>=0; i--){
            leftSum -= arr[i];
            rightSum += arr[rIndex--];

            maxSum = Math.max(maxSum,leftSum+rightSum);
        }
        return maxSum;
    }
}
