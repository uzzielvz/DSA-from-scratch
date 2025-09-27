/**
 * Solution class for LeetCode Problem #605: Can Place Flowers.
 * Determines if n flowers can be planted in a flowerbed without violating the no-adjacent rule.
 *
 * Problem Number: 605
 * Design Pattern: Greedy Algorithm
 * Solution Approach:
 * This solution uses a greedy approach to maximize flower placement by planting flowers
 * as early as possible when conditions are met. For each empty plot (value 0), we check
 * if both adjacent plots are also empty (or don't exist for edge cases). The key insight
 * is that placing a flower as soon as possible is always optimal since it doesn't prevent
 * future placements that wouldn't have been possible anyway. We handle edge cases by
 * checking if we're at the boundaries (first or last position) where there's no adjacent
 * plot to consider. After planting each flower, we decrement our target count n.
 * Time complexity: O(m) where m is the length of flowerbed.
 * Space complexity: O(1) as we modify the input array in-place.
 */
public class CanPlaceFlowers {

    /**
     * Determines if n flowers can be planted in flowerbed without adjacent flowers.
     *
     * Uses a greedy strategy: plant flowers as early as possible when valid.
     * For each empty position, checks if both neighbors are empty (or don't exist
     * at boundaries). This greedy approach is optimal because early placement
     * never prevents later valid placements that would have been impossible anyway.
     *
     * Time Complexity: O(m) where m is flowerbed length - single pass
     * Space Complexity: O(1) - modifies input array in-place
     *
     * @param flowerbed Array of 0s and 1s representing empty/occupied plots
     * @param n Number of flowers that need to be planted
     * @return true if n flowers can be planted, false otherwise
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            // Check if current position is empty and both neighbors are empty/nonexistent
            if (flowerbed[i] == 0 &&
                    (i == 0 || flowerbed[i - 1] == 0) &&                    // Left neighbor check
                    (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) { // Right neighbor check

                flowerbed[i] = 1;  // Plant flower at current position
                n--;               // Decrement remaining flowers needed

                if (n <= 0) {      // Early termination optimization
                    return true;
                }
            }
        }

        return n <= 0;  // Check if all required flowers were planted
    }
}