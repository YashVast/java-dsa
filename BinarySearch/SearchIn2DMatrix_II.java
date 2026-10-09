public class SearchIn2DMatrix_II {
    // BRUTE FORCE -->
    // TC: O(n*m)
    // SC: O(1)
    // public static void main(String[] args){
    //     int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
    //     int target = 14;
    //     System.out.println(searchElement(matrix,target));
    // }
    // public static boolean searchElement(int[][] matrix, int target){
    //     int n = matrix.length;
    //     int m = matrix[0].length;

    //     for(int i=0; i<n; i++){
    //         for(int j=0; j<m; j++){
    //             if(matrix[i][j] == target){
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }

    // BETTER -->
    // TC: O(n log m)
    // SC: O(1)
    // public static void main(String[] args){
    //     int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
    //     int target = 14;
    //     System.out.println(searchElement(matrix,target));
    // }  
    // public static boolean searchElement(int[][] matrix, int target){
    //     int n = matrix.length;

    //     for(int i=0; i<n; i++){
    //         boolean isPresent = binarSearch(matrix[i],target);
    //         if(isPresent == true){
    //             return true;
    //         }
    //     }
    //     return false;
    // }
    // public static boolean binarSearch(int[] matrix, int target){
    //     int n = matrix.length;
    //     int low = 0;
    //     int high = n-1;

    //     while(low<=high){
    //         int mid = low+(high-low)/2;
    //         if(matrix[mid] == target){
    //             return true;
    //         }
    //         else if(matrix[mid]<target){
    //             low = mid+1;
    //         }
    //         else{
    //             high = mid-1;
    //         }
    //     }
    //     return false;
    // }

    // OPTIMAL -->
    // TC: O(n+m)
    // SC: O(1)
    public static void main(String[] args){
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 14;
        System.out.println(searchElement(matrix,target));
    } 
    public static boolean searchElement(int[][] matrix, int target){
        int n = matrix.length;
        int m = matrix[0].length;
        int row = 0;
        int col = m-1;

        while(row<n && col>=0){
            if(matrix[row][col] == target){
                return true;
            }
            else if(matrix[row][col] < target){
                row++;
            }
            else{
                col--;
            }
        }
        return false;
    }
}
