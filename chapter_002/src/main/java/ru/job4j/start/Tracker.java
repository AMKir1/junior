package ru.job4j.start;
/**
 * Class Tracker.
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import java.util.*;
public class Tracker {
	/**
	* Params.
	*/
	private Item[] items = new Item[100];
	/**
	* Params.
	*/
	private int position = 0;
	
	/**
	* Add.
	* @param item - first ards.
	* @return result.
	*/
	public Item add(Item item) {
		Item result;
		this.items[this.position] = item;
		result = this.items[position];
		this.position++;
		return result;
	}
	/**
	* Update.
	* @param item - first ards.
	*/
	public void update(Item item) {
		for (int index = 0; index != this.position; index++) {
			System.out.println(this.items[index].getId());
			if (this.items[index].getId() == item.getId()) {
			this.items[index] = item;
			}
		}
	}
	/**
	* Delete.
	* @param key - first ards.
	* @return result.
	*/
	public void delete(Item item) {	
		for (int index = 0; index != this.position; index++) {
			if (this.items[index].getId() == item.getId()) {
			this.items[index] = null;
			}
		}
	}
	/**
	* Find All.
	* @return result.
	*/
	public Item[] findAll() {
		Item[] result = new Item[this.position];
		int i = 0;
		for (Item item : this.items) {
			if (item != null) {
				result[i] = item;
				i++;
			}
		}
		return result;
	}
	/**
	* Find By Name.
	* @param key - first ards.
	* @return result.
	*/
	public Item[] findByName(String key) {
		Item[] result = new Item[position];
		for (int i = 0; i != this.position; i++) {
			if (this.items[i].getName().equals(key)) {
			result[i] = this.items[i];
			}
		}
		return result;
	}
	/**
	* Find By Id.
	* @param id - first ards.
	* @return result.
	*/
	public Item findById(String id) {
		Item result = null;
		for (Item item : items) {
			if (item.getId().equals(id)) {
				result = item;
				break;
			}
		}
		return result;
	}
}