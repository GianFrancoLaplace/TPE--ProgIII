package tpe;

public class Timer {

    private long startTime;

    public Timer() {
        startTime = 0;
    }

    public void start() {
        startTime = System.nanoTime();
    }

    public double stop() {
        long stopTime = System.nanoTime();
        double elapsedTimeInSeconds = (stopTime - startTime) / 1e9; // Convertir nanosegundos a segundos
        return elapsedTimeInSeconds;
    }
}