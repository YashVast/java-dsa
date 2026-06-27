public class SetMatrixZeros{

    //BRUTE FORCE --> TC: O(n*m)*(n+m) + O(n*m) SC: O(1)
    // public static void main(String args[]){
    //     int[][] matrix = {{1,1,1,1},
    //                       {1,0,0,1},
    //                       {1,1,0,1},
    //                       {1,1,1,1}};
    //     setZeros(matrix);  
    //     int n = matrix.length;
    //     int m = matrix[0].length;

    //     for(int i=0; i<n; i++){
    //         for(int j=0; j<m; j++){
    //             System.out .print(matrix[i][j]+" ");
    //         }
    //         System.out.println();
    //     }
    // }
    // public static void setZeros(int[][] matrix){
    //     int n = matrix.length;
    //     int m = matrix[0].length;

    //     for(int i=0; i<n; i++){
    //         for(int j=0; j<m; j++){
    //             if(matrix[i][j] == 0){
    //                 markRow(matrix,i);
    //                 markCol(matrix,j);
    //             }
    //         }
    //     }

    //     for(int i=0; i<n; i++){
    //         for(int j=0; j<m; j++){
    //             if(matrix[i][j] == -1){
    //                 matrix[i][j] = 0;
    //             }
    //         }
    //     }
    // }
    // public static void markRow(int[][] matrix,int i){
    //     int m = matrix[0].length;
    //     for(int j=0; j<m; j++){
    //         if(matrix[i][j] != 0){
    //             matrix[i][j] = -1;
    //         }
    //     }
    // }
    // public static void markCol(int[][] matrix,int j){
    //     int n = matrix.length;
    //     for(int i=0; i<n; i++){
    //         if(matrix[i][j] != 0){
    //             matrix[i][j] = -1;
    //         }
    //     }
    // }

    //BETTER --> TC: O(n*m)+O(n*m) SC: O(n)+O(m)
    // public static void main(String args[]){
    //     int[][] matrix = {{1,1,1,1},
    //                       {1,0,0,1},
    //                       {1,1,0,1},
    //                       {1,1,1,1}};
    //     setZeros(matrix);
    //     int n = matrix.length;
    //     int m = matrix[0].length;

    //     for(int i=0; i<n; i++){
    //         for(int j=0; j<m; j++){
    //             System.out.print(matrix[i][j]+" ");
    //         }
    //         System.out.println("");
    //     }

    // }
    // public static void setZeros(int[][] matrix){
    //     int n = matrix.length;
    //     int m = matrix[0].length;

    //     int[] row = new int[n];
    //     int[] col = new int[m];

    //     for(int i=0; i<n; i++){
    //         for(int j=0; j<m; j++){
    //             if(matrix[i][j] == 0){
    //                 row[i] = -1;
    //                 col[j] = -1;
    //             }
    //         }
    //     }
    //     for(int i=0; i<n; i++){
    //         for(int j=0; j<m; j++){
    //             if(row[i] == -1|| col[j] == -1){
    //                 matrix[i][j] = 0;
    //             }
    //         }
    //     }
    // }


    //OPTIMAL --> TC: O(n*m)+O(n*m) SC: O(1)
    public static void main(String args[]){
        int[][] matrix = {{1,1,1,1},
                          {1,0,0,1},
                          {1,1,0,1},
                          {1,1,1,1}};
        setZeros(matrix);
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }
    }
    public static void setZeros(int[][] matrix){
        int n = matrix.length;  
        int m = matrix[0].length;

        // int[] row = new int[n];  --> matrix[..][0]
        // int[] col = new int[m];  --> matrix[0][..]

        int col0 = 1;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    if(j != 0){
                        matrix[0][j] = 0;
                    }
                    else{
                        col0 = 0;
                    }
                }
            }
        }

        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(matrix[i][j] != 0){
                    if(matrix[i][0] ==0 || matrix[0][j] == 0){
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        if(matrix[0][0] == 0){
            for(int j=0; j<m; j++){
                matrix[0][j] = 0;
            }
        }
        if(col0 == 0){
            for(int i=0; i<n; i++){
                matrix[i][0] = 0;
            }
        }
    }
}