//you can replace at most one 0 to 1

public class MaximumConsecutiveOnes_II {
    //TC: O(n) SC: O(1)
    public static void main(String args[]){
        int[] arr = {1,0,1,1,0};
        System.out.println(maxConsecutiveOnes(arr));
    }
    public static int maxConsecutiveOnes(int[] arr){
        int n = arr.length;
        int left = 0;
        int right = 0;
        int maxCounter = 0;
        int zeroCounter = 0;

        while(right<n){
            if(arr[right] == 0){
                zeroCounter++;
            }
            while(zeroCounter>1){
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
