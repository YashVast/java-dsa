public class MedianOfTwoSortedArraysOfDifferentSizes{
    // BRUTE FORCE -->
    // TC: O(n+m)
    // SC: O(n+m)
    // public static void main(String[] args){
    //     int[] arr1 = {1,3,4,7,10,12};
    //     int[] arr2 = {2,3,6,15};
    //     System.out.println(findMedian(arr1,arr2));
    // }
    // public static double findMedian(int[] arr1, int[] arr2){
    //     int n1 = arr1.length;
    //     int n2 = arr2.length;
    //     int[] result = new int[n1+n2];
    //     int index = 0;
    //     int left = 0;
    //     int right = 0;

    //     while(left<n1 && right<n2){
    //         if(arr1[left]<=arr2[right]){
    //             result[index++] = arr1[left++];
    //         }
    //         else{
    //             result[index++] = arr2[right++];
    //         }
    //     }
    //     while(left<n1){
    //         result[index++] = arr1[left++];
    //     }
    //     while(right<n2){
    //         result[index++] = arr2[right++];
    //     }
    //     int n = n1+n2;
    //     if(n%2 == 1){
    //         return result[n/2];
    //     }
    //     return (result[n/2]+result[n/2-1])/2.0;
    // }

    // BETTER -->
    // TC: O(n+m)
    // SC: O(1)
    // public static void main(String[] args){
    //     int[] arr1 = {1,3,4,7,10,12};
    //     int[] arr2 = {2,3,6,15};
    //     System.out.println(findMedian(arr1,arr2));
    // }
    // public static double findMedian(int[] arr1, int[] arr2){
    //     int n1 = arr1.length;
    //     int n2 = arr2.length;
    //     int left = 0;
    //     int right = 0;
    //     int n = n1+n2;
    //     int index2 = n/2;
    //     int index1 = index2-1;
    //     int element1 = -1;
    //     int element2 = -1;
    //     int count = 0;

    //     while(left<n1 && right<n2){
    //         if(arr1[left]<=arr2[right]){
    //             if(count == index1){
    //                 element1 = arr1[left];
    //             }
    //             if(count == index2){
    //                 element2 = arr1[left];
    //             }
    //             count++;
    //             left++;
    //         }
    //         else{
    //             if(count == index1){
    //                 element1 = arr2[left];
    //             }
    //             if(count == index2){
    //                 element2 = arr2[right];
    //             }
    //             count++;
    //             right++;
    //         }
    //     }
    //     while(left<n1){
    //         if(count == index1){
    //             element1 = arr1[left];
    //         }
    //         if(count == index2){
    //             element2 = arr1[left];
    //         }
    //         count++;
    //         left++;
    //     }
    //     while(right<n2){
    //         if(count == index1){
    //             element1 = arr2[right];
    //         }
    //         if(count == index2){
    //             element2 = arr2[right];
    //         }
    //         count++;
    //         right++;
    //     }
    //     if(n%2 == 1){
    //         return (double)element2;
    //     }
    //     return (double)(element1+element2)/2.0;
    // }


    // OPTIMAL -->
    // TC: O(min(log n, log m))
    // SC: O(1)
    public static void main(String[] args){
        int[] arr1 = {1,3,4,7,10,12};
        int[] arr2 = {2,3,6,15};
        System.out.println(findMedian(arr1,arr2));
    }
    public static double findMedian(int[] arr1, int[] arr2){
        int n1 = arr1.length;
        int n2 = arr2.length;
        if(n1>n2){
            return findMedian(arr2,arr1);
        }
        int low = 0;
        int high = n1;
        int n = n1+n2;
        int left = (n1+n2+1)/2;

        while(low<=high){
            int mid1 = low+(high-low)/2;
            int mid2 = left-mid1;
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            if(mid1 <n1){
                r1 = arr1[mid1];
            }
            if(mid2 <n2){
                r2 = arr2[mid2];
            }
            if(mid1-1 >=0){
                l1 = arr1[mid1-1];
            }
            if(mid2-1 >=0){
                l2 = arr2[mid2-1];
            }
            if(l1<=r2 && l2<=r1){
                if(n%2 == 1){
                    return (double)Math.max(l1,l2);
                }
                return ((double)(Math.max(l1,l2)+Math.min(r1,r2))/2.0);
            }
            else if(l1>r2){
                high = mid1-1;
            }
            else{
                low = mid1+1;
            }
        }
        return 0.0;
    }
}