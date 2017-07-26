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
	* @param array2 - first args.
	* @return result.
	*/
    public int[] sumArrays(int[] array1, int[] array2) {
		int length1 = 0;
		int length2 = 0;
		for (int i : array1) {
			length1 += 1;
		}
		for (int i : array2) {
			length2 += 1;
		}
		int[] array3 = new int[length1 + length2];
		for (int i = 0; i < array3.length; i++) {
			if (i < length1) {
				array3[i] = array1[i];
			} else {
				array3[i] = array2[i - length1];
			}
		}
		return array3;
	}
}