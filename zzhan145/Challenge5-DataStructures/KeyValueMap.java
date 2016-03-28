/**
 * @author zzhan145
 */

import java.awt.Color;

public class KeyValueMap { // aka Dictionary or Map
	
	private Color red, blue, green, black;
	
	/**
	 * Adds a key and value. If the key already exists, it replaces the original
	 * entry.
	 */
	
	public void add(String key, Color value) {
		key = key.toUpperCase();
		if(key.equals("RED"))
			red = value;
		if(key.equals("BLUE"))
			blue = value;
		if(key.equals("GREEN"))
			green = value;
		if(key.equals("BLACK"))
			black = value;
	}

	/**
	 * Returns particular Color object previously added to this map.
	 */
	public Color find(String key) {
		if(key.equals("RED"))
			return red;
		else if(key.equals("BLUE"))
			return blue;
		else if(key.equals("GREEN"))
			return green;
		else if(key.equals("BLACK"))
			return black;
		else
			return null;
	}

	/**
	 * Returns true if the key exists in this map.
	 */
	public boolean exists(String key) {
		if(key.equals("RED")){
			if(red == null) return false;
			else return true;
		}else if(key.equals("BLUE")){
			if(blue == null) return false;
			else return true;
		}else if(key.equals("GREEN")){
			if(green == null) return false;
			else return true;
		}else if(key.equals("BLACK")){
			if(black == null) return false;
			else return true;
		}else
			return false;
	}

	/**
	 * Removes the key (and the color) from this map.
	 */
	public void remove(String key) {
		add(key, null);
	}

}
