public class BubbleSort {

    //TC: Average & Woorst Case - O(n2), Best Case - O(n) SC: O(1)
    public static void main(String args[]){
        int[] arr = {13,46,24,52,20,9};
        bubbleSort(arr);

        for(int x: arr){
            System.out.print(x+" ");
        }
    }
    public static void bubbleSort(int[] arr){
        int n = arr.length;
        boolean swapped = false;

        for(int i=0; i<n; i++){
            for(int j=0; j<n-i-1; j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                    swapped = true;
                }
            }
            if(swapped == false){
                break;
            }
        }
    }
}
