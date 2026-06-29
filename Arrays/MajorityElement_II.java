
import java.util.ArrayList;
import java.util.List;



public class MajorityElement_II{
    //BRUTE FORCE --> TC: O(n2) SC: O(n)
    // public static void main(String args[]){
    //     int[] arr = {1,1,1,3,3,2,2,2};
    //     List<Integer> list = majorityElement(arr);

    //     for(int i=0; i<list.size(); i++){
    //         System.out.print(list.get(i)+ " ");
    //     }
    // }
    // public static List<Integer> majorityElement(int[] arr){
    //     int n = arr.length;
    //     List<Integer> list = new ArrayList<>();

    //     for(int i=0; i<n; i++){
    //         int counter = 0;
    //         int num = arr[i];
    //         for(int j=0; j<n; j++){
    //             if(arr[j]==num){
    //                 counter++;
    //             }
    //         }
    //         if(counter>n/3){
    //             if(!list.contains(num)) list.add(num);
    //         }
    //         if(list.size()>=2){
    //             break;
    //         }
    //     }
    //     return list;
    // }

    //BETTER --> TC: O(n)+O(n) SC: O(n)+O(n)
    // public static void main(String args[]){
    //     int[] arr = {1,1,1,3,3,2,2,2};
    //     List<Integer> list =  majorityElement(arr);

    //     for(int i=0; i<list.size(); i++){
    //         System.out.print(list.get(i)+" ");
    //     }
    // }
    // public static List<Integer> majorityElement(int[] arr){
    //     int n = arr.length;
    //     List<Integer> list = new ArrayList<>();
    //     Map<Integer,Integer> map = new HashMap<>();
    //     for(int i=0; i<n; i++){
    //         if(map.containsKey(arr[i])){
    //             map.put(arr[i], map.get(arr[i])+1);
    //         }
    //         else{
    //             map.put(arr[i], 1);
    //         }
    //     }
    //     for(int key: map.keySet()){
    //         if(map.get(key)>n/3){
    //             list.add(key);
    //         }
    //     }
    //     return list;
    // }


    //OPTIMAL --> TC: O(n)+O(n) SC: O(n)
    public static void main(String args[]){
        int[] arr = {1,1,1,3,3,2,2,2};
        List<Integer> list = majorityElement(arr);

        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i)+ " ");
        }
    }
    public static List<Integer> majorityElement(int[] arr){
        int n = arr.length;
        int count1 = 0;
        int element1 = 0;
        int count2 = 0;
        int element2 = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(count1 == 0 && arr[i]!=element2){
                count1++;
                element1 = arr[i];
            }
            else if(count2 == 0 && arr[i]!=element1){
                count2++;
                element2 = arr[i];
            }
            else if(arr[i]==element1){
                count1++;
            }
            else if(arr[i]==element2){
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;

        for(int i=0; i<n; i++){
            if(arr[i]==element1){
                count1++;
            }
            else if(arr[i]==element2){
                count2++;
            }
        }
        if(count1>n/3){
            list.add(element1);
        }
        if(count2>n/3){
            list.add(element2);
        }
        return list;
    }
}