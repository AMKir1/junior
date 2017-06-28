package ru.job4j.loop;

/**
 * Class Max решение задачи части 001 урок 3.1.
 *
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Counter {
	/**
	* Max first and second.
	* @param start - first args.
	* @param finish - second args.
	* @return Sum number.
	*/
    public int add(int start, int finish) {
		int sum = 0;
		if (start <= finish) {
			for (int i = start; i <= finish; i++) {
				if (i % 2 == 0) {
					sum += i;
				}
			}
		}
		return sum;
    }
}
