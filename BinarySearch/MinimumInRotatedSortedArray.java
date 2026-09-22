//Duplicated not allowed.

public class MinimumInRotatedSortedArray {
    // TC: O(log n)
    // SC: O(1)
    public static void main(String[] args){
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(minimum(arr));
    }
    public static int minimum(int[] arr){
        int n = arr.length;
        int low = 0;
        int high = n-1;
        int ans = Integer.MAX_VALUE;

        while(low<=high){
            int mid = low+(high-low)/2;
            //Optimizaion
            if(arr[low]<=arr[high]){
                ans = Math.min(ans,arr[low]);
                break;
            }
            if(arr[low]<=arr[mid]){
                ans = Math.min(ans,arr[low]);
                low = mid+1;
            }
            else{
                ans = Math.min(ans,arr[mid]);
                high = mid-1;
            }
        }
        return ans;
    }
}
