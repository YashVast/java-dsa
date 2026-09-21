public class BinarySearch{

    // TC: O(log n)
    // SC: O(1)
    // public static void main(String[] args){
    //     int[] arr = {3,4,6,7,9,12,16,17};
    //     int target = 6;

    //     System.out.println(binarySearch(arr,target));
    // }
    // public static boolean binarySearch(int[] arr, int target){
    //     int n = arr.length;
    //     int low = 0;
    //     int high = n-1;

    //     while(low<=high){
    //         int mid = low+(high-low)/2;
    //         if(arr[mid] == target){
    //             return true;
    //         }
    //         else if(target>arr[mid]){
    //             low = mid+1;
    //         }
    //         else{
    //             high = mid-1;
    //         }
    //     }
    //     return false;
    // }

    //Recursive Code -->
    // TC: O(log n)
    // SC: O(log n)
    public static void main(String[] args){
        int[] arr = {3,4,6,7,9,12,16,17};
        int target = 6;
        int n = arr.length;
        int low = 0;
        int high = n-1;
        System.out.println(binarySearch(arr,target,n,low,high));
    }
    public static int binarySearch(int[] arr, int target, int n,int low, int high){
        if(low>high){
            return -1;
        }
        int mid = low+(high-low)/2;
        if(arr[mid] == target){
            return mid;
        }
        else if(target>arr[mid]){
            return binarySearch(arr, target, n, mid+1, high);
        }
        else{
            return binarySearch(arr, target, n, low, mid-1);
        }
    }
}