package ru.job4j.array;
/**
 * Class ArrayDuplicate решение задачи контрольной.
 *
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ArrayAddArray {
	/**
	* Duplicate.
	* @param array1 - first args.
	* @param array2 - second args.
	* @return result.
	*/
    public int[] sumArrays(int[] array1, int[] array2) {
		int[] array3 = new int[array1.length + array2.length];
		for (int i = 0; i < array3.length; i++) {
			if (i < array1.length) {
				array3[i] = array1[i];
			} else {
				array3[i] = array2[i - array1.length];
			}
		}
		return array3;
	}
}