//you can replace at most one 0 to 1

public class MaximumConsecutiveOnes_II {
    //BRUTE FORCE -->
    // TC: O(n*2)
    // SC: O(1)
    public static void main(String args[]){
        int[] arr = {1,0,1,1,0};
        System.out.println(maxConsecutiveOnes(arr));
    }
    public static int maxConsecutiveOnes(int[] arr){
        int n = arr.length;
        int maxLength = 0;

        for(int i=0; i<n; i++){
            int maxZeros = 0;
            for(int j=i; j<n; j++){
                if(arr[j] == 0){
                    maxZeros++;
                }
                if(maxZeros<=1){
                    maxLength = Math.max(maxLength, j-i+1);
                }
            }
        }
        return maxLength;
    }

    // // BETTER -->
    // // TC: O(n)+O(n) = O(2n)
    // // SC: O(1)
    // public static void main(String args[]){
    //     int[] arr = {1,0,1,1,0};
    //     System.out.println(maxConsecutiveOnes(arr));
    // }
    // public static int maxConsecutiveOnes(int[] arr){
    //     int n = arr.length;
    //     int left = 0;
    //     int right = 0;
    //     int maxLength = 0;
    //     int maxZeros = 0;

    //     while(right<n){
    //         if(arr[right] == 0){
    //             maxZeros++;
    //         }
    //         while(maxZeros>1){
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
    // public static void main(String args[]){
    //     int[] arr = {1,0,1,1,0};
    //     System.out.println(maxConsecutiveOnes(arr));
    // }
    // public static int maxConsecutiveOnes(int[] arr){
    //     int n = arr.length;
    //     int left = 0;
    //     int right = 0;
    //     int maxLength = 0;
    //     int maxZeros = 0;

    //     while(right<n){
    //         if(arr[right] == 0){
    //             maxZeros++;
    //         }
    //         if(maxZeros>1){
    //             if(arr[left] == 0){
    //                 maxZeros--;
    //             }
    //             left++;
    //         }
    //         if(maxZeros<=1){
    //             maxLength = Math.max(maxLength,right-left+1);
    //         }
    //         right++;
    //     }
    //     return maxLength;
    // }
}
