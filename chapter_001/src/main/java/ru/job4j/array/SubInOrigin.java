package ru.job4j.array;
/**
 * Class SubInOrigin решение задачи части 001 урок 6.
 *
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SubInOrigin {
	/**
	* Duplicate.
	* @param origin - first args.
	* @param sub - second ards.
	* @return result.
	*/
    public boolean contains(String origin, String sub) {
		char[] massOrigin = origin.toCharArray();
		char[] massSub = sub.toCharArray();
		int countletter = 0;
		boolean cont = false;
		if (massOrigin.length >= massSub.length && massSub.length != 0) {
			for (int i = 0; i < massOrigin.length; i++) {
				for (int j = countletter; j < massSub.length; j++) {
					if (massOrigin[i] == massSub[j] && i != massOrigin.length - 1 && j <= massSub.length - 1) {
						countletter++;
						break;
					} else if (massOrigin[i] != massSub[j] && countletter > 0) {
						countletter = 0;
					}
				}
				if (countletter == massSub.length) {
					cont = true;
				}
			}
		} else {
			cont = false;
		}
		return cont;
	}
}