package ru.job4j.start;
/**
 * Class StartUI.
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.1
 */
 import ru.job4j.start.*;
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
		String selectedAction = this.showMenu();
		boolean exit = true;
		while (exit) {
			switch (selectedAction) {
				case ADDNEWITEM: this.addNewItem();
								 break;
								 
				//case SHOWALLITEMS: 	this.showAllItems();
				//					//System.out.println("BBB");
				//					break;
								   
				//case EDITITEM: this.editItem();
				//			   break;
							
				//case DELETEITEM: this.deleteItem();
				//			     break;
								 
				//case FINDITEMBYID: this.findItembyId();
				//			       break;
					
				//case FINDITEMBYNAME: this.findItemsbyName();
				//					 break;
									 
				case EXIT:	exit = false;
							System.out.println("See you later!");
							break;
							
				default: System.out.println("The menu has not this position, please try again:)"); exit = false; init(); break;
			}
		}
	}
	/**
	* Add new item.
	* @param tarcker - first param.
	*/
	private void addNewItem() {
		System.out.println("Adding a new item");
		String itemName = "1"; //this.input.ask("Plesae, enter the item's name: ");
		String itemDesc = "1"; //this.input.ask("Plesae, enter the item's description: ");
		Item item1 = new Item(itemName, itemDesc, System.currentTimeMillis());
		this.tracker.add(item1);
		System.out.println("Your item was added:");
		System.out.println("Name: " + item1.getName() + "\n" + "Description: " + item1.getDescription() + "\n" + "Cretae: " + item1.getCreate() + "\n");
		System.out.println("Thank you. Do you want to contionue work?\n1. Yes\n2. No\nPlease, choose number for action: ");
		this.init();
	}
	/**
	* Show all items.
	* @param tarcker - first param.
	*/
	private void showAllItems() {
		System.out.println("All Items");
		Item[] items = tracker.findAll();
		int position = 0;
		if (items.length > 0) {
			for (Item item : items) {
				position++;
				System.out.println("Position: " + position + "\n" + "Name: " + item.getName() + "\n" + "Description: " + item.getDescription() + "\n" + "Cretae: " + item.getCreate() + "\n");
				this.init();
			}
		} else {
			System.out.println("No items");
			this.init();
		}
	}
	/**
	* Edit item.
	* @param tarcker - first param.
	*/
	private void editItem() {
		System.out.println("Edit Item");
		String itemName = this.input.ask("Plesae, enter the item's name: ");
		String itemDesc = this.input.ask("Plesae, enter the item's description: ");
		Item editItem = new Item(itemName, itemDesc, System.currentTimeMillis());
		this.tracker.update(editItem);
		this.init();
	}
	/**
	* Delete item.
	* @param tarcker - first param.
	*/
	private void deleteItem() {
		System.out.println("Delete Item");
		String itemId = input.ask("Plesae, enter the item's id, which you want to delete: ");
		Item deletedItem = this.tracker.findById(itemId);
		this.tracker.delete(deletedItem);
		this.init();
	}
	/**
	* Find item by id.
	* @param tarcker - first param.
	*/
	private void findItembyId() {
		System.out.println("Find Item by Id");
		String itemId = input.ask("Plesae, enter the item's id, which you want to find: ");
		Item item = this.tracker.findById(itemId);
		String itemName = item.getName();
		String itemDesc = item.getDescription();
		String itemCreate = String.valueOf(item.getCreate());
		System.out.println("It's your item:" + "\n" + "Name: " + itemName + "\n" + "Description: " + itemDesc + "\n" + "Cretae: " + itemCreate + "\n");
		this.init();
	}
	/**
	* Find item by name.
	* @param tarcker - first param.
	*/
	private void findItemsbyName() {
		System.out.println("Find Items by Name");
		String itemKey = this.input.ask("Plesae, enter the item's key, which you want to find: ");
		Item[] items = this.tracker.findByName(itemKey);		
		for (Item item : items) {
			String itemName = item.getName();
			String itemDesc = item.getDescription();
			String itemCreate = String.valueOf(item.getCreate());
			System.out.println("It's your item:" + "\n" + "Name: " + itemName + "\n" + "Description: " + itemDesc + "\n" + "Cretae: " + itemCreate + "\n");
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
		System.out.println("5. Find items by name");
		System.out.println("6. Exit Program");
		String selectedAction = input.ask("\nPlease, choose number for action: ");
		return selectedAction;
	}
}