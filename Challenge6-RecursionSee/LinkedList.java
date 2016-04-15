//UIUC CS125 SPRING 2016 MP. File: LinkedList.java, CS125 Project: Challenge6-RecursionSee, Version: 2016-03-27T20:12:33-0500.368833636
/**
 * @author zzhan145
 *
 */
public class LinkedList {
	
	private LinkedList next; 	
	private final String word;

	/** Constructs this link.
	 * @param word ; a single word (never null).
	 * @param next ; the next item in the chain (null, if there are no more items).
	 */
	public LinkedList(String word, LinkedList next) {
		this.word = word;
		this.next = next;
	}

	/**
	 * Converts the entire linked list into a string representation.
	 */
	public String toString() {
		if (next == null)
			return word;// BASE CASE; no more recursion required

		// Recursive case:
		String restOfString = next.toString(); // Forward Recursion
		return word + ";" + restOfString;
	}

	/**
	 * Returns the number of entries in the linked list.
	 * @return number of entries.
	 */
	public int getCount() {
		if (next == null)
			return 1; // BASE CASE; no more recursion required!

		// Recursive case:
		return 1 + next.getCount(); // Forward recursion
	}
	
	/** Creates a new LinkedList entry at the end of this linked list.
	 * Recursively finds the last entry then adds a new link to the end.
	 * @param word
	 */
	public void append(String word) {
		
		if (next != null)
			next.append(word); // BASE CASE
		
		// Recursive case:
		else
			this.next = new LinkedList(word, null);
		
	}
	/**
	 * Recursively counts the total number of letters used.
	 * 
	 * @return total number of letters in the words of the linked list
	 */
	public int getLetterCount() {
		
		if (next == null)
			return this.word.length(); // BASE CASE
		
		//Recursive case:
		return this.word.length() + next.getLetterCount();
		
		// returns the total number of letters. word1.length() + word2.length()+...
		// "A" -> "CAT" -> null returns 1 + 3 = 4.
	}

	/**
	 * Recursively searches for and the returns the longest word.
	 * @return the longest word i.e. word.length() is maximal.
	 */
	public String getLongestWord() {
		
		if (next == null)
			return word; // BASE CASE
		
		else{ // Recursive case:
			String result = next.getLongestWord();
			
			if (result.length() > word.length())
				return result;
			return word;
			
		}
	}

	/** Converts linked list into a sentence (a single string representation).
	* Each word pair is separated by a space.
	* A period (".") is appended after the last word.
	* The last link represents the last word in the sentence.*/
	public String getSentence() {
		
		if (next == null)
			return word + "."; //BASE CASE
		
		else{ // Recursive case
			String restOfString = next.getSentence();
			return word + " " + restOfString;
		
		}
	}
	
	/**
	 * Converts linked list into a sentence (a single string representation).
	 * Each word pair is separated by a space. A period (".") is appended after
	 * the last word. The last link represents the first word in the sentence
	 * (and vice versa). The partialResult is the partial string constructed
	 * from earlier links. This partialResult is initially an empty string. 
	 */
	public String getReversedSentence(String partialResult) {
		
		partialResult = word + partialResult; // Add word to the forward of partialResult
		if (next == null)
			return partialResult + "."; // BASE CASE
		
		// Recursive case:
		partialResult = " " + partialResult; // Since next is not null, prepare a space before partialResult
		return next.getReversedSentence(partialResult);
		
	}
	

	/** Creates a linked list of words from an array of strings.
	 * Each string in the array is a word. */
	public static LinkedList createLinkedList(String[] words) {
		
		LinkedList result;
		
		String[] newWords = new String[words.length - 1]; // The array storing the information of the elements after
		for (int i = 0; i < newWords.length; i++)
			newWords[i] = words[i + 1];
		
		if (words.length == 1){
			result = new LinkedList(words[0], null); // BASE CASE
		}
		else{ // Recursive case:
			result = new LinkedList(words[0], createLinkedList(newWords));
		}
		return result;
		
		// Hint: This is a wrapper method. You'll need to create your own recursive method.
		// Yes this is possible _without_ loops!
	}

	/**
	 * Searches for the following word in the linked list. Hint: use .equals not ==
	 * to compare strings.
	 * 
	 * @param word
	 * @return true if the linked list contains the word (case sensivitive)
	 */
	public boolean contains(String word) {
		
		if (this.word.equals(word)) // Find it! BASE CASE
			return true;
		
		if (next == null) // Have reached the end of the linked list but still didn't find it
			return false;
		
		return next.contains(word); //Recursive case
		
	}

	/** Recursively searches for the given word in the linked list.
	 * If this link matches the given word then return this link.
	 * Otherwise search the next link.
	 * If no matching links are found return null.
	 * @param word the word to search for.
	 * @return The link that contains the search word.
	 */
	public LinkedList find(String word) {
		
		if (this.word.equals(word)) // Find it! BASE CASE
			return this;
		
		if (next == null) // Have reached the end of the linked list but still didn't find it
			return null;
		
		return next.find(word); //Recursive case
		
	}

	/**
	 * Returns the last most link that has the given word, or returns null if
	 * the word cannot be found.
	 * Hint: Would forward recursion be useful?
	 * @param word the word to search for.
	 * @return the last LinkedList object that represents the given word, or null if it is not found.
	 */
	public LinkedList findLast(String word) {
		
		if (this.contains(word)){ // Check if the Linked list truly contains the word
			
			if (next == null) // BASE CASE: we have reached the end of the list
				return this; // There is only one word in the list and the list contains "word"
			                 // So this is exactly the word
			
			else if (next.contains(word)) // Check if we can find the word in the list coming after
				return next.findLast(word); // If we can find, recursive case
			return this; // We cannot find the word in the list after, so this word is exactly the one we are looking for.
			
		}
		return null; // It is not found in the list
		
	}

	public LinkedList insert(String string) {
		
		if (string.charAt(0) < word.charAt(0)) {
			LinkedList result = new LinkedList(string, this);
			return result;
		}
		
		if(next == null){
			next = new LinkedList(string,null);
			return this;
		}
		
		next = next.insert(string);
		return this;
	}

}
