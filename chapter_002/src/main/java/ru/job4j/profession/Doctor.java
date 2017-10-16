package ru.job4j.profession;
/**
 * Class Teacher.
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Doctor extends Profession {
	/**
	* Params.
	*/
	private boolean license;
	/**
	* Params.
	*/
	private String direction;
	/**
	* Constructor.
	* @param direction - first args.
	* @param license - second args.
	*/
	public Doctor(String direction, boolean license) {
		this.direction = direction;
		this.license = license;
	}
	/**
	* Get License.
	* @return this.license.
	*/
	public boolean getLicense() {
		return this.license;
	}
	/**
	* Get Direction.
	* @return this.direction.
	*/
	public String getDirection() {
		return this.direction;
	}
	/**
	* To Ask.
	* @param question - first args.
	* @return answer.
	*/
	public String toAsk(String question) {
		String answer = "AllOK";
		return answer;
	}
	/**
	* To Diagnose.
	* @param symptoms - first args.
	* @return .
	*/
	public String toDiagnose(String symptoms) {
		if (symptoms == "Отравление") {
			return "Активированный уголь и больше жидкости";
		} else {
			return "Зеленка";
		}
	}
}