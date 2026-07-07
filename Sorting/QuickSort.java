public class QuickSort{
    //TC: O(n log n) SC: O(1)
    public static void main(String args[]){
        int[] arr = {4,6,2,5,7,9,1,3};
        int n = arr.length;
        int low = 0;
        int high = n-1;
        quickSort(arr,low,high);

        for(int x: arr){
            System.out.print(x +" ");
        }
    }
    public static void quickSort(int[] arr, int low, int high){
        if(low<high){
            int partitionIndex = parition(arr,low,high);
            quickSort(arr,low,partitionIndex-1);
            quickSort(arr, partitionIndex+1, high);
        }
    }
    public static int parition(int[] arr, int low, int high){
        int pivot = arr[low];
        int i= low;
        int j= high;

        while(i<j) { 
            while(i<=high-1 && arr[i]<=pivot){
                i++;
            }
            while(j>=low+1 && arr[j]>pivot ){
                j--;
            }
            if(i<j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        } 
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        return j;
    }
}