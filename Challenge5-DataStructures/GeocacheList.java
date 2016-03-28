/**
 * @author zzhan145
 */

/**
 * Complete the following GeocacheList, to ensure all unit tests pass.
 * There are several errors in the code below
 *
 * Hint: Get the Geocache class working and passing its tests first.
 */
public class GeocacheList {
	
	private Geocache[] data = new Geocache[0];
	private int size = data.length;

	public Geocache getGeocache(int i) {
		return data[i];
	}

	public int getSize() {
		return size;
	}

	public GeocacheList() {
	}

	public GeocacheList(GeocacheList other, boolean deepCopy) {
		data = new Geocache[other.data.length];
		size = other.size;
		
		if(deepCopy){
			for(int i = 0; i < data.length; i++)
				data[i] = new Geocache(other.data[i].getX(), other.data[i].getY());
		}
		else{
			for(int i = 0; i < data.length; i++)
				data[i] = other.data[i];
		}
		
	}

	public void add(Geocache p) {
		size++;
		if (size > data.length) {
			Geocache[] old = data;
			data = new Geocache[size * 2];
			for (int i = 0; i < old.length; i++)
				data[i] = old[i];
		}
		data[size-1] = p;
	}

	public void removeFromTop() {
		size--;
		Geocache[] result = data;
		data = new Geocache[data.length - 1];
		for(int i = 0; i < size; i++)
			data[i] = result[i];
	}

	public String toString() {
		StringBuffer s = new StringBuffer("GeocacheList:");
		for (int i = 0; i < size; i++) {
			if (i > 0)
				s.append(',');
			s.append(data[i]);
		}
		return s.toString();
	}
}