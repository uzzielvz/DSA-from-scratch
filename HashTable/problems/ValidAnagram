/**
 * Solution class for LeetCode Problem #242: Valid Anagram.
 * Determines if two strings are anagrams of each other.
 *
 * Problem Number: 242
 * Design Pattern: Hash Map Frequency Counter
 * Solution Approach:
 * This solution uses a frequency counting approach with a single HashMap to determine
 * if two strings are anagrams. The key insight is that anagrams have identical character
 * frequencies. We iterate through both strings simultaneously, incrementing the count for
 * characters in the first string and decrementing for the second. If the strings are
 * anagrams, all frequencies will balance to zero. We optimize with an early length check
 * since anagrams must have equal lengths. After processing, we verify that all frequency
 * values are zero, which confirms the strings contain the same characters with identical
 * frequencies regardless of order.
 * Time complexity: O(n) where n is the length of the strings.
 * Space complexity: O(k) where k is the number of unique characters (at most 26 for lowercase).
 */
public class ValidAnagram {

    /**
     * Determines if two strings are valid anagrams of each other.
     *
     * Uses a single HashMap to track character frequencies. Increments count for
     * characters in string s and decrements for string t. If all frequencies balance
     * to zero after processing both strings, they are anagrams. This approach leverages
     * the mathematical property that equal frequencies sum to zero when using +1/-1.
     *
     * Time Complexity: O(n) - single pass through both strings + verification pass
     * Space Complexity: O(k) - HashMap stores at most k unique characters
     *
     * @param s First input string to compare
     * @param t Second input string to compare
     * @return true if strings are anagrams, false otherwise
     */
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> frequencies = new HashMap<>();

        // Early termination: anagrams must have equal length
        if (s.length() != t.length()) return false;

        // Build frequency map: increment for s, decrement for t
        for (int i = 0; i < s.length(); i++) {
            frequencies.put(s.charAt(i), frequencies.getOrDefault(s.charAt(i), 0) + 1);
            frequencies.put(t.charAt(i), frequencies.getOrDefault(t.charAt(i), 0) - 1);
        }

        // Verify all frequencies balanced to zero
        for (int count : frequencies.values()) {
            if (count != 0) return false;  // Found imbalance, not anagrams
        }

        return true;  // All frequencies zero, strings are anagrams
    }
}