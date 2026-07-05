public class InsertionSort {

    //TC: Best Case - O(n), Average & Worst Case - O(n2) SC: O(1) 
    public static void main(String args[]){
        int[] arr = {14,9,15,12,6,8,13};
        insertionSort(arr);

        for(int x : arr){
            System.out.print(x+ " ");
        }
    }
    public static void insertionSort(int[] arr){
        int n = arr.length;
        for(int i=0; i<n; i++){
            int j=i;
            while(j>0 && arr[j-1]>arr[j]){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
    }
}
