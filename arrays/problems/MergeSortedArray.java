/**
 * Solution class for LeetCode Problem #88: Merge Sorted Array.
 * Merges two sorted arrays into the first array in-place, maintaining sorted order.
 *
 * Problem Number: 88
 * Design Pattern: Two Pointers
 * Solution Approach:
 * The solution uses a two-pointer technique to merge two sorted arrays in-place.
 * Starting from the end of both arrays, it compares elements from nums1 and nums2,
 * placing the larger element at the end of nums1. This approach avoids overwriting
 * unprocessed elements in nums1 since it works backward. The time complexity is O(n + m),
 * where m and n are the lengths of nums1 and nums2, respectively, and the space complexity
 * is O(1) since the merge is performed in-place.
 */
public class MergeSortedArray {

    /**
     * Merges two sorted arrays nums1 and nums2 into nums1 in-place, maintaining sorted order.
     *
     * @param nums1 The first sorted array with enough space to hold both arrays (length m + n)
     * @param m     The number of valid elements in nums1
     * @param nums2 The second sorted array (length n)
     * @param n     The number of valid elements in nums2
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // Pointer for the last valid element in nums1
        int j = n - 1; // Pointer for the last element in nums2
        int put = m + n - 1; // Pointer for the position to place the next element in nums1

        // Merge from the end to avoid overwriting unprocessed elements
        while (j >= 0) {
            if (i >= 0 && nums1[i] >= nums2[j]) {
                nums1[put] = nums1[i]; // Place larger element from nums1
                i--;
            } else {
                nums1[put] = nums2[j]; // Place larger element from nums2
                j--;
            }
            put--;
        }
    }
}