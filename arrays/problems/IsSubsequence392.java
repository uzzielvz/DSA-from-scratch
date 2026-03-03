/**
 * LeetCode 392. Is Subsequence
 * Difficulty: Easy | Two Pointers
 *
 * Returns true if s is a subsequence of t (same order, not necessarily consecutive).
 * O(|s| + |t|), O(1) space.
 */
class Solution {
    public boolean isSubsequence(String s, String t) {
        int is = 0;
        for (int it = 0; it < t.length(); it++) {
            if (is < s.length() && s.charAt(is) == t.charAt(it)) {
                is++;
            }
        }
        return is == s.length();
    }
}
