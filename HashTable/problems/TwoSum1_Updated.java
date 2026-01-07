/**
 * Solution class for LeetCode Problem #1: Two Sum
 * Given an array of integers nums and an integer target, return indices of the 
 * two numbers such that they add up to target.
 *
 * Problem Number: 1
 * Difficulty: Easy
 * Design Pattern: Arrays & Hashing
 * 
 * Solution Approach:
 * Use HashMap to store seen numbers and their indices. For each element:
 * 1. Calculate complement (target - current number)
 * 2. Check if complement exists in map
 * 3. If yes, return [complement_index, current_index]
 * 4. If no, store current number and index in map
 * 
 * Key insight: Store element AFTER checking for complement to avoid using 
 * the same element twice (e.g., target=10, nums[i]=5 would match itself).
 * 
 * Time complexity: O(n) - single pass through array
 * Space complexity: O(n) - worst case store all elements in HashMap
 */

import java.util.Map;
import java.util.HashMap;

public class TwoSum1_Updated {
    
    /**
     * Finds two indices where nums[i] + nums[j] = target
     * 
     * Approach:
     * 1. Create HashMap to store (value -> index) mappings
     * 2. For each element:
     *    - Calculate complement = target - nums[i]
     *    - Check if complement exists in map
     *    - If yes: found the pair, return indices
     *    - If no: store current element and continue
     * 
     * Time Complexity: O(n) where n is length of array
     * Space Complexity: O(n) for HashMap storage (worst case)
     * 
     * @param nums Array of integers
     * @param target Target sum
     * @return Array of two indices [i, j] where nums[i] + nums[j] = target
     */
    public int[] twoSum(int[] nums, int target) {
        // HashMap: stores (number -> index)
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            
            // Check if complement exists (BEFORE storing current element)
            if(map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            
            // Store current element AFTER checking
            // This prevents using same element twice
            map.put(nums[i], i);
        }
        
        // No solution found (problem guarantees exactly one solution)
        return new int[]{}; 
    }
}

