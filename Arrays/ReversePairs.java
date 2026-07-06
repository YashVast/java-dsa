public class ReversePairs{

    //BRUTE FORCE --> TC: O(n2) SC: O(1)
    // public static void main(String args[]){
    //     int[] arr = {40,25,19,12,9,6,2};
    //     System.out.println(reversePairs(arr));
    // }
    // public static int reversePairs(int[] arr){
    //     int n = arr.length;
    //     int count = 0;

    //     for(int i=0; i<n; i++){
    //         int num = arr[i];
    //         for(int j=i+1; j<n; j++){
    //             if(num> 2*arr[j]){
    //                 count++;
    //             }
    //         }
    //     }
    //     return count;
    // }


    //GLOBAL VARIABLE
    // static int count = 0;
    // public static void main(String args[]){
    //     int[] arr = {40,25,19,12,9,6,2};
    //     System.out.println(reversePairs(arr));
    // }
    // public static int reversePairs(int[] arr){
    //     int n = arr.length;
    //     int low = 0;
    //     int high = n-1;
    //     mergeSort(arr, low, high);
    //     return count;
    // }
    // public static void mergeSort(int[] arr, int low, int high){
    //     if(low>=high){
    //         return;
    //     }
    //     int mid = (low+high)/2;
    //     mergeSort(arr, low, mid);
    //     mergeSort(arr, mid+1, high);
    //     countPairs(arr,low,mid,high);
    //     merge(arr,low,mid,high);
    // }
    // public static void countPairs(int[] arr, int low, int mid, int high){
    //     int right = mid+1;
    //     for(int i=low; i<=mid; i++){
    //         while(right<= high && arr[i]> 2*arr[right]){
    //             right++;
    //         }
    //         count += (right - (mid+1));
    //     }

    // }
    // public static void merge(int[] arr, int low, int mid, int high){
    //     int left = low;
    //     int right = mid+1;
    //     int index = 0;
    //     int[] temp = new int[high-low+1];

    //     while(left<=mid && right<= high){
    //         if(arr[left]<= arr[right]){
    //             temp[index++] = arr[left];
    //             left++;
    //         }
    //         else{
    //             temp[index++] = arr[right];
    //             right++;
    //         }
    //     }
    //     while(left<=mid){
    //         temp[index++] = arr[left];
    //         left++;
    //     }
    //     while(right<= high){
    //         temp[index++] = arr[right];
    //         right++;
    //     }
    //     for(int i=low; i<=high; i++){
    //         arr[i] = temp[i-low];
    //     }
    // }


    //OPTIMAL --> TC: O(n log n) SC: O(n)
    public static void main(String args[]){
        int[] arr = {40,25,19,12,9,6,2};
        System.out.println(reversePairs(arr));
    }
    public static int reversePairs(int[] arr){
        int n = arr.length;
        int low = 0;
        int high = n-1;
        return mergeSort(arr, low, high);
    }
    public static int mergeSort(int[] arr, int low, int high){
        int count = 0;
        if(low>=high){
            return count;
        }
        int mid = (low+high)/2;
        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid+1, high);
        count += countPairs(arr,low,mid,high);
        merge(arr,low,mid,high);
        return count;
    }
    public static int countPairs(int[] arr, int low, int mid, int high){
        int right = mid+1;
        int count = 0;
        for(int i=low; i<=mid; i++){
            while(right<= high && arr[i]> 2*arr[right]){
                right++;
            }
            count += (right - (mid+1));
        }
        return count;
    }
    public static void merge(int[] arr, int low, int mid, int high){
        int left = low;
        int right = mid+1;
        int index = 0;
        int[] temp = new int[high-low+1];

        while(left<=mid && right<= high){
            if(arr[left]<= arr[right]){
                temp[index++] = arr[left];
                left++;
            }
            else{
                temp[index++] = arr[right];
                right++;
            }
        }
        while(left<=mid){
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
    }
}