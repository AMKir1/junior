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
	private int[] range = new int[] {0, 1, 2, 3, 4, 5, 6};
	private Input input;
	private Tracker tracker;
	int id = 0;
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
			//int key = Integer.valueOf(input.ask("Select: "));
			menu.select(input.ask("Select: ", this.range));
		} while (!"y".equals(this.input.ask("Exit?(y)")));
		/*String selectedAction = this.showMenu();
		
		boolean exit = true;
			if (selectedAction.equals(ADDNEWITEM)) {
				this.addNewItem();
			} else if (selectedAction.equals(SHOWALLITEMS)) {
				this.showAllItems();
			} else if (selectedAction.equals(EDITITEM)) {				   
				this.editItem();
			} else if (selectedAction.equals(DELETEITEM)) {
				this.deleteItem();
			} else if (selectedAction.equals(FINDITEMBYID)) {
				this.findItembyId();
			} else if (selectedAction.equals(FINDITEMBYNAME)) {
				this.findItemsbyName();
			} else if (selectedAction.equals(EXIT)) {
				System.out.println("See you later!");
			} else {
				System.out.println("The menu has not this position, please try again:)");
				selectedAction = this.showMenu();
			}
			*/
		
	}
	/**
	* Add new item.
	* @param tarcker - first param.
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
	* @param tarcker - first param.
	*/
	private void showAllItems() {
		System.out.println("All Items");
		Item[] items = tracker.findAll();
		int position = 0;
		if (items.length > 0) {
			for (Item item : items) {
				if (item.getName() != null) {
					position++;
					System.out.println("Position: " + position + "\n" + "Name: " + item.getName() + "\n" + "Description: " + item.getDescription() + "\n" + "Cretae: " + item.getCreate() + "\n" + "Id: " + item.getId() + "\n");
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
	* @param tarcker - first param.
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
	* @param tarcker - first param.
	*/
	private void deleteItem() {
		boolean del = false;
		System.out.println("Delete Item");
		String itemId = input.ask("Plesae, enter the item's id, which you want to delete: ");
		Item[] items = this.tracker.findAll();
		for (int i = 0; i < items.length; i++) {
			if (items[i].getId().equals(itemId)) {
				System.out.println("It's your deleted item:");
				showItem(items[i]);
				this.tracker.delete(items[i]);
				del = true;
			}
		}
		if (!del) {
			System.out.println("NO Such Items");
		}
		this.init();
	}
	/**
	* Find item by id.
	* @param tarcker - first param.
	*/
	private void findItembyId() {
		boolean id = false;
		System.out.println("Find Items by Id");
		String itemId = input.ask("Plesae, enter the item's id, which you want to find: ");
		Item[] items = this.tracker.findAll();
		for (int i = 0; i < items.length; i++) {
			if (items[i].getId().equals(itemId)) {
			System.out.println("It's your item:");
			showItem(items[i]);	
			id = true;
			}
		}
		if (!id) {
			System.out.println("NO Items");
		}
		this.init();
	}
	/**
	* Find item by name.
	* @param tarcker - first param.
	*/
	private void findItemsbyName() {
		boolean name = false;
		System.out.println("Find Items by Name");
		String itemKey = this.input.ask("Plesae, enter the item's key, which you want to find: ");
		Item[] items = this.tracker.findAll();
		for (int i = 0; i < items.length; i++) {
			if (items[i].getName().equals(itemKey)) {
			System.out.println("It's your item:");
			showItem(items[i]);
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
		String selectedAction = input.ask("\nPlease, choose number for action: ");
		return selectedAction;
	}
	private void showItem(Item item) {
        System.out.println("Name: " + item.getName());
		System.out.println("Description: " + item.getDescription());
		System.out.println("Create: " + item.getCreate());
        System.out.println("Id: " + item.getId());
	}
}