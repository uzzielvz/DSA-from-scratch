/**
 * UC San Diego - Course 1: Algorithmic Toolbox
 * Week 2: Greedy Algorithms
 * Problem: Fractional Knapsack
 * 
 * Uses BestItem to select items with best value/weight ratio.
 */

public class Knapsack {
    
    public static double getOptimalValue(int capacity, int[] weights, int[] values) {
        double value = 0;
        int[] w = weights.clone();
        int[] v = values.clone();
        
        while (capacity > 0) {
            int best = BestItem.BestItem(w, v);
            if (w[best] <= 0) break;
            
            int amount = Math.min(capacity, w[best]);
            value += amount * (v[best] / (double) w[best]);
            capacity -= amount;
            w[best] -= amount;
        }
        
        return Math.round(value * 10000.0) / 10000.0;
    }
    
    public static void main(String[] args) {
        int capacity = 50;
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        
        double result = getOptimalValue(capacity, weights, values);
        System.out.println("Valor óptimo: " + result);
    }
}
