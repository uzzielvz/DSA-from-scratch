/**
 * Solution class for LeetCode Problem #278: First Bad Version
 * Finds the first bad version in a sequence using binary search on an API.
 *
 * Problem Number: 278
 * Difficulty: Easy
 * Design Pattern: Binary Search (API-based)
 *
 * Solution Approach:
 * Given n versions [1, 2, 3, ..., n], where versions are ordered and once a version
 * becomes "bad", all subsequent versions are also bad. Use binary search to find the
 * first bad version by querying the isBadVersion() API:
 * - If isBadVersion(mid) is true: mid could be first bad, or there's a bad before it
 *   → search left half (right = mid - 1)
 * - If isBadVersion(mid) is false: mid is good, first bad must be to the right
 *   → search right half (left = mid + 1)
 * 
 * When the loop terminates, left points to the first bad version.
 *
 * Time complexity: O(log n) - binary search over n versions
 * Space complexity: O(1) - constant auxiliary space
 */
public class FirstBadVersion278 extends VersionControl {
    
    /**
     * Finds the first bad version using binary search.
     *
     * Similar to search insert position: when loop ends, left points to the
     * first position where the condition (isBadVersion) becomes true.
     *
     * Example: versions 1,2,3,4,5 where 4 is first bad
     * - mid=3 → isBadVersion(3)=false → left=4
     * - mid=4 → isBadVersion(4)=true → right=3
     * - Loop ends: left=4 (first bad)
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     *
     * @param n total number of versions
     * @return first bad version number
     */
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (isBadVersion(mid)) {
                // mid is bad, but check if there's a bad version before it
                right = mid - 1;
            } else {
                // mid is good, first bad must be after it
                left = mid + 1;
            }
        }
        
        return left;  // left points to first bad version
    }
}

