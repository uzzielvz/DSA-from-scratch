/**
 * Solution class for LeetCode Problem #238: Product of Array Except Self
 * Given an integer array nums, return an array answer such that answer[i] is equal 
 * to the product of all the elements of nums except nums[i].
 * 
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operator.
 *
 * Problem Number: 238
 * Difficulty: Medium
 * Design Pattern: Arrays & Hashing (Prefix/Suffix Product)
 * 
 * Solution Approach:
 * Use two passes:
 * 1. First pass (left to right): Calculate prefix products (all elements to the left)
 * 2. Second pass (right to left): Multiply by suffix products (all elements to the right)
 * 
 * Key insight: Product except self = (product of left) * (product of right)
 * Can't use division because of zeros. Two-pass approach avoids extra space.
 * 
 * Time complexity: O(n) - two passes through array
 * Space complexity: O(1) - only output array (not counting input/output)
 */

public class ProductOfArrayExceptSelf238 {
    
    /**
     * Calculates product of all elements except self using prefix/suffix technique
     * 
     * Approach:
     * 1. First pass: Store prefix products (all elements to the left of i)
     * 2. Second pass: Multiply by suffix products (all elements to the right of i)
     * 
     * Example: nums = [1, 2, 3, 4]
     * After pass 1: answer = [1, 1, 2, 6] (prefix products)
     * After pass 2: answer = [24, 12, 8, 6] (multiplied by suffix)
     * 
     * Time Complexity: O(n) - two passes
     * Space Complexity: O(1) - only output array
     * 
     * @param nums Array of integers
     * @return Array where answer[i] = product of all elements except nums[i]
     */
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        
        // First pass: Calculate prefix products (left side)
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            answer[i] = prefix;        // Store prefix product
            prefix *= nums[i];         // Update prefix for next iteration
        }
        
        // Second pass: Multiply by suffix products (right side)
        int suffix = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            answer[i] *= suffix;       // Multiply existing prefix by suffix
            suffix *= nums[i];        // Update suffix for next iteration
        }
        
        return answer;
    }
}
