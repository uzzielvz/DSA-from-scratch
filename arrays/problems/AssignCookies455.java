import java.util.Arrays;

/**
 * Solution class for LeetCode Problem #455: Assign Cookies
 * Maximizes the number of content children by assigning cookies greedily.
 *
 * Problem Number: 455
 * Difficulty: Easy
 * Design Pattern: Greedy (sort + two pointers)
 *
 * Solution Approach:
 * Sort both arrays so we match the smallest greedy children with the smallest
 * cookies that satisfy them. Use two pointers: for each cookie, try to satisfy
 * the current child; if g[kid] <= s[cookie], assign and move to next child.
 * Each cookie is used at most once (no splitting).
 *
 * Greedy choice: assign the smallest cookie that satisfies the current child.
 * This maximizes content children because we avoid wasting large cookies on
 * small greed when a smaller cookie would suffice.
 *
 * Time complexity: O(n log n + m log m) - sorting dominates
 * Space complexity: O(log n + log m) - sorting uses stack space, or O(1) if in-place
 */
public class AssignCookies455 {

    /**
     * Returns the maximum number of content children.
     *
     * Greedy: sort children by greed (ascending), sort cookies by size (ascending),
     * then assign the smallest cookie that satisfies each child in order.
     *
     * Time Complexity: O(n log n + m log m)
     * Space Complexity: O(log n + log m) for sorting
     *
     * @param g array of children's greed factors
     * @param s array of cookie sizes
     * @return maximum number of content children
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int contentsKids = 0;
        int cookie = 0;
        int kid = 0;

        while (cookie < s.length && kid < g.length) {
            if (g[kid] <= s[cookie]) {
                contentsKids++;
                kid++;
            }
            cookie++;
        }
        return contentsKids;
    }
}
