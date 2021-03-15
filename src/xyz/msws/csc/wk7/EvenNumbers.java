package xyz.msws.csc.wk7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EvenNumbers {

    public static void evenNumbers(Scanner in) {
        List<Integer> nums = new ArrayList<>();
        while (in.hasNext())
            nums.add(in.nextInt());

        int total = 0;
        int evens = 0;
        for (int i : nums) {
            total += i;
            evens += i % 2 == 0 ? 1 : 0;
        }

        System.out.printf("%d numbers, sum = %d\n", nums.size(), total);
        System.out.printf("%d evens (%.2f%%)", evens, (double) evens / nums.size() * 100);
    }
}
