/**
 * Solution class for LeetCode Problem #35: Search Insert Position.
 * Finds the index where a target should be inserted in a sorted array.
 *
 * Problem Number: 35
 * Difficulty: Easy
 * Design Pattern: Binary Search (Two Pointers)
 * 
 * Solution Approach:
 * We use binary search to find the target if it exists, or determine its insertion position.
 * The key insight is that when the binary search loop terminates (left > right), the `left`
 * pointer always points to the correct insertion position. This is because:
 * - If target is smaller than all elements: left remains at 0
 * - If target is larger than all elements: left becomes nums.length
 * - If target is between elements: left points to the first position where target <= nums[left]
 * 
 * The loop terminates when left > right, meaning we've narrowed down to the exact position
 * where the target should be inserted to maintain sorted order.
 * 
 * Time complexity: O(log n) - binary search divides search space in half each iteration
 * Space complexity: O(1) - only uses constant auxiliary variables
 */
public class SearchInsertPosition35 {
    
    /**
     * Returns the index where target should be inserted in sorted array to maintain order.
     * If target exists, returns its index. Otherwise, returns insertion position.
     * 
     * Algorithm:
     * 1. Use binary search with two pointers (left, right)
     * 2. If target found: return its index immediately
     * 3. If not found: when loop terminates (left > right), return left
     * 
     * Critical insight: When binary search terminates without finding target,
     * the `left` pointer indicates where target should be inserted because:
     * - It points to the first element >= target (if any)
     * - Or to nums.length if target > all elements
     * 
     * Time Complexity: O(log n) - binary search eliminates half of elements per iteration
     * Space Complexity: O(1) - constant space for pointers
     * 
     * @param nums sorted array of distinct integers in ascending order
     * @param target value to find or insert
     * @return index of target if found, or insertion position if not found
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while(left <= right){
            int mid = (left + right) / 2;
            
            if(nums[mid] < target){
                left = mid + 1;  // Search in right half
            } else if(nums[mid] > target){
                right = mid - 1;  // Search in left half
            } else {
                return mid;  // Found target
            }
        }
        
        return left;  // Insertion position when target not found
    }
}

