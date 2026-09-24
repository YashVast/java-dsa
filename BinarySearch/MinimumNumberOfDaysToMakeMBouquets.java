public class MinimumNumberOfDaysToMakeMBouquets {
    // BRUTE FORCE -->
    // TC: O(n*d)+O(n)+O(n)
    // SC: O(1)
    // public static void main(String[] args){
    //     int[] bloomDay = {7,7,7,7,13,11,12,7};
    //     int m = 2;
    //     int k = 3;
    //     System.out.println(minimumDays(bloomDay,m,k));
    // }
    // public static int minimumDays(int[] bloomDay, int m, int k){
    //     int n = bloomDay.length;
    //     if(m*k>n){
    //         return -1;
    //     }
    //     int minBloomDay = minDays(bloomDay);
    //     int maxBloomDay = maxDays(bloomDay);
        
    //     for(int i=minBloomDay; i<=maxBloomDay; i++){
    //         if (canMake(bloomDay, m, k, i)) {
    //         return i;
    //         }
    //     }
    //     return -1;
    // }
    // public static boolean canMake(int[] bloomDay, int m, int k, int day) {
    //     int bouquet = 0;
    //     int counter = 0;

    //     for (int i = 0; i < bloomDay.length; i++) {
    //         if (bloomDay[i] <= day) {
    //             counter++;
    //             if (counter == k) {
    //                 bouquet++;
    //                 counter = 0;
    //             }
    //         } else {
    //             counter = 0;
    //         }
    //         if (bouquet >= m) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }
    // public static int minDays(int[] bloomDay){
    //     int minBloomDay = Integer.MAX_VALUE;
    //     for(int day: bloomDay){
    //         if(day<minBloomDay){
    //             minBloomDay = day;
    //         }
    //     }
    //     return minBloomDay;
    // }
    // public static int maxDays(int[] bloomDay){
    //     int maxBloomDay = Integer.MIN_VALUE;
    //     for(int day: bloomDay){
    //         if(day>maxBloomDay){
    //             maxBloomDay = day;
    //         }
    //     }
    //     return maxBloomDay;
    // }

    // OPTIMAL -->
    // TC: O(n log d)+O(2n)
    // SC: O(1)
    public static void main(String[] args){
        int[] bloomDay = {7,7,7,7,13,11,12,7};
        int m = 2;
        int k = 3;
        System.out.println(minimumDays(bloomDay,m,k));
    }
    public static int minimumDays(int[] bloomDay, int m, int k){
        int n = bloomDay.length;
        if(m*k>n){
            return -1;
        }
        int minBloomDay = minDays(bloomDay);
        int maxBloomDay = maxDays(bloomDay);
        int low = minBloomDay;
        int high = maxBloomDay;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canMake(bloomDay, m, k, mid)) {
                ans = mid;
                high = mid - 1; // Try an earlier day
            } else {
                low = mid + 1; // Need more days
            }
        }
        return ans;
    }
    public static int minDays(int[] bloomDay){
        int minBloomDay = Integer.MAX_VALUE;
        for(int day: bloomDay){
            if(day<minBloomDay){
                minBloomDay = day;
            }
        }
        return minBloomDay;
    }
    public static int maxDays(int[] bloomDay){
        int maxBloomDay = Integer.MIN_VALUE;
        for(int day: bloomDay){
            if(day>maxBloomDay){
                maxBloomDay = day;
            }
        }
        return maxBloomDay;
    }
    public static boolean canMake(int[] bloomDay, int m, int k, int day) {
        int bouquet = 0;
        int counter = 0;

        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                counter++;

                if (counter == k) {
                    bouquet++;
                    counter = 0;
                }
            } else {
                counter = 0;
            }

            if (bouquet >= m) {
                return true;
            }
        }
        return false;
    }
}
