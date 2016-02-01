//UIUC CS125 SPRING 2016 MP. File: Winner.java, CS125 Project: Challenge1-DebugMe, Version: 2016-01-31T21:54:24-0600.693679958

/**
 * This program prints "a","b","c" depending on who has the highest score. The
 * given code may not be correct. Fix it and additional code to pass the unit
 * tests.
 * 
 * @see Winner-ReadMe.txt for details on how to complete this program.
 * @author insert-your-netid-here
 * 
 */
public class Winner {
	public static void main(String[] args) {
		System.out.println("Enter three unique integer scores.");

		int a = TextIO.getlnInt();
		int b = TextIO.getlnInt();
		int c = TextIO.getlnInt();

		TextIO.put("1st Place:");
		if (a > b && a > c)
			TextIO.putln("wow");
		// the logic and text output need further work...
	}
}
