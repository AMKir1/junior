package ru.job4j.start;
/**
 * Class Tracker.
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import ru.job4j.models.*;
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
	* Params.
	*/
	private static final Random RN = new Random();
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
		for (int index = 0; index != this.position; index++) {
			if (this.items[index] != null) {
			result[index] = this.items[index];
			}
		}
		return result;
	}
	/**
	* Find By Name.
	* @param key - first ards.
	* @return result.
	*/
	public Item findByName(String key) {
		Item result = null;
		for (int index = 0; index != this.position; index++) {
			if (this.items[index].getName() == key) {
			result = this.items[index];
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
			if (item != null && item.getId().equals(id)) {
				result = item;
				break;
			}
		}
		return result;
	}
}