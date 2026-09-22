//Duplicates not allowed

public class SearchInRotatedSortedArray_I {
    // TC: O(log n)
    // SC: O(1)
    public static void main(String[] args){
        int[] arr = {7,8,9,1,2,3,4,5,6};
        int target = 1;
        System.out.println(searchElement(arr,target));
    }
    public static int searchElement(int[] arr, int target){
        int n = arr.length;
        int low = 0;
        int high = n-1;

        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[low]<=arr[mid]){
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
        return -1;
    }
}
