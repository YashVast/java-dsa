public class BookAllocation{
    // BRUTE FORCE -->
    // TC: O(2n)+O(n*(sumArr-maxArr+1))
    // SC: O(1)
    // public static void main(String[] args){
    //     int[] arr = {25,46,28,49,24};
    //     int students = 4;
    //     System.out.println(minBooks(arr,students));
    // }
    // public static int minBooks(int[] arr, int students){
    //     int low = maxArr(arr);
    //     int high = sumArr(arr);

    //     for(int i=low; i<=high; i++){
    //         int countSudents = func(arr,i);
    //         if(countSudents<=students){
    //             return i;
    //         }
    //     }
    //     return -1;
    // }
    // public static int func(int[] arr, int minPages){
    //     int n = arr.length;
    //     int countSudents = 1;
    //     int pagesStudent = 0;

    //     for(int i=0; i<n; i++){
    //         if(pagesStudent+arr[i]<=minPages){
    //             pagesStudent += arr[i];
    //         }
    //         else{
    //             countSudents++;
    //             pagesStudent = arr[i];
    //         }
    //     }
    //     return countSudents;
    // }
    // public static int maxArr(int[] arr){
    //     int max = Integer.MIN_VALUE;
    //     for(int x: arr){
    //         if(x>max){
    //             max = x;
    //         }
    //     }
    //     return max;
    // }
    // public static int sumArr(int[] arr){
    //     int sum = 0;
    //     for(int x: arr){
    //         sum += x;
    //     }
    //     return sum;
    // }


    // OPTIMAL -->
    // TC: O(2n)+O(n* log (sumArr-maxArr+1))
    // SC: O(1)
    public static void main(String[] args){
        int[] arr = {25,46,28,49,24};
        int students = 4;
        System.out.println(minBooks(arr,students));
    }
    public static int minBooks(int[] arr, int students){
        int low = maxArr(arr);
        int high = sumArr(arr);
        int ans = -1;

        while(low<=high){
            int mid = low+(high-low)/2;
            int countSudents = func(arr, mid);
            if(countSudents<=students){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    public static int func(int[] arr, int minPages){
        int n = arr.length;
        int countSudents = 1;
        int pagesStudent = 0;

        for(int i=0; i<n; i++){
            if(pagesStudent+arr[i]<=minPages){
                pagesStudent += arr[i];
            }
            else{
                countSudents++;
                pagesStudent = arr[i];
            }
        }
        return countSudents;
    }
    public static int maxArr(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int x: arr){
            if(x>max){
                max = x;
            }
        }
        return max;
    }
    public static int sumArr(int[] arr){
        int sum = 0;
        for(int x: arr){
            sum += x;
        }
        return sum;
    }
}