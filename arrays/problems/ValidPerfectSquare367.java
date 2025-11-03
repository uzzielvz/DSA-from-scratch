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
 * - If q < mid → mid * mid > num → move right bound down (mid too large).
 * - If q > mid → mid * mid < num → move left bound up (mid too small).
 *
 * Key insight: Using division avoids integer overflow that would occur with mid*mid
 * for large values of num (e.g., num close to Integer.MAX_VALUE).
 *
 * Time complexity: O(log n)
 * Space complexity: O(1)
 */
public class ValidPerfectSquare367 {

    /**
     * Returns true if num is a perfect square, otherwise false.
     *
     * Uses binary search on the integer range [1, num/2] and division-based 
     * comparisons to avoid overflow. When q == mid (from num/mid), we verify
     * with modulo to ensure it's an exact square, not just equal due to truncation.
     *
     * Example: num=16 → sqrt is 4, found at mid=4 where 16/4=4 and 16%4=0
     * Example: num=14 → no perfect square, returns false after exhausting search
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
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
                // Could be equal due to truncation, verify exact square
                if (num % mid == 0) return true;
                low = mid + 1;  // otherwise mid*mid < num (truncation)
            } else if (q < mid) {
                // q < mid means num/mid < mid, so mid*mid > num
                high = mid - 1;  // mid is too large
            } else {
                // q > mid means num/mid > mid, so mid*mid < num
                low = mid + 1;   // mid is too small
            }
        }
        return false;
    }
}
