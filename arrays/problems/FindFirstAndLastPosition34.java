/**
 * Solution class for LeetCode Problem #34: Find First and Last Position of Element in Sorted Array
 * Finds the starting and ending position of a target value in a sorted array with duplicates.
 *
 * Problem Number: 34
 * Difficulty: Medium
 * Design Pattern: Binary Search (double search - leftmost and rightmost)
 *
 * Solution Approach:
 * Uses TWO separate binary searches to find the first and last occurrence of the target:
 * 
 * 1. First Search (leftmost occurrence):
 *    When nums[mid] == target, we don't return immediately. Instead, we save mid as a
 *    candidate and continue searching LEFT (right = mid - 1) to find if there's an
 *    earlier occurrence.
 * 
 * 2. Second Search (rightmost occurrence):
 *    When nums[mid] == target, we save mid and continue searching RIGHT (left = mid + 1)
 *    to find if there's a later occurrence.
 * 
 * Both variables (first and last) are initialized to -1, so if target doesn't exist,
 * we naturally return [-1, -1] without additional logic.
 * 
 * Time complexity: O(log n) - two independent binary searches
 * Space complexity: O(1) - only uses constant auxiliary variables
 */
public class FindFirstAndLastPosition34 {
    
    /**
     * Finds the first and last position of target in a sorted array.
     *
     * Performs two binary searches:
     * - First search: finds leftmost (earliest) occurrence
     * - Second search: finds rightmost (latest) occurrence
     *
     * Example: nums = [5,7,7,8,8,8,10], target = 8
     * - First search finds index 3 (first 8)
     * - Second search finds index 5 (last 8)
     * - Returns [3, 5]
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     *
     * @param nums sorted array in ascending order (may contain duplicates)
     * @param target value to search for
     * @return array [first, last] with indices, or [-1, -1] if not found
     */
    public int[] searchRange(int[] nums, int target) {
        // Search 1: Find FIRST (leftmost) occurrence
        int left = 0;
        int right = nums.length - 1;
        int first = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                first = mid;         // Save candidate
                right = mid - 1;     // Continue searching LEFT
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        // Search 2: Find LAST (rightmost) occurrence
        left = 0;
        right = nums.length - 1;
        int last = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                last = mid;          // Save candidate
                left = mid + 1;      // Continue searching RIGHT
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return new int[]{first, last};
    }
}

