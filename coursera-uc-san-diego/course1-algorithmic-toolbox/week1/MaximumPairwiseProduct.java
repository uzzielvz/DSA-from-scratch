/**
 * UC San Diego - Course 1: Algorithmic Toolbox
 * Week 1: Programming Challenges
 * Problem: Maximum Pairwise Product
 * 
 * Task: Find the maximum product of two distinct numbers in a sequence of non-negative integers.
 * 
 * Input format: 
 * - First line: integer n (2 ≤ n ≤ 2×10^5)
 * - Second line: n non-negative integers a1, a2, ..., an (0 ≤ ai ≤ 2×10^5)
 * 
 * Output format: 
 * - Maximum pairwise product
 * 
 * Constraints:
 * - 2 ≤ n ≤ 2×10^5
 * - 0 ≤ ai ≤ 2×10^5
 * 
 * Example:
 * Input:
 * 3
 * 1 2 3
 * Output:
 * 6
 * 
 * Explanation: Maximum product is 2 * 3 = 6
 */

import java.util.Scanner;

public class MaximumPairwiseProduct {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Lee n (número de elementos)
        int n = scanner.nextInt();
        
        // Lee el array de n enteros
        long[] numbers = new long[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextLong();
        }
        
        // Calcula y imprime el producto máximo
        long result = maximumPairwiseProduct(numbers);
        System.out.println(result);
        
        scanner.close();
    }
    
    /**
     * Encuentra el máximo producto de dos números distintos en el array
     * 
     * TODO: Implementa este método
     * 
     * @param numbers Array de números no negativos
     * @return Máximo producto de dos números distintos
     */
    public static long maximumPairwiseProduct(long[] numbers) {
        // Encuentra el índice del primer máximo
        int index1 = 0;
        for(int i = 1; i < numbers.length; i++){
            if(numbers[i] > numbers[index1]){
                index1 = i;
            }
        }
        
        // Encuentra el índice del segundo máximo
        // Si index1 es 0, empezamos desde 1, sino desde 0
        int index2 = (index1 == 0) ? 1 : 0;
        for(int i = 0; i < numbers.length; i++){
            if(i != index1 && numbers[i] > numbers[index2]){
                index2 = i;
            }
        }
        
        return numbers[index1] * numbers[index2];
    }
}
