import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String args[]){
        int[] arr = {1,1,2,2,3,3,4,4,5,5};

        int[] result = removeDuplicates(arr);
        
        for(int num:result){
            System.out.print(num+" ");
        }
    }
    public static int[] removeDuplicates(int[] arr){
        Set<Integer> set = new HashSet<>();

        for(int num:arr){
            set.add(num);
        }
        int[] result = new int[set.size()];
        int index = 0;
        
        for(int num:set){
            result[index++] = num;
        }
        return result;
    }
    
}
