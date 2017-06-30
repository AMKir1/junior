package ru.job4j.array;

/**
 * Class Turn решение задачи части 001 урок 5.0.
 *
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Turn {
	/**
	* Chees.
	* @param array - first args.
	* @return result.
	*/
    public int[] back(int[] array) {
		for (int i = 0; i != array.length / 2; i++) {
			int temp = array[array.length - 1 - i];
			array[array.length - 1 - i] = array[i];
			array[i] = temp;
		}
		return array;
	}
}