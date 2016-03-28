/**
 * @author zzhan145
 */

/**
 * Complete the class method 'analyze' that takes a SimplePublicPair object as an argument
 * and returns a new SimplePublicTriple object.
 * The SimplePublicTriple needs to set up as follows:
 * x = the minimum value of 'a' and 'b'
 * y = the maximum value of 'a' and 'b'
 * description:a*b=M 
 *   where a,b, and M are replaced with the numerical values of a, b and the multiplication of a and b.
 * Your code will create a SimplePublicTriple, initializes the three fields and return a reference to the SimplePublicTriple object.
 *
 */
public class UsingPublicFieldsIsEasy {
	
	public static SimplePublicTriple analyze(SimplePublicPair pair) {
		
		SimplePublicTriple result = new SimplePublicTriple();
		
		if(pair.a < pair.b){
			result.x = pair.a;
			result.y = pair.b;
		}else{
			result.x = pair.b;
			result.y = pair.a;
		}
		
		int M = pair.a * pair.b;
		result.description = (pair.a + "*" + pair.b + "=" + M);
		
		return result;
		
	}
}
