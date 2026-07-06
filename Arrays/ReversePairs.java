public class ReversePairs{

    //BRUTE FORCE --> TC: O(n2) SC: O(1)
    public static void main(String args[]){
        int[] arr = {40,25,19,12,9,6,2};
        System.out.println(reversePairs(arr));
    }
    public static int reversePairs(int[] arr){
        int n = arr.length;
        int count = 0;

        for(int i=0; i<n; i++){
            int num = arr[i];
            for(int j=i+1; j<n; j++){
                if(num> 2*arr[j]){
                    count++;
                }
            }
        }
        return count;
    }
}