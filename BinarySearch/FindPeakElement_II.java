public class FindPeakElement_II {
    // BRUTE FORCE -->
    // TC: O(n*m)
    // SC: O(1)
    // public static void main(String[] args){
    //     int[][] matrix = {{4,2,5,1,4,5},{2,9,3,2,3,2},{1,7,6,0,1,3},{3,6,2,3,7,2}};
    //     int[] result = peakElement(matrix);
    //     for(int x: result){
    //         System.out.print(x+" ");
    //     }
    // }
    // public static int[] peakElement(int[][] matrix){
    //     int n = matrix.length;
    //     int m = matrix[0].length;
    //     int largest = Integer.MIN_VALUE;
    //     int[] ans = {-1,-1};
    //     for(int i=0; i<n; i++){
    //         for(int j=0; j<m; j++){
    //             if(matrix[i][j]>largest){
    //                 largest = matrix[i][j];
    //                 ans = new int[]{i,j};
    //             }
    //         }
    //     }
    //     return ans;
    // }


    // BRUTE FORCE -->
    // TC: O(n*m)
    // SC: O(1)
    public static void main(String[] args){
        int[][] matrix = {{4,2,5,1,4,5},{2,9,3,2,3,2},{1,7,6,0,1,3},{3,6,2,3,7,2}};
        int[] result = peakElement(matrix);
        for(int x: result){
            System.out.print(x+" ");
        }
    }
    public static int[] peakElement(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0;
        int high = m-1;

        while(low<=high){
            int mid = low+(high-low)/2;
            int row = maxIndex(matrix,n,m,mid);
            int left = (mid-1 >= 0) ? matrix[row][mid-1]: -1;
            int right = (mid+1 < m) ? matrix[row][mid+1]: -1;

            if(matrix[row][mid]>left && matrix[row][mid]>right){
                return  new int[]{row,mid};
            }
            else if(matrix[row][mid]<left){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return new int[]{-1,-1};
    }
    public static int maxIndex(int[][] matrix, int n,int m, int col){
        int maxElement = -1;
        int maxIndex = -1;

        for(int i=0; i<n; i++){
            if(matrix[i][col] > maxElement){
                maxElement = matrix[i][col];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
