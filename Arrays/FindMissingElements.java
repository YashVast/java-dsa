import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindMissingElements {
    public static void main(String args[]){
        int[] arr = {1,4,2,5,9};
        List<Integer> result = missingElements(arr);

        for(int i=0; i<result.size(); i++){
            System.out.print(result.get(i)+ " ");
        }
    }
    public static List<Integer> missingElements(int[] arr){
        int n = arr.length;
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        set.add(arr[0]);
        int startingPoint = arr[0];
        int endingPoint = arr[0];

        for(int i=1; i<n; i++){
            set.add(arr[i]);
            if(arr[i]<startingPoint){
                startingPoint = arr[i];
            }
            if(arr[i]>endingPoint){
                endingPoint = arr[i];
            }
        }
        for(int i=startingPoint; i<endingPoint; i++){
            if(!set.contains(i)){
                list.add(i);
            }
        }
        return list;
    }
}
