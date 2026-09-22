//LowerBound --> smallest index such that arr[i]>=x

public class LowerBound{
    // TC: O(log n)
    // SC: O(1)
    public static void main(String[] args){
        int[] arr = {1,2,3,3,7,8,9,9,9,11};
        int target = 1;
        System.out.println(lowerBound(arr,target));
    }
    public static int lowerBound(int[] arr, int target){
        int n = arr.length;
        int low = 0;
        int high = n-1;
        int ans = n;

        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]>= target){
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