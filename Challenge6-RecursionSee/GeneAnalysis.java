//UIUC CS125 SPRING 2016 MP. File: GeneAnalysis.java, CS125 Project: Challenge6-RecursionSee, Version: 2016-03-27T20:12:33-0500.368833636
/**
 * @author replace-with-your-netid-here
 *
 */
public class GeneAnalysis
{
	/** Wrapper method. Returns the length of the longest 
	 * common subsequence
	 */
	public static int score(String gene1, String gene2)
	{
		if (gene1 == "" || gene2 == "") // Two empty genes
			return 0;
		
		if (gene1.length() == 1 && gene2.length() == 1) { // Two 1-letter genes
			if (gene1.charAt(0) == gene2.charAt(0))
				return 1;
			return 0;
		}
		
		if (gene1.length() == 1) {
			if (gene1.charAt(0) == gene2.charAt(0)) // Check if the first letter is the same
				return 1;
			// The first letter is not the same. Check if we can find it in the later letters of gene2
			return score(gene1, gene2.substring(1, gene2.length()));
			
		}
		
		if (gene2.length() == 1) { // Similar as gene1.length == 1
			if (gene1.charAt(0) == gene2.charAt(0))
				return 1;
			return score(gene1.substring(1, gene1.length()), gene2);
		}
		
		if(gene1.charAt(0) == gene2.charAt(0)) // Check if the first letter is the same
			return 1 + score(gene1.substring(1, gene1.length()), gene2.substring(1, gene2.length()));
		return Math.max(score(gene1, gene2.substring(1, gene2.length())), 
				        score(gene1.substring(1, gene1.length()), gene2));
		
		// Hint: Use toCharArray() to convert each string to a char array.
		 // call your recursive implementation here with
		// the genes as char arrays, starting at the end of each gene.
	}

	/** Implements longest common subsequence recursive search
The recursive case is defined as
					S(i-1, j)
S(i,j) = max {		S(i,j-1)
					S(i-1,j-1)
					S(i-1,j-1) +1 if gene1[i] = gene2[j]

NB  0<=i < gene1.length
    0<=j < gene2.length

You need to figure out the base case.
	 * */
//	define a private recursive Class method 'score' that 
//	returns an integer the score.
//	The method should take four parameters- 
//	two char arrays and two integers (gene1,gene2,i,j)
//	i and j are the indices into gene1 and gene2 respectively.

}
// Use local variables to store a recursive result so that you  do not need to calculate it again.

// Do not use a loops.
