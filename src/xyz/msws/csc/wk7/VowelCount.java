package xyz.msws.csc.wk7;

public class VowelCount {
    public static int[] vowelCount(String s) {
        int[] vowels = new int[5];
        int index = -1;
        char[] vs = "aeiou".toCharArray();
        for (int i = 0; i < vs.length; i++) {
            for (char c : s.toCharArray()) {
                if (c == vs[i]) {
                    vowels[i]++;
                }
            }
        }
        return vowels;
    }
}
