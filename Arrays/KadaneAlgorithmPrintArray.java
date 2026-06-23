public class KadaneAlgorithmPrintArray{

    //TC: O(n) Sc: O(1)
    public static void main(String args[]){
        // int[] arr = {-2,-3,4,-1,-2,1,5,-3};
        int[] arr = {-5, -2, -8};
        int[] result = maxSubArraySum(arr);

        for(int x: result){
            System.out.print(x+" ");
        }
    }
    public static int[] maxSubArraySum(int[] arr){
        int n = arr.length;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        int ansStart = 0;

        for(int i=0; i<n; i++){
            if(sum==0){
                start = i;
            }
            sum += arr[i];
            if(sum>maxSum){
                maxSum = Math.max(maxSum,sum);
                ansStart = start;
                end = i;
            }
            if(sum<0){
                sum = 0;
            }
        }
        return new int[]{ansStart,end};
    }
}