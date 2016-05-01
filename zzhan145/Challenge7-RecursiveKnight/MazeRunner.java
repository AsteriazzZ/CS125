//UIUC CS125 SPRING 2016 MP. File: MazeRunner.java, CS125 Project: Challenge7-RecursiveKnight, Version: 2016-04-18T08:08:00-0500.951298206
//@author zzhan145

public class MazeRunner {

	private int x, y;

	/** Initializes the MazeRunner with the x,y values */
	public MazeRunner(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}


	/** Moves the runner one unit. No error checking is performed.
	 * 'N':go North (increment y), S:decrement y, E(increment x), W(decrement x)
	 * character values other than N,S,E or W are ignored.
	 */
	void moveOne(char dir) {
//		 TODO: Implement moveOne
		
		if(dir == 'N') this.y++;
		if(dir == 'S') this.y--;
		if(dir == 'W') this.x--;
		if(dir == 'E') this.x++;
		
	}
	/** Returns true if this maze runner is on the same (x,y) square
	 * as the parameter. Assumes that the parameter is non-null.
	 */
	public boolean caught(MazeRunner other) {
		
		if(this.x == other.x && this.y == other.y)
			return true;
		else
			return false;
		 // TODO: Implement caught
	}

	/**
	 * Uses recursion to find index of the shortest string.
	 * Null strings are treated as infinitely long.
	 * Implementation notes:
	 * The base case if lo == hi.
	 * Use safeStringLength(paths[xxx]) to determine the string length.
	 * Invoke recursion to test the remaining paths (lo +1)
	 */
	static int findShortestString(String[] paths, int lo, int hi) {
		// TODO: findShortestString
		
		if(lo == hi) return lo;
		int result = findShortestString(paths, lo + 1, hi);
		if(safeStringLength(paths[result]) < safeStringLength(paths[lo]))
			return result;
		else return lo;
		
	}

	/** Returns the length of the string or Integer.MAX_VALUE
	 * if the string is null.
	 * @param s
	 * @return
	 */
	static int safeStringLength(String s) {
		//TODO: safeStringLength
		
		if(s != null) return s.length();
		else return Integer.MAX_VALUE;
		
	}


	/* Returns a string representation of the shortest path between
	 * (x,y) and (tx,ty). e.g. a result of "NNEE"
	 * means to travel from (x,y) -> (tx,ty) go North twice, then East twice.
	 * blocked is a square boolean grid of points that cannot be used.
	 * If(x,y) are invalid coords (outside of the grid array) this method returns null.
	 * If(x,y) is on a blocked square, this method returns null. Otherwise,
	 * If(x,y) are already the same as the target position, returns an empty string.
	 * If there is no path between (x,y) and (tx,ty) the method returns null.
	 * 
	 * Implementation notes:
	 * Use the statements above for the base cases.
	 * For the recursion part:
	 * 1. Set the current position to blocked (so that the recursive method does not
	 * attempt to re-use this square again)
	 * 2. Collect all paths from the NSEW neighbors
	 * 3. Reset the current blocked position to false.
	 * 4. Use findShortestString to determine the shortest path
	 * 5. If its non-null then PREPEND the compass direction of that neighbor's path.
	 * e.g. if the Northern neighbor returned "EWWS" 
	 * the East neighbor returned "NWWWWWWWSEEEESS" and W and S Neighbor return null
	 * then return "N" + "EWWS"
	 * Otherwise, just return null as none of the neighbors found a path.
	 */
	public static String shortestPath(int x, int y, int tX, int tY,
			boolean blocked[][]) {
		
		// TODO: BASE CASES HERE
		if (x < 0 || y < 0 || x >= blocked.length || y >= blocked[0].length || blocked[x][y] || blocked[tX][tY])
			return null;
		if (x == tX && y == tY)
			return "";
		
		blocked[x][y] = true;
		//String[] paths = { 
			//TODO: COLLECT RECURSIVE RESULTS HERE
		//};
		String options[] = new String[4];
		options[0] = shortestPath(x, y + 1, tX, tY, blocked);
		options[1] = shortestPath(x, y - 1, tX, tY, blocked);
		options[2] = shortestPath(x - 1, y, tX, tY, blocked);
		options[3] = shortestPath(x + 1, y, tX, tY, blocked);
		
		if (options[0] != null) options[0] = "N" + options[0];
		if (options[1] != null) options[1] = "S" + options[1];
		if (options[2] != null) options[2] = "W" + options[2];
		if (options[3] != null) options[3] = "E" + options[3];
		
		blocked[x][y] = false;
		return options[findShortestString(options,0,3)];

		// TODO: Use findShortestString on paths
		// TODO: Return correct string with Compass direction prepended (or null)
		
	}

	/** Moves the runner towards the target position, if the
	 * shortest path can be found between the current and target position.
	 * Implementation notes: calls shortestPath, 
	 * if result is not null then send the first char to moveOne()
	 * Hint: watch out for the empty string when target = current position...
	 */
	public void chase(boolean maze[][], int targetX, int targetY) {
		
		if (shortestPath(this.x, this.y, targetX, targetY, maze) == null) return;
		if (x == targetX && y == targetY) return;
		moveOne(shortestPath(this.x, this.y, targetX, targetY, maze).charAt(0));
		
		// TODO: Implement chase
		// Use shortestPath, string.charAt,  moveOne
	}

}
