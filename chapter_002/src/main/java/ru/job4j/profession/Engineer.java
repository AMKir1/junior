package ru.job4j.profession;
/**
 * Class Teacher.
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Engineer extends Profession {
	/**
	* Params.
	*/
	private int experience;
	/**
	* Params.
	*/
	private String direction;
	/**
	* Constructor.
	* @param experience - first args.
	* @param direction - second args.
	*/
	public Engineer(String direction, int experience) {
		this.experience = experience;
		this.direction = direction;
	}
	/**
	* Get Experience.
	* @return this.experience.
	*/
	public int getExperience() {
		return this.experience;
	}
	/**
	* Get Direction.
	* @return this.direction.
	*/
	public String getDirection() {
		return this.direction;
	}
	/**
	* Completed.
	* @param id - first args.
	* @return done.
	*/
	public boolean completed(int id) {
		boolean done;
		if (id == 1) {
			done = true;
		} else {
			done = false;
		}
		return done;
	}
	/**
	* Repairof Equipment.
	* @param thing - first args.
	* @return id.
	*/
	public int toRepairofEquipment(Thing thing) {
		int id = 1;
		return id;
	}
}