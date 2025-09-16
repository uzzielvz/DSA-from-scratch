/**
 * Solution class for LeetCode Problem #867: Transpose Matrix.
 * Returns the transpose of a 2D integer matrix by flipping over the main diagonal.
 *
 * Problem Number: 867
 * Design Pattern: Matrix Manipulation
 * Solution Approach:
 * The transpose operation flips a matrix over its main diagonal, switching row and
 * column indices. For an m×n matrix, the transpose becomes an n×m matrix where
 * element at position [i][j] in the original matrix moves to position [j][i] in
 * the transposed matrix. Since dimensions change (unless it's a square matrix),
 * we must create a new result array with swapped dimensions. The algorithm iterates
 * through each element once, performing the coordinate transformation.
 * Time complexity: O(m×n) where m and n are the matrix dimensions.
 * Space complexity: O(m×n) for the result matrix.
 */
public class TransposeMatrix {

    /**
     * Returns the transpose of the given matrix by flipping over main diagonal.
     *
     * The transpose operation switches rows and columns: element at matrix[i][j]
     * becomes result[j][i]. For a matrix with m rows and n columns, the result
     * will have n rows and m columns.
     *
     * Time Complexity: O(m×n) - visit each element exactly once
     * Space Complexity: O(m×n) - create new matrix for result
     *
     * @param matrix 2D integer array to transpose (m×n dimensions)
     * @return New 2D array representing the transpose (n×m dimensions)
     */
    public int[][] transpose(int[][] matrix) {
        // Create result matrix with swapped dimensions: n×m instead of m×n
        int[][] result = new int[matrix[0].length][matrix.length];

        // Iterate through original matrix dimensions
        for (int i = 0; i < matrix.length; i++) {           // Traverse rows (m)
            for (int j = 0; j < matrix[0].length; j++) {     // Traverse columns (n)
                result[j][i] = matrix[i][j];                 // Swap coordinates: [i][j] → [j][i]
            }
        }

        return result;
    }
}