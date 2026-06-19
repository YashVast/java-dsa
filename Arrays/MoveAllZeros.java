

public class MoveAllZeros{

    //BRUTE FORCE --> TC: O(n) SC: O(n)
    // public static void main(String args[]){
    //     int[] arr = {1,0,2,0,3,0,4,0,5,0};
    //     int[] result = moveZero(arr);

    //     for(int num:result){
    //         System.out.print(num+" ");
    //     }
    // }
    // public static int[] moveZero(int[] arr){
    //     if(arr==null){
    //         throw new IllegalArgumentException("Given array is null");
    //     }
    //     List<Integer> list = new ArrayList<>();

    //     for(int i=0; i<arr.length; i++){
    //         if(arr[i]!= 0){
    //             list.add(arr[i]);
    //         }
    //     }
    //     int[] temp = new int[arr.length];
    //     int index = 0;
    //     for(int i=0; i<list.size(); i++){
    //         temp[index] = list.get(i);
    //         index++;
    //     }
    //     return temp;
    // }

    //OPTIMAL --> TC:O(N) SC:O(1)
    public static void main(String args[]){
        int[] arr = {1,0,2,0,3,0,4,0,5,0};
        moveZeros(arr);

        for(int num:arr){
            System.out.print(num+" ");
        }
    }
    public static void moveZeros(int[] arr){
        if(arr==null){
            throw new IllegalArgumentException("array is null");
        }
        int n = arr.length;
        int index = -1;

        for(int i=0; i<n; i++){
            if(arr[i]==0){
                index = i;
                break;
            }
        }
        if(index== -1){
            return;
        }

        for(int i=index; i<n; i++){
            if(arr[i]!=0){
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                index++;
            }
        }
    }
}