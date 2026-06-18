public class RemoveDuplicatesSortedArray{
    //TC: O(n) SC: O(1)
    public static void main(String args[]){
        int[] arr = {1,1,2,2,3,3,4,4,5,5};
        int index = removeDuplicates(arr);

        for(int i=0; i<=index; i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static int removeDuplicates(int[] arr){
        int n = arr.length;
        int index = 0;
        for(int i=1; i<n; i++){
            if(arr[i] != arr[index]){
                arr[index+1] = arr[i];
                index++;
            }
        }
        return index;
    }
}