import java.util.Arrays;

public class MinCoins {

    private static int minCoins(int[] coins, int amount) {
        int i=coins.length - 1; // Start from the largest coin
        int count = 0; // Count of coins used
        while(i>=0){
            if(coins[i]<=amount){
                amount -= coins[i]; // Subtract coin value from amount
                count++; // Increment coin count
            }else{
                i--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int coins[] = { 1,5,6,9 }; // Coin denominations
        int amount = 11; // Amount to make change for
        Arrays.sort(coins); // Sort coins for greedy approach
        int result = minCoins(coins, amount);
        System.out.println(result);
    }

}
