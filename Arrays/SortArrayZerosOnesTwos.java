public class SortArrayZerosOnesTwos {
    //BETTER --> TC: O(n)+ O(n) SC: O(n) 
    // public static void main(String args[]){
    //     int[] arr = {0,1,2,0,1,2,1,2,0,0,0,1};

    //     int[] result = sortArray(arr);

    //     for(int x:result){
    //         System.out.print(x+" ");
    //     }
    // }
    // public static int[] sortArray(int[] arr){
    //     int n = arr.length;
    //     int counter0 = 0;
    //     int counter1 = 0;
    //     int counter2 = 0;

    //     for(int i=0;i<n;i++){
    //         if(arr[i]==0){
    //             counter0 ++;
    //         }
    //         else if(arr[i]==1){
    //             counter1 ++;
    //         }
    //         else{
    //             counter2++;
    //         }
    //     }
    //     int[] temp = new int[n];
    //     int index = 0;
    //     for(int i=0; i<counter0; i++){
    //         temp[index++] = 0;
    //     }
    //     for(int i=0; i<counter1; i++){
    //         temp[index++] = 1;
    //     }
    //     for(int i=0; i<counter2; i++){
    //         temp[index++] = 2;
    //     }
    //     return temp;
    // }

    //OPTIMAL --> TC:O(n) SC:O(1)  --> this one purely O(n) as TC
    //DUTCH NATIONAL FLAG ALGORITHM
    public static void main(String args[]){
        int[] arr = {0,1,2,0,1,2,1,2,0,0,0,1};
        sortArray(arr);

        for(int x:arr){
            System.out.print(x+" ");
        }
    }
    public static void sortArray(int[] arr){
        int n = arr.length;
        int low = 0;
        int mid = 0;
        int high = n-1;

        while(mid<=high){

            if(arr[mid]==0){
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                low++;
                mid++;
            }
            else if(arr[mid]==1){
                mid++;
            }
            else{
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }
}
