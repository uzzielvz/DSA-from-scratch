import java.util.Stack;

/**
 * LeetCode 20 - Valid Parentheses
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 *
 * An input string is valid if:
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 * 3. Every close bracket has a corresponding open bracket of the same type.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // Agregar paréntesis de apertura al stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // Si encontramos un paréntesis de cierre pero el stack está vacío
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                // Verificar si el paréntesis de cierre coincide con el de apertura
                if (c == ')' && top != '(') {
                    return false;
                }
                if (c == '}' && top != '{') {
                    return false;
                }
                if (c == ']' && top != '[') {
                    return false;
                }
            }
        }

        // El string es válido solo si el stack está vacío al final
        return stack.isEmpty();
    }
}