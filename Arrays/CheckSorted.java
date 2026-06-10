public class CheckSorted {
    public static void main(String args[]){
        int[] arr = {1,2,3,4,5,6};

        System.out.println(checkIsSorted(arr));
    }
    public static boolean checkIsSorted(int[] arr){
        if(arr.length==0 || arr.length==1){
            return true;
        }

        for(int i=0; i<arr.length-1; i++){
            if(arr[i]>arr[i+1]){
                return false;
            }
        }
        return true;
    }
}
