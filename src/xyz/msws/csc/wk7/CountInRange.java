package xyz.msws.csc.wk7;

public class CountInRange {
    public static int countInRange(int[] arr, int min, int max) {
        int total = 0;
        for (int i : arr) {
            if (i >= min && i <= max)
                total++;
        }
        return total;
    }
}
