/**
 * Solution class for LeetCode Problem #1295: Find Numbers with Even Number of Digits.
 * Counts how many numbers in an array have an even number of digits.
 *
 * Problem Number: 1295
 * Design Pattern: Mathematical Optimization vs String Conversion
 *
 * Two approaches provided:
 * 1. Mathematical (Optimal): Uses log10 for O(1) digit counting per number
 * 2. String Conversion (Alternative): Converts to string and checks length
 *
 * The mathematical approach is preferred for interviews as it demonstrates
 * algorithmic thinking and avoids string creation overhead.
 */
public class FindNumbersWithEvenDigits {

    /**
     * OPTIMAL SOLUTION: Uses logarithmic approach for efficient digit counting.
     *
     * Time Complexity: O(n) where n is array length
     * Space Complexity: O(1) - no extra space used
     *
     * @param nums Array of integers to analyze
     * @return Count of numbers with even number of digits
     */
    public int findNumbers(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (numberOfDigits(nums[i]) % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * Calculates the number of digits using mathematical formula.
     * For any positive integer n: digits = floor(log10(n)) + 1
     *
     * @param num The integer to count digits for
     * @return Number of digits in the integer
     */
    public int numberOfDigits(int num) {
        if (num == 0) return 1;                    // Special case: zero has 1 digit
        return (int) Math.log10(Math.abs(num)) + 1; // O(1) mathematical operation
    }

    /**
     * ALTERNATIVE SOLUTION: Uses string conversion for digit counting.
     *
     * Time Complexity: O(n * m) where n is array length, m is average digits
     * Space Complexity: O(m) for string creation per number
     *
     * Trade-offs:
     * + Simpler to understand and implement
     * - Creates temporary string objects (garbage collection overhead)
     * - String conversion has hidden complexity
     * - Less efficient for large datasets
     *
     * @param nums Array of integers to analyze
     * @return Count of numbers with even number of digits
     */
    public int findNumbersStringApproach(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (String.valueOf(num).length() % 2 == 0) { // String conversion approach
                count++;
            }
        }
        return count;
    }
}