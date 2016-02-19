//UIUC CS125 SPRING 2016 MP. File: OddSum.java, CS125 Project: Challenge3-TopSecret, Version: 2016-02-15T07:58:15-0600.366801625
/**
 * Prints sum of odd numbers in a specific format.
 * TODO: add your netid to the line below
 * @author zzhan145
 */
public class OddSum {
/**
Example output if user enters 10:
Max?
1 + 3 + 5 + 7 + 9 = 25
25 = 9 + 7 + 5 + 3 + 1

Example output if user enters 11:
Max?
1 + 3 + 5 + 7 + 9 + 11 = 36
36 = 11 + 9 + 7 + 5 + 3 + 1

 */
 public static void main(String[] args){
	 int maxNumber;
	 int arrNumber;
	 int sum = 0;
	 
	 TextIO.putln("Max?");
	 maxNumber = TextIO.getlnInt();
	 
	 if(maxNumber % 2 == 1){
		 arrNumber = maxNumber / 2 + 1;
	 }else{
		 arrNumber = maxNumber / 2;
		 maxNumber--;
	 }
	 
	 int[] odd = new int[arrNumber];
	 
		 
	 for(int i = odd.length - 1; i >= 0; i--){
	     odd[i] = maxNumber;
	     maxNumber = maxNumber - 2;
	 }
	 
	 
	 for(int i = 0; i < odd.length; i++)
		 sum = sum + odd[i];
	
	 for(int i = 0; i < (odd.length - 1); i++)
		 System.out.print(odd[i] + " + ");
	 System.out.println(odd[odd.length -1] + " = " + sum);
	 
	 System.out.print(sum + " = ");
	 for(int i = odd.length - 1; i > 0; i--)
		 System.out.print(odd[i] + " + ");
	 System.out.print(odd[0]);
		 
	

 } 
} 
