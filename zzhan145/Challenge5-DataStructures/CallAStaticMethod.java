/**
 * @author zzhan145
 */

/**
 * Prints out only lines that contain an email address Each printed line is
 * justified to right by prepending the text with '.' characters The minimum
 * width of the line including padding is 40 characters. See the test case for
 * example input and expected output.
 */
class CallAStaticMethod {

	public static void main(String[] args) {

		while (!TextIO.eof()) {
			String line = TextIO.getln();
			// Use ExampleClassMethods
			// 'isEmailAddress' and 'createPadding' to complete this method
			
			String result = "";
			if(line.indexOf(".") != -1){
				for(int i = 0; i < (40 - line.length()); i++)
					result += ".";
				result += line;
				System.out.println(result);
			}
		}

	}
}
