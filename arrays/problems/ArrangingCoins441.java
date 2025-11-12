/**
 * Solution class for LeetCode Problem #441: Arranging Coins
 * Finds the total number of complete rows of coins that can be formed.
 *
 * Problem Number: 441
 * Difficulty: Easy
 * Design Pattern: Binary Search (numeric range)
 *
 * Solution Approach:
 * We need the largest k such that k * (k + 1) / 2 <= n. This can be solved
 * with binary search over the range [0, n]. To avoid overflow, we work with
 * long values when computing mid * (mid + 1) / 2. If the coins needed for mid
 * rows are less than or equal to n, we try larger mid; otherwise we move lower.
 *
 * Time complexity: O(log n)
 * Space complexity: O(1)
 */
public class ArrangingCoins441 {

    /**
     * Returns the number of complete rows that can be formed with n coins.
     *
     * @param n total number of coins
     * @return number of complete staircase rows
     */
    public int arrangeCoins(int n) {
        long left = 0;
        long right = n;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long coinsNeeded = mid * (mid + 1) / 2;

            if (coinsNeeded <= n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return (int) right;
    }
}

