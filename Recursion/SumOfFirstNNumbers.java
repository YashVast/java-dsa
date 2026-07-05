public class SumOfFirstNNumbers {

    //Parameterized way to do it.
    // public static void main(String args[]){
    //     int n = 5;
    //     sum(n,0);
    // }
    // public static void sum(int i, int sum){
    //     if(i<1){
    //         System.out.println(sum);
    //         return;
    //     }
    //     else{
    //         sum(i-1, sum+i);
    //     }
    // }

    //Functional(Recursive Code)
    public static void main(String args[]){
        int n = 5;
        System.out.println(sum(n));
    }
    public static int sum(int n){
        if(n == 0){
            return 0;
        }
        else{
            return n + sum(n-1);
        }
    }
}
