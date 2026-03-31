/**
 * LeetCode 35. Search Insert Position
 * Difficulty: Easy | Binary Search
 *
 * Dado un array ordenado sin duplicados y un target, devuelve el índice donde
 * estaría el target. Si existe, devuelve su índice; si no, el índice donde
 * se insertaría para mantener el orden.
 *
 * O(log n), O(1).
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}
