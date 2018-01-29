package ru.job4j.start;
/**
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.1
 */
	import ru.job4j.start.*;

class Exit implements UserAction {
		@Override
		public int key() {
			return 6;
		}
		@Override
		public void execute(Input input, Tracker tracker) { }
		@Override
		public String info() {
			return String.format("%s. %s", this.key(), "Exit Program");
		}
	}	
	

public class MenuTracker {
	
	private Input input;
	private Tracker tracker;
	private UserAction[] actions = new UserAction[7];
	private int id;
	
	public MenuTracker(Input input, Tracker tracker) {
	this.input = input;
	this.tracker = tracker;
	}
	
	private void showItem(Item item) {
        System.out.println("Name: " + item.getName());
		System.out.println("Description: " + item.getDescription());
		System.out.println("Create: " + item.getCreate());
        System.out.println("Id: " + item.getId());
	}
	
	public void fillAction() {
		this.actions[0] = this.new AddItem();
		this.actions[1] = this.new ShowAllItems();
		this.actions[2] = new MenuTracker.EditItem();
		this.actions[3] = this.new DeleteItem();
		this.actions[4] = this.new FindItemById();
		this.actions[5] = this.new FindItemsByName();
		this.actions[6] = new Exit();
	}
	
	public void select(int key) {
		this.actions[key].execute(this.input, this.tracker);
	}
	
	public void show() {
		for (UserAction action : this.actions) {
			if (action != null) {
				System.out.println(action.info());
			}
		}
	}
	
	private class AddItem implements UserAction {
		@Override
		public int key() {
			return 0;
		}
		@Override
		public void execute(Input input, Tracker tracker) {
			String itemId = Integer.toString(id++);
			String itemName = input.ask("Plesae, enter the item's name: ");
			String itemDesc = input.ask("Plesae, enter the item's description: ");
			Item item = new Item(itemName, itemDesc, System.currentTimeMillis(), itemId);
			tracker.add(item);
			System.out.println("Your item was added:");
			showItem(item);
		}
		@Override
		public String info() {
			return String.format("%s. %s", this.key(), "Add the new Item");
		}
	}
	
	private class ShowAllItems implements UserAction {
		@Override
		public int key() {
			return 1;
		}
		@Override
		public void execute(Input input, Tracker tracker) {
			if (tracker.findAll().length > 0) {
				for (Item item : tracker.findAll()) {
					if (item.getName() != null) {
						showItem(item);
					} else {
						System.out.println("NO Items");
					}
				} 
			} else {
				System.out.println("NO Items");
			}
		}
		@Override
		public String info() {
			return String.format("%s. %s", this.key(), "Show all Items");		
		}
	}
	
	private class DeleteItem implements UserAction {
		@Override
		public int key() {
			return 3;
		}
		@Override
		public void execute(Input input, Tracker tracker) {
			boolean del = false;
			String itemId = input.ask("Plesae, enter the item's id, which you want to delete: ");
			for (int i = 0; i < tracker.findAll().length; i++) {
				if (tracker.findAll()[i].getId().equals(itemId)) {
					System.out.println("It's your deleted item:");
					showItem(tracker.findAll()[i]);
					tracker.delete(tracker.findAll()[i]);
					del = true;
				}
			}
			if (!del) {
				System.out.println("NO Such Items");
			}
		}
		@Override
		public String info() {
			return String.format("%s. %s", this.key(), "Delete Item");
		}
	}
	
	private class FindItemById implements UserAction {
		@Override
		public int key() {
			return 4;
		}
		@Override
		public void execute(Input input, Tracker tracker) {
			boolean id = false;
			String itemId = input.ask("Plesae, enter the item's id, which you want to find: ");
			for (int i = 0; i < tracker.findAll().length; i++) {
				if (tracker.findAll()[i].getId().equals(itemId)) {
				System.out.println("It's your item:");
				showItem(tracker.findAll()[i]);	
				id = true;
				}
			}
			if (!id) {
				System.out.println("NO Items");
			}
		}
		@Override
		public String info() {
			return String.format("%s. %s", this.key(), "Find Items by Id");
		}
	}
	
	private class FindItemsByName implements UserAction {
		@Override
		public int key() {
			return 5;
		}
		@Override
		public void execute(Input input, Tracker tracker) {
			boolean name = false;
			String itemKey = input.ask("Plesae, enter the item's key, which you want to find: ");
			for (int i = 0; i < tracker.findAll().length; i++) {
				if (tracker.findAll()[i].getName().equals(itemKey)) {
					System.out.println("It's your item:");
					showItem(tracker.findAll()[i]);
					name = true;
				}
			}
			if (!name) {
				System.out.println("NO Items");
			}
		}
		@Override
		public String info() {
			return String.format("%s. %s", this.key(), "Find Items by Name");
		}
	}
	
	static class EditItem implements UserAction {
	
		@Override
		public int key() {
			return 2;
		}
		@Override
		public void execute(Input input, Tracker tracker) {
				String itemId =  input.ask("Plesae, enter the item's id, which you want to edit: ");
				String itemName = input.ask("Plesae, enter the item's name: ");
				String itemDesc = input.ask("Plesae, enter the item's description: ");
				Item editItem = new Item(itemName, itemDesc, System.currentTimeMillis(), itemId);
				tracker.update(editItem);
		}
		@Override
		public String info() {
			return String.format("%s. %s", this.key(), "Edit Item");
		}
	
	}

	
}