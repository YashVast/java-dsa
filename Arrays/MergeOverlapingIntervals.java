
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlapingIntervals{

    //BRUTE FORCE --> TC: O(n log n)+O(n2) SC: O(n)
    // public static void main(String args[]){
    //     int[][] arr = {{1,3},{2,6},{8,9},{9,11},{8,10},{2,4},{15,18},{16,17}};
    //     List<List<Integer>> result = mergeIntervals(arr);       

    //     for(List<Integer> l : result){
    //         System.out.println(l);
    //     }
    // }
    // public static List<List<Integer>> mergeIntervals(int[][] arr){
    //     int n = arr.length;
    //     Arrays.sort(arr, (a,b) -> Integer.compare(a[0], b[0]));
    //     List<List<Integer>> list = new ArrayList<>();

    //     for(int i=0; i<n; i++){
    //         int start = arr[i][0];
    //         int end = arr[i][1];
    //         if(!list.isEmpty() && start <= list.get(list.size()-1).get(1)){
    //             continue;
    //         }
    //         for(int j=i+1; j<n; j++){
    //             if(arr[j][0] <=end){
    //                 end = Math.max(end,arr[j][1]);
    //             }
    //             else{
    //                 break;
    //             }
    //         }
    //         list.add(Arrays.asList(start,end));
    //     }
    //     return list;
    // }

    //OPTIMAL --> TC: O(n og n)+ O(n) SC: O(n)
    public static void main(String args[]){
        int[][] arr = {{1,3},{2,6},{8,9},{9,11},{8,10},{2,4},{15,18},{16,17}};
        List<List<Integer>> result = mergeIntervals(arr);

        for(List<Integer> l : result){
            System.out.println(l);
        }
    }
    public static List<List<Integer>> mergeIntervals(int[][] arr){
        int n = arr.length;
        Arrays.sort(arr, (a,b) -> Integer.compare(a[0], b[0]));
        List<List<Integer>> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(list.isEmpty() || arr[i][0] > list.get(list.size()-1).get(1)){
                list.add(Arrays.asList(arr[i][0],arr[i][1]));
            }
            else{
                List<Integer> last = list.get(list.size()-1);
                last.set(1,Math.max(last.get(1), arr[i][1]));
            }
        }
        return list;
    }
}