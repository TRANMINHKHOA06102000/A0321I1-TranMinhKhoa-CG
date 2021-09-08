package b4_class_and_oop_in_java.baitap.stopwatch;

public class StopWatch {
    private long startTime;
    private long endTime;

    public StopWatch() {
        startTime = System.currentTimeMillis();
    }

   /* public StopWatch(long startTime, long endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }*/

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long startTime() {
        return startTime = System.currentTimeMillis();
    }

    public long endTime() {
        return endTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        long elapsedTime = endTime - startTime;
        return elapsedTime;
    }
}
