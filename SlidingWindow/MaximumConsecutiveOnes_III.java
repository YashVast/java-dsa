public class MaximumConsecutiveOnes_III {
    // BRUTE FORCE --> 
    // TC: O(n*2)
    // SC: O(1)
    // public static void main(String args[]){
    //     int[] arr = {1,1,1,0,0,0,1,1,1,1,0,};
    //     int k = 2;
    //     System.out.println(maxConsecutiveOnes(arr,k));
    // }
    // public static int maxConsecutiveOnes(int[] arr, int k){
    //     int n = arr.length;
    //     int maxLength = 0;
        
    //     for(int i=0; i<n; i++){
    //         int maxZeros = 0;
    //         for(int j=i; j<n; j++){
    //             if(arr[j] == 0){
    //                 maxZeros++;
    //             }
    //             if(maxZeros<=k){
    //                 int length = j-i+1;
    //                 maxLength = Math.max(maxLength,length);
    //             }
    //         }
    //     }
    //     return maxLength;
    // }

    //BETTER -->
    // TC: O(n)+O(n) = O(2n)
    // SC: O(1)
    // public static void main(String args[]){
    //     int[] arr = {1,1,1,0,0,0,1,1,1,1,0,};
    //     int k = 2;
    //     System.out.println(maxConsecutiveOnes(arr,k));
    // }
    // public static int maxConsecutiveOnes(int[] arr, int k){
    //     int n = arr.length;
    //     int left = 0;
    //     int right = 0;
    //     int maxLength = 0;
    //     int maxZeros = 0;

    //     while(right<n){
    //         if(arr[right] == 0){
    //             maxZeros++;
    //         }
    //         while(maxZeros>k){
    //             if(arr[left] == 0){
    //                 maxZeros--;
    //             }
    //             left++;
    //         }
    //         maxLength = Math.max(maxLength,right-left+1);
    //         right++;
    //     }
    //     return maxLength;
    // }


    //OPTIMAL --> 
    // TC: O(n)
    // SC: O(1)
    public static void main(String args[]){
        int[] arr = {1,1,1,0,0,0,1,1,1,1,0,};
        int k = 2;
        System.out.println(maxConsecutiveOnes(arr,k));
    }
    public static int maxConsecutiveOnes(int[] arr, int k){
        int n = arr.length;
        int left = 0;
        int right = 0;
        int maxLength = 0;
        int maxZeros = 0;

        while(right<n){
            if(arr[right] == 0){
                maxZeros++;
            }
            if(maxZeros>k){
                if(arr[left] == 0){
                    maxZeros--;
                }
                left++;
            }
            if(maxZeros<=k){
                maxLength = Math.max(maxLength,right-left+1);
            }
            right++;
        }
        return maxLength;
    }
}
