/**
 * Solution class for LeetCode Problem #367: Valid Perfect Square
 * Checks if a positive integer is a perfect square using integer binary search.
 *
 * Problem Number: 367
 * Difficulty: Easy
 * Design Pattern: Binary Search (numeric range, overflow-safe with division)
 *
 * Solution Approach:
 * Binary search over [1, num/2] for num >= 2. Compare mid*mid with num without
 * risking integer overflow by using division:
 * - Let q = num / mid.
 * - If q == mid and num % mid == 0 → exact square (mid * mid == num).
 * - If q > mid → mid * mid < num → move left bound up.
 * - If q < mid → mid * mid > num → move right bound down.
 *
 * Time complexity: O(log n)
 * Space complexity: O(1)
 */
public class ValidPerfectSquare367 {

    /**
     * Returns true if num is a perfect square, otherwise false.
     *
     * Uses binary search on the integer range and division-based comparisons to
     * avoid overflow in mid * mid.
     *
     * @param num positive integer
     * @return whether num is a perfect square
     */
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;

        int low = 1;
        int high = num / 2;  // for num >= 2, sqrt(num) <= num/2

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int q = num / mid;  // floor division

            if (q == mid) {
                if (num % mid == 0) return true;  // exact square
                low = mid + 1;  // otherwise mid*mid < num due to truncation
            } else if (q > mid) {
                low = mid + 1;   // mid*mid < num
            } else {
                high = mid - 1;  // mid*mid > num
            }
        }
        return false;
    }
}
