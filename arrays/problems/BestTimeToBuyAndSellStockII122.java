/**
 * LeetCode 122. Best Time to Buy and Sell Stock II
 * Difficulty: Easy | Greedy
 *
 * Unlimited buys/sells (one position at a time). Max profit = sum every uphill (prices[i+1]-prices[i] when positive).
 * O(n), O(1).
 */
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                profit += prices[i + 1] - prices[i];
            }
        }
        return profit;
    }
}
