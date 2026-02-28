// COMPLETED — Week 3 Greedy: Maximum Value of the Loot
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        int n = values.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) indices[i] = i;
        Arrays.sort(indices, Comparator.comparingDouble(i -> -(double) values[i] / weights[i]));

        double value = 0;
        int remaining = capacity;

        for (int i = 0; i < n && remaining > 0; i++) {
            int idx = indices[i];
            int take = Math.min(weights[idx], remaining);
            value += take * ((double) values[idx] / weights[idx]);
            remaining -= take;
        }
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
        scanner.close();
    }
}
