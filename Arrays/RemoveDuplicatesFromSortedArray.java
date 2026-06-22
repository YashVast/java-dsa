import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromSortedArray {
    // public static void main(String args[]){
    //     int[] arr = {1,1,2,2,3,3,4,4,5,5};

    //     int[] result = removeDuplicates(arr);
        
    //     for(int num:result){
    //         System.out.print(num+" ");
    //     }
    // }
    // public static int[] removeDuplicates(int[] arr){
    //     Set<Integer> set = new HashSet<>();

    //     for(int num:arr){
    //         set.add(num);
    //     }
    //     int[] result = new int[set.size()];
    //     int index = 0;
        
    //     for(int num:set){
    //         result[index++] = num;
    //     }
    //     return result;
    // }

    //OPTIMAL --> TC: O(n) SC: O(1)
    public static void main(String args[]){
        int[] arr = {1,1,2,2,3,3,4,4,5,5};
        int index = remove(arr);

        for(int i=0; i<index; i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static int remove(int[] arr){
        int n = arr.length;
        int index = 0;

        for(int i=1; i<n; i++){
            if(arr[i]!= arr[index]){
                arr[index+1] = arr[i];
                index++;
            }
        }
        return index+1;
    }
}
