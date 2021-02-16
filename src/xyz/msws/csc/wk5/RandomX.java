package xyz.msws.csc.wk5;

import java.util.Random;

public class RandomX {
    public static void randomX() {
        Random rnd = new Random();
        while (true) {
            int x = rnd.nextInt(15) + 5;
            p(x);
            if (x >= 16)
                break;
        }
    }

    private static void p(int a) {
        for (int i = 0; i < a; i++)
            System.out.print("x");
        System.out.println();
    }
}
