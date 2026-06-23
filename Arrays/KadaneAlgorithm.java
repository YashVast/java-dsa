//-------------------------------//MAXIMUM SUB-ARRAY SUM//-------------------------------//


public class KadaneAlgorithm{

    //BRUTE FORCE --> TC O(n2) SC: O(1)
    // public static void main(String args[]){
    //     int[] arr = {-2,-3,4,-1,-2,1,5,-3};
    //     System.out.println(maxSubArraySum(arr));
    // }
    // public static int maxSubArraySum(int[] arr){
    //     int n = arr.length;
    //     int maxSum = Integer.MIN_VALUE;
    //     for(int i=0; i<n; i++){
    //         int sum = 0;
    //         for(int j=i; j<n; j++){
    //             sum += arr[j];
    //             if(sum>maxSum){
    //                 maxSum = Math.max(maxSum,sum);
    //             }
    //         }
    //     }
    //     return maxSum;
    // }


    //OPTIMAL FORCE --> TC: O(n) SC: O(1)
    public static void main(String args[]){
        // int[] arr = {-2,-3,4,-1,-2,1,5,-3};
        int[] arr = {-5, -2, -8};
        System.out.println(maxSubArraySum(arr));
    }
    public static int maxSubArraySum(int[] arr){
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for(int i=0; i<n; i++){
            sum += arr[i];
            if(sum>maxSum){
                maxSum = Math.max(maxSum,sum);
            }

            if(sum<0){
                sum = 0;
            }
        }
        //AGAR MENTIONED HO KI FOR NEGATIVE OUTPUT RETURN 0
        // if(maxSum<=0){
        //     maxSum=0;
        //     return maxSum;
        // }
        // else{
        //     return maxSum;
        // }
        return maxSum;
    }
}