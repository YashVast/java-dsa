

public class KthSmallestProduct{
    // BRUTE FORCE -->
    // TC: O(n1*n2)+O(n log n)
    // SC: O(n)
    // public static void main(String[] args){
    //     int[] arr1 = {2,5};
    //     int[] arr2 = {3,4};
    //     long k = 2;
    //     System.out.println(kthSmallestProduct(arr1,arr2,k));
    // }
    // public static long kthSmallestProduct(int[] arr1, int[] arr2, long k){
    //     int n1 = arr1.length;
    //     int n2 = arr2.length;
    //     List<Long> productList = new ArrayList<>();
    //     for(int i=0; i<n1; i++){
    //         for(int j=0; j<n2; j++){
    //             long product = arr1[i]*arr2[j];
    //             productList.add(product);
    //         }
    //     }
    //     Collections.sort(productList);
    //     return (long)productList.get((int)k-1);
    // }


    // BETTER -->
    // TC: O(n1*n2 * log k)
    // SC: O(k)
    // public static void main(String[] args){
    //     int[] arr1 = {2,5};
    //     int[] arr2 = {3,4};
    //     long k = 2;
    //     System.out.println(kthSmallestProduct(arr1,arr2,k));
    // }
    // public static long kthSmallestProduct(int[] arr1, int[] arr2, long k){
    //     int n1 = arr1.length;
    //     int n2 = arr2.length;
    //     PriorityQueue<Long> queue = new PriorityQueue<>(Collections.reverseOrder());

    //     for(int i=0; i<n1; i++){
    //         for(int j=0; j<n2; j++){
    //             long product = (long)arr1[i]*arr2[j];
    //             if(queue.size()<k){
    //                 queue.offer(product);
    //             }
    //             else if(product < queue.peek()){
    //                 queue.poll();
    //                 queue.offer(product);
    //             }
    //         }
    //     }
    //     return queue.peek();
    // }


    // OPTIMAL -->
    // TC: O((n1 + n2) · log R)
    // SC: O(1)
    public static void main(String[] args){
        int[] arr1 = {2,5};
        int[] arr2 = {3,4};
        long k = 2;
        System.out.println(kthSmallestProduct(arr1,arr2,k));
    }
    public static long kthSmallestProduct(int[] nums1, int[] nums2, long k){
        long lo = -10_000_000_000L, hi = 10_000_000_000L;

        while (lo < hi) {
            long mid = lo + ((hi - lo) >> 1);
            if (count(nums1, nums2, mid) >= k) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
    // number of pairs (a, b) with a * b <= x, in O(n1 + n2)
    public static long count(int[] nums1, int[] nums2, long x) {
        int n2 = nums2.length;
        // For x >= 0 the pointers sweep left from the end; for x < 0 they sweep right from the start.
        int neg = (x >= 0) ? n2 : 0;   // pointer used for a < 0
        int pos = neg;                 // pointer used for a > 0
        long c = 0;

        for (int a : nums1) {          // nums1 is ascending: negatives, zeros, positives
            if (a < 0) {
                // valid b's form a suffix: [neg, n2)
                if (x >= 0) {
                    while (neg > 0 && (long) a * nums2[neg - 1] <= x) neg--;
                } else {
                    while (neg < n2 && (long) a * nums2[neg] > x) neg++;
                }
                c += n2 - neg;
            } else if (a > 0) {
                // valid b's form a prefix: [0, pos)
                if (x >= 0) {
                    while (pos > 0 && (long) a * nums2[pos - 1] > x) pos--;
                } else {
                    while (pos < n2 && (long) a * nums2[pos] <= x) pos++;
                }
                c += pos;
            } else if (x >= 0) {
                c += n2;               // a == 0, product is 0
            }
        }
        return c;
    }
}