package xyz.msws.csc.wk2;

import xyz.msws.utils.StringHelper;

/**
 * Prints a left-justified triangle
 * 
 * @author imodm
 *
 */
public class BetterTriangle {
	public static void main(String[] args) {
		BetterTriangle t = new BetterTriangle();
		t.print(15);
	}

	public void print(int limit) {
		// Get the maxLength of the last line to properly space out the characters
		int maxLength = StringHelper.repeat(limit + " ", limit).length();
		for (int i = 1; i <= limit; i += 2) {
			String s = StringHelper.repeat(i + " ", i);
			// I think this is cheating but it works ;)
			System.out.println(String.format("%" + maxLength + "s", s));
		}
	}
}
