import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {

    //BRUTE FORCE --> TC: O(n4) SC:O(no. of quads) * 2
    // public static void main(String args[]){
    //     int[] arr = {1,0,-1,0,-2,2};
    //     int target = 0;
    //     List<List<Integer>> list = fourSum(arr,target);

    //     for(List<Integer> ans : list){
    //         System.out.print(ans);
    //     }
    // }
    // public static List<List<Integer>> fourSum(int[] arr, int target){
    //     int n = arr.length;
    //     Set<List<Integer>> set = new HashSet<>();
    //     List<List<Integer>> list = new ArrayList<>();

    //     for(int i=0; i<n; i++){
    //         for(int j=i+1; j<n; j++){
    //             for(int k=j+1; k<n; k++){
    //                 for(int l=k+1; l<n; l++){
    //                     if(arr[i]+arr[j]+arr[k]+arr[l] == target){
    //                         List<Integer> temp = new ArrayList<>();
    //                         temp.add(arr[i]);
    //                         temp.add(arr[j]);
    //                         temp.add(arr[k]);
    //                         temp.add(arr[l]);
    //                         Collections.sort(temp);
    //                         set.add(temp);
    //                     }
    //                 }
    //             }
    //         }
    //     }

    //     for(List<Integer> l : set){
    //         list.add(l);
    //     }
    //     return list;
    // }

    //BETTER --> TC: O(n3) SC: O(n) + O(no. of quads) * 2
    // public static void main(String args[]){
    //     int[] arr = {1,0,-1,0,-2,2};
    //     int target = 0;

    //     List<List<Integer>> list = fourSum(arr, target);

    //     for(List<Integer> l : list){
    //         System.out.print(l);
    //     }
    // }
    // public static List<List<Integer>> fourSum(int[] arr, int target){
    //     int n = arr.length;
    //     Set<List<Integer>> set = new HashSet<>();
    //     List<List<Integer>> list = new ArrayList<>();

    //     for(int i=0; i<n; i++){
    //         for(int j=i+1; j<n; j++){
    //             Set<Integer> hashset = new HashSet<>();

    //             for(int k=j+1; k<n; k++){
    //                 int fourth = target - (arr[i]+arr[j]+arr[k]);
    //                 if(hashset.contains(fourth)){
    //                     List<Integer> temp = new ArrayList<>();
    //                     temp.add(arr[i]);
    //                     temp.add(arr[j]);
    //                     temp.add(arr[k]);
    //                     temp.add(fourth);
    //                     Collections.sort(temp);
    //                     set.add(temp);
    //                 }
    //                 hashset.add(arr[k]);
    //             }
    //             hashset.clear();
    //         }
    //     }
    //     for(List<Integer> l: set){
    //         list.add(l);
    //     }
    //     return list;
    // }

    //OPTIMAL --> TC: O(n2)*O(n) SC: O(no.quads)
    public static void main(String args[]){
        int[] arr = {1,1,1,2,2,2,3,3,3,4,4,4,5,5};
        int target = 8;

        List<List<Integer>> list = fourSum(arr, target);

        for(List<Integer> l : list){
            System.out.print(l);
        }
    }
    public static List<List<Integer>> fourSum(int[] arr, int target){
        Arrays.sort(arr);
        int n = arr.length;
        List<List<Integer>> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(i>0 && arr[i] == arr[i-1]) continue;
            for(int j=i+1; j<n; j++){
                if(j > i+1 && arr[j] == arr[j-1]) continue;
                int k = j+1;
                int l = n-1;
                
                while(k<l){
                    long sum = (long) arr[i]+arr[j]+arr[k]+arr[l];
                    if(sum == target){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        temp.add(arr[l]);
                        list.add(temp);
                        k++;
                        l--;
                        while(k<l && arr[k] == arr[k-1]) k++;
                        while(k<l && arr[l] == arr[l+1]) l--;
                    }
                    else if(sum < target){
                        k++;
                    }
                    else{
                        l--;
                    }
                }
            }
        }
        return list;
    }
}
