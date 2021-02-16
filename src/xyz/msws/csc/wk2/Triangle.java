package xyz.msws.csc.wk2;

import xyz.msws.utils.StringHelper;

public class Triangle {
	public static void main(String[] args) {
		Triangle t = new Triangle();
		t.print(15);
	}

	public void print(int limit) {
		int length = limit * 2 + 1;
		for (int i = 1; i <= limit; i += 2) {
			StringBuilder builder = new StringBuilder(StringHelper.repeat(" ", length - i * 2));
			for (int j = 0; j < i; j++) {
				builder.append(i).append(j < i - 1 ? " " : "");
			}
			System.out.println(builder.toString());
		}
	}
}
