package ru.job4j.start;
/**
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.1
 */

	class Exit extends BaseAction {
		public Exit(int key, String name) {
                super(key, name);
            }
		@Override
		public void execute(Input input, Tracker tracker) { }
	}	
	

	public class MenuTracker {
	
	private Input input;
	private Tracker tracker;
	private UserAction[] actions = new UserAction[7];
	private int id;
	private int position = 0;
	
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
		this.actions[position++] = this.new AddItem(0, "Add the new Item");
		this.actions[position++] = this.new ShowAllItems(1, "Show all Items");
		this.actions[position++] = new MenuTracker.EditItem(2, "Edit Item");
		this.actions[position++] = this.new DeleteItem(3, "Delete Item");
		this.actions[position++] = this.new FindItemById(4, "Find Items by Id");
		this.actions[position++] = this.new FindItemsByName(5, "Find Items by Name");
		this.actions[position++] = new Exit(6, "Exit Program");
	}
	
	public void addAction(UserAction action) {
		this.actions[position++] = action;
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
	
	private class AddItem extends BaseAction {
		 private AddItem(int key, String name) {
                super(key, name);
            }
		 public void execute(Input input, Tracker tracker) {
			String itemId = Integer.toString(id++);
			String itemName = input.ask("Plesae, enter the item's name: ");
			String itemDesc = input.ask("Plesae, enter the item's description: ");
			Item item = new Item(itemName, itemDesc, System.currentTimeMillis(), itemId);
			tracker.add(item);
			System.out.println("Your item was added:");
			showItem(item);
		}
	}
	
	private class ShowAllItems extends BaseAction {
		private ShowAllItems(int key, String name) {
                super(key, name);
            }
		@Override
		public void execute(Input input, Tracker tracker) {
			if (tracker.findAll().size() > 0) {
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
	}
	
	private class DeleteItem extends BaseAction {
		private DeleteItem(int key, String name) {
			super(key, name);
		}

		@Override
		public void execute(Input input, Tracker tracker) {
			String itemId = input.ask("Plesae, enter the item's id, which you want to delete: ");
			for (Item item : tracker.findAll()) {
				if (item.getId().equals(itemId)) {
					showItem(tracker.findAll().get(Integer.parseInt(itemId)));
				}
			}
			tracker.delete(itemId);
		}
	}
	
	private class FindItemById extends BaseAction {
		private FindItemById(int key, String name) {
                super(key, name);
        }
		@Override
		public void execute(Input input, Tracker tracker) {
			boolean id = false;
			String itemId = input.ask("Plesae, enter the item's id, which you want to find: ");
			for (int i = 0; i < tracker.findAll().size(); i++) {
				if (tracker.findAll().get(i).getId().equals(itemId)) {
				System.out.println("It's your item:");
				showItem(tracker.findAll().get(i));
				id = true;
				}
			}
			if (!id) {
				System.out.println("NO Items");
			}
		}
	}
	
	private class FindItemsByName extends BaseAction {
		private FindItemsByName(int key, String name) {
                super(key, name);
        }
		@Override
		public void execute(Input input, Tracker tracker) {
			boolean name = false;
			String itemKey = input.ask("Plesae, enter the item's key, which you want to find: ");
			for (int i = 0; i < tracker.findAll().size(); i++) {
				if (tracker.findAll().get(i).getName().equals(itemKey)) {
					System.out.println("It's your item:");
					showItem(tracker.findAll().get(i));
					name = true;
				}
			}
			if (!name) {
				System.out.println("NO Items");
			}
		}
	}
	
	static class EditItem extends BaseAction {
		private EditItem(int key, String name) {
                super(key, name);
        }
		@Override
		public void execute(Input input, Tracker tracker) {
				String itemId =  input.ask("Plesae, enter the item's id, which you want to edit: ");
				String itemName = input.ask("Plesae, enter the item's name: ");
				String itemDesc = input.ask("Plesae, enter the item's description: ");
				Item editItem = new Item(itemName, itemDesc, System.currentTimeMillis(), itemId);
				tracker.update(editItem);
		}
	}
}