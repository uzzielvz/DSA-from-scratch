/**
 * LeetCode 55. Jump Game
 * Difficulty: Medium | Greedy
 *
 * Return true if you can reach the last index (start at 0; from i you can jump up to nums[i] steps).
 * O(n), O(1).
 */
class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false;
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= nums.length - 1) return true;
        }
        return true;
    }
}
