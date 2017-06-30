package ru.job4j.array;

/**
 * Class RotateArray решение задачи части 001 урок 5.2.
 *
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class RotateArray {
	/**
	* Chees.
	* @param array - first args.
	* @return result.
	*/
    public int[][] rotate(int[][] array) {
		for (int i = 0; i < array.length / 2; i++) {
			for (int j = i; j < array.length - i - 1; j++) {
					int temp = array[i][j];
					array[i][j] = array[array.length - j - 1][i];
					array[array.length - j - 1][i] = array[array.length - i - 1][array.length - j - 1];
					array[array.length - i - 1][array.length - j - 1] = array[j][array.length - i - 1];
					array[j][array.length - i - 1] = temp;
			}
		}
		return array;
	}
}