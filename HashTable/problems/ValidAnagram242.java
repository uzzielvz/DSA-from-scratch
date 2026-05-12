import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode #242 - Valid Anagram
 *
 * Dadas dos strings s y t, devuelve true si t es un anagrama de s.
 * Un anagrama usa exactamente los mismos caracteres con las mismas frecuencias,
 * solo reordenados.
 *
 * Enfoque: HashMap de frecuencias con dos pasadas (+1 en t, -1 en s).
 * Si longitudes difieren, no pueden ser anagramas (early return).
 * Contamos cada char de t como +1 y cada char de s como -1 sobre el MISMO map.
 * Si son anagramas, todos los valores quedan en 0; si alguno no es 0, no lo son.
 *
 * Time:  O(n)  - dos pasadas lineales sobre las strings + recorrido del map.
 * Space: O(k)  - k = caracteres únicos. Para solo minúsculas, k ≤ 26 → O(1).
 *
 * Alternativas:
 *  - int[26] si garantizan solo 'a'-'z' → mismo O(n) tiempo pero O(1) espacio fijo.
 *  - Ordenar ambas strings y comparar → O(n log n) tiempo, O(1) espacio extra.
 */
class Solution {
    public boolean isAnagram(String s, String t) {

        Map<Character, Integer> frequencies = new HashMap<>();

        if (s.length() != t.length()) return false;

        for (int i = 0; i < t.length(); i++) {
            frequencies.put(t.charAt(i), frequencies.getOrDefault(t.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            frequencies.put(s.charAt(i), frequencies.getOrDefault(s.charAt(i), 0) - 1);
        }

        for (Integer frequency : frequencies.values()) {
            if (frequency != 0) return false;
        }
        return true;
    }
}
