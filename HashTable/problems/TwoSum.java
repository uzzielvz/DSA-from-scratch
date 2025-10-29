/**
 * Solution class for LeetCode Problem #1: Two Sum.
 * Finds two numbers in an array that add up to a specific target value.
 *
 * Problem Number: 1
 * Design Pattern: Hash Map Complement Lookup
 * Solution Approach:
 * This solution uses a HashMap to achieve O(n) time complexity by storing previously
 * seen numbers and their indices. The key insight is that for each element, instead of
 * checking all remaining elements (which would be O(n²)), we can lookup its complement
 * in O(1) time. As we iterate through the array, we calculate the required complement
 * (target - nums[i]) and check if it already exists in our map. If found, we immediately
 * return the pair of indices. Otherwise, we store the current value with its index for
 * future lookups. This approach trades space for time, using O(n) extra space to achieve
 * linear time complexity.
 * Time complexity: O(n) - single pass through array with O(1) HashMap operations.
 * Space complexity: O(n) - HashMap stores at most n elements.
 */
public class TwoSum {

    /**
     * Finds two indices in the array where the values sum to the target.
     *
     * Uses the complement lookup pattern: for each number, calculates what value
     * would complete the sum (target - current) and checks if that complement was
     * seen previously. By storing numbers as keys and indices as values, we can
     * quickly retrieve the index of a complement when found. The algorithm processes
     * each element once, checking for its complement before storing it, which prevents
     * an element from pairing with itself.
     *
     * Time Complexity: O(n) - single traversal with constant-time HashMap operations
     * Space Complexity: O(n) - HashMap stores at most n key-value pairs
     *
     * @param nums Array of integers to search
     * @param target Target sum value
     * @return Array of two indices [i, j] where nums[i] + nums[j] == target
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];  // Calculate required complement

            if (map.containsKey(complement)) {   // Check if complement was seen before
                return new int[] {map.get(complement), i};  // Found pair, return indices
            }

            map.put(nums[i], i);  // Store current number with its index for future lookups
        }

        return new int[] {};  // No solution found (problem guarantees one exists)
    }
}