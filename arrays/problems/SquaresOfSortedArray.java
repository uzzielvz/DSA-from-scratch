/**
 * Solution class for LeetCode Problem #977: Squares of a Sorted Array.
 * Returns an array of squares of each element in sorted order.
 *
 * Problem Number: 977
 * Design Pattern: Two Pointers (Optimal) vs Brute Force
 * Solution Approach:
 * The optimal solution uses two pointers to leverage the fact that the input array
 * is already sorted. Since the largest squares will be at the extremes (either
 * large negative numbers or large positive numbers), we can compare squares from
 * both ends and build the result array from back to front. This eliminates the
 * need for sorting and achieves O(n) time complexity instead of O(n log n).
 * The brute force alternative (square all + sort) is also provided for comparison.
 * Time complexity: O(n) optimal vs O(n log n) brute force. Space complexity: O(n).
 */
public class SquaresOfSortedArray {

    /**
     * OPTIMAL SOLUTION: Two pointers approach leveraging sorted input property.
     *
     * Key insight: In a sorted array, the largest squares are at the extremes
     * (large negative or large positive values). We compare squares from both
     * ends and fill the result array from back to front.
     *
     * Time Complexity: O(n) - single pass with two pointers
     * Space Complexity: O(n) - for the result array
     *
     * @param nums Sorted integer array (ascending order)
     * @return Array of squares in sorted order
     */
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0, right = n - 1;
        int pos = n - 1;  // Fill result array from back to front

        while (left <= right) {
            int leftSquare = nums[left] * nums[left];   // Square of leftmost element
            int rightSquare = nums[right] * nums[right]; // Square of rightmost element

            if (leftSquare > rightSquare) {
                result[pos] = leftSquare;  // Place larger square at current position
                left++;                    // Move left pointer inward
            } else {
                result[pos] = rightSquare; // Place larger square at current position
                right--;                   // Move right pointer inward
            }
            pos--;  // Move to next position (towards front)
        }

        return result;
    }

    /**
     * ALTERNATIVE SOLUTION: Brute force approach (square all elements then sort).
     *
     * This approach is simpler to implement but doesn't leverage the sorted
     * property of the input array. Good as a starting solution in interviews
     * before optimizing to the two-pointer approach.
     *
     * Time Complexity: O(n log n) - due to sorting step
     * Space Complexity: O(n) - for the result array
     *
     * @param nums Sorted integer array (ascending order)
     * @return Array of squares in sorted order
     */
    public int[] sortedSquaresBruteForce(int[] nums) {
        int[] result = new int[nums.length];

        // Square all elements
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i] * nums[i];
        }

        // Sort the squared values
        Arrays.sort(result);
        return result;
    }
}