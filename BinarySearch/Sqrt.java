public class Sqrt {
    // TC: O(1)
    // SC: O(1)
    // public static void main(String[] args){
    //     int x = 25;
    //     System.out.println(sqrt(x));
    // }
    // public static int sqrt(int x){
    //     int result = (int)Math.sqrt(x);
    //     return result;
    // }

    // TC: O(n)
    // SC: O(1)
    // public static void main(String[] args){
    //     int x = 25;
    //     System.out.println(sqrt(x));
    // }
    // public static int sqrt(int x){
    //     if(x == 0){
    //         return 0;
    //     }
    //     int ans = 1;
    //     for(int i=1; i<=x; i++){
    //         if(i*i <= x){
    //             ans = i;
    //         }
    //     }
    //     return ans;
    // }


    // TC: O(log n)
    // SC: O(1)
    public static void main(String[] args){
        int x = 25;
        System.out.println(sqrt(x));
    }
    public static int sqrt(int x){
        if(x <2){
            return x;
        }
        int low = 1;
        int high = x/2;
        int ans = 1;

        while(low<=high){
            int mid = low+(high-low)/2;
            if(mid*mid <= x){
                ans = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }
}
