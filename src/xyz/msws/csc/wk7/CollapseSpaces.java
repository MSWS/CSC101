package xyz.msws.csc.wk7;

import java.util.Scanner;

public class CollapseSpaces {
    public static void collapseSpaces(Scanner in) {
        while (in.hasNext()) {
            System.out.println(String.join("", in.nextLine().split(" +")).trim());
        }
    }
}
