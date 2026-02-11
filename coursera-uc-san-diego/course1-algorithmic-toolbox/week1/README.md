# Week 1: Programming Challenges

## Overview
Esta semana introduce el proceso de:
1. Leer el enunciado del problema
2. Diseñar un algoritmo
3. Implementar la solución
4. Probar y depurar
5. Enviar al sistema de calificación

---

## Problems

### 1. A Plus B
**File:** `APlusB.java`  
**Difficulty:** Warmup  
**Status:** ✅ Completed (Dec 26, 2025)

### 2. Maximum Pairwise Product
**File:** `MaximumPairwiseProduct.java`  
**Difficulty:** Easy  
**Status:** ✅ Completed (Jan 19, 2026)

**Description:** Find the maximum product of two distinct numbers in a sequence.

**Input format:** 
- First line: n (2 ≤ n ≤ 2×10^5)
- Second line: n non-negative integers

**Output format:** Maximum pairwise product

**Key learning:** 
- Find index of max1, then find index of max2 excluding index1
- Prevents index1 == index2 bug
- Use long to avoid overflow

**Test cases:**
- [1, 2] → 2 ✅
- [2, 1] → 2 ✅
- [1, 2, 3] → 6 ✅
- [5, 5, 3] → 25 ✅

**Testing:**
```bash
javac MaximumPairwiseProduct.java MaximumPairwiseProductTest.java
java MaximumPairwiseProductTest
```

**Description:** Lee dos enteros y devuelve su suma.

**Input format:** Dos enteros a y b en la misma línea (separados por espacio)  
**Output format:** La suma de a y b

**Constraints:** 1 ≤ a, b ≤ 10^9

**Sample Input:**
```
2 3
```

**Sample Output:**
```
5
```

---

## Testing

**Compile:**
```bash
javac APlusB.java
```

**Run:**
```bash
java APlusB
```

**Test manually:**
- Input: `2 3` → Expected output: `5`
- Input: `10 20` → Expected output: `30`
- Input: `1000000000 1000000000` → Expected output: `2000000000`

---

## Notes
- Este problema es sobre familiarizarse con el proceso
- El algoritmo es trivial: suma = a + b
- Enfócate en la estructura del código y lectura de input

---

**Date Started:** December 26, 2025

---

## Module 1 Progress: Programming Challenges

**Progress:** 7/17 recursos completados (41%)

**Completed:**
- Introduction to programming challenges
- Sum of two digits (APlusB assignment)
- Basic workflow and submission process
- (otros recursos del módulo)

**Remaining:** 10/17 recursos (59%)

**Next:** Completar módulo 1 antes de avanzar a problemas más complejos

---

**Last Updated:** December 26, 2025

---

### 3. Greatest Common Divisor (GCD)
**File:** `GDC.java` (en carpeta raíz course1)  
**Difficulty:** Easy  
**Status:** ✅ Completed (Jan 22, 2026)

**Description:** Find GCD of two positive integers using Euclidean algorithm.

**Algorithm:** Recursive Euclidean algorithm
- gcd(a, b) = gcd(b, a % b) until b == 0
- Time: O(log(min(a, b)))
- Space: O(log(min(a, b))) for recursion

**Key learning:** Euclidean algorithm for GCD calculation

---

## Course Progress

**Overall Progress:** 21% (Jan 22, 2026)
- Started: 14%
- Current: 21%
- Progress today: +7%**Current focus:** Studying logarithms (identified gap)**Last Updated:** January 22, 2026
