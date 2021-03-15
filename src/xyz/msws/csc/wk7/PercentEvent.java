package xyz.msws.csc.wk7;

public class PercentEvent {
    public static double percentEven(int[] arr) {
        int even = 0;
        for (int i : arr) {
            if (i % 2 == 0)
                even++;
        }
        if (arr.length == 0)
            return 0;
        return (double) even / arr.length * 100.0;
    }
}
