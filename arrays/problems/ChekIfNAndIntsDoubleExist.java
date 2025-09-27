/**
 * Solution class for LeetCode Problem #1346: Check If N and Its Double Exist.
 * Determines if there exist two indices where one element is double the other.
 *
 * Problem Number: 1346
 * Design Pattern: Hash Set Lookup
 * Solution Approach:
 * This solution uses a HashSet to efficiently track previously seen elements while
 * iterating through the array. For each element, we check if its double (num * 2)
 * or its half (num / 2, if even) already exists in the set. The key insight is to
 * search before adding the current element to avoid an element matching with itself.
 * We only check for half when the number is even to avoid integer division issues.
 * This approach ensures we find pairs where one element appears before the other
 * in the array, satisfying the distinct indices requirement.
 * Time complexity: O(n) - single pass with O(1) HashSet operations.
 * Space complexity: O(n) - HashSet stores at most n elements.
 */
public class CheckIfNAndItsDoubleExist {

    /**
     * Checks if there exist two distinct indices i and j such that arr[i] = 2 * arr[j].
     *
     * The algorithm maintains a HashSet of previously seen elements. For each element,
     * it checks if either its double or half (when even) exists in the set before
     * adding the current element. This ordering prevents self-matching and ensures
     * we only find valid pairs with distinct indices.
     *
     * Time Complexity: O(n) - single traversal with constant-time set operations
     * Space Complexity: O(n) - HashSet stores up to n unique elements
     *
     * @param arr Array of integers to search for double relationships
     * @return true if N and its double exist at different indices, false otherwise
     */
    public boolean checkIfExist(int[] arr) {
        Set<Integer> seen = new HashSet<>();

        for (int num : arr) {
            // Check if double or half exists before adding current element
            if (seen.contains(num * 2) || (num % 2 == 0 && seen.contains(num / 2))) {
                return true;  // Found valid pair with distinct indices
            }

            seen.add(num);  // Add current element for future searches
        }

        return false;  // No valid pairs found
    }
}