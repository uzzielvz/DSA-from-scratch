import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode #128 - Longest Consecutive Sequence
 *
 * Dado un arreglo sin ordenar, devuelve la longitud de la secuencia
 * consecutiva más larga.
 *
 * Enfoque: HashSet para lookup O(1).
 * Solo empezamos a contar desde un num si num-1 NO está en el set
 * (es el inicio de una secuencia). Luego avanzamos num+1, num+2...
 *
 * Time:  O(n)
 * Space: O(n)
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int current = num;
                int streak = 1;

                while (set.contains(current + 1)) {
                    current++;
                    streak++;
                }

                longest = Math.max(longest, streak);
            }
        }

        return longest;
    }
}
