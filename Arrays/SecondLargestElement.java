public class SecondLargestElement{
    // public static void main(String args[]){
    //     int[] arr = {13,34,56,7,2,22,46,66,99};

    //     System.out.println(secondLargest(arr));
    // }
    // public static int secondLargest(int[] arr){
    //     int n = arr.length;
    //     int largest = arr[0];
    //     int secondLargest = Integer.MIN_VALUE;

    //     for(int i=1; i<n; i++){
    //         if(arr[i]>largest){
    //             secondLargest = largest;
    //             largest = arr[i];
    //         }
    //         else if(arr[i]!=largest && arr[i]>secondLargest){
    //             secondLargest = arr[i];
    //         }
    //     }
    //     return secondLargest;
    // }


    public static void main(String args[]){
        int[] arr = {13,34,56,7,2,22,46,66,99};

        System.out.println(secondLargest(arr));
    }
    public static int secondLargest(int[] arr){
        int largest = arr[0];
        int secondLargest = Integer.MIN_VALUE;

        for(int i=1; i<arr.length; i++){
            if(arr[i]>largest){
                secondLargest = largest;
                largest = arr[i];
            }
            else if(arr[i]!=largest && arr[i]>secondLargest){
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }
}