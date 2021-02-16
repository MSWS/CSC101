package xyz.msws.csc.utils;

import java.util.StringJoiner;

/**
 * Simple utilities class for string operations
 * 
 * @author Isaac
 *
 */
public class StringHelper {
	/**
	 * Repeats a string amo times
	 * 
	 * @param s   String to repeat
	 * @param amo amount of times to repeat
	 * @return s repeated amo times
	 */
	public static String repeat(String s, int amo) {
		return repeat(s, amo, "");
	}

	/**
	 * Repeats a string amo times with sep in between each repetition
	 * 
	 * @param s   String to repeat
	 * @param amo amount of times to repeat
	 * @param sep String to separate each s
	 * @return s repeated amo times with sep in between each repeat
	 */
	public static String repeat(String s, int amo, String sep) {
		if (s == null)
			throw new NullPointerException("String cannot be null");
		StringJoiner joiner = new StringJoiner(sep);
		for (int i = 0; i < amo; i++)
			joiner.add(s);
		return joiner.toString();
	}
}
