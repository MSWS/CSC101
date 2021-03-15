package xyz.msws.csc.wk7;

import java.util.Scanner;

public class PurpleGold {
    public static void purpleGold(Scanner in) {
        int purple = 0, gold = 0;
        int total = 0;
        boolean uneven = false;
        while (in.hasNext()) {
            in.next();
            purple += in.nextInt();
            total++;
            if (!in.hasNext()) {
                uneven = true;
                break;
            }
            in.next();
            gold += in.nextInt();
        }
        System.out.printf("%d purple, %d gold\n", total, total - (uneven ? 0 : 1));
        System.out.printf("Difference between purple team and gold team sums: %d", Math.abs(purple - gold));
    }
}
