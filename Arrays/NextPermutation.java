public class NextPermutation{
    //OPTIMAL --> TC: O(n)+O(n)+O(n) SC:O(1)
    public static void main(String args[]){
        int[] arr = {2,1,5,4,3,0,0};
        int[] result = nextPermutation(arr);
        for(int x:result){
            System.out.print(x+" ");
        }
    }
    public static int[] nextPermutation(int[] arr){
        int n = arr.length;
        int index = -1;
        for(int i=n-2; i>-0; i--){
            if(arr[i]<arr[i+1]){
                index = i;
                break;
            }
        }
        if(index == -1){
            reverse(arr,0,n-1);
        }
        for(int i=n-1; i>=0; i--){
            if(arr[i]>arr[index]){
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                break;
            }
        }
        reverse(arr,index+1,n-1);
        return arr;
    }
    public static void reverse(int[] arr, int start, int end){
        while(start<end){
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            start++;
            end--;
        }
    }
}