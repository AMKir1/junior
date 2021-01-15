package ru.job4j.menu;
/*
 * Chapter_009. OOD [#143]
 * Task: Создать меню. [#4748]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 3
 */
import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    /**
     * List of components (Items or Composite of Items).
     */
    private List<Component> components = new ArrayList<>();

    /**
     * Composite's action.
     */
    private Action action;

    /**
     * Composite's name.
     */
    private String name;

    /**
     * Designer.
     * @param name Composite's name.
     */
    public Composite(String name, Action action) {
        this.name = name;
        this.action = action;
    }

    /**
     * Add to list.
     * @param component - component.
     */
    public void addComponent(Component component) {
        this.components.add(component);
    }

    /**
     * remove from list.
     * @param component - component.
     */
    public void removeComponent(Component component) {
        this.components.remove(component);
    }

    /**
     * Name's getter.
     * @return - string.
     */
    public String getName() {
        return this.name;
    }

    /**
     * get String Component.
     * @param level - level.
     * @return String.
     */
    @Override
    public String print(String level) {
        StringBuilder sb = new StringBuilder();
        sb.append(level).append(getName()).append(System.lineSeparator());
        level += "--- ";
        String finalLevel = level;
        components.forEach(c -> sb.append(c.print(finalLevel)));
        return sb.toString();
    }
}
