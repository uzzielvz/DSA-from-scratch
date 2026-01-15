/**
 * Solution class for LeetCode Problem #347: Top K Frequent Elements
 * Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 *
 * Problem Number: 347
 * Difficulty: Medium
 * Design Pattern: Arrays & Hashing (Bucket Sort approach)
 * 
 * Solution Approach:
 * Use Bucket Sort technique:
 * 1. Count frequency of each element using HashMap
 * 2. Create array of lists indexed by frequency (bucket sort)
 * 3. Iterate from highest frequency to lowest to collect top k
 * 
 * Key insight: Maximum frequency = nums.length (if all elements same).
 * Use frequency as index, group elements by their frequency.
 * 
 * Time complexity: O(n) - counting + bucket filling + result collection
 * Space complexity: O(n) - HashMap + frequency array
 * 
 * Alternative: Heap approach O(n log k) time, but bucket sort is O(n) for this problem
 */

import java.util.*;

public class TopKFrequentElements347 {
    
    /**
     * Finds k most frequent elements using bucket sort
     * 
     * Approach:
     * 1. Count frequency of each element (HashMap)
     * 2. Create frequency buckets: array[List] indexed by frequency
     * 3. Group elements into buckets based on frequency
     * 4. Iterate from highest frequency backwards to collect top k
     * 
     * Time Complexity: O(n) where n = array length
     * Space Complexity: O(n) for HashMap and frequency buckets
     * 
     * @param nums Array of integers
     * @param k Number of top frequent elements to return
     * @return Array of k most frequent elements
     */
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequency of each element
        Map<Integer, Integer> count = new HashMap<>();
        
        // Step 2: Create frequency buckets
        // Size = nums.length + 1 because max frequency = nums.length
        List<Integer>[] freq = new List[nums.length + 1];
        
        // Initialize all buckets
        for (int i = 0; i <= nums.length; i++) {
            freq[i] = new ArrayList<>();
        }
        
        // Count frequencies
        for(int n : nums){
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        
        // Step 3: Group elements by frequency into buckets
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int frequency = entry.getValue();
            int element = entry.getKey();
            freq[frequency].add(element);  // Add element to its frequency bucket
        }
        
        // Step 4: Collect top k from highest frequency buckets
        int[] ans = new int[k];
        int index = 0;
        
        // Iterate from highest frequency (backwards) to lowest
        for(int i = freq.length - 1; i > 0 && index < k; i--){
            // Process all elements in this frequency bucket
            for(int n: freq[i]){
                ans[index++] = n;
                if(index == k) return ans;  // Found k elements, done
            }
        }
        
        return ans;
    }
    
    /**
     * Alternative solution: Using PriorityQueue (Min Heap)
     * 
     * Time: O(n log k) - heap operations
     * Space: O(k) - heap size
     * 
     * Trade-off: Slightly worse time, but better space if k << n
     */
    public int[] topKFrequentHeap(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        
        for(int n : nums){
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        
        // Min heap of size k (keep only k most frequent)
        PriorityQueue<Map.Entry<Integer, Integer>> heap = 
            new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        
        for(Map.Entry<Integer, Integer> entry : count.entrySet()){
            heap.offer(entry);
            if(heap.size() > k){
                heap.poll();  // Remove least frequent
            }
        }
        
        int[] ans = new int[k];
        for(int i = k - 1; i >= 0; i--){
            ans[i] = heap.poll().getKey();
        }
        
        return ans;
    }
}
