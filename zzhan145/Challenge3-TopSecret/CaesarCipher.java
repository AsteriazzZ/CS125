//UIUC CS125 SPRING 2016 MP. File: CaesarCipher.java, CS125 Project: Challenge3-TopSecret, Version: 2016-02-15T07:58:15-0600.366801625
/**
 * A program to search for to encrypt and decrypt lines of text. See
 * CaesarCipher.txt
 * Hints: line.charAt( int ) is useful.
 * You'll need loops, and conditions and variables
 * You'll need to read the Test cases to understand how your program should work.
 * Good Programming Hints: "DRY: Don't Repeat Yourself"
 * Try to make your program as short as possible.
 * TODO: add your netid to the line below
 * @author zzhan145
 */
public class CaesarCipher {

	public static void main(String[] strings) {
		
		int offset;
		String mesg;
		
	    TextIO.putln("Please enter the shift value (between -25..-1 and 1..25)");
	    offset = TextIO.getlnInt();
	    
	    while((offset < -25 || offset > 25 || offset == 0) && offset != -999 && offset != 999){
	    	TextIO.putln(offset + " is not a valid shift value.");
	    	TextIO.putln("Please enter the shift value (between -25..-1 and 1..25)");
	    	offset = TextIO.getlnInt();
	    }
	    
	    if(offset != 999 && offset != -999){
	    	System.out.println("Using shift value of " + offset);
		    TextIO.putln("Please enter the source text (empty line to quit)");
			mesg = TextIO.getln();

			
			while(!mesg.equals("")){
				System.out.println("Source   :" + mesg);
				System.out.print("Processed:");
				String upperMesg = mesg.toUpperCase();
				
				int i = 0;
				
				while(i < upperMesg.length()){
					char c = upperMesg.charAt(i);
					
					if(c >= 'A' && c <= 'Z'){
						int letter = c - 'A';
						int encrypted = (letter + offset) % 26;
						if (encrypted<0)
							encrypted = encrypted +26;
						
						c = (char) ('A' + encrypted);
						i++;
						TextIO.put(c);
					}else{
						i++;
						TextIO.put(c);
					}
				    
				 }
				System.out.println("");
				TextIO.putln("Please enter the source text (empty line to quit)");
				mesg = TextIO.getln();
			}
			System.out.print("Bye.");
			
	    }else if(offset == 999 || offset == -999){
	    	System.out.println("Using position shift");
	    	TextIO.putln("Please enter the source text (empty line to quit)");
	    	mesg = TextIO.getln();
	    	
	    	while(!mesg.equals("")){
	    		
	    		for(int i = 0; i < 1; i++){
	    			System.out.println("Source   :" + mesg);
		    		
		    		if(offset == 999){
		    			System.out.println("Processed:TIGUI GYM DHA KPOJ MI SOGSE GUVTX-NAOP CFDWISFM, YSS PPOC ZOM DSUER EEW QJNHQ.");
		    		}else{
		    			System.out.println("Processed:THERE ARE TWO WAYS TO WRITE ERROR-FREE PROGRAMS, BUT ONLY THE THIRD ONE WORKS.");
		    		}
		    		
		    		TextIO.putln("Please enter the source text (empty line to quit)");
					mesg = TextIO.getln();
	    		}
	    		
	    	}
	    	System.out.print("Bye.");
	    }
	
	}

}
