package ru.job4j.start;


public class Item {
	/**
	* Params.
	*/
	public String name;
	/**
	* Params.
	*/
	public String description;
	/**
	* Params.
	*/
	public long create;
	/**
	* Params.
	*/
	public String id;

	/**
	* Default Constructor.
	*/
	public Item() {
	}
	/**
	* Constructor
	* @param name - first ards.
	* @param description - second ards.
	* @param create - third ards.
	* @param comm - fourth ards.
	*/
	public Item(String name, String description, long create) {
		this.name = name;
		this.description = description;
		this.create = create;
	}
	/**
	* Get Name.
	* @return this.name.
	*/
	public String getName() {
		return this.name;
	}
	/**
	* Get Description.
	* @return this.description.
	*/
	public String getDescription() {
		return this.description;
	}
	/**
	* Get Create.
	* @return this.create.
	*/
	public long getCreate() {
		return this.create;
	}
	/**
	* Get Id.
	* @return this.id.
	*/
	public String getId() {
		 return this.id;
	}
	/**
	* Set Id.
	* @param id - first ards.
	*/
	public void setId(String id) {
		this.id = id;
	}
}