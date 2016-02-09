//UIUC CS125 SPRING 2016 MP. File: Example_Ting.java, CS125 Project: Challenge2-Hollywood, Version: 2016-02-08T21:42:05-0600.407451735
public class Example_Ting {

// Here's one version of the 'ting' lecture problem.

	public static void main(String[] args) {
		TextIO.putln("Enter a word that includes the substring 'ting'");
		String blahdeblah = TextIO.getln();
		TextIO.put("You entered:");
		TextIO.putln(blahdeblah);
		TextIO.put("Found 'ting' at position " + (1 + blahdeblah.indexOf("ting")));
	}

}
