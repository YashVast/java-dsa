import java.util.*;

public class MinimiseMaxDistanceBetweenGasStations{
    // BRUTE FORCE -->
    // TC: O(n*k)+O(n)
    // SC: O(n-1)
    // public static void main(String[] args){
    //     int[] arr = {1,13,17,23};
    //     int k = 5;
    //     System.out.println(minimumDistance(arr,k));
    // }
    // public static double minimumDistance(int[] arr, int k){
    //     int n = arr.length;
    //     int[] howMany = new int[n-1];

    //     for(int gasStation=1; gasStation<=k; gasStation++){
    //         double maxSection = -1;
    //         int maxIndex = -1;

    //         for(int i=0; i<n-1; i++){
    //             double diff = arr[i+1]-arr[i];
    //             double sectionLength = diff/(howMany[i]+1); 

    //             if(sectionLength>maxSection){
    //                 maxSection = sectionLength;
    //                 maxIndex = i;
    //             }
    //         }
    //         howMany[maxIndex]++;
    //     }
    //     double maxAns = -1;
    //     for(int i=0; i<n-1; i++){
    //         double diff = arr[i+1]-arr[i];
    //         double sectionLength = diff/(howMany[i]+1);

    //         maxAns = Math.max(maxAns,sectionLength);
    //     }
    //     return maxAns;
    // }

    // BETTER -->
    // TC: O(k log n)+O(n log n)
    // SC: O(n-1)*2
    public static void main(String[] args){
        int[] arr = {1,13,17,23};
        int k = 5;
        System.out.println(minimumDistance(arr,k));
    }
    public static double minimumDistance(int[] arr, int k) {

        int n = arr.length;

        int[] howMany = new int[n - 1];

        // Max Heap
        // Stores: {currentSectionLength, sectionIndex}
        PriorityQueue<double[]> pq =
                new PriorityQueue<>(
                        (a, b) -> Double.compare(b[0], a[0])
                );

        // Put all original sections into PQ
        for (int i = 0; i < n - 1; i++) {

            double diff = arr[i + 1] - arr[i];

            pq.offer(new double[]{diff, i});
        }

        // Place k gas stations
        for (int gasStation = 1; gasStation <= k; gasStation++) {

            // Get largest current section
            double[] top = pq.poll();

            double sectionLength = top[0];
            int sectionIndex = (int) top[1];

            // Put one station in this section
            howMany[sectionIndex]++;

            // Original length of this section
            double diff =
                    arr[sectionIndex + 1] - arr[sectionIndex];

            // Recalculate its current maximum distance
            double newSectionLength =
                    diff / (howMany[sectionIndex] + 1.0);

            // Put updated section back
            pq.offer(new double[]{
                    newSectionLength,
                    sectionIndex
            });
        }

        // Largest section remaining
        return pq.peek()[0];
    }
}