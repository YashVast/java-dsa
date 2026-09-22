public class CountOccurences{
    // TC: 2*O(log n)
    // SC: O(1)
    public static void main(String[] args){
        int[] arr = {2,4,6,8,8,8,11,13};
        int target = 8;
        System.out.println(countOccurences(arr,target));
    }
    public static int countOccurences(int[] arr, int target){
        int first = firstOccurence(arr,target);
        if(first == -1){
            return -1;
        }
        int last = lastOccurence(arr,target);
        int result = last-first+1;
        return result;
    }
    public static int firstOccurence(int[] arr, int target){
        int n = arr.length;
        int low = 0;
        int high = n-1;
        int first = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid] == target){
                first = mid;
                high = mid-1;
            }
            else if(arr[mid]<target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return first;
    }
    public static int lastOccurence(int[] arr, int target){
        int n = arr.length;
        int low = 0;
        int high = n-1;
        int last = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid] == target){
                last = mid;
                low = mid+1;
            }
            else if(arr[mid]<target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return last;
    }
}