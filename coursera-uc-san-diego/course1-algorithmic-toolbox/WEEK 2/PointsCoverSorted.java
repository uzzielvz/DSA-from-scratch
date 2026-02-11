import java.util.ArrayList;
import java.util.List;

public class PointsCoverSorted {
    public static int pointsCoverSorted(int[] points) {
        
        List<int[]> result = new ArrayList<>();
        int left = 0;

        while(left < points.length) {
            int start = points[left];
            int end = start + 2;
            result.add(new int[]{start, end});
            while(left < points.length && points[left] <= end) {
                left++;
            }
        }
        return result.size();
    }

    public static void main(String[] args) {
        int[] points = {1, 2, 3, 4, 5};
        System.out.println(pointsCoverSorted(points));
    }
}