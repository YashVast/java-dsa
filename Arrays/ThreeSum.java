//sum will always be 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ThreeSum{

    //BRUTE FORCE --> TC: O(n3) SC: 2 * O(no.of triplets)
    // public static void main(String args[]){
    //     int[] arr = {-1,0,1,2,-1,-4};
    //     List<List<Integer>> list = threeSum(arr);

    //     for(List<Integer> triplet: list){
    //         System.out.print(triplet);
    //     }
    // }
    // public static List<List<Integer>> threeSum(int[] arr){
    //     int n = arr.length;
    //     List<List<Integer>> list = new ArrayList<>();
    //     Set<List<Integer>> set = new HashSet<>();

    //     for(int i=0; i<n; i++){
    //         for(int j=i+1; j<n; j++){
    //             for(int k=j+1; k<n; k++){
    //                 if(arr[i]+arr[j]+arr[k] == 0){
    //                 List<Integer> temp = new ArrayList<>();
    //                 temp.add(arr[i]);
    //                 temp.add(arr[j]);
    //                 temp.add(arr[k]);
    //                 Collections.sort(temp);
    //                 set.add(temp);
    //                 }
    //             }
    //         }
    //     }

    //     for(List<Integer> l : set){
    //         list.add(l);
    //     }

    //     return list;
    // }


    //BETTER --> TC:O(n2) SC: O(n)+ 2 * O(no.triplets)
    // public static void main(String args[]){
    //     int[] arr = {-1,0,1,2,-1,-4};
    //     List<List<Integer>> list = threeSum(arr);

    //     for(List<Integer> triplet: list){
    //         System.out.print(triplet);
    //     }
    // }
    // public static List<List<Integer>> threeSum(int[] arr){
    //     int n = arr.length;
    //     List<List<Integer>> list = new ArrayList<>();
    //     Set<List<Integer>> set = new HashSet<>();

    //     for(int i=0; i<n; i++){
    //         Set<Integer> hashset = new HashSet<>();
    //         hashset.clear();
    //         for(int j=i+1; j<n; j++){
    //             int third = -(arr[i]+arr[j]);
    //             if(hashset.contains(third)){
    //                 List<Integer> temp = new ArrayList<>();
    //                 temp.add(arr[i]);
    //                 temp.add(arr[j]);
    //                 temp.add(third);
    //                 Collections.sort(temp);
    //                 set.add(temp);
    //             }
    //             else{
    //                 hashset.add(arr[j]);
    //             }
    //         }
    //     }
    //     for(List<Integer> l : set){
    //         list.add(l);
    //     }
    //     return list;
    // }


    //OPTIMAL --> TC: O(n log n)+ O(n2) SC: O(no. of triplets)
    public static void main(String args[]){
        // int[] arr = {-1,0,1,2,-1,-4};
        int[] arr = {-2,-2,-2,-1,-1,-1,0,0,0,2,2,2,2};
        List<List<Integer>> list = threeSum(arr);

        for(List<Integer> triplet : list){
            System.out.print(triplet);
        }
    }
    public static List<List<Integer>> threeSum(int[] arr){
        Arrays.sort(arr);
        int n = arr.length;
        List<List<Integer>> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(i>0  && arr[i]==arr[i-1]){
                continue;
            }
            int j = i+1;
            int k = n-1;
            while(j<k){
                int sum = arr[i]+arr[j]+arr[k];
                if(sum<0){
                    j++;
                }
                else if(sum>0){
                    k--;
                }
                else{
                    List<Integer> temp = new ArrayList<>();
                    temp.add(arr[i]);
                    temp.add(arr[j]);
                    temp.add(arr[k]);
                    list.add(temp);
                    j++;
                    k--;
                    while(j<k && arr[j] == arr[j-1]) j++;
                    while(j<k && arr[k] == arr[k+1]) k--;
                }
            }
        }
        return list;
    }
}