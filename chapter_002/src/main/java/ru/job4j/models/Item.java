package ru.job4j.models;

public class Item {
	
	public String name;
	
	public String description;
	
	public long create;
	
	public String id;
	
	public String[] comments;
	
	public Item() {
	}
	
	public Item(String name, String description, long create, String[] comm) {
		this.name = name;
		this.description = description;
		this.create = create;
		this.comments = comm;
	}
	
	public String getNAme() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public String getCreate() {
		return this.create;
	}
	
	public String getId() {
		 return this.id;
	}
	
	public void setId (String id) {
		this.id = id;
	}
}