//Only one transaction allowed, i.e. one time buy and one time sell.

public class Stock_Buy_Sell_I{
    //TC: O(n) SC: O(1)
    public static void main(String args[]){
        int[] arr = {7,1,5,3,6,4};
        System.out.println(maximumProfit(arr));
    }
    public static int maximumProfit(int[] arr){
        int n = arr.length;
        int minimum = arr[0];
        int profit = 0;

        for(int i=1; i<n; i++){
            int cost = arr[i]-minimum;
            profit = Math.max(profit,cost);

            minimum = Math.min(minimum,arr[i]);
        }
        return profit;
    }
}