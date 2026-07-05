public class PrintSomethingNTimes {
    public static void main(String args[]){
        printNTimes(0);
    }
    public static void printNTimes(int count){
        if(count == 5){
            return;
        }
        else {
            System.out.println(count);
            printNTimes(count+1);
        }
    }
}
