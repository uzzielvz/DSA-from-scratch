/**
 * Solution class for LeetCode Problem #153: Find Minimum in Rotated Sorted Array
 * Finds the minimum element in a rotated sorted array in O(log n) time.
 *
 * Problem Number: 153
 * Difficulty: Medium
 * Design Pattern: Binary Search (rotated array variation)
 *
 * Solution Approach:
 * Similar to #33 (Search in Rotated Sorted Array) but instead of searching for a target,
 * we search for the minimum element. The key insight is:
 * - Compare nums[mid] with nums[high] (not nums[low])
 * - If nums[mid] > nums[high]: the right half is rotated, minimum must be there
 *   → search right: left = mid + 1
 * - If nums[mid] <= nums[high]: the right half is sorted, minimum is in left half or at mid
 *   → search left: right = mid (NOT mid-1, because mid could be the minimum)
 *
 * Critical difference from #33:
 * - Use while(left < right) instead of while(left <= right)
 * - When right half is sorted, set right = mid (not mid-1) to preserve mid as candidate
 * - At termination, left == right, both pointing to minimum
 *
 * Time complexity: O(log n) - binary search eliminates half the array each iteration
 * Space complexity: O(1) - only uses constant auxiliary variables
 */
public class FindMinimumInRotatedSortedArray153 {
    
    /**
     * Finds the minimum element in a rotated sorted array.
     *
     * The array was sorted in ascending order and then rotated. We use binary search
     * by comparing the middle element with the rightmost element to determine which
     * half contains the minimum.
     *
     * Example: nums = [4,5,6,7,0,1,2]
     * - mid=3 (value 7), compare with rightmost (2)
     * - 7 > 2 → right half is rotated, minimum must be there
     * - Eventually finds minimum 0 at index 4
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     *
     * @param nums rotated sorted array with distinct values (unique minimum)
     * @return minimum element in the array
     */
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {  // Not <=, because we want left == right at termination
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > nums[right]) {
                // Right half is rotated, minimum must be in right half
                left = mid + 1;
            } else {
                // Right half is sorted, minimum is in left half or at mid
                // Don't use mid - 1, because mid could be the minimum
                right = mid;
            }
        }
        
        return nums[left];  // left == right, both point to minimum
    }
}

