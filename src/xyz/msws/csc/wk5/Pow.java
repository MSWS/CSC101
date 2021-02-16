package xyz.msws.csc.wk5;

public class Pow {
    public static int pow(int base, int amo) {
        int r = 1;
        for (int i = 0; i < amo; i++)
            r *= base;
        return r;
    }
}
