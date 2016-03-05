//UIUC CS125 SPRING 2016 MP. File: PlayListUtil.java, CS125 Project: Challenge4-Photoscoop, Version: 2016-02-22T08:15:41-0600.419530601
/**
 * Add you netid here..
 * @author zzhan145
 *
 */
public class PlayListUtil {

	/**
	 * Debug ME! Use the unit tests to reverse engineer how this method should work.
	 * Hint: Fix the formatting (shift-cmd-F) to help debug the following code
	 * @param list
	 * @param maximum
	 */
	public static void list(String[] list, int maximum) {
		int i;
		int max;
		if (maximum == -1) {
			max = list.length;
		} else
			max = maximum;
		for (i = 0; i < max; i++) {
			TextIO.putln("" + (i + 1) + ". " + list[i]);
		}
	}

	/**
	 * Appends or prepends the title
	 * @param list
	 * @param title
	 * @param prepend if true, prepend the title otherwise append the title
	 * @return a new list with the title prepended or appended to the original list
	 */
	public static String[] add(String[] list, String title, boolean prepend) {
		String[] arr1 = new String[list.length + 1];
		if (prepend == true) {
			for (int i = 0; i < list.length; i++) {
				arr1[i + 1] = list[i];
			}
			arr1[0] = title;
		} else {
			{
				for (int i = 0; i < list.length; i++) {
					arr1[i] = list[i];
				}
				arr1[list.length] = title;
			}
		}
		return arr1;
	}
	/**
	 * Returns a new list with the element at index removed.
	 * @param list the original list
	 * @param index the array index to remove.
	 * @return a new list with the String at position 'index', absent.
	 */
	public static String[] discard(String[] list, int index) {
		String[] arr1 = new String[list.length - 1];
		boolean before=false;
		for (int i = 0; i < list.length - 1; i++) {
			if (i == index) {
				arr1[i] = list[i + 1];before=true;
			} else if(before==false)
				{arr1[i] = list[i];}
			else if(before==true)
			{arr1[i]=list[i+1];}
		}
		return arr1;

	}

}
