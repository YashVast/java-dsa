
import java.util.Arrays;

public class MergeSortedArrays{

    //BRUTE FORCE --> TC: 2 * O(n+m) SC: O(n+m)
    // public static void main(String args[]){
    //     int[] arr1 = {1,3,5,7};
    //     int[] arr2 = {0,2,6,8,9};

    //     mergeArrays(arr1,arr2);

    //     for(int x:arr1){
    //         System.out.print(x+" ");
    //     }
    //     for(int x:arr2){
    //         System.out.print(x+" ");
    //     }
    // }
    // public static void mergeArrays(int[] arr1,int[] arr2){
    //     int n = arr1.length;
    //     int m = arr2.length;
    //     int[] result = new int[n+m];
    //     int left = 0;
    //     int right = 0;
    //     int index = 0;
    //     while(left < n && right < m){
    //         if(arr1[left] <= arr2[right]){
    //             result[index++] = arr1[left];
    //             left++;
    //         }
    //         else{
    //             result[index++] = arr2[right];
    //             right++;
    //         }
    //     }
    //     while(left<n){
    //         result[index++] = arr1[left];
    //         left++;
    //     }
    //     while(right<m){
    //         result[index++] = arr2[right];
    //         right++;
    //     }
    //     for(int i=0; i<n+m; i++){
    //         if(i<n){
    //             arr1[i] = result[i];
    //         }
    //         else{
    //             arr2[i-n] = result[i];
    //         }
    //     }
    // }

    //OPTIMAL --> TC: O(min(n,m))+ O(n log n)+ O(m log m) SC: O(1)
    public static void main(String[] args) {
        int[] arr1 = {1,3,5,7};
        int[] arr2 = {0,2,6,8,9};
        mergeArrays(arr1,arr2);
        for(int x : arr1){
            System.out.print(x+" ");
        }
        for(int x : arr2){
            System.out.print(x+" ");
        }
    }
    public static void mergeArrays(int[] arr1, int[] arr2){
        int n = arr1.length;
        int m = arr2.length;
        int left = n-1;
        int right = 0;

        while(left >=0 && right < m){
            if(arr1[left] > arr2[right]){
                int temp = arr2[right];
                arr2[right] = arr1[left];
                arr1[left] = temp;
                left--;
                right++;
            }
            else{
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}