/**
 * Solution class for LeetCode Problem #405: Convert a Number to Hexadecimal.
 * Converts a 32-bit signed integer to its hexadecimal representation as a string.
 *
 * Problem Number: 405
 * Design Pattern: Bit Manipulation
 * Solution Approach:
 * This solution uses bitwise operations to extract hexadecimal digits from the integer's
 * binary representation. For each iteration, we extract the last 4 bits using bitwise AND
 * with 15 (binary 1111), which gives us a value 0-15 corresponding to hex digits 0-f.
 * We then use unsigned right shift (>>>) to process the next 4 bits. The unsigned shift
 * is crucial for handling negative numbers correctly, as it treats them according to
 * two's complement representation. Since we extract digits from least to most significant,
 * we reverse the final result. This approach works for both positive and negative integers
 * without using built-in conversion methods.
 * Time complexity: O(1) - at most 8 iterations for 32-bit integer.
 * Space complexity: O(1) - constant space for the result string.
 */
public class NumberToHexadecimal {

    /**
     * Converts a 32-bit signed integer to its hexadecimal string representation.
     *
     * The algorithm extracts 4-bit groups from the integer's binary representation,
     * converting each group to its corresponding hexadecimal digit (0-9, a-f).
     * Uses bitwise operations to handle both positive and negative numbers correctly
     * according to two's complement representation.
     *
     * Time Complexity: O(1) - processes at most 8 hex digits for 32-bit integer
     * Space Complexity: O(1) - result string has fixed maximum length
     *
     * @param num 32-bit signed integer to convert (-2³¹ to 2³¹-1)
     * @return Lowercase hexadecimal string representation without leading zeros
     */
    public String toHex(int num) {
        if (num == 0) return "0";

        StringBuilder result = new StringBuilder();
        char[] hexChars = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

        while (num != 0) {
            int digit = num & 15;              // Extract last 4 bits (0-15 range)
            result.append(hexChars[digit]);    // Convert to hex character
            num = num >>> 4;                   // Unsigned right shift by 4 bits
        }

        return result.reverse().toString();    // Reverse since we built digits backwards
    }
}