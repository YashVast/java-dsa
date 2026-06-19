public class MissingNumber{
    // Sum n*(n+1)/2 can also do but it will overflow int some cases.

    // TC: O(n) SC: O(1)
    public static void main(String args[]){
        int[] arr = {1,2,4,5};
        System.out.println(missingNumber(arr));
    }
    public static int missingNumber(int[] arr){
        int n = arr.length+1;
        int xor1 = 0;
        int xor2 = 0;

        for(int i=0; i<arr.length; i++){
            xor1 ^= (i+1);
            xor2 ^= arr[i];
        }
        xor1 ^= n;
        return xor1^xor2;
    }
}