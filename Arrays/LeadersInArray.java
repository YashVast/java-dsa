import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class LeadersInArray{

    //BRUTE FORCE --> TC: O(n2) SC: O(n)
    // public static void main(String args[]){
    //     int[] arr = {10,22,12,3,0,6};
    //     List<Integer> list = leaders(arr);
        
    //     for(int i=0; i<list.size(); i++){
    //         System.out.print(list.get(i)+" ");
    //     }
    // }
    // public static List<Integer> leaders(int[] arr){
    //     int n = arr.length;
    //     List<Integer> list = new ArrayList<>();
    //     boolean leader = false;

    //     for(int i=0; i<n; i++){
    //         leader = true;
    //         for(int j=i+1; j<n; j++){
    //             if(arr[j]>arr[i]){
    //                 leader = false;
    //                 break;
    //             }
    //         }
    //         if(leader==true){
    //             list.add(arr[i]);
    //         }
    //     }
    //     return list;
    // }

    //OPTIMAL --> TC: O(n)+ Depends if asked more SC: O(n)
    public static void main(String args[]){
        int[] arr = {10,22,12,3,0,6};
        List<Integer> list = leaders(arr);
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i)+ " ");
        }
    }
    public static List<Integer> leaders(int[] arr){
        int n = arr.length;
        List<Integer> list = new ArrayList<>();
        int maximum = Integer.MIN_VALUE;
        for(int i=n-1; i>=0; i--){
            if(arr[i]>maximum){
                list.add(arr[i]);
            }
            maximum = Math.max(maximum,arr[i]);
        }
        //if asked to sort then do this
        //TC: O(n log n)
        // Collections.sort(list);

        //if asked to print in order preserved
        //TC: O(n)
        // Collections.reverse(list);
        
        return list;
    }
}