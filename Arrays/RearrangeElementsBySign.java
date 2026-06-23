public class RearrangeElementsBySign{

    //BRUTE FORCE --> TC: O(n)+ O(n) SC: O(n)
    // public static void main(String args[]){
    //     int[] arr = {3,1,-2,-5,2,-4};
    //     int[] result = rearrange(arr);

    //     for(int x:result){
    //         System.out.print(x+" ");
    //     }
    // }
    // public static int[] rearrange(int[] arr){
    //     int n = arr.length;
    //     int[] positive = new int[n/2];
    //     int pIndex = 0;
    //     int[] negative = new int[n/2];
    //     int nIndex = 0;

    //     for(int i=0; i<n; i++){
    //         if(arr[i]>0){
    //             positive[pIndex++] = arr[i];
    //         }
    //         else{
    //             negative[nIndex++] = arr[i];
    //         }
    //     }

    //     for(int i=0;i<n/2; i++){
    //         arr[2*i] = positive[i];
    //         arr[2*i+1] = negative[i];
    //     }
    //     return arr;
    // }


    //OPTIMAL --> TC: O(n) SC: O(n) 
    public static void main(String args[]){
        int[] arr = {3,1,-2,-5,2,-4};
        int[] result = rearrange(arr);

        for(int x:result){
            System.out.print(x+" ");
        }
    }
    public static int[] rearrange(int[] arr){
        int n = arr.length;
        int pIndex = 0;
        int nIndex = 1;
        int[] result = new int[n];

        for(int i=0; i<n; i++){
            if(arr[i]<0){
                result[nIndex] = arr[i];
                nIndex += 2;
            }
            else{
                result[pIndex] = arr[i];
                pIndex += 2;
            }
        }
        return result;
    }
}