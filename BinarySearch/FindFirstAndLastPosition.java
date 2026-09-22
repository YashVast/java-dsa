public class FindFirstAndLastPosition{

    // BRUTE FORCE -->
    // TC: O(n)
    // SC: O(1)
    // public static void main(String[] args){
    //     int[] arr = {2,4,6,8,8,8,11,13};
    //     int x = 8;
    //     int[] result = firstAndLast(arr,x);

    //     for(int num: result){
    //         System.out.print(num+" ");
    //     }
    // }
    // public static int[] firstAndLast(int[] arr, int x){
    //     int n = arr.length;
    //     int first = -1;
    //     int last = -1;
    //     for(int i=0; i<n; i++){
    //         if(arr[i] == x && first == -1){
    //             first = i;
    //             last = i;
    //         }
    //         else if(arr[i] == x){
    //             last = i;
    //         }
    //     }
    //     return new int[]{first,last};
    // }

    // TC: 2 * O(log n)
    // SC: O(1)

    public static void main(String[] args){
        int[] arr = {2,4,6,8,8,8,11,13};
        int x = 8;
        int[] result = firstAndLast(arr,x);

        for(int num: result){
            System.out.print(num+" ");
        }
    }
    public static int[] firstAndLast(int[] arr, int x){
        int first = firstElement(arr,x);
        if(first == -1){
            return new int[]{-1,-1};
        }
        int last = lastElement(arr,x);

        return new int[]{first,last};
    }
    public static int firstElement(int[] arr, int x){
        int n = arr.length;
        int low = 0;
        int high = n-1;
        int first = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid] == x){
                first = mid;
                high = mid-1;
            }
            else if(arr[mid]<x){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return first;
    }
    public static int lastElement(int[] arr, int x){
        int n = arr.length;
        int low = 0;
        int high = n-1;
        int last = -1;

        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid] == x){
                last = mid;
                low = mid+1;
            }
            else if(arr[mid]<x){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return last;
    }
}