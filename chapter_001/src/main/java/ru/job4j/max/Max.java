package ru.job4j.max;

/**
 * Class Max решение задачи части 001 урок 3.1.
 *
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Max {
	/**
	* Max first and second.
	* @param first - first args.
	* @param second - second args.
	* @return max number.
	*/
    public int max(int first, int second) {
	return first >= second ? first : second;
	}
	/**
	* Max first and second.
	* @param first - first args.
	* @param second - second args.
	* @param third - third args.
	* @return max number.
	*/
	public int max(int first, int second, int third) {
		return max(max(first, second), third);
	}
}
