package ru.job4j.loop;

/**
 * Class Factorial решение задачи части 001 урок 4.2.
 *
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Factorial {
	/**
	* Max first and second.
	* @param n - second args.
	* @return result.
	*/
    public int calc(int n) {
		int result = 0;
		if (n > 0) {
			result = 1;
			for (int i = 1; i <= n; i++) {
				result *= i;
			}
		} else if (n == 0) {
			result = 1;
		}
		return result;
    }
}
