import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        Arrays.sort(a, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        if (a[0].equals("0")) {
            return "0";
        }
        return String.join("", a);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
        scanner.close();
    }
}
