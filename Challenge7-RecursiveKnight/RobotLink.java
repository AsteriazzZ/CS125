//UIUC CS125 SPRING 2016 MP. File: RobotLink.java, CS125 Project: Challenge7-RecursiveKnight, Version: 2016-04-18T08:08:00-0500.951298206
//@author zzhan145

public class RobotLink {

	private RobotLink next; 	
	private final Robot robot;

	public Robot getRobot() {
		return robot;
	}
	/** Constructs this link.
	 * @param next ; the next item in the chain (null, if there are no more items).
	 * @param robot ; a single robot (never null).
	 */
	public RobotLink(RobotLink next,Robot robot) {
		this.robot = robot;
		this.next = next;
	}

	/**
	 * Returns the number of entries in the linked list.
	 * @return number of entries.
	 */
	public int count() {
		if (next == null)
			return 1; // BASE CASE; no more recursion required!

		// Recursive case:
		return 1 + next.count();
	}
	/**
	 * Counts the number of flying robots in the linked list.
	 * Hint: robot.isFlying is useful here.
	 */
	public int countFlyingRobots() {
		
		int result = 0;
		if (this.robot.isFlying())
			result ++;
		if (next == null)
			return result;
		else return result + next.countFlyingRobots();
		
	}
	/**
	 * Counts the number of flying robots U!P!T!O! and excluding a sad robot.
	 * (i.e. do not count the sad robot if it is flying).
	 * If there are no sad robots this function will return the same value as countFlyingRobots().
	 * Hint: robot.isHappy() is useful.
	 */
	public int countFlyingRobotsBeforeSadRobot() {
		
		int result = 0;
		if (this.robot.isHappy() == false)
			return result;
		if (this.robot.isFlying())
			result ++;
		if (next == null)
			return result;
		return result + next.countFlyingRobotsBeforeSadRobot();
		
	}
	/** Creates a new LinkedList entry at the end of this linked list.
	 * Recursively finds the last entry then adds a new link to the end.
	 * @param robot - the robot value of the new last link
	 */
	public void append(Robot robot) {
		
		if (next == null)
			this.next = new RobotLink(null, robot);
		else
			next.append(robot);

	}
	/**
	 * Returns the first flying unhappy robot, or null
	 * if there are not robots that are flying and unhappy.
	 * @return
	 */
	public Robot getFirstFlyingUnhappyRobot() {
		
		if (this.robot.isHappy() == false && this.robot.isFlying())
			return this.robot;
		if (next == null)
			return null;
		else return next.getFirstFlyingUnhappyRobot();
		
	}
	/**
	 * Returns the last flying unhappy robotn the linked list, or null
	 * if there are not robots that are flying and unhappy.
	 * @return
	 */
	public Robot getLastFlyingUnhappyRobot() {
		
		if (this.containFlyingUnhappyRobot()){
			if (next == null) 
				return this.getRobot();
			else if (next.containFlyingUnhappyRobot())
				return next.getLastFlyingUnhappyRobot();
			return this.getRobot();
		}
		return null;
		
	}
	
	public boolean containFlyingUnhappyRobot(){
		
		if (this.robot.isHappy() == false && this.robot.isFlying())
			return true;
		if (next == null) return false;
		else return next.containFlyingUnhappyRobot();
		
	}
	
	
	/**
	 * Returns a reference to the happy most distant explorer.
	 * Returns null if there are no happy robots
	 * @return reference to the most distant happy robot
	 */
	public Robot findHappyRobotFurthestFromHome() {
		
		Robot result = null;
		
		if (this.robot.isHappy()){
			if (result == null) result = this.robot;
			if (result != null && result.getDistanceFromHome() < this.robot.getDistanceFromHome())
				result = this.robot;
		}
		if (next != null) 
			next.findHappyRobotFurthestFromHome();
		return result;
		
	}
	/**
	 * Returns true if linked list contains the robot.
	 * Hint: Use robot.equals(other).
	 * @param robot
	 * @return
	 */
	public boolean contains(Robot other) {
		
		if (this.robot.equals(other)) return true;
		if (next == null) return false;
		return next.contains(other);
		
	}

	
}
