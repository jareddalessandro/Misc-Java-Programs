package StopWatch;

//Useful stopwatch class can be used to time applications

public class StopWatch {

    private long startTime;
    private long elapsedTime;
    private boolean isRunningInd;

    public void start() {
        synchronized (this) {
            startTime = System.currentTimeMillis();
            isRunningInd = true;
        }
    }

    public void stop() {
        synchronized (this) {
            elapsedTime = System.currentTimeMillis() - startTime;
            isRunningInd = false;
        }
    }

    public void reset() {
        synchronized (this) {
            startTime = 0;
            elapsedTime = 0;
            isRunningInd = false;
        }
    }

    public double getTime() {
        synchronized (this) {
            double currentElapsedTime = 0;
            if (isRunningInd) {
                currentElapsedTime = System.currentTimeMillis() - startTime;
            }
            return elapsedTime + currentElapsedTime;
        }
    }
}