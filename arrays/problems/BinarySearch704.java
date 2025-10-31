/**
 * Solution class for LeetCode Problem #704: Binary Search.
 * Classic implementation of the binary search algorithm on a sorted array.
 *
 * Problem Number: 704
 * Difficulty: Easy
 * Design Pattern: Binary Search (Two Pointers)
 * 
 * Solution Approach:
 * We use two pointers (left and right) that define the search space.
 * In each iteration, we calculate the middle point and compare it with the target:
 * - If the middle value is less than target, we discard the left half
 * - If the middle value is greater than target, we discard the right half
 * - If we find the target, we return its index
 * 
 * The key is the loop condition (left <= right) which ensures we check all elements,
 * including the case where left == right. This is crucial for correctness.
 * 
 * Time complexity: O(log n) - we divide the search space in half at each step
 * Space complexity: O(1) - we only use constant auxiliary variables
 */
public class BinarySearch704 {
    
    /**
     * Searches for a target element in a sorted array using binary search.
     * 
     * Algorithm:
     * 1. Initialize left=0, right=length-1
     * 2. While left <= right:
     *    - Calculate mid = (left + right) / 2
     *    - If nums[mid] < target: move left = mid + 1
     *    - If nums[mid] > target: move right = mid - 1
     *    - If nums[mid] == target: return mid
     * 3. If not found, return -1
     * 
     * The critical insight is that binary search works because the array is sorted,
     * allowing us to eliminate half of the remaining elements at each step.
     * 
     * Time Complexity: O(log n) - at most log₂(n) iterations
     * Space Complexity: O(1) - only uses three variables (left, right, mid)
     * 
     * @param nums array of integers sorted in ascending order
     * @param target value to search for in the array
     * @return index of target if it exists, -1 if not found
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while(left <= right){
            int mid = (left + right) / 2;
            
            if(nums[mid] < target){
                left = mid + 1;  // Search in right half
            } else if(nums[mid] > target){
                right = mid - 1;  // Search in left half
            } else {
                return mid;  // Found
            }
        }
        
        return -1;  // Not found
    }
}

