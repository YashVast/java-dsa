public class MaximumConsecutiveOnes{
    //TC: O(n) SC: O(1)
    public static void main(String args[]){
        int[] arr = {1,1,0,0,1,1,1,0,2};
        System.out.println(maximumConsecutiveOnes(arr));
    }
    public static int maximumConsecutiveOnes(int[] arr){
        if(arr==null){
            throw new IllegalArgumentException("array is null");
        }
        int n = arr.length;
        int maxCounter = 0;
        int counter = 0;
        for(int i=0; i<n; i++){
            if(arr[i]==1){
                counter++;
                maxCounter = Math.max(counter,maxCounter);
            }
            else{
                counter = 0;
            }
        }
        return maxCounter;
    }
}