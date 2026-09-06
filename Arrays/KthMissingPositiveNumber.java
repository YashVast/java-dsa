//Array will be in sorted fashion

public class KthMissingPositiveNumber {
    public static void main(String args[]){
        int[] arr = {2,3,4,7,11};
        int k = 5;
        System.out.println(kthMissingNumber(arr,k));
    }
    public static int kthMissingNumber(int[] arr, int k){
        for(int num:arr){
            if(num<=k){
                k++;
            }
            else{
                break;
            }
        }
        return k;
    }
}
