/**
 * Solution class for LeetCode Problem #49: Group Anagrams
 * Given an array of strings strs, group the anagrams together.
 *
 * Problem Number: 49
 * Difficulty: Medium
 * Design Pattern: Arrays & Hashing
 * 
 * Solution Approach:
 * Use HashMap where key is character frequency signature and value is list of anagrams.
 * For each string:
 * 1. Create array[26] to count character frequencies
 * 2. Convert array to String as unique key
 * 3. Group strings with same key (same character frequencies)
 * 
 * Key insight: Anagrams have identical character frequency patterns.
 * Array representation ensures same key for all anagrams.
 * 
 * Time complexity: O(n * k) where n = number of strings, k = avg string length
 * Space complexity: O(n * k) for storing all strings in HashMap
 * 
 * Alternative: Sort each string as key - O(n * k log k) time
 */

import java.util.*;

public class GroupAnagrams49 {
    
    /**
     * Groups anagrams using character frequency array as key
     * 
     * Approach:
     * 1. For each string, create frequency count array[26]
     * 2. Convert array to String representation as HashMap key
     * 3. Group all strings with same frequency pattern
     * 4. Return all groups
     * 
     * Time Complexity: O(n * k) where n = strings, k = avg length
     * Space Complexity: O(n * k) for HashMap storage
     * 
     * @param strs Array of strings
     * @return List of grouped anagrams
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // HashMap: frequency signature -> list of anagrams
        Map<String, List<String>> res = new HashMap<>();
        
        for (String s : strs) {
            // Array for lowercase letters a-z
            int[] count = new int[26];
            
            // Count frequency of each character
            for (char c : s.toCharArray()) {
                count[c - 'a']++;  // Map 'a'->0, 'b'->1, ..., 'z'->25
            }
            
            // Convert count array to String as key
            // Same frequencies = same key
            String key = Arrays.toString(count);
            
            // Create new list if key doesn't exist
            res.putIfAbsent(key, new ArrayList<>());
            
            // Add string to its anagram group
            res.get(key).add(s);
        }
        
        // Return all anagram groups
        return new ArrayList<>(res.values());
    }
    
    /**
     * Alternative solution: Sort each string as key
     * 
     * Time: O(n * k log k) - sorting each string
     * Space: O(n * k)
     * 
     * Trade-off: Simpler code, slightly worse time complexity
     */
    public List<List<String>> groupAnagramsSorting(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        
        for (String s : strs) {
            // Sort string to create consistent key
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(s);
        }
        
        return new ArrayList<>(res.values());
    }
}
