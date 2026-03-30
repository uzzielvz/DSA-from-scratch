import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution class for LeetCode Problem #763: Partition Labels
 *
 * Problem Number: 763
 * Difficulty: Medium
 * Design Pattern: Greedy (expand partition end by last occurrence of letters seen)
 *
 * Split the string into as many parts as possible so each letter appears in at
 * most one part. Track the farthest index any character in the current chunk
 * must reach; when the scan index meets that bound, close the chunk.
 *
 * Time complexity: O(n)
 * Space complexity: O(1) alphabet / O(k) distinct characters in map
 */
public class PartitionLabels763 {

    /**
     * @param s lowercase English letters
     * @return sizes of each partition in order
     */
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastIndex.put(s.charAt(i), i);
        }

        int end = 0;
        int start = 0;
        List<Integer> result = new ArrayList<>();

        for (int current = 0; current < s.length(); current++) {
            end = Math.max(lastIndex.get(s.charAt(current)), end);
            if (current == end) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }
}
