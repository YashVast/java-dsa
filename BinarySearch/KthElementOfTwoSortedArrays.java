public class KthElementOfTwoSortedArrays{
    // BRUTE FORCE -->
    // TC: O(n1+n2)
    // SC: O(n1+n2)
    // public static void main(String[] args){
    //     int[] arr1 = {2,3,6,7,9};
    //     int[] arr2 = {1,4,8,10};
    //     int k = 4;
    //     System.out.println(kthElement(arr1,arr2,k));
    // }
    // public static int kthElement(int[] arr1, int[] arr2, int k){
    //     int n1 = arr1.length;
    //     int n2 = arr2.length;
    //     int[] result = new int[n1+n2];
    //     int left = 0;
    //     int right = 0;
    //     int index = 0;

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
    //     return result[k-1];
    // }


    // BETTER -->
    // TC: O(n1+n2)
    // SC: O(1)
    public static void main(String[] args){
        int[] arr1 = {2,3,6,7,9};
        int[] arr2 = {1,4,8,10};
        int k = 4;
        System.out.println(kthElement(arr1,arr2,k));
    }
    public static int kthElement(int[] arr1, int[] arr2, int k){
        int n1 = arr1.length;
        int n2 = arr2.length;
        int left = 0;
        int right = 0;
        int count = 0;
        int element = -1;

        while(left<n1 && right<n2){
            if(arr1[left]<=arr2[right]){
                if(count == k){
                    element = arr1[left];
                }
                count++;
                left++;
            }
            else{
                if(count == k){
                    element = arr2[right];
                }
                count++;
                right++;
            }
        }
        while(left<n1){
            if(count == k){
                element = arr1[left];
            }
            count++;
            left++;
        }
        while(right<n2){
            if(count == k){
                element = arr2[right];
            }
            count++;
            right++;
        }
        return element;
    }
}