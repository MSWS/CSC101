package xyz.msws.csc.rocket;

import java.util.StringJoiner;

import xyz.msws.csc.utils.StringHelper;

/**
 * Prints out a very fancy rocket given a specified height
 * 
 * @author Isaac
 *
 */
public class DrawRocket {
	public static final int HEIGHT = 4;

	public static void main(String[] args) {
		System.out.println(getCone());
		System.out.println(getBody());
		System.out.println(getCone());
	}

	/**
	 * Returns the body of the rocket
	 * 
	 * @return
	 */
	public static String getBody() {
		String seperator = "+" + StringHelper.repeat("=#", HEIGHT * 2) + "+";
		StringJoiner joiner = new StringJoiner("\n");
		joiner.add(seperator);
		for (int i = 0; i < 4; i++)
			joiner.add(getTriangles(i != 3));
		joiner.add(StringHelper.repeat(seperator, 2, "\n"));

		return joiner.toString();
	}

	/**
	 * Returns the inner triangles that makeup the body
	 * 
	 * @param upper True if the triangles should point upwards, false if not
	 * @return
	 */
	public static String getTriangles(boolean upper) {
		StringJoiner joiner = new StringJoiner("\n");
		for (int i = upper ? 1 : HEIGHT; upper ? i <= HEIGHT : i > 0; i += upper ? 1 : -1) {
			String body = "|";

			body += StringHelper.repeat(".", HEIGHT - i);
			body += StringHelper.repeat(upper ? "/\\" : "\\/", i);
			body += StringHelper.repeat(".", (HEIGHT - i) * 2);
			body += StringHelper.repeat(upper ? "/\\" : "\\/", i);
			body += StringHelper.repeat(".", HEIGHT - i);

			body += "|";
			joiner.add(body);
		}
		return joiner.toString();
	}

	/**
	 * Returns the cones that are for the top and bottom of the rocket
	 * 
	 * @return
	 */
	public static String getCone() {
		StringJoiner joiner = new StringJoiner("\n");

		for (int i = 1; i < HEIGHT * 2; i++) {
			String spaces = StringHelper.repeat(" ", HEIGHT * 2 - i);
			String prefix = StringHelper.repeat("/", i);
			String body = "**";
			String suffix = StringHelper.repeat("\\", i);
			joiner.add(spaces + prefix + body + suffix);

		}

		return joiner.toString();
	}

}
