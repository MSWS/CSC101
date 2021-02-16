package xyz.msws.csc.wk3;

import java.util.Scanner;

public class ProcessName {
	public static void processName(Scanner in) {
		System.out.print("Please enter your full name: ");
		String name = in.nextLine();

		System.out.println("Your name in reverse order is " + name.split(" ")[1] + ", " + name.split(" ")[0]);
	}
}
