//Duplicates are allowed

public class SearchInRotatedSortedArray_II {
    // TC: Average : O(log n) --> Worst Case : O(n/2)
    // SC: O(1)
    public static void main(String[] args){
        int[] arr = {7,8,1,2,3,3,3,4,5,6};
        int target = 3;
        System.out.println(searchElement(arr,target));
    }
    public static boolean searchElement(int[] arr, int target){
        int n = arr.length;
        int low = 0;
        int high = n-1;

        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid] == target){
                return true;
            }
            if(arr[low] ==arr[mid] && arr[mid] == arr[high]){
                low = low+1;
                high = high-1;
                continue;
            }
            if(arr[low]<=arr[mid]){
                if(arr[low]<=target && target<=arr[mid]){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            else{
                if(arr[mid]<=target && target<=arr[high]){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
        }
        return false;
    }
}
