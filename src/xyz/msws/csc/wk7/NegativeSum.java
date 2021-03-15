package xyz.msws.csc.wk7;

import java.util.Scanner;

public class NegativeSum {
    public static boolean negativeSum(Scanner scanner) {
        int total = 0;
        int steps = 0;
        while (scanner.hasNext() && total >= 0) {
            total += scanner.nextInt();
            steps++;
        }

        System.out.printf(total < 0 ? "%d after %d steps\n" : "no negative sum\n", total, steps);
        return total < 0;
    }
}
