public class IsSortedArray{
    //TC: O(n) SC: O(1)
    public static void main(String args[]){
        int[] arr = {1,1,2,2,3,3,6,4,4,5,6,7,8};
        System.out.println(isSorted(arr));
    }
    public static boolean isSorted(int[] arr){
        int n = arr.length;
        if(arr==null){
            throw new IllegalArgumentException("Array is null");
        }
        for(int i=1; i<n-1; i++){
            if(arr[i]<arr[i-1]){
                return false;
            }
        }
        return true;
    }
}