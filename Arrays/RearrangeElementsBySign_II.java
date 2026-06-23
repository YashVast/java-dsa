import java.util.List;
import java.util.ArrayList;


public class RearrangeElementsBySign_II{
    //OPTIMAL --> TC:O(n)+O(n) SC: O(n)
    public static void main(String args[]){
        int[] arr = {-1,2,3,4,-3,1};
        reArrange(arr);

        for(int x:arr){
            System.out.print(x+" ");
        }
    }
    public static void reArrange(int[] arr){
        int n = arr.length;
        List<Integer> pList = new ArrayList<>();
        List<Integer> nList = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(arr[i]>0){
                pList.add(arr[i]);
            }
            else{
                nList.add(arr[i]);
            }
        }

        if(pList.size()>nList.size()){
            for(int i=0; i<nList.size(); i++){
                arr[2*i] = pList.get(i);
                arr[2*i+1] = nList.get(i);
            }
            int index = nList.size()*2;
            for(int i=nList.size(); i<pList.size(); i++){
                arr[index++] = pList.get(i);
            }
        }
        else{
            for(int i=0; i<pList.size(); i++){
                arr[2*i] = pList.get(i);
                arr[2*i+1] = nList.get(i);
            }
            int index = pList.size()*2;
            for(int i=pList.size(); i<nList.size(); i++){
                arr[index++] = nList.get(i);
            }
        }
    }
}