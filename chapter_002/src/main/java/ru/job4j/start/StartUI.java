package ru.job4j.start;
/**
 * Class StartUI.
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
	/**
	* Params.
	*/
	private Input input;
	private Tracker tracker;
	private static final String ADDNEWITEM = "0";
	private static final String SHOWALLITEMS = "1";
	private static final String EDITITEM = "2";
	private static final String DELETEITEM = "3";
	private static final String FINDITEMBYID = "4";
	private static final String FINDITEMBYNAME = "5";
	private static final String EXIT = "6";
	
	public StartUI(Input input, Tracker tracker) {
		this.input = input;
		this.tracker = tracker;
	}
	/**
	* Main.
	* @param args - first args.
	*/
	public static void main(String[] args) {
		Input input = new ConsoleInput();
		Tracker tracker = new Tracker();
		new StartUI(input, tracker).init();
	}	
	/**
	* Init
	*/
	public void init() {
		Tracker tracker = new Tracker();
		String selectedAction = showMenu();
		boolean exit = false;
		while (exit) {
			switch (selectedAction) {
				case ADDNEWITEM: this.addNewItem();
					
				case SHOWALLITEMS: this.showAllItems();
					
				case EDITITEM: this.editItem();
					
				case DELETEITEM: this.deleteItem();
					
				case FINDITEMBYID: this.findItembyId();
					
				case FINDITEMBYNAME: this.findItemsbyName();
					
				case EXIT:	this.input.ask("See you later!");
							exit = true;
					
				default: input.ask("The menu has not this position"); init();
			}
		}
	}
	/**
	* Add new item.
	* @param tarcker - first param.
	*/
	private void addNewItem() {
		this.input.ask("Adding a new item");
		String itemName = this.input.ask("Plesae, enter the item's name");
		String itemDesc = this.input.ask("Plesae, enter the item's description");
		this.tracker.add(new Item(itemName, itemDesc, System.currentTimeMillis()));
		/*String yesno = input.ask("Thank you. Do you want to contionue work?" + "\n" + "1. Yes" + "\n" + "2. No");
		if (yesno == "2") {
			selectedAction = "6";
			init();
		} else {
			init();
		}*/
	}
	/**
	* Show all items.
	* @param tarcker - first param.
	*/
	private void showAllItems() {
		tracker.findAll();
	}
	/**
	* Edit item.
	* @param tarcker - first param.
	*/
	private void editItem() {
		String itemName = this.input.ask("Plesae, enter the item's name");
		String itemDesc = this.input.ask("Plesae, enter the item's description");
		Item editItem = new Item(itemName, itemDesc, System.currentTimeMillis());
		this.tracker.update(editItem);
		/*String yesno = input.ask("Thank you. Do you want to contionue work?" + "\n" + "1. Yes" + "\n" + "2. No");
		if (yesno == "2") {
			selectedAction = "6";
			init();
		} else {
			init();
		}*/
	}
	/**
	* Delete item.
	* @param tarcker - first param.
	*/
	private void deleteItem() {
		String itemId = input.ask("Plesae, enter the item's id, which you want to delete");
		Item deletedItem = this.tracker.findById(itemId);
		this.tracker.delete(deletedItem);
	}
	/**
	* Find item by id.
	* @param tarcker - first param.
	*/
	private void findItembyId() {
		String itemId = input.ask("Plesae, enter the item's id, which you want to find");
		Item item = this.tracker.findById(itemId);
		String itemName = item.getName();
		String itemDesc = item.getDescription();
		String itemCreate = String.valueOf(item.getCreate());
		input.ask("It's your item:" + "\n" + "Name: " + itemName + "\n" + "Description: " + itemDesc + "\n" + "Cretae: " + itemCreate + "\n");
		/*String yesno = this.input.ask("Thank you. Do you want to contionue work or contionue searching?" + "\n" + "1. Yes, I want to find item again" + "\n" + "2.Yes, Show me menu" + "\n" + "3. No, I want close this application.");
		if (yesno == "3") {
			selectedAction = "6";
			init();
		} else if (yesno == "2") {
			findItembyId();
		} else {
			init();
		}*/
	}
	/**
	* Find item by name.
	* @param tarcker - first param.
	*/
	private void findItemsbyName() {
		String itemKey = this.input.ask("Plesae, enter the item's key, which you want to find");
		Item[] items = this.tracker.findByName(itemKey);		
		for (Item item : items) {
			String itemName = item.getName();
			String itemDesc = item.getDescription();
			String itemCreate = String.valueOf(item.getCreate());
			this.input.ask("It's your item:" + "\n" + "Name: " + itemName + "\n" + "Description: " + itemDesc + "\n" + "Cretae: " + itemCreate + "\n");
		}
		/*String yesno = input.ask("Thank you. Do you want to contionue work or contionue searching?" + "\n" + "1. Yes, I want to find item again" + "\n" + "2.Yes, Show me menu" + "\n" + "3. No, I want close this application.");
		if (yesno == "3") {
			selectedAction = "6";
			init();
		} else if (yesno == "2") {
			findItemsbyName();
		} else {
			init();
		}*/
	}

	private String showMenu() {
		input.ask("0. Add new Item");
		input.ask("1. Show all items");
		input.ask("2. Edit item");
		input.ask("3. Delete item");
		input.ask("4. Find item by id");
		input.ask("5. Find items by name");
		input.ask("6. Exit Program");
		String selectedAction = input.ask("Please, choose number for action: ");
		return selectedAction;
	}
}