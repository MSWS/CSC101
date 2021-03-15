package xyz.msws.csc.wk7;

import java.util.HashMap;
import java.util.Scanner;

public class CountCoins {

    private static HashMap<String, Integer> values = new HashMap<>();

    static {
        values.put("pennies", 1);
        values.put("nickels", 5);
        values.put("dimes", 10);
        values.put("quarters", 25);
    }

    public static void countCoins(Scanner in) {
        long total = 0;
        while (in.hasNext()) {
            total += (long) in.nextInt() * getValue(in.next());
        }
        System.out.printf("Total money: $%.2f", (double) total / 100);
    }

    private static int getValue(String s) {
        return values.getOrDefault(s.toLowerCase(), 0);
    }
}
