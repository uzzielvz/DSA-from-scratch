/**
 * Solution class for LeetCode Problem #27: Remove Element.
 * Removes all instances of a given value from an array in-place and returns the new length.
 *
 * Problem Number: 27
 * Design Pattern: Two Pointers
 * Solution Approach:
 * The solution uses a two-pointer technique to modify the array in-place. One pointer (i) iterates
 * through the array, while another pointer (k) tracks the position where the next element not equal
 * to the given value should be placed. Elements not equal to the given value are copied to the
 * position indicated by k, and k is incremented. This ensures that the first k elements of the array
 * contain all elements not equal to the given value, in their relative order. The time complexity is
 * O(n) where n is the length of the array, and the space complexity is O(1) since the operation is
 * performed in-place.
 */
public class RemoveElement {

    /**
     * Removes all occurrences of a specified value from the given array in-place.
     *
     * @param nums The input array from which to remove elements
     * @param val  The value to remove from the array
     * @return The number of elements in nums that are not equal to val
     */
    public int removeElement(int[] nums, int val) {
        int k = 0; // Pointer for the position of the next non-val element
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i]; // Place non-val element at index k
                k++;
            }
        }
        return k; // Return the count of non-val elements
    }
}