public class NthRootOfM {
    // BRUTE FORCE -->
    // TC: O(m)
    // SC: O(1)
    // public static void main(String[] args){
    //     int n = 3;
    //     int m = 27;
    //     System.out.println(nthRoot(n,m));
    // }
    // public static int nthRoot(int n, int m){
    //     if(m<2){
    //         return m;
    //     }
    //     for(int i=1; i<=m; i++){
    //         if(func(i,n) == m){
    //             return  i;
    //         }
    //         else if(func(i,n)>m){
    //             break;
    //         }
    //     }
    //     return -1;
    // }
    // public static int func(int i, int n){
    //     int power = 1;
    //     for(int j=1; j<=n; j++){
    //         power *= i;
    //     }
    //     return power;
    // }

    // OPTIMAL -->
    // TC: O(n log m)
    // SC: O(1)
    public static void main(String[] args){
        int n = 3;
        int m = 27;
        System.out.println(nthRoot(n,m));
    }
    public static int nthRoot(int n, int m){
        if(m<2){
            return m;
        }
        int low = 1;
        int high = m/2;

        while(low<=high){
            int mid = low+(high-low)/2;
            if(func(mid,n) == m){
                return mid;
            }
            else if(func(mid,n)<m){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }
    public static int func(int mid, int n){
        int power = 1;
        for(int i=1; i<=n; i++){
            power *= mid;
        }
        return power;
    }
}
