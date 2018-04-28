package ru.job4j.start;
/**
 * Class StartUI.
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.1
 */

import java.util.ArrayList;

public class StartUI {
	/**
	 * Params.
	 */
	private int[] range = new int[] {0, 1, 2, 3, 4, 5, 6};
	private Input input;
	private Tracker tracker;
	private int id = 0;

	public StartUI(Input input, Tracker tracker) {
		this.input = input;
		this.tracker = tracker;
	}
	/**
	 * Main.
	 * @param args - first args.
	 */
	public static void main(String[] args) {
		new StartUI(
				new ValidateInput(new ConsoleInput()),
				new Tracker()
		).init();
	}
	/**
	 * Init
	 */
	public void init() {
		MenuTracker menu = new MenuTracker(this.input, this.tracker);
		menu.fillAction();
		do {
			menu.show();
			menu.select(input.ask("Select: ", this.range));
		} while (!"y".equals(this.input.ask("Exit?(y)")));

	}
	/**
	 * Add new item.
	 */
	private void addNewItem() {
		System.out.println("Adding a new item");
		String itemId = Integer.toString(this.id++);
		String itemName = this.input.ask("Plesae, enter the item's name: ");
		String itemDesc = this.input.ask("Plesae, enter the item's description: ");
		Item item1 = new Item(itemName, itemDesc, System.currentTimeMillis(), itemId);
		this.tracker.add(item1);
		System.out.println("Your item was added:");
		System.out.println("Name: " + item1.getName() + "\n" + "Description: " + item1.getDescription() + "\n" + "Cretae: " + item1.getCreate() + "\n" + "Id: " + item1.getId() + "\n");
		this.init();
	}
	/**
	 * Show all items.
	 */
	private void showAllItems() {
		System.out.println("All Items");
		ArrayList<Item> items = tracker.findAll();
		int position = 0;
		if (items.size() > 0) {
			for (Item item : items) {
				if (item.getName() != null) {
					position++;
					System.out.println("Space: " + position + "\n" + "Name: " + item.getName() + "\n" + "Description: " + item.getDescription() + "\n" + "Cretae: " + item.getCreate() + "\n" + "Id: " + item.getId() + "\n");
				} else {
					System.out.println("NO Items");
				}
			}
		} else {
			System.out.println("NO Items");
		}
		this.init();
	}
	/**
	 * Edit item.
	 */
	private void editItem() {
		System.out.println("Edit Item");
		String itemName = this.input.ask("Plesae, enter the item's name: ");
		String itemDesc = this.input.ask("Plesae, enter the item's description: ");
		String itemId =  input.ask("Plesae, enter the item's id, which you want to edit: ");
		Item editItem1 = new Item(itemName, itemDesc, System.currentTimeMillis(), itemId);
		this.tracker.update(editItem1);
		System.out.println("It's Edited item:" + "\n");
		System.out.println("Name: " + editItem1.getName() + "\n" + "Description: " + editItem1.getDescription() + "\n" + "Id: " + editItem1.getId() + "\n");
		this.init();
	}
	/**
	 * Delete item.
	 */
	private void deleteItem() {
		System.out.println("Delete Item");
		String itemId = input.ask("Plesae, enter the item's id, which you want to delete: ");
		this.tracker.delete(itemId);
		this.init();
	}
	/**
	 * Find item by id.
	 */
	private void findItembyId() {
		boolean id = false;
		System.out.println("Find Items by Id");
		String itemId = input.ask("Plesae, enter the item's id, which you want to find: ");
		ArrayList<Item> items = this.tracker.findAll();
		for (Item item : items) {
				System.out.println("It's your item:");
				showItem(item);
				id = true;
			}
		if (!id) {
			System.out.println("NO Items");
		}
		this.init();
	}
	/**
	 * Find item by name.
	 */
	private void findItemsbyName() {
		boolean name = false;
		System.out.println("Find Items by Name");
		String itemKey = this.input.ask("Plesae, enter the item's key, which you want to find: ");
		ArrayList<Item> items = this.tracker.findAll();
		for (Item item : items) {
			if (item.getName().equals(itemKey)) {

				System.out.println("It's your item:");
				showItem(item);
				name = true;
			}
		}
		if (!name) {
			System.out.println("NO Items");
		}
		this.init();
	}

	private String showMenu() {
		System.out.println("MENU");
		System.out.println("0. Add new Item");
		System.out.println("1. Show all items");
		System.out.println("2. Edit item");
		System.out.println("3. Delete item");
		System.out.println("4. Find item by id");
		System.out.println("5. Find item by name");
		System.out.println("6. Exit Program");
		return input.ask("\nPlease, choose number for action: ");

	}
	private void showItem(Item item) {
		System.out.println("Name: " + item.getName());
		System.out.println("Description: " + item.getDescription());
		System.out.println("Create: " + item.getCreate());
		System.out.println("Id: " + item.getId());
	}
}