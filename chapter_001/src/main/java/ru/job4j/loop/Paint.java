package ru.job4j.loop;

/**
 * Class Paint решение задачи части 001 урок 4.3.
 *
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Paint {
	/**
	* Chees.
	* @param h - first args.
	* @return result.
	*/
	public String pairamid(int h) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < (h - i) + (2 * i + 1); j++) {
				if (j > (h - i) - 1) {
					builder.append("^");
				} else {
					builder.append(" ");
				}
			}
			builder.append(System.getProperty("line.separator"));
		}
		return builder.toString();
	}
}