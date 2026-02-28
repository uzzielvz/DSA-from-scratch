import java.util.*;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
        Arrays.sort(segments, Comparator.comparingInt(s -> s.end));
        List<Integer> list = new ArrayList<>();
        int current = Integer.MIN_VALUE;
        for (Segment s : segments) {
            if (s.start > current) {
                current = s.end;
                list.add(current);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
        scanner.close();
    }
}
