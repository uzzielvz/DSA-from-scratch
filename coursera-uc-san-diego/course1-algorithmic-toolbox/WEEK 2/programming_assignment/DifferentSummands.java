import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<>();
        int next = 1;
        int remaining = n;
        while (remaining >= next) {
            summands.add(next);
            remaining -= next;
            next++;
        }
        if (remaining > 0) {
            int last = summands.remove(summands.size() - 1);
            summands.add(last + remaining);
        }
        return summands;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
        scanner.close();
    }
}
