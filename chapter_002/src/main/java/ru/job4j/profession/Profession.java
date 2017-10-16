package ru.job4j.profession;
/**
 * Class Profession.
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Profession {
	/**
	* Params.
	*/
	private String fio;
	/**
	* Params.
	*/
	private String education;
	/**
	* Params.
	*/
	private String speciality;
	/**
	* Params.
	*/
	private int experience;
	/**
	* Defalte Constructor.
	*/
	public Profession() { }
	/**
	* Constructor.
	* @param fio - first args.
	* @param education - second args.
	* @param experience - third args.
	*/
	public Profession(String fio, String education, int experience) {
		this.fio = fio;
		this.education = education;
		this.speciality = speciality;
		this.experience = experience;
	}
	/**
	* GetFIO.
	* @return this.fio.
	*/
	public String getFio() {
		return this.fio;
	}
	/**
	* GetEducation.
	* @return this.education.
	*/
	public String getEducation() {
		return this.education;
	}
	/**
	* GetSpeciality.
	* @return this.speciality.
	*/
	public String getSpeciality() {
		return this.speciality;
	}
	/**
	* GetExperience.
	* @return this.experience.
	*/
	public int getExperience() {
		return this.experience;
	}
}