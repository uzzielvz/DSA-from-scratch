/**
 * Test cases para Maximum Pairwise Product
 * Ejecuta estos casos para verificar que el algoritmo funciona correctamente
 */

public class MaximumPairwiseProductTest {
    public static void main(String[] args) {
        System.out.println("=== Pruebas Maximum Pairwise Product ===\n");
        
        // Test 1: A = [1, 2]
        long[] test1 = {1, 2};
        long result1 = MaximumPairwiseProduct.maximumPairwiseProduct(test1);
        System.out.println("Test 1: [1, 2]");
        System.out.println("Esperado: 2");
        System.out.println("Obtenido: " + result1);
        System.out.println("✅ " + (result1 == 2 ? "PASS" : "FAIL") + "\n");
        
        // Test 2: A = [2, 1]
        long[] test2 = {2, 1};
        long result2 = MaximumPairwiseProduct.maximumPairwiseProduct(test2);
        System.out.println("Test 2: [2, 1]");
        System.out.println("Esperado: 2");
        System.out.println("Obtenido: " + result2);
        System.out.println("✅ " + (result2 == 2 ? "PASS" : "FAIL") + "\n");
        
        // Test 3: A = [1, 2, 3]
        long[] test3 = {1, 2, 3};
        long result3 = MaximumPairwiseProduct.maximumPairwiseProduct(test3);
        System.out.println("Test 3: [1, 2, 3]");
        System.out.println("Esperado: 6");
        System.out.println("Obtenido: " + result3);
        System.out.println("✅ " + (result3 == 6 ? "PASS" : "FAIL") + "\n");
        
        // Test 4: A = [5, 5, 3] - caso con duplicados
        long[] test4 = {5, 5, 3};
        long result4 = MaximumPairwiseProduct.maximumPairwiseProduct(test4);
        System.out.println("Test 4: [5, 5, 3]");
        System.out.println("Esperado: 25");
        System.out.println("Obtenido: " + result4);
        System.out.println("✅ " + (result4 == 25 ? "PASS" : "FAIL") + "\n");
        
        // Test 5: A = [100000, 90000]
        long[] test5 = {100000, 90000};
        long result5 = MaximumPairwiseProduct.maximumPairwiseProduct(test5);
        System.out.println("Test 5: [100000, 90000]");
        System.out.println("Esperado: 9000000000");
        System.out.println("Obtenido: " + result5);
        System.out.println("✅ " + (result5 == 9000000000L ? "PASS" : "FAIL") + "\n");
        
        System.out.println("=== Fin de pruebas ===");
    }
}
