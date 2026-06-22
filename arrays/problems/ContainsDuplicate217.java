import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode #217 - Contains Duplicate
 *
 * HashSet.add() devuelve false si el elemento ya existe → duplicado.
 * Time: O(n) | Space: O(n)
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<Integer>();

        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
