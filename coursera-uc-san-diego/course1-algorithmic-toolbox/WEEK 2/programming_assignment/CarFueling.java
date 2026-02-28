import java.util.*;
import java.io.*;

/**
 * CAR FUELING — Greedy solution.
 *
 * HOW TO DESIGN A GREEDY ALGORITHM (steps to reuse on any problem):
 *
 * 1. CHOICE: What decision do we make at each step?
 *    Here: "At which station do I refill?" → Greedy: refill only when necessary,
 *    and when you do, you're at the farthest station you could reach.
 *
 * 2. SAFE MOVE: This choice is "safe" (leads to an optimal). Here: going as far
 *    as possible before refilling never forces more refills.
 *
 * 3. SUBPROBLEM: After the choice, what's left? Same problem from new position.
 *
 * 4. INVARIANT: We can always reach the current station from lastRefill (or start).
 *
 * 5. IMPLEMENT: One pass. At each station: can I reach it? If not → -1.
 *    From here with full tank, can I reach next stop or dist? If not → refill here.
 */
public class CarFueling {

    static int computeMinRefills(int dist, int tank, int[] stops) {
        int numRefills = 0;
        int lastRefill = 0;  // position after last refill (0 = start with full tank)

        for (int i = 0; i < stops.length; i++) {
            // Can we reach this station from lastRefill?
            if (stops[i] - lastRefill > tank) {
                return -1;
            }
            int nextTarget = (i + 1 < stops.length) ? stops[i + 1] : dist;
            if (lastRefill + tank >= dist) {
                return numRefills;
            }
            // Can't reach next target from lastRefill → must refill here
            if (lastRefill + tank < nextTarget) {
                if (stops[i] + tank < nextTarget) {
                    return -1;  // even with full tank from here, can't reach next
                }
                numRefills++;
                lastRefill = stops[i];
            }
        }

        if (lastRefill + tank >= dist) {
            return numRefills;
        }
        return -1;
    }

    /** Compact version: while we haven't reached dist, jump to farthest reachable station; refill there. */
    static int computeMinRefillsCompact(int dist, int tank, int[] stops) {
        int refills = 0, lastRefill = 0, i = 0;
        while (lastRefill + tank < dist) {
            while (i < stops.length && stops[i] <= lastRefill + tank) i++;
            if (i > 0 && stops[i - 1] > lastRefill) {
                lastRefill = stops[i - 1];
                refills++;
            } else {
                return -1;
            }
        }
        return refills;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
        scanner.close();
    }
}
