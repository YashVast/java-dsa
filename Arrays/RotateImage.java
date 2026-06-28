
public class RotateImage {

    //BRUTE FORCE --> TC: O(n2) SC: O(n2)
    // public static void main(String args[]){
    //     int[][] matrix = {{1,2,3,4},
    //                       {5,6,7,8},
    //                       {9,10,11,12},
    //                       {13,14,15,16}};
    //     int[][] result = rotate(matrix);
    //     int n = result.length;                  
    //     int m = result[0].length;        
        
    //     for(int i=0; i<n; i++){
    //         for(int j=0; j<m; j++){
    //             System.out.print(result[i][j]+" ");
    //         }
    //         System.out.println("");
    //     }
    // }
    // public static int[][] rotate(int[][] matrix){
    //     int n = matrix.length;
    //     int m = matrix[0].length;
    //     int[][] result = new int[n][n];

    //     for(int i=0; i<n; i++){
    //         for(int j=0; j<m; j++){
    //             result[j][n-1-i] = matrix[i][j];
    //         }
    //     }
    //     return result;
    // }

   // OPTIMAL --> TC: O(n²), SC: O(1)
    public static void main(String args[]) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        rotate(matrix);

        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                swap(matrix, i, j, j, i);
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            reverse(matrix[i]);
        }
    }

    public static void swap(int[][] matrix, int r1, int c1, int r2, int c2) {
        int temp = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = temp;
    }

    public static void reverse(int[] row) {
        int left = 0;
        int right = row.length - 1;

        while (left < right) {
            int temp = row[left];
            row[left] = row[right];
            row[right] = temp;

            left++;
            right--;
        }
    }
}
