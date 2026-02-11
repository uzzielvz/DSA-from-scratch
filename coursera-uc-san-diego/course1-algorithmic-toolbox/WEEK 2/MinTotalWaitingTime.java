package coursera-uc-san-diego.course1-algorithmic-toolbox.WEEK 2;

public class MinTotalWaitingTime {
    public int minTotalWaitingTime(int[] times) {
        int totalWaitingTime = 0;
        int[] treated = new int[times.length];

        for(int i = 0; i < times.length; i++) {
            int minTime = Integer.MAX_VALUE;
            int minIndex = -1;
            for(int j = 0; j < times.length; j++) {
                if(treated[j] == 0 && times[j] < minTime) {
                    minIndex = j;
                    minTime = times[j];
                }
            }
            
            totalWaitingTime += minTime * (times.length - i - 1);
            treated[minIndex] = 1;
        }
        return totalWaitingTime;
    }
}
