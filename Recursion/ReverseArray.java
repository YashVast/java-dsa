public class ReverseArray {
    //Parameterized way to do it.
    public static void main(String args[]){
        int[] arr = {1,2,3,4,5};
        int n = arr.length;
        reverse(0,n-1,arr);
        
        for(int x : arr){
            System.out.print(x + " ");
        }
    }
    public static void reverse(int left, int right,int[] arr){
        if(left>=right){
            return;
        }
        else{
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
            reverse(left,right,arr);
        }
    }
}
