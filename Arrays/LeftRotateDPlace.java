public class LeftRotateDPlace{
    //Brute Force --> TC: O(n+d) SC: O(d)
    // public static void main(String args[]){
    //     int[] arr = {1,2,3,4,5,6,7,8};
    //     int d = 3;
    //     rotateArray(arr,d);

    //     for(int num:arr){
    //         System.out.print(num+" ");
    //     }
    // }
    // public static void rotateArray(int[] arr, int d){
    //     if(arr==null){
    //         throw new IllegalArgumentException("array is null");
    //     }
    //     int n = arr.length;
    //     if(n==1){
    //         return;
    //     }
    //     d = d%n;

    //     int[] temp = new int[d];
    //     int counter = 0;
    //     for(int i=0; i<d; i++){
    //         temp[counter++] = arr[i];
    //     }

    //     for(int i=d; i<n; i++){
    //         arr[i-d] = arr[i];
    //     }
    //     int index = 0;
    //     for(int i=n-d; i<n; i++){
    //         arr[i] = temp[index++];
    //     }
    // }

    //Optimal--> TC: O(n) SC: O(1)
    public static void main(String args[]){
        int[] arr = {1,2,3,4,5,6,7,8};
        int d = 3;
        rotateArray(arr,d);

        for(int num:arr){
            System.out.print(num+" ");
        }
    }
    public static void rotateArray(int[] arr, int d){
        if(arr==null){
            throw new IllegalArgumentException("array is null");
        }
        int n = arr.length;
        if(n <= 1){
            return;
        }
        d = d%n;
        
        //Left Rotate Array
        reverse(arr,0,d-1);
        reverse(arr,d,n-1);
        reverse(arr,0,n-1);

        //Right Rotate Array
        // reverse(arr,0,n-1);
        // reverse(arr,0,d-1);
        // reverse(arr,d,n-1);
    }
    public static void reverse(int[] arr,int start, int end){
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}