/**
* Solution class for LeetCode Problem #485: Max Consecutive Ones.
* Finds the maximum number of consecutive 1s in a binary array.
*
* Problem Number: 485
* Design Pattern: Sliding Window / Running Counter
* Solution Approach:
* The solution uses a running counter to track consecutive 1s while iterating through
* the array. It maintains a global maximum that gets updated eagerly during each iteration
* using Math.max(). When a 0 is encountered, the counter resets to start a new sequence.
* This approach eliminates the need for boundary checks and handles edge cases naturally.
* The time complexity is O(n) where n is the length of the array, and the space complexity
* is O(1) since only two variables are used.
*/
public class MaxConsecutiveOnes {

   /**
    * Finds the maximum number of consecutive 1s in a binary array.
    *
    * @param nums A binary array containing only 0s and 1s
    * @return The maximum number of consecutive 1s found in the array
    */
   public int findMaxConsecutiveOnes(int[] nums) {
       int max = 0;     // Tracks the maximum consecutive 1s found so far
       int counter = 0; // Tracks the current sequence of consecutive 1s

       // Iterate through the array using enhanced for loop
       for (int num : nums) {
           if (num == 1) {
               counter++;                        // Extend current sequence
               max = Math.max(max, counter);     // Update maximum eagerly
           } else {
               counter = 0;                      // Reset counter when 0 is found
           }
       }

       return max;
   }
}