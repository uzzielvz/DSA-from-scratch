/**
 * Solution class for LeetCode Problem #26: Remove Duplicates from Sorted Array.
 * Removes duplicates in-place from a sorted array, keeping only unique elements.
 *
 * Problem Number: 26
 * Design Pattern: Two Pointers (Fast/Slow)
 * Solution Approach:
 * This solution uses the two-pointer technique to efficiently remove duplicates in-place.
 * Since the array is sorted, all duplicate elements are adjacent to each other. We use
 * a slow pointer to track the position where the next unique element should be placed,
 * and a fast pointer to scan through the array. When we find a new unique element
 * (nums[slow] != nums[fast]), we increment slow and place the unique element at that
 * position. This approach maintains the relative order while compacting unique elements
 * to the front of the array. The algorithm returns slow + 1, which represents the count
 * of unique elements and the length of the modified array section.
 * Time complexity: O(n) - single pass through array. Space complexity: O(1) - in-place.
 */
public class RemoveDuplicatesFromSortedArray {

    /**
     * Removes duplicates from a sorted array in-place, returning the count of unique elements.
     *
     * The algorithm leverages the sorted property: duplicates are always adjacent.
     * Uses two pointers - slow (write position) and fast (read position) to efficiently
     * compact unique elements to the front of the array. When a new unique element is
     * found, it's placed at the next available position tracked by the slow pointer.
     *
     * Time Complexity: O(n) - single traversal of the array
     * Space Complexity: O(1) - only uses constant extra space (two pointers)
     *
     * @param nums Sorted integer array in non-decreasing order
     * @return Number of unique elements (k), where first k elements contain unique values
     */
    public int removeDuplicates(int[] nums) {
        int slow = 0;  // Points to position of last unique element found

        // Fast pointer scans array starting from second element
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[slow] != nums[fast]) {      // Found new unique element
                slow++;                          // Move to next write position
                nums[slow] = nums[fast];         // Place unique element at write position
            }
        }

        return slow + 1;  // Convert position to count (0-indexed to 1-indexed)
    }
}