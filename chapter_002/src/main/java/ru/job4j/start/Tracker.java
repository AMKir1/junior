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
	private ArrayList<Item> items = new ArrayList<>();

	/**
	* Add.
	* @param item - first args.
	* @return result.
	*/
	public Item add(Item item) {
		this.items.add(item);
		return item;
	}
	/**
	* Update.
	* @param item - first args.
	*/
	public void update(Item item) {
		int count = 0;
		for (Item i : this.items) {
			if (i.getId().equals(item.getId())) {
				this.items.set(count, item);
				count++;
			}
		}
	}
	/**
	* Delete.
	* @param id - first args.
	* @return result.
	*/
	public void delete(String id) {
		boolean eq = false;
		for (Item i : this.items) {
			if (i.getId().equals(id)) {
				this.items.remove(i);
				eq = true;
				break;
			}
		}
		if (!eq) {
			System.out.println("NO Such Items");
		}
	}
	/**
	* Find All.
	* @return result.
	*/
	public ArrayList<Item> findAll() {
		return this.items;
	}
	/**
	* Find By Name.
	* @param key - first args.
	* @return result.
	*/
	public ArrayList<Item> findByName(String key) {
		ArrayList<Item> result = new ArrayList<>();
		for (Item item : this.items) {
			if (item.getName().equals(key)) {
				result.add(item);
			}
		}
		return result;
	}
	/**
	* Find By Id.
	* @param id - first args.
	* @return result.
	*/
	public ArrayList<Item> findById(String id) {
		boolean ad = false;
		ArrayList<Item> result = new ArrayList<>();
		for (Item item : this.items) {
			if (item.getId().equals(id)) {
			result.add(item);
			ad = true;
			}
		}
		return !ad ? null : result;
	}
}