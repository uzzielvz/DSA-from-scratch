import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode #1 - Two Sum
 *
 * Dado un arreglo de enteros y un target, devuelve los índices de los dos
 * números cuya suma es igual al target.
 *
 * Enfoque: HashMap con búsqueda de complemento.
 * Para cada nums[i] calculamos complement = target - nums[i] y revisamos si
 * ya lo vimos antes. Si sí, devolvemos los índices; si no, guardamos el
 * número actual con su índice. Al revisar ANTES de guardar evitamos usar
 * el mismo elemento dos veces.
 *
 * Time:  O(n)  - una sola pasada con operaciones O(1) en el HashMap.
 * Space: O(n)  - en el peor caso guardamos todos los elementos.
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i <= nums.length - 1; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{0, 0};
    }
}
