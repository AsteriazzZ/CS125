//UIUC CS125 SPRING 2016 MP. File: MovieSurvey.java, CS125 Project: Challenge2-Hollywood, Version: 2016-02-08T21:42:05-0600.407451735
/**
 * A program to run a simple survey and report the results. See MovieSurvey.txt
 * for more information. TODO: add your netid to the line below
 * 
 * @author zzhan145
 */
public class MovieSurvey {
	public static void main(String[] arg) {
		int cinema;
		int dvdPlayer;
		int computer;
		
		//some introductory lines
		TextIO.putln("Welcome. We're interested in how people are watching movies this year.");
		TextIO.putln("Thanks for your time. - The WRITERS GUILD OF AMERICA.");
		TextIO.putln("Please tell us about how you've watched movies in the last month.");
		
		//prompt for three quantities
		//The first one
		TextIO.putln("How many movies have you seen at the cinema?");
		cinema = TextIO.getlnInt();
		
		//The second one
		TextIO.putln("How many movies have you seen using a DVD or VHS player?");
		dvdPlayer = TextIO.getlnInt();
		
		//The third one
		TextIO.putln("How many movies have you seen using a Computer?");
		computer = TextIO.getlnInt();
		
		//print out a summary of the input values
		TextIO.put("Summary: ");
		TextIO.put(cinema + " Cinema movies, ");
		TextIO.put(dvdPlayer + " DVD/VHS movies, ");
		TextIO.putln(computer + " Computer movies");
		
		//print out the total number of movies seen in one month
		int total = cinema + dvdPlayer + computer;
		TextIO.putln("Total: " + total + " movies");
		
		//print out the percent of movies seen at the cinema to two decimal places
		double percentOfCinema;
		percentOfCinema = ((float)cinema / (float)total) * 100;
		TextIO.putf("Fraction of movies seen at a cinema: %.2f%%%n", percentOfCinema);
		
		//print out the percent of movies seen outside of the cinema to two decimal places
		double percentOfOutside;
		percentOfOutside = 100 - percentOfCinema;
		TextIO.putf("Fraction of movies seen outside of a cinema: %.2f%%%n", percentOfOutside);
		
		
	}
}
