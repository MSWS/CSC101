package xyz.msws.csc.wk5;

import java.util.Scanner;

public class SmallLarge {
    public static void smallestLargest() {
        System.out.print("How many numbers do you want to enter? ");
        Scanner in = new Scanner(System.in);
        int amo = in.nextInt();

        int small = Integer.MAX_VALUE, large = Integer.MIN_VALUE;

        for (int i = 0; i < amo; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            int n = in.nextInt();
            small = Integer.min(n, small);
            large = Integer.max(n, large);
        }

        System.out.println("Smallest = " + small);
        System.out.print("Largest = " + large);
    }
}
