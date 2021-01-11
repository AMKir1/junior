package ru.job4j.menu;
/*
 * Chapter_009. OOD [#143]
 * Task: Создать меню. [#4748]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
public interface Component {
    /**
     * Get menu in string.
     * @param level - level.
     * @return - menu.
     */
    String print(String level);

    /**
     * Choose menu.
     * @param item - item.
     * @return - String.
     */
    String chooseItem(String item);
}
