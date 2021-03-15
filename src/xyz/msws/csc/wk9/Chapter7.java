package xyz.msws.csc.wk9;

public class Chapter7 {
    public static double[] arraySum(double[] a, double[] b) {
        double[] result = new double[Math.max(a.length, b.length)];
        for (int i = 0; i < result.length; i++) {
            result[i] = (i < a.length ? a[i] : 0) + (i < b.length ? b[i] : 0);
        }
        return result;
    }

    public static void rotateRight(int[] arr) {
        int last = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
//        System.arraycopy(arr, 0, arr, 1, arr.length - 1);
        arr[0] = last;
    }

    public static void swapAll(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            int c = b[i];
            b[i] = a[i];
            a[i] = c;
        }
    }

    public static int[] delta(int[] a) {
        int[] b = new int[a.length * 2 - 1];
        for (int i = 0; i < a.length - 1; i++) {
            b[i * 2] = a[i];
            b[i * 2 + 1] = a[i + 1] - a[i];
        }
        b[b.length - 1] = a[a.length - 1];
        return b;
    }
}
