/**
 * Solution class for LeetCode Problem #242: Valid Anagram
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An anagram is a word formed by rearranging the letters of another word, using all 
 * the original letters exactly once.
 *
 * Problem Number: 242
 * Difficulty: Easy
 * Design Pattern: Arrays & Hashing
 * 
 * Solution Approach:
 * Use a HashMap to track character frequencies. For each position:
 * - Increment count for character in s (+1)
 * - Decrement count for character in t (-1)
 * 
 * If strings are anagrams, all counts will be 0 (each +1 cancels with -1).
 * If any count != 0, strings are not anagrams.
 * 
 * Key insight: Processing both strings simultaneously with +1/-1 eliminates
 * the need for two separate passes or two HashMaps.
 * 
 * Time complexity: O(n) where n is length of strings
 * Space complexity: O(k) where k is number of unique characters (worst case O(n))
 *                   For lowercase letters only: O(26) = O(1)
 * 
 * Alternative approaches:
 * 1. Sort both strings and compare: O(n log n) time, O(1) space
 * 2. Use array[26] for lowercase only: O(n) time, O(1) space (less flexible)
 */

import java.util.Map;
import java.util.HashMap;

public class ValidAnagram242 {
    
    /**
     * Checks if two strings are anagrams using HashMap
     * 
     * Approach:
     * 1. Early return if lengths differ (can't be anagrams)
     * 2. Iterate through both strings simultaneously:
     *    - For each char in s: increment count (+1)
     *    - For each char in t: decrement count (-1)
     * 3. Check all values in map: if any != 0, not anagrams
     * 
     * Time Complexity: O(n) - single pass + map iteration (max n unique chars)
     * Space Complexity: O(k) where k = unique characters (worst case O(n))
     * 
     * @param s First string
     * @param t Second string
     * @return true if t is anagram of s, false otherwise
     */
    public boolean isAnagram(String s, String t) {
        // Early validation: lengths must match
        if (s.length() != t.length()) return false;

        // HashMap to track character frequencies
        Map<Character, Integer> map = new HashMap<>();

        // Process both strings simultaneously
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);  // Character from s
            char c2 = t.charAt(i);  // Character from t

            // Increment for s, decrement for t
            map.put(c1, map.getOrDefault(c1, 0) + 1);
            map.put(c2, map.getOrDefault(c2, 0) - 1);
        }

        // If anagrams, all counts should be 0
        for (int val : map.values()) {
            if (val != 0) return false;  // Found character with mismatched frequency
        }
        
        return true;  // All characters matched
    }
    
    /**
     * Alternative solution: Using array for lowercase letters only
     * More efficient if we know input is only lowercase a-z
     * 
     * Time: O(n), Space: O(1) - fixed array of 26
     */
    public boolean isAnagramArray(String s, String t) {
        if (s.length() != t.length()) return false;
        
        int[] count = new int[26];  // Only for lowercase a-z
        
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;  // Increment for s
            count[t.charAt(i) - 'a']--;  // Decrement for t
        }
        
        for (int val : count) {
            if (val != 0) return false;
        }
        
        return true;
    }
    
    /**
     * Alternative solution: Sort and compare
     * 
     * Time: O(n log n), Space: O(1) or O(n) depending on sort implementation
     * Trade-off: Worse time complexity, better space complexity
     */
    public boolean isAnagramSorting(String s, String t) {
        if (s.length() != t.length()) return false;
        
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        
        java.util.Arrays.sort(sArray);  // O(n log n)
        java.util.Arrays.sort(tArray);
        
        return java.util.Arrays.equals(sArray, tArray);  // O(n)
    }
}

