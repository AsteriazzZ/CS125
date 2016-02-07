//UIUC CS125 SPRING 2016 MP. File: Factorial.java, CS125 Project: Challenge1-DebugMe, Version: 2016-01-31T21:54:24-0600.693679958

/**
 * A program to calculate a factorial. The given code may contain errors. Fix the
 * given code and add additional code to calculate a factorial and pass the unit
 * tests. Hint sometimes an 'int' just 'aint big enough.
 * 
 * @see Factorial-ReadMe.txt for details on how to complete this program.
 * @author zzhan145
 */
public class Factorial {
	public static void main(String[] args) {
		int max = 0;			//the number I put in
		long factorial =1; 		//= max!
		
		while (max < 1 || max >= 21) {
			System.out.println("Enter a number between 1 and 20 inclusive.");
			max = TextIO.getlnInt();
		}
		
		long count = max;
		System.out.print( count + "! = ");
		
		while(count>0){
			   factorial = factorial*count;
			   count = count - 1;
			    
		}
		
		TextIO.putln(factorial);
	}
}
