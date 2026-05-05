import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode #217 - Contains Duplicate
 *
 * Dado un arreglo de enteros, devuelve true si algún valor aparece al menos
 * dos veces, y false si todos los elementos son distintos.
 *
 * Enfoque: HashSet.
 * Recorremos el arreglo intentando insertar cada elemento en un Set.
 * HashSet.add() devuelve false cuando el elemento ya existe; en ese momento
 * sabemos que hay duplicado y devolvemos true. Si terminamos el recorrido
 * sin colisiones, no hay duplicados.
 *
 * Time:  O(n)  - una sola pasada con add() en O(1) promedio.
 * Space: O(n)  - en el peor caso (sin duplicados) guardamos todos los elementos.
 *
 * Alternativa: ordenar el arreglo (O(n log n)) y comparar adyacentes en O(1)
 * espacio extra. Trade-off entre tiempo y memoria.
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {

        Set<Integer> numbers = new HashSet<>();

        for (int i = 0; i <= nums.length - 1; i++) {
            if (numbers.add(nums[i])) {
                continue;
            }
            return true;
        }
        return false;
    }
}
