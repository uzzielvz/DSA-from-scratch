import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode #49 - Group Anagrams
 *
 * Dado un arreglo de strings, agrupa los anagramas juntos.
 *
 * Enfoque: HashMap con clave = versión ordenada de cada palabra.
 * Anagramas comparten la misma clave (mismos caracteres, distinto orden).
 * Por cada string: ordenamos sus chars, usamos esa clave en el map,
 * y agregamos la palabra a la lista correspondiente.
 *
 * Time:  O(n * k log k)  - n strings, k = longitud promedio; sort por palabra.
 * Space: O(n * k)        - almacenar todas las strings en el map.
 *
 * Alternativa: array[26] de frecuencias como clave → O(n * k) sin sort.
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String palabra : strs) {
            String clave = ordenarPalabra(palabra);

            if (!map.containsKey(clave)) {
                map.put(clave, new ArrayList<>());
            }
            map.get(clave).add(palabra);
        }

        return new ArrayList<>(map.values());
    }

    public static String ordenarPalabra(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
