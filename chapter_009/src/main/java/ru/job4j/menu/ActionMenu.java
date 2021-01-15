package ru.job4j.menu;
/*
 * Chapter_009. OOD [#143]
 * Task: Создать меню. [#4748]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 3
 */
public class ActionMenu implements Action {

    private String action;
    private boolean activate = false;

    public ActionMenu(String action) {
        this.action = action;
    }

    public void open() {
        this.activate = true;
    }

    public boolean getActivate() {
        return activate;
    }

    @Override
    public boolean execute() {
        open();
        return activate;
    }
}
