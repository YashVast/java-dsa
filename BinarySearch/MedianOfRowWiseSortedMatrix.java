// it will be n * m matrix where n and m both will be strictly odd

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedianOfRowWiseSortedMatrix {
    // BRUTE FORCE -->
    // TC: O(n*m)+O(n*m log n*m)
    // SC: O(n*m)
    // public static void main(String[] args){
    //     int[][] matrix = {{1,5,7,9,11},{2,3,4,5,10},{9,10,12,14,16}};
    //     System.out.println(findMedian(matrix));
    // }
    // public static int findMedian(int[][] matrix){
    //     int n = matrix.length;
    //     int m = matrix[0].length;
    //     List<Integer> list = new ArrayList<>();

    //     for(int i=0; i<n; i++){
    //         for(int j=0; j<m; j++){
    //             list.add(matrix[i][j]);
    //         }
    //     }
    //     Collections.sort(list);
    //     return list.get(list.size()/2);
    // }

    // OPTIMAL -->
    // TC: O(log high)*O(n log m)
    // SC: O(1)
    public static void main(String[] args){
        int[][] matrix = {{1,5,7,9,11},{2,3,4,5,10},{9,10,12,14,16}};
        System.out.println(findMedian(matrix));
    }
    public static int findMedian(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        int low = findStart(matrix,n,0);
        int high = findEnd(matrix,n,m-1);
        int req = (n*m)/2;

        while(low<=high){
            int mid = low+(high-low)/2;
            int smallEqual = blackBox(matrix,n,m,mid);
            if(smallEqual<=req){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return low;
    }
    public static int blackBox(int[][] matrix, int n,int m,int mid){
        int count = 0;
        for(int i=0; i<n; i++){
            count += upperBound(matrix[i],m,mid);
        }
        return count;
    }
    public static int upperBound(int[] matrix, int m, int x){
        int low = 0;
        int high = m-1;
        int upperBound = m;

        while(low<=high){
            int mid = low+(high-low)/2;
            if(matrix[mid]>x){
                upperBound = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return upperBound;
    }
    public static int findStart(int[][] matrix,int n,int col){
        int start = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
           if(matrix[i][col]<start){
                start = matrix[i][col]; 
           }
        }
        return start;
    }
    public static int findEnd(int[][] matrix,int n,int col){
        int end = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(matrix[i][col]>end){
                end = matrix[i][col];
            }
        }
        return end;
    }
}
