/**
 * Solution class for LeetCode Problem #860: Lemonade Change
 *
 * Problem Number: 860
 * Difficulty: Easy
 * Design Pattern: Greedy (inventory of 5s and 10s only)
 *
 * Each lemonade costs $5. Customers pay with 5, 10, or 20. Track fives and
 * tens; for a $20 prefer giving 10+5 over three 5s (more flexible change later).
 *
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class LemonadeChange860 {

    /**
     * @param bills sequence of customer payments (each is 5, 10, or 20)
     * @return true if we can provide correct change for every customer in order
     */
    public boolean lemonadeChange(int[] bills) {
        int fiveBills = 0;
        int tenBills = 0;

        for (int bill : bills) {
            if (bill == 5) {
                fiveBills++;
            } else if (bill == 10) {
                if (fiveBills == 0) {
                    return false;
                }
                fiveBills--;
                tenBills++;
            } else if (bill == 20) {
                if (fiveBills > 0 && tenBills > 0) {
                    fiveBills--;
                    tenBills--;
                } else if (fiveBills >= 3) {
                    fiveBills -= 3;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
