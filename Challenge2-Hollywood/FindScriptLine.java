//UIUC CS125 SPRING 2016 MP. File: FindScriptLine.java, CS125 Project: Challenge2-Hollywood, Version: 2016-02-08T21:42:05-0600.407451735
/**
 * A program to search for specific lines and print their line number.
 * See FindScriptLine.txt for more details
 * TODO: add your netid to the line below
 * @author zzhan145
 */
public class FindScriptLine {

	public static void main(String[] args) {
// TODO: Implement the functionality described in FindScriptLine.txt
// TODO: Test your code manually and using the automated unit tests in FindScriptLineTest
		
		//When the program starts it asks you to enter the words to search for.
		TextIO.putln("Please enter the word(s) to search for");
		
		String word;
		word = TextIO.getln();
		int count = 0;
		boolean output = false;
		
		//read from the file
		TextIO.readFile("thematrix.txt");
		TextIO.putln("Searching for " + "\'" + word + "\'");
		
		//search until we reach the end of the file
		while(false == TextIO.eof()){
			
			//the program reads one line at a time
			String line = TextIO.getln();
			//the test is case insensitive
			String lineUpperCase = line.toUpperCase();
			String wordUpperCase = word.toUpperCase();
			
			//searching for the word you gave in the line
			if(lineUpperCase.indexOf(wordUpperCase) >= 0){
				output = true;
			}else{
				output = false;	
			}
			
			//counting for the numbers
			count = count + 1;
			
			//when we find the word, output the line number with the script, connected by a dash
			if(output){
				line = line.trim();
				TextIO.putln(count + " - " + line);
			}
		}
		TextIO.putln("Done Searching for " + "\'" + word + "\'");
	}
}
