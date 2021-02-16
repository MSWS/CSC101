package xyz.msws.csc.wk3;

public class WeeklyProblem {
	public static void main(String[] args) {
		printRangeOfNumbers(4, 11);
	}

	public static void printRangeOfNumbers(int start, int end) {
		for (int i = start; i < end; i++)
			System.out.printf("{%d} ", i);
	}
}
