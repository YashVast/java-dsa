public class SearchIn2DMatrix_I {
    // BRUTE FORCE -->
    // TC: O(n*m)
    // SC: O(1)
    // public static void main(String[] args){
    //     int[][] matrix = {{3,4,7,9},{12,13,16,18},{20,21,23,29}};
    //     int element = 23;
    //     System.out.println(searchElement(matrix,element));
    // }
    // public static boolean searchElement(int[][] matrix,int element){
    //     int n = matrix.length;
    //     int m = matrix[0].length;

    //     for(int i=0; i<n; i++){
    //         for(int j=0; j<m; j++){
    //             if(matrix[i][j] == element){
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }

    // BETTER -->
    // TC: O(n + log m)
    // SC: O(1)
    // public static void main(String[] args){
    //     int[][] matrix = {{3,4,7,9},{12,13,16,18},{20,21,23,29}};
    //     int element = 23;
    //     System.out.println(searchElement(matrix,element));
    // }
    // public static boolean searchElement(int[][] matrix, int target){
    //     int n = matrix.length;
    //     int m = matrix[0].length;

    //     for(int i=0; i<n; i++){
    //         if(matrix[i][0] <= target && matrix[i][m-1]>=target){
    //             return binarySearch(matrix[i],target);
    //         }
    //     }
    //     return false;
    // }
    // public static boolean binarySearch(int[] matrix,int target){
    //     int n = matrix.length;
    //     int low = 0;
    //     int high = n-1;

    //     while(low<=high){
    //         int mid = low+(high-low)/2;
    //         if(matrix[mid]==target){
    //             return true;
    //         }
    //         else if(matrix[mid]<=target){
    //             low = mid+1;
    //         }
    //         else{
    //             high = mid-1;
    //         }
    //     }
    //     return false;
    // }

    // OPTIMAL -->
    // TC: O(log n*m)
    // SC: O(1)
    public static void main(String[] args){
        int[][] matrix = {{3,4,7,9},{12,13,16,18},{20,21,23,29}};
        int element = 23;
        System.out.println(searchElement(matrix,element));
    }
    public static boolean searchElement(int[][] matrix, int target){
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0;
        int high = n*m-1;

        while(low<=high){
            int mid = low+(high-low)/2;
            int row = mid/m;
            int col = mid%m;
            if(matrix[row][col] == target){
                return true;
            }
            else if(matrix[row][col]<target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return false;
    }
}
