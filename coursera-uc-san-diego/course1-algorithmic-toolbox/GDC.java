/**
 * UC San Diego - Course 1: Algorithmic Toolbox
 * Week 1: Programming Challenges
 * Problem: Greatest Common Divisor (GCD)
 * 
 * Task: Find the greatest common divisor of two positive integers using Euclidean algorithm.
 * 
 * Input format: Two positive integers a and b (separated by space)
 * Output format: GCD of a and b
 * 
 * Constraints:
 * 1 ≤ a, b ≤ 2×10^9
 * 
 * Example:
 * Input: 18 35
 * Output: 1
 * 
 * Explanation: GCD(18, 35) = 1 (they are coprime)
 */

import java.util.Scanner;

public class GDC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Lee dos enteros
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        
        // Calcula y imprime el GCD
        int result = gcd(a, b);
        System.out.println(result);
        
        scanner.close();
    }
    
    /**
     * Calcula el máximo común divisor usando el algoritmo de Euclides
     * 
     * Algoritmo de Euclides:
     * gcd(a, b) = gcd(b, a % b) hasta que b == 0
     * 
     * Time Complexity: O(log(min(a, b)))
     * Space Complexity: O(log(min(a, b))) por recursión
     * 
     * @param a Primer entero positivo
     * @param b Segundo entero positivo
     * @return GCD de a y b
     */
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
