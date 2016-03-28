/**
 * @author zzhan145
 */

public class Queue {
	private double[] q = new double[0];
	
	/** Adds the value to the front of the queue.
	 * Note the queue automatically resizes as more items are added. */
	public void add(double value) {
		
		double[] result = new double[q.length + 1];
		for(int i = 0; i < q.length; i++)
			result[i + 1] = q[i];
		result[0] = value;
		q = result;
		
	}
	
	/** Removes the value from the end of the queue. If the queue is empty, returns 0 */
	public double remove() {
		
		if(q.length == 0){
			return 0;
		}else{
			double[] result = new double[q.length - 1];
			for(int i = 0; i < result.length; i++)
				result[i] = q[i];
			double p = q[result.length];
			q = result;
			return p;
		}

	}
	
	/** Returns the number of items in the queue. */
	public int length() {
		return q.length;		
	}
	
	/** Returns true iff the queue is empty */
	public boolean isEmpty() {
		return q.length == 0;
	}
	
	/** Returns a comma separated string representation of the queue. */
	public String toString() {
		
		String result = "";
		for(int i = q.length - 1; i > 0; i--)
			result = result + q[i] + ",";
		result += q[0];
		return result;
		
	}
}
