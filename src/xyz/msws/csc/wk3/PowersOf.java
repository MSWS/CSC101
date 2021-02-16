package xyz.msws.csc.wk3;

public class PowersOf {
	public static void main(String[] args) {
		printPowersOfN(4, 3);
	}

	public static void printPowersOf2(int limit) {
		int previous = 1;
		for (int i = 0; i <= limit; i++) {
			System.out.print(previous + " ");
			previous *= 2;
		}
	}

	public static void printPowersOfN(int exp, int max) {
		int previous = 1;
		for (int i = 0; i <= max; i++) {
			System.out.print(previous + " ");
			previous *= exp;
		}
	}
}
