//piles[] can be unsorted also

public class KokoEatingBananas {
    // BRUTE FORCE --> 
    // TC: O(n)+O(n^2)
    // SC: O(1)
    // public static void main(String[] args){
    //     int[] piles = {3,6,7,11};
    //     int h = 8;
    //     System.out.println(minNumberOfBananas(piles,h));
    // }
    // public static int minNumberOfBananas(int[] piles, int h){
    //     int n = piles.length;
    //     if (h < n) {
    //         return -1;
    //     }
    //     int maxPile = 0;
    //     for (int pile : piles) {
    //         maxPile = Math.max(maxPile, pile);
    //     }
    //     for (int k = 1; k <= maxPile; k++) {
    //         long minHours = 0;
    //         for (int i = 0; i < n; i++) {
    //             minHours += (int)Math.ceil((double)piles[i] / k);
    //         }
    //         if (minHours <= h) {
    //             return k;
    //         }
    //     }
    //     return -1;
    // }

    // OPTIMAL --> 
    // TC: O(n)* O(log maxElement)+O(n)
    // SC: O(1)
    public static void main(String[] args){
        int[] piles = {3,6,7,11};
        int h = 8;
        System.out.println(minNumberOfBananas(piles,h));
    }
    public static int minNumberOfBananas(int[] piles, int h){
        int n = piles.length;
        if(h<n){
            return -1;
        }
        int maxPile = Integer.MIN_VALUE;
        for(int pile: piles){
            if(pile>maxPile){
                maxPile = pile;
            }
        }
        int low = 1;
        int high = maxPile;
        int ans = 0;
        while(low<=high){
            int mid = low+(high-low)/2;
            long totalHours = claculateTotalHours(piles,mid);
            if(totalHours<= h){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    public static long claculateTotalHours(int[] piles,int mid){
       long totalHours = 0;
       int n = piles.length;

       for(int i=0; i<n; i++){
            totalHours += (int)Math.ceil((double)piles[i]/mid);
       }
       return totalHours;
    }
}
