import java.util.Arrays;

/**
 * Solution class for the classic Binary Search algorithm.
 * This implementation provides a static method to find the index of an integer
 * in a sorted array and includes a test client for a whitelist filtering application.
 *
 * Design Pattern: Divide and Conquer
 *
 * The core logic is encapsulated in the rank() method, which efficiently locates
 * a key by repeatedly dividing the search interval in half. The main() method
 * serves as a practical example, demonstrating how binary search can be applied
 * to solve real-world problems like filtering large datasets.
 */
public class BinarySearch {

    /**
     * OPTIMAL SOLUTION: Finds the index of a specified key in a sorted array.
     * This method is the core implementation of the binary search algorithm.
     *
     * Pre-condition: The input array `a` must be sorted in ascending order.
     *
     * Time Complexity: O(log n) - In each step, the algorithm reduces the search
     * space by half, making it extremely efficient for large arrays.
     * Space Complexity: O(1) - The algorithm uses a constant amount of extra
     * space regardless of the input array size.
     *
     * @param key The integer value to search for.
     * @param a The sorted array of integers to be searched.
     * @return The index of the key in the array if it is present; -1 otherwise.
     */
    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;

        // Loop continues as long as the search space [lo..hi] is not empty.
        while (lo <= hi) {
            // Calculate mid-point safely to prevent potential integer overflow.
            int mid = lo + (hi - lo) / 2;

            if (key < a[mid]) {
                // Key is in the left half, so discard the right half.
                hi = mid - 1;
            } else if (key > a[mid]) {
                // Key is in the right half, so discard the left half.
                lo = mid + 1;
            } else {
                // Key found at the mid-point.
                return mid;
            }
        }
        // If the loop completes, the key was not found in the array.
        return -1;
    }

    /**
     * Development client and unit test for the Binary Search algorithm.
     *
     * This main method implements a "whitelist filter." It reads a list of
     * integers from a file specified as a command-line argument (the whitelist).
     * It then reads integers from standard input and prints only those integers
     * that do *not* appear in the whitelist file.
     *
     * Usage from command line:
     * java BinarySearch whitelist.txt < keys.txt
     *
     * @param args Command-line arguments. args[0] is expected to be the
     * filename of the whitelist.
     */
    public static void main(String[] args) {
        // Read the whitelist file specified in the command-line argument.
        int[] whitelist = In.readInts(args[0]);

        // IMPORTANT: The array must be sorted for binary search to work.
        Arrays.sort(whitelist);

        // Read integers from standard input until it is empty.
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();

            // Use the rank() method to check if the key is in the whitelist.
            // If rank() returns a negative value, the key is not present.
            if (rank(key, whitelist) < 0) {
                StdOut.println(key);
            }
        }
    }
}