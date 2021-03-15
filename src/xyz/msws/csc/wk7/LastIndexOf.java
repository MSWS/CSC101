package xyz.msws.csc.wk7;

public class LastIndexOf {
    public static int lastIndexOf(int[] arr, int value) {
        int ind = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value)
                ind = i;
        }
        return ind;
    }

}
