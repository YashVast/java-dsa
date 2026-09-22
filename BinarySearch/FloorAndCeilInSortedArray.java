// Floor = largest no. in array <= x 
// Ceil = smallest no. in array >= x

public class FloorAndCeilInSortedArray {
    public static void main(String[] args){
        int[] arr = {10,20,30,40,50};
        // int[] arr = {10,20,25,40,50};
        int x = 25;
        int[] result = floorAndCeil(arr,x);

        for(int num: result){
            System.out.print(num+" ");
        }
    }
    public static int[] floorAndCeil(int[] arr,int x){
        int ceil = findCeil(arr,x);
        int floor = findFloor(arr,x);
        return new int[]{floor,ceil};
    }
    public static int findCeil(int[] arr, int x){
        int n = arr.length;
        int low = 0;
        int high = n-1;
        int ceil = -1;

        while(low<=high){
            int mid = low+(high-low)/2;    
            if(arr[mid]>=x){
                ceil = mid;
                high = mid-1;
            }    
            else{
                low = mid+1;
            }
        }
        return ceil;
    }
    public static int findFloor(int[] arr, int x){
        int n = arr.length;
        int low = 0;
        int high = n-1;
        int floor = -1;

        while(low<=high){
            int mid = low+(high-low)/2;

            if(arr[mid]<=x){
                floor = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return floor; 
    }
}
