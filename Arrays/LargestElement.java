public class LargestElement{
    //TC --> O(n)  SC --> O(1)
    public static void main(String args[]){
        int[] arr = {13,34,56,7,2,22,46,66,99};
        System.out.println(largestElement(arr));
    }
    public static int largestElement(int[] arr){
        int largest = arr[0];
        int n = arr.length;
        for(int i=1; i<n; i++){
            if(arr[i]>largest){
                largest = arr[i];
            }
        }
        return largest;
    }
}