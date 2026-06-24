import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode #3 - Longest Substring Without Repeating Characters
 *
 * Sliding window con HashSet: expande con i, contrae start mientras haya
 * duplicado. maxLength = max(end - start).
 * Time: O(n) | Space: O(min(n, charset))
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {

        int start = 0;
        int end = 0;
        int maxLength = 0;

        Set<Character> set = new HashSet<>();

        for (int i = 0; i <= s.length() - 1; i++) {
            char c = s.charAt(i);

            while (set.contains(c)) {
                set.remove(s.charAt(start));
                start++;
            }

            set.add(c);
            end++;
            maxLength = Math.max(maxLength, (end - start));
        }
        return maxLength;
    }
}
