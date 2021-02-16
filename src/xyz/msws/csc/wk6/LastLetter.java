package xyz.msws.csc.wk6;

import java.util.Scanner;

public class LastLetter {
    public static void main(String[] args) {
        lastLetter(new Scanner(System.in), 'e');
    }

    public static void lastLetter(Scanner in, char l) {
        String last, current = null;
        System.out.printf("Looking for two words in a row ending in an \"%c\"\n", l);
        do {
            last = current;
            System.out.print("Type a word: ");
            current = in.next();
        } while (last == null || last.charAt(last.length() - 1) != l || current.charAt(current.length() - 1) != l);
        System.out.printf("ending in \"%s\" is for \"%s\"\n", l, current);
    }
}
