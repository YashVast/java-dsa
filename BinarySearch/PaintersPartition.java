public class PaintersPartition{
    // BRUTE FORCE -->
    // TC: O(n * maxSum-low+1)+O(2n)
    // SC: O(1)
    // public static void main(String[] args){
    //     int[] arr = {10,20,30,40};
    //     int k = 2;
    //     System.out.println(minPartition(arr,k));
    // }
    // public static int minPartition(int[] arr, int k){
    //     int n = arr.length;
    //     if(n<k){
    //         return -1;
    //     }
    //     int low = findLow(arr);
    //     int high = findHigh(arr);

    //     for(int i=low; i<=high; i++){
    //         int countMin = func(arr,i);
    //         if(countMin<=k){
    //             return i;
    //         }
    //     }
    //     return -1;
    // }
    // public static int func(int[] arr, int minWall){
    //     int n = arr.length;
    //     int painter = 1;
    //     int last = 0;

    //     for(int i=0; i<n; i++){
    //         if(last+arr[i]<=minWall){
    //             last += arr[i];
    //         }
    //         else{
    //             painter++;
    //             last = arr[i];
    //         }
    //     }
    //     return painter;
    // }
    // public static int findLow(int[] arr){
    //     int max = Integer.MIN_VALUE;
    //     for(int num: arr){
    //         max = Math.max(max,num);
    //     }
    //     return max;
    // }
    // public static int findHigh(int[] arr){
    //     int max = 0;
    //     for(int num: arr){
    //         max += num;
    //     }
    //     return max;
    // }


    // OPTIMAL -->
    // TC: O(n * log (maxSum-low+1))+O(2n)
    // SC: O(1)
    public static void main(String[] args){
        int[] arr = {10,20,30,40};
        int k = 2;
        System.out.println(minPartition(arr,k));
    }
    public static int minPartition(int[] arr, int k){
        int n = arr.length;
        if(n<k){
            return -1;
        }
        int low = findLow(arr);
        int high = findHigh(arr);
        int ans = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            int countMin = func(arr,mid);
            if(countMin<=k){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    public static int func(int[] arr, int minWall){
        int n = arr.length;
        int painter = 1;
        int last = 0;

        for(int i=0; i<n; i++){
            if(last+arr[i]<=minWall){
                last += arr[i];
            }
            else{
                painter++;
                last = arr[i];
            }
        }
        return painter;
    }
    public static int findLow(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int num: arr){
            max = Math.max(max,num);
        }
        return max;
    }
    public static int findHigh(int[] arr){
        int max = 0;
        for(int num: arr){
            max += num;
        }
        return max;
    }
}