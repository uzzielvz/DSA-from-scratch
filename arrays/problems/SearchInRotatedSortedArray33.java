/**
 * Solution class for LeetCode Problem #33: Search in Rotated Sorted Array
 * Searches for a target value in a rotated sorted array in O(log n) time.
 *
 * Problem Number: 33
 * Difficulty: Medium
 * Design Pattern: Binary Search (modified for rotated array)
 *
 * Solution Approach:
 * A sorted array that has been rotated maintains a key property: at least one half
 * of the array (left or right of mid) is always sorted. We use modified binary search:
 * 1. Determine which half is sorted by comparing nums[left] with nums[mid]
 * 2. Check if target lies within the sorted half's range
 * 3. If yes, search in that half; otherwise, search in the other half
 *
 * Key insight: We always know the bounds of the sorted half, allowing us to decide
 * whether the target could be in that range, even though the other half is rotated.
 *
 * Time complexity: O(log n) - binary search eliminates half the array each iteration
 * Space complexity: O(1) - only uses constant auxiliary variables
 */
public class SearchInRotatedSortedArray33 {
    
    /**
     * Searches for target in a rotated sorted array.
     *
     * Algorithm:
     * 1. Use binary search with left and right pointers
     * 2. At each iteration:
     *    - Check if nums[mid] == target (found)
     *    - Determine which half is sorted (left or right)
     *    - If target is within sorted half's range: search that half
     *    - Otherwise: search the other half
     * 3. Return -1 if not found
     *
     * Example: [4,5,6,7,0,1,2], target=0
     * - mid=3 (value 7), left half [4,5,6,7] is sorted
     * - target=0 not in [4,7], so search right half
     * - Eventually finds 0 at index 4
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     *
     * @param nums rotated sorted array with distinct values
     * @param target value to search for
     * @return index of target if found, -1 otherwise
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Found target
            if (nums[mid] == target) {
                return mid;
            }
            
            // Determine which half is sorted
            if (nums[left] <= nums[mid]) {
                // Left half is sorted [left...mid]
                // Check if target is within this sorted range
                if (target >= nums[left] && target < nums[mid]) {
                    // Target is in sorted left half
                    right = mid - 1;
                } else {
                    // Target must be in rotated right half
                    left = mid + 1;
                }
            } else {
                // Right half is sorted [mid...right]
                // Check if target is within this sorted range
                if (target > nums[mid] && target <= nums[right]) {
                    // Target is in sorted right half
                    left = mid + 1;
                } else {
                    // Target must be in rotated left half
                    right = mid - 1;
                }
            }
        }
        
        return -1;  // Target not found
    }
}

