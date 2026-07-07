public class MaximumProductSubArray{
    //BRUTE FORCE --> TC: O(n2) SC: O(1)
    // public static void main(String args[]){
    //     int[] arr = {2,3,-2,4};
    //     System.out.println(maximumProduct(arr));
    // }
    // public static int maximumProduct(int[] arr){
    //     int n = arr.length;
    //     int maxProduct = Integer.MIN_VALUE;
    //     for(int i=0; i<n; i++){
    //         int product = 1;
    //         for(int j=i; j<n; j++){
    //             product *= arr[j];
    //             if(product>maxProduct){
    //                 maxProduct = Math.max(maxProduct,product);
    //             }
    //         }
    //     }
    //     return maxProduct;
    // }

    //OPTIMAL --> TC: O(n) SC: O(1)
    public static void main(String args[]){
        int[] arr = {2,3,-2,4};
        System.out.println(maximumProduct(arr));
    }
    public static int maximumProduct(int[] arr){
        int n = arr.length;
        int prefix = 1;
        int suffix = 1;
        int maxProduct = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            if(prefix == 0){
                prefix = 1;
            }
            if(suffix == 0){
                suffix = 1;
            }
            prefix *= arr[i];
            suffix *= arr[n-i-1];

            maxProduct = Math.max(maxProduct, Math.max(prefix,suffix));
        }
        return maxProduct;
    }
}