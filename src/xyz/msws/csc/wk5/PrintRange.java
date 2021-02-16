package xyz.msws.csc.wk5;

public class PrintRange {
    public static void main(String[] args) {
        printRange(2, 7);
        printRange(19, 11);
        printRange(5, 5);
    }

    public static void printRange(int start, int end) {
        for (int i = start; i != (end + (start > end ? -1 : 1)); i += (start > end) ? -1 : 1) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}
