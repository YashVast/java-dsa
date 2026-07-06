public class CountInversions{

    //BRUTE FORCE --> TC: O(n2) SC: O(1)
    // public static void main(String args[]){
    //     int[] arr = {5,3,2,4,1};
    //     System.out.println(countInversions(arr));
    // }
    // public static int countInversions(int[] arr){
    //     int n = arr.length;
    //     int count = 0;

    //     for(int i=0; i<n; i++){
    //         int num = arr[i];
    //         for(int j=i+1; j<n; j++){
    //             if(arr[j]<num){
    //                 count++;
    //             }
    //         }
    //     }
    //     return count;
    // }

    //OPTIMAL --> TC: O(n log n) Sc: O(n)
    public static void main(String args[]){
        int[] arr = {5,3,2,4,1};
        System.out.println(countInversions(arr));
    }
    public static int countInversions(int[] arr){
        int n = arr.length;
        return mergeSort(arr,0,n-1);
    }
    public static int mergeSort(int[] arr, int low, int high){
        int count = 0;
        if(low>=high){
            return count;
        }
        int mid = (low+high)/2;
        count += mergeSort(arr, low, mid);
        count += mergeSort(arr,mid+1,high);
        count += merge(arr,low,mid,high);
        return count;
    }
    public static int merge(int[] arr, int low, int mid, int high){
        int[] temp = new int[high-low+1];
        int left = low;
        int right = mid+1;
        int index = 0;
        int count = 0;

        while(left <= mid && right <= high){
            if(arr[left]<= arr[right]){
                temp[index++] = arr[left];
                left++;
            }
            else{
                temp[index++] = arr[right];
                count += mid-left+1;
                right++;
            }
        }
        while(left<= mid){
            temp[index++] = arr[left];
            left++;
        }
        while(right<= high){
            temp[index++] = arr[right];
            right++;
        }
        for(int i=low; i<=high; i++){
            arr[i] = temp[i-low];
        }
        return count;
    }
}



//GLOBAL VARIABLE(AVOID IT)
// static int count = 0; public static void main(String args[]){ int[] arr = {5,3,2,4,1}; System.out.println(countInversions(arr)); } public static int countInversions(int[] arr){ int n = arr.length; mergeSort(arr,0,n-1); return count; } public static void mergeSort(int[] arr, int low, int high){ int mid = (low-high)/2; mergeSort(arr, low, mid); mergeSort(arr,mid+1,high); merge(arr,low,mid,high); } public static void merge(int[] arr, int low, int mid, int high){ int[] temp = new int[high-low+1]; int left = low; int right = mid+1; int index = 0; while(left <= mid && right <= high){ if(arr[left]<= arr[right]){ temp[index++] = arr[left]; left++; } else{ temp[index++] = arr[right]; count += mid-left+1; right++; } } while(left<= mid){ temp[index++] = arr[left]; left++; } while(right<= high){ temp[index++] = arr[right]; right++; } for(int i=low; i<=high; i++){ arr[i] = temp[i-low]; } }