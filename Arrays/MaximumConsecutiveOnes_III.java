public class MaximumConsecutiveOnes_III {
    //TC: O(n)+O(n) 
    //SC: O(1)
    public static void main(String args[]){
        int[] arr = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println(maxConsecutiveOnes(arr,k));
    }
    public static int maxConsecutiveOnes(int[] arr, int k){
        int n = arr.length;
        int left = 0;
        int right = 0;
        int maxCounter = 0;
        int zeroCounter = 0;

        //TC: O(n)
        while(right<n){
            if(arr[right] == 0){
                zeroCounter++;
            }
            //TC: O(n)
            while(zeroCounter>k){
                if(arr[left] == 0){
                    zeroCounter--;
                }
                left++;
            }
            maxCounter = Math.max(maxCounter,right-left+1);
            right++;
        }
        return maxCounter;
    }
}
