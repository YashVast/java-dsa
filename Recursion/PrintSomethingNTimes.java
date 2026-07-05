public class PrintSomethingNTimes {
    public static void main(String args[]){
        int n = 5;
        printNTimes(1,n);
    }
    public static void printNTimes(int i, int n){
        if(i>n){
            return;
        }
        else {
            System.out.println(i);
            printNTimes(i+1,n);
        }
    }
}
