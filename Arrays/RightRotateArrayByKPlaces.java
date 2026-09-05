public class RightRotateArrayByKPlaces {
    // TC: O(n-k)+O(n-k)+O(k) --> O(n+k) 
    // SC: O(k) 
    // public static void main(String args[]){
    //     int[] arr = {1,2,3,4,5,6,7};
    //     int k = 3;
    //     rightRotate(arr,k);
    //     for(int x: arr){
    //         System.out.print(x+" ");
    //     }
    // }
    // public static void rightRotate(int[] arr, int k){
    //     int n = arr.length;
    //     k = k%n; 
    //     int[] temp = new int[k];
    //     int index = 0;
    //     for(int i=n-k; i<n; i++){
    //         temp[index++] = arr[i];
    //     }
    //     //here's the cathc we have to move from right to left not left to right
    //     for(int i = n-k-1; i >= 0; i--){
    //         arr[i+k] = arr[i];
    //     }
    //     for(int i=0; i<k; i++){
    //         arr[i] = temp[i];
    //     }
    // }

    // TC: O(n)+O(n-k)+O(k) --> O(n+k)
    // SC: O(1)
    public static void main(String args[]){
        int[] arr = {1,2,3,4,5,6,7,8};
        int d = 3;
        leftRotate(arr,d);

        for(int x: arr){
            System.out.print(x+" ");
        }
    }
    public static void leftRotate(int[] arr, int d){
        int n = arr.length;
        d = d%n;

        reverse(arr,0,n-1);
        reverse(arr,0,d-1);
        reverse(arr,d,n-1);
    }
    public static void reverse(int[] arr,int start,int end){
        while(start<end){
            int temp= arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
