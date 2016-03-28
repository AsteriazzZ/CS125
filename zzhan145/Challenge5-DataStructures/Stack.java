/**
 * @author zzhan145
 */

public class Stack {
	private String arr[] = new String[0];
	
	/** Adds a value to the top of the stack.*/
	public void push(String value){
		
		String[] arr1 = new String[arr.length + 1];
		for(int i = 0; i < arr.length; i++)
			arr1[i + 1] = arr[i];
		arr1[0] = value;
		arr = arr1;
		
	}
	
	/** Removes the topmost string. If the stack is empty, returns null. */
	public String pop() {
		
		if(arr.length == 0)
			return null;
		
		String arr2[] = new String[arr.length - 1];
		for(int i = 0; i < arr2.length; i++)
			arr2[i] = arr[i + 1];
		
		String x = arr[0];
		arr = arr2;
		return x;	
		
		
	}
	
	/** Returns the topmost string but does not remove it. If the stack is empty, returns null. */
	public String peek() {
		
		if(arr.length == 0)
			return null;
		else
			return arr[0];
		
	}
	
	/** Returns true iff the stack is empty */
	public boolean isEmpty() {
		if(arr.length == 0)
			return true;
		else return false;
	}

	/** Returns the number of items in the stack. */
	public int length() {
		return arr.length;
	}
	
	/** Returns a string representation of the stack. Each string is separated by a newline. Returns an empty string if the stack is empty. */
	public String toString() {
		
		String result = "";
		for(int i = 0; i < arr.length; i++)
			result = arr[i] + "\n" + result;
		return result;
		
	}
}
