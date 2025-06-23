import java.util.*;

class Items implements Comparable<Items> {
    int value;
    int weight;

    Items(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    @Override
    public int compareTo(Items other) {
        double r1 = (double) this.value / this.weight;
        double r2 = (double) other.value / other.weight;
        return Double.compare(r2, r1); // Sort in descending order
    }
}

public class FractionalKnapsack {
    public static double fractionalKnapsack(int W, Items[] items) {
        Arrays.sort(items);
        double totalValue = 0.0;
        for (Items item : items) {
            if (W == 0) {
                break;
            } else if (item.weight <= W) {
                W = W - item.weight;
                totalValue = totalValue + item.value;
            } else {
                double fraction = (item.value / item.weight) * W;
                totalValue = totalValue + fraction;
                W = 0;

            }
        }
        return totalValue;

    }

    public static void main(String[] args) {
        Items[] items = {
                new Items(60, 10),
                new Items(100, 20),
                new Items(120, 30)
        };

        int W = 50; // Knapsack capacity

        double result = fractionalKnapsack(W, items);
        System.out.printf("Max value in Fractional Knapsack = %.2f\n", result);
    }
}
