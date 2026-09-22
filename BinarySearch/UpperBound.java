// Upper Bound --> smallest index such that arr[i]>x

public class UpperBound {
    // TC: O(log n)
    // SC: O(1)
    public static void main(String[] args){
        int[] arr = {2,3,6,7,8,8,11,11,11,12};
        int target = 6;
        System.out.println(upperBound(arr,target));
    }
    public static int upperBound(int[] arr, int target){
        int n = arr.length;
        int ans = n;
        int low = 0;
        int high = n-1;

        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]>target){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
}
