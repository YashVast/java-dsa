public class SelectionSort {

    //TC: O(n2) SC: O(1)
    public static void main(String args[]){
        int[] arr = {13,46,24,52,20,9};
        selectionSort(arr);

        for(int x : arr){
            System.out.print(x + " ");
        }
    }
    public static void selectionSort(int[] arr){
        int n = arr.length;
        for(int i=0; i<=n-2; i++){
            int minimum = i;
            for(int j=i+1; j<= n-1; j++){
                if(arr[j]<arr[minimum]){
                    minimum = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minimum];
            arr[minimum] = temp;
        }
    }
}
