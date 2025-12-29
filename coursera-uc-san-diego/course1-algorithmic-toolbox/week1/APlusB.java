/**
 * UC San Diego - Course 1: Algorithmic Toolbox
 * Week 1: Programming Challenges
 * Problem: A Plus B
 * 
 * Task: Read two integers from standard input and output their sum.
 * 
 * Input format: Two integers a and b on the same line (separated by a space).
 * Output format: The sum of a and b.
 * 
 * Constraints:
 * 1 ≤ a, b ≤ 10^9
 */

import java.util.Scanner;

public class APlusB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int a = scanner.nextInt();
        int b = scanner.nextInt();  
        
        int sum = a + b;
        
        System.out.println(sum);
        
        scanner.close();
    }
}

