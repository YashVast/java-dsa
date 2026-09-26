public class LeastCapacityToShipPackagesWithinDDays{
    // BRUTE FORCE -->
    // TC: O(n)+O(n)+O((maxSum-maxWeight+1) * n)
    // SC: O(1)
    // public static void main(String[] args){
    //     int[] weights = {1,2,3,4,5,6,7,8,9,10};
    //     int days = 5;
    //     System.out.println(leastCapacity(weights,days));
    // }
    // public static int leastCapacity(int[] weights, int days){
    //     int maxWeight = maxWeight(weights);
    //     int maxSum = maxSum(weights);

    //     for(int capacity=maxWeight; capacity<=maxSum; capacity++){
    //         int daysReq = func(weights,capacity);
    //         if(daysReq<=days){
    //             return capacity;
    //         }
    //     }
    //     return -1;
    // }
    // public static int func(int[] weights, int capacity){
    //     int days = 1;
    //     int load = 0;
    //     for(int i=0; i<weights.length; i++){
    //         if(load + weights[i]>capacity){
    //             days++;
    //             load = weights[i];
    //         }
    //         else{
    //             load += weights[i];
    //         }
    //     }
    //     return days;
    // }
    // public static int maxWeight(int[] weights){
    //     int max = Integer.MIN_VALUE;
    //     for(int x: weights){
    //         if(x>max){
    //             max = x;
    //         }
    //     }
    //     return max;
    // }
    // public static int maxSum(int[] weights){
    //     int sum = 0;
    //     for(int x: weights){
    //         sum += x;
    //     }
    //     return sum;
    // }

    // Optimal -->
    // TC: O(n)+O(n)+O(log (maxRange-minRange+1) * n)
    // SC: O(1)
    public static void main(String[] args){
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        System.out.println(leastCapacity(weights,days));
    }
    public static int leastCapacity(int[] weights, int days){
        int minRange = minRange(weights);
        int maxRange = maxRange(weights);
        int ans = 0;
        int low = minRange;
        int high = maxRange;

        while(low<=high){
            int capacity = low+(high-low)/2;
            int reqDays = func(weights,capacity);
            if(reqDays<=days){
                ans = capacity;
                high = capacity-1;
            }
            else{
                low = capacity+1;
            }
        }
        return ans;
    }
    public static int func(int[] weights,int capacity){
        int days = 1;
        int load = 0;

        for(int i=0; i<weights.length; i++){
            if(load+weights[i]>capacity){
                days++;
                load = weights[i];
            }
            else{
                load += weights[i];
            }
        }
        return days;
    }
    public static int minRange(int[] weights){
        int max = Integer.MIN_VALUE;
        for(int x: weights){
            if(x>max){
                max = x;
            }
        }
        return max;
    }
    public static int maxRange(int[] weights){
        int sum = 0;
        for(int x: weights){
            sum += x;
        }
        return sum;
    }
}