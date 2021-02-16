package xyz.msws.csc.wk5;

import java.util.ArrayList;
import java.util.List;

public class PrintFactors {
    public static void printFactors(int max) {
        List<String> factors = new ArrayList<>();
        for (int i = 1; i <= max; i++) {
            if ((double) max / i == Math.round((double) max / i)) {
                factors.add(i + "");
            }
        }
        System.out.println(String.join(" and ", factors));
    }
}
