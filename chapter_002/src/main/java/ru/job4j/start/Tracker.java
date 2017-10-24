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
	private static final Random RN = New Random();
	/**
	* Add.
	* @param item - first ards.
	* @return item.
	*/
	public Item add(Item item) {
		item.setId(String.ValueOf(System.currentTimeMillis() + RN.nextInt()));
		this.items[position++] = item;
		return item;
	}
	/**
	* Update.
	* @param item - first ards.
	*/
	public void update(Item item) {
		Item newItem = new Item ("NewItem","NewDesc","NewL");
		this.items[item.getId()] = newItem;
	}
	/**
	* Delete.
	* @param key - first ards.
	* @return result.
	*/
	public void delete(Item item) {
		this.items[item.getId()] = null;
	}
	/**
	* Find All.
	* @return result.
	*/
	public Item[] findAll() {
		Item[] result = new Item[position];
		for (int index = 0; index!=this.position; index++) {
			if(this.items[index] != null) {
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
	public Item[] findByName(String key) {
		Item[] result = new Item[position];
		for (int index = 0; index!=this.position; index++) {
			if(this.items[index].getName() == key) {
			result[index] = this.items[index];
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
		for (Item item : items) {
			if (item != null && item.getId().equals(id)) {
				result = itam;
				break;
			}
		}
		return result;
	}
}