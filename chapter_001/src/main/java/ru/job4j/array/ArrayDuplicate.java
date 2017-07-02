package ru.job4j.array;

import java.util.Arrays;
/**
 * Class ArrayDuplicate решение задачи части 001 урок 5.3.
 *
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ArrayDuplicate {
	/**
	* Duplicate.
	* @param array - first args.
	* @return result.
	*/
    public String[] remove(String[] array) {
		int n = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i; j < array.length; j++) {
				if ((array[i] == array[j]) && (i != j)) {
					String temp = array[j];
					for (int k = j; k < array.length - 1; k++) {
						array[k] = array[k + 1];
					}
					array[array.length - 1] = temp;
				}
			}
			for (int s = i + 1; s < array.length; s++) {
				if ((array[i] == array[s])) {
					n++;
					break;
				}
			}
		}
		return Arrays.copyOf(array, array.length - n);
	}
}