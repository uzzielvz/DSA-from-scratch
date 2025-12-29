/**
 * Solution class for LeetCode Problem #217: Contains Duplicate
 * Given an integer array nums, return true if any value appears at least twice in the array, 
 * and return false if every element is distinct.
 *
 * Problem Number: 217
 * Difficulty: Easy
 * Design Pattern: Arrays & Hashing
 * 
 * Solution Approach:
 * Use a HashSet to track elements we've seen. As we iterate through the array:
 * - If add() returns false, the element already exists → duplicate found
 * - If we complete the loop without finding duplicates, return false
 * 
 * Key insight: HashSet.add() returns false when element already exists, which
 * directly indicates a duplicate without needing a separate contains() check.
 * 
 * Time complexity: O(n) - single pass through array, O(1) HashSet operations
 * Space complexity: O(n) - worst case, store all elements if no duplicates
 * 
 * Alternative approach: Sort array (O(n log n)) then check adjacent elements (O(1) space)
 */

import java.util.Set;
import java.util.HashSet;

public class ContainsDuplicate217 {
    
    /**
     * Checks if array contains any duplicate elements
     * 
     * Approach:
     * 1. Create HashSet to track seen elements
     * 2. For each element in array:
     *    - Try to add to set
     *    - If add() returns false, element exists → return true (duplicate found)
     * 3. If loop completes, no duplicates → return false
     * 
     * Time Complexity: O(n) where n is length of array
     * Space Complexity: O(n) for HashSet storage
     * 
     * @param nums Array of integers to check
     * @return true if any value appears at least twice, false otherwise
     */
    public boolean containsDuplicate(int[] nums) {
        // HashSet to track elements we've seen
        Set<Integer> elements = new HashSet<>(); 
        
        // Iterate through array
        for(int num: nums){
            // add() returns false if element already exists
            if(!elements.add(num)){
                return true;  // Duplicate found
            }
        }
        
        return false;  // No duplicates found
    }
    
    /**
     * Alternative solution: Sort + compare adjacent elements
     * Time: O(n log n), Space: O(1) or O(n) depending on sorting algorithm
     * 
     * Trade-off: Better space complexity, worse time complexity
     */
    public boolean containsDuplicateSorting(int[] nums) {
        java.util.Arrays.sort(nums);
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]){
                return true;
            }
        }
        
        return false;
    }
}

