public class PrintSomethingNTimesBacktracking {

    //here the sys out is after the recersive function call
    public static void main(String args[]){
        int n = 5;
        printNTimes(n,n);
    }
    public static void printNTimes(int i, int n){
        if(i<1){
            return;
        }
        else{
            printNTimes(i-1, n);
            System.out.println(i);
        }
    }
}
