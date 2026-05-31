/**
 * LeetCode #125 - Valid Palindrome
 *
 * Two Pointers: limpia alfanuméricos, compara desde extremos.
 * Time: O(n) | Space: O(n)
 */
class Solution {
    public boolean isPalindrome(String s) {

        char[] original = s.toCharArray();
        char[] limpio = new char[original.length];
        int k = 0;

        for (char c : original) {
            if (Character.isLetterOrDigit(c)) {
                limpio[k++] = Character.toLowerCase(c);
            }
        }

        int i = 0, j = k - 1;

        while (i < j) {
            if (limpio[i] != limpio[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
