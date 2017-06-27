package ru.job4j.loop;

/**
 * Class Board решение задачи части 001 урок 4.3.
 *
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Board {
	/**
	* Chees.
	* @param width - first args.
	* @param heigh - second args.
	* @return result.
	*/
    public String paint(int width, int heigh) {
		StringBuilder builder = new StringBuilder();
		for (int i = 1; i <= heigh; i++) {
			for (int j = 1; j <= width; j++) {
				if ((i % 2 != 0) && (j % 2 != 0) || (i % 2 == 0) && (j % 2 == 0)) {
					builder.append("x");
				} else {
					builder.append(" ");
				}
			}
			builder.append("\r\n");
			//System.getProperty("line.separator");
		}
		return builder.toString();
	}
}