public class FindRowWithMaximumOnes {
    // BRUTE FORCE -->
    // TC: O(n*m)
    // SC: O(1)
    // public static void main(String[] args){
    //     int[][] matrix = {{0,0,1,1,1},
    //                       {0,0,0,0,0},
    //                       {0,1,1,1,1},
    //                       {0,0,0,0,0},
    //                       {1,1,1,1,1}};
    //     System.out.println(maxOnesRow(matrix));
    // }
    // public static int maxOnesRow(int[][] mat){
    //     int n = mat.length;
    //     int m = mat[0].length;

    //     int maxOnes = 0;
    //     int rowCount = 0;

    //     for(int i=0; i<n; i++){
    //         int count = 0;
    //         for(int j=0; j<m; j++){
    //             if(mat[i][j] == 1){
    //                 count++;
    //             }
    //         }
    //         if(count>maxOnes){
    //             maxOnes = count;
    //             rowCount = i;
    //         }
    //     }
    //     return rowCount;
    // }


    // OPTIMAL -->
    // TC: O(n log m)
    // SC: O(1)
    public static void main(String[] args){
        int[][] matrix = {{0,0,1,1,1},
                          {0,0,0,0,0},
                          {0,1,1,1,1},
                          {0,0,0,0,0},
                          {1,1,1,1,1}};
        System.out.println(maxOnesRow(matrix));
    }
    public static int maxOnesRow(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;
        int maxOnes = 0;
        int rowCount = 0;

        for(int i=0; i<n; i++){
            int count = m - lowerBound(mat[i]);
            if(count>maxOnes){
                maxOnes = count;
                rowCount = i;
            }
        }
        return rowCount;
    }
    public static int lowerBound(int[] mat){
        int n = mat.length;
        int low = 0;
        int high = n-1;
        int ans = n;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(mat[mid]>=1){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
}
