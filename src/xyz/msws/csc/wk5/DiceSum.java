package xyz.msws.csc.wk5;

import java.util.Random;
import java.util.Scanner;

public class DiceSum {
    public static void main(String[] args) {
        diceSum();
    }

    public static void diceSum() {
        Scanner in = new Scanner(System.in);
        System.out.print("Desired dice sum: ");
        int sum = in.nextInt();

        Random rnd = new Random();
        int a, b;
        do {
            a = rnd.nextInt(6) + 1;
            b = rnd.nextInt(6) + 1;
            System.out.printf("%d and %d = %d\n", a, b, a + b);
        } while (a + b != sum);
    }
}
