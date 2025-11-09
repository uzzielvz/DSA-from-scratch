/**
 * Solution class for LeetCode Problem #69: Sqrt(x)
 * Computes the integer square root (floor) of a non-negative integer using binary search.
 *
 * Problem Number: 69
 * Difficulty: Easy
 * Design Pattern: Binary Search (numeric range, overflow-safe)
 *
 * Solution Approach:
 * Uses binary search over the range [1, x/2] for x >= 2. For each candidate mid,
 * we check if mid*mid <= x without risking integer overflow by using division:
 * - If mid <= x/mid, then mid*mid <= x, so mid is a valid answer candidate
 * - Save mid as result and search for a larger candidate (left = mid + 1)
 * - If mid > x/mid, then mid*mid > x, so search smaller values (right = mid - 1)
 *
 * Key insight: Using division comparison avoids integer overflow that would occur
 * with mid*mid for large values of x (close to Integer.MAX_VALUE).
 *
 * Time complexity: O(log x) - binary search over at most x/2 values
 * Space complexity: O(1) - only uses constant auxiliary variables
 */
public class Sqrt69 {
    
    /**
     * Returns the integer square root (floor) of x.
     *
     * Uses binary search on the range [1, x/2] and division-based comparisons
     * to find the largest integer whose square is <= x. Special case handling
     * for x < 2 since sqrt(0) = 0 and sqrt(1) = 1.
     *
     * Example: x = 8 → sqrt(8) ≈ 2.828, so return 2
     * Example: x = 4 → sqrt(4) = 2, so return 2
     *
     * Time Complexity: O(log x)
     * Space Complexity: O(1)
     *
     * @param x non-negative integer
     * @return integer square root (floor value)
     */
    public int mySqrt(int x) {
        if (x < 2) return x;  // Handle edge cases: sqrt(0) = 0, sqrt(1) = 1
        
        int left = 1;
        int right = x / 2;    // For x >= 2, sqrt(x) <= x/2
        int result = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (mid <= x / mid) {    // Equivalent to mid*mid <= x (no overflow)
                result = mid;        // Save candidate answer
                left = mid + 1;      // Search for larger candidate
            } else {
                right = mid - 1;     // mid*mid > x, search smaller values
            }
        }
        
        return result;  // Floor of sqrt(x)
    }
}
