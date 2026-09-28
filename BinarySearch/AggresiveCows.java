
import java.util.Arrays;

public class AggresiveCows{
    // BRUTE FORCE -->
    // TC: O(n log n)+ O(n*(max-min+1))
    // SC: O(1)
    // public static void main(String[] args){
    //     int[] arr = {0,3,4,7,10,9};
    //     int cows = 4;
    //     System.out.println(minDistance(arr,cows));
    // }
    // public static int minDistance(int[] arr, int cows){
    //     int n = arr.length;
    //     if(n<cows){
    //         return -1;
    //     }
    //     Arrays.sort(arr);
    //     int low = 1;
    //     int high = arr[n-1];
    //     int ans = -1;
    //     for(int i=low; i<=high; i++){
    //         if(canWePlace(arr,i,cows) == true){
    //             ans = i;
    //         }
    //     }
    //     return ans;
    // }
    // public static boolean canWePlace(int[] arr, int minDistance, int cows){
    //     int n = arr.length;
    //     int position = arr[0];
    //     int countCows = 1;

    //     for(int i=1; i<n; i++){
    //         if(arr[i]-position>=minDistance){
    //             countCows++;
    //             position = arr[i];
    //         }
    //         if(countCows>=cows){
    //             return true;
    //         }
    //     }
    //     return false;
    // }


    // OPTIMAL -->
    // TC: O(n log n)+ O(n* log (max-min+1))
    // SC: O(1)
    public static void main(String[] args){
        int[] arr = {0,3,4,7,10,9};
        int cows = 4;
        System.out.println(minDistance(arr,cows));
    }
    public static int minDistance(int[] arr, int cows){
        int n = arr.length;
        if(n<cows){
            return -1;
        }
        Arrays.sort(arr);
        int low = 1;
        int high = arr[n-1];
        int ans = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(canWeplace(arr,mid,cows) == true){
                ans = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }
    public static boolean canWeplace(int[] arr, int minDistance, int cows){
        int n = arr.length;
        int countCows = 1;
        int lastPosition = arr[0];

        for(int i=1; i<n; i++){
            if(arr[i]-lastPosition>=minDistance){
                countCows++;
                lastPosition = arr[i];
            }
            if(countCows>= cows){
                return true;
            }
        }
        return false;
    }
}