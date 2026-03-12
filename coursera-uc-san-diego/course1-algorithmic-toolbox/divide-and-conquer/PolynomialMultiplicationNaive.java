/**
 * UC San Diego - Course 1: Algorithmic Toolbox
 * Section: Divide and Conquer
 *
 * Naive algorithm for multiplying two polynomials.
 * A(x) = A[0] + A[1]*x + ... + A[n-1]*x^(n-1)
 * B(x) = B[0] + B[1]*x + ... + B[n-1]*x^(n-1)
 *
 * Result C = A * B has degree at most 2n-2 (length 2n-1).
 * Time: O(n^2).
 */
public class PolynomialMultiplicationNaive {

    /**
     * Multiplies two polynomials given by their coefficient arrays.
     *
     * @param A coefficients of first polynomial (max degree n-1)
     * @param B coefficients of second polynomial (max degree n-1)
     * @param n maximum degree + 1 (number of coefficients per polynomial)
     * @return coefficients of C = A * B (length 2n-1)
     */
    public static long[] multiply(int[] A, int[] B, int n) {
        // TODO: implementar algoritmo naive: C[k] = sum_{i+j=k} A[i]*B[j]
        // Resultado: array de longitud 2*n - 1
        throw new UnsupportedOperationException("TODO: implementar multiplicación naive de polinomios");
    }

    /** Prints polynomial as a_0 + a_1*x + a_2*x^2 + ... */
    public static String polyToString(long[] coeffs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < coeffs.length; i++) {
            if (coeffs[i] == 0) continue;
            if (sb.length() > 0) sb.append(" + ");
            sb.append(coeffs[i]);
            if (i > 0) sb.append("*x^").append(i);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        // Ejemplo: (1 + 2x) * (1 + 3x) = 1 + 5x + 6x^2
        // n = 2 (grado máx 1), A = [1, 2], B = [1, 3]
        int n = 2;
        int[] A = {1, 2};
        int[] B = {1, 3};

        long[] C = multiply(A, B, n);
        System.out.println("A(x) = " + polyToString(new long[]{A[0], A[1]}));
        System.out.println("B(x) = " + polyToString(new long[]{B[0], B[1]}));
        System.out.println("C(x) = A(x)*B(x) = " + polyToString(C));

        // Otro: (1 + x + x^2) * (1 + x) con n=3
        System.out.println();
        n = 3;
        A = new int[]{1, 1, 1};
        B = new int[]{1, 1, 0};
        C = multiply(A, B, n);
        System.out.println("A(x) = 1 + x + x^2");
        System.out.println("B(x) = 1 + x");
        System.out.println("C(x) = " + polyToString(C));
    }
}
