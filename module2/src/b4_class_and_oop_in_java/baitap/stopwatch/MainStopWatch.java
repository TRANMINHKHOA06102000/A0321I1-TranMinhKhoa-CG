package b4_class_and_oop_in_java.baitap.stopwatch;

import java.util.Arrays;

public class MainStopWatch {
    public static void main(String[] args) {
        double[] array = new double[100000];
        for (int j = 0; j < 100000; j++) {
            array[j] = Math.random() * 100000;
        }
        StopWatch stopWatch = new StopWatch();
        stopWatch.startTime();
        Arrays.sort(array);
        stopWatch.endTime();
        long milliseconds = stopWatch.getElapsedTime();
        System.out.println("Thời gian thực hiện thuật toán là: " + milliseconds);
    }
}
