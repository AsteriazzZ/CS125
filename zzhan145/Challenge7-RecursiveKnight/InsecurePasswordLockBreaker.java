//UIUC CS125 SPRING 2016 MP. File: InsecurePasswordLockBreaker.java, CS125 Project: Challenge7-RecursiveKnight, Version: 2016-04-18T08:08:00-0500.951298206
//@author zzhan145

        // write code here to determine the secret password
		// to unlock the given lock object.
		// You do not need to use recursion.
		// Hint: Read the source code of InsecurePasswordLock
		// The lock has a weakness....
		// Understand it and you can write an algorithm to quickly find the
		// secret password
		// (A brute force guess of a 40 character password would take a long
		// time...
		// as there are 26^40 combinations!
		// Your method should find it in a few seconds.

		// Beginner: You should complete this code in less than an hour

		// Advanced Code-Golf: Can you complete this method in 8 lines
		// (excluding the top and bottom given
		// lines and after autoformating your code)
		
		// Crazy Instructor level:
		// I can write a complete albeit-inefficient solution using single while loop :-)
		// expression: while (____){/*NoCodeHere*/}

public class InsecurePasswordLockBreaker {

	public static char[] breakLock(InsecurePasswordLock lock) {
		
		int length = 0;
		for (int i = 30; i < 51; i++) {
			
			char[] key = new char[i];
			
			if (lock.open(key) != -1) {
				length = i; 
				break; 
			}	//find the length
			
		}
		char[] result = new char[length];
		
		for (int i = 0; i < length; i++) {
			for (int j = 0; lock.open(result) != i + 1; j++) {	//next letter is wrong,
				result[i] = (char)j;							//so current letter is right
			}
		}
		return result;
	}

	public static void main(String[] args) {
		InsecurePasswordLock lock = new InsecurePasswordLock(35);
		char[] key = breakLock(lock);
		System.out.println(key);
		System.out.println(lock.isUnlocked());
	}
}
