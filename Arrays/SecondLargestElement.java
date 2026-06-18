public class SecondLargestElement{
    //TC: O(n) SC: O(1)
    public static void main(String args[]){
        int[] arr = {1,2,3,4,5,6,7};
        System.out.println(secondLargest(arr));
    }
    public static int secondLargest(int[] arr){
        int n = arr.length;
        if(arr == null || n<=1){
            throw new IllegalArgumentException("Array length is less than 1 or null");
        }
        int largest = arr[0];
        int secondLargest = Integer.MIN_VALUE;

        for(int i=1; i<arr.length; i++){
            if(arr[i]>largest){
                secondLargest = largest;
                largest = arr[i];
            }
            else if(arr[i]>secondLargest && arr[i]!= largest){
                secondLargest = arr[i];
            }
        }
        if(secondLargest == Integer.MIN_VALUE){
            throw new IllegalArgumentException("No second distinct largest element exists");
        }
        return secondLargest;
    }
}