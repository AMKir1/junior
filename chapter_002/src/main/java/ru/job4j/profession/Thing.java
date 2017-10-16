package ru.job4j.profession;
/**
 * Class Thing.
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Thing {
	/**
	* Params.
	*/
	private String title;
	/**
	* Params.
	*/
	private int serialnumber;
	/**
	* Params.
	*/
	private String manufacturer;
	/**
	* Params.
	*/
	/**
	* Constructor.
	* @param title - first args.
	* @param serialnumber - second args.
	* @param manufacturer - third args.
	*/
	public Thing(String title, int serialnumber, String manufacturer) {
		this.title = title;
		this.serialnumber = serialnumber;
		this.manufacturer = manufacturer;
	}
	/**
	* Get Title.
	* @return this.title.
	*/
	public String getTitle() {
		return this.title;
	}
	/**
	* Get Manufacturer.
	* @return this.manufacturer.
	*/
	public String getManufacturer() {
		return this.manufacturer;
	}
	/**
	* Get Serialnumber.
	* @return this.serialnumber.
	*/
	public int getSerialnumber() {
		return this.serialnumber;
	}
}