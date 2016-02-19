//UIUC CS125 SPRING 2016 MP. File: CipherBreaker.java, CS125 Project: Challenge3-TopSecret, Version: 2016-02-15T07:58:15-0600.366801625
/**
 * See CipherBreaker.txt for instructions.
 * TODO: add your netid to the line below
 * 
 * @author zzhan145
 */
public class CipherBreaker {

	public static void main(String[] args) {
		TextIO.putln("Text?");
		String line = TextIO.getln();
		TextIO.putln(line);
		
		int[] letterHistogram = new int[26];
        int numDigits = 0;
        int numSpaces = 0;
        int numPunctuations = 0;
        
        for (int i = 0; i < letterHistogram.length; i++) 
        	   letterHistogram[i] = 0;
        
        int i = 0;
        while(i < line.length()){
        	char c = line.charAt(i);
        	
        	if(c >= 'A' && c <= 'Z'){
        		int letter = c - 'A';
        		letterHistogram[letter]++;
        	}else if(c >= 'a' && c <= 'z'){
        		int letter = c - 'a';
        		letterHistogram[letter]++;
        	}else if(c >= '0' && c <= '9'){
        		numDigits++;
        	}else if(c == ' '){
        		numSpaces++;
        	}else if(c == '\"' || c == '-' || c == '\'' || c == '.' || c == '!' || c == ','){
        		numPunctuations++;
        	}	
        	i++;
        }
      
        for (i = 0; i < letterHistogram.length; i++ ){
        	if(letterHistogram[i] != 0){
        		char d = (char)('A' + i);
        		System.out.println(d + ":" + letterHistogram[i]);
            }
        }
        if(numDigits!=0)
        	System.out.println("DIGITS:" + numDigits);
        if(numSpaces!=0)
        	System.out.println("SPACES:" + numSpaces);
        if(numPunctuations!=0)
        	System.out.println("PUNCTUATION:" + numPunctuations);
        

    }	
	
}
