package ru.job4j.menu;
/*
 * Chapter_009. OOD [#143]
 * Task: Создать меню. [#4748]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 4
 */
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
public class MenuControllerTest {

    /**
     * Show menu.
     */
    @Test
    public void whenShowMenu() {
        MenuController mc = new MenuController();
        Composite composite = mc.initComposite();
        String menuString = composite.print("");
        StringBuilder result = new StringBuilder();
        result.append("Меню").append(System.lineSeparator());
        result.append("--- 1").append(System.lineSeparator());
        result.append("--- --- 1.1").append(System.lineSeparator()).append("--- --- 1.2").append(System.lineSeparator()).append("--- --- 1.3").append(System.lineSeparator());
        result.append("--- 2").append(System.lineSeparator());
        result.append("--- --- 2.1").append(System.lineSeparator());
        result.append("--- --- --- 2.1.1").append(System.lineSeparator());
        result.append("--- --- --- --- 2.1.1.1").append(System.lineSeparator());
        result.append("--- 3").append(System.lineSeparator());
        result.append("--- --- 3.1").append(System.lineSeparator());
        result.append("--- --- --- 3.1.1").append(System.lineSeparator());
        result.append("--- --- --- --- 3.1.1.1").append(System.lineSeparator()).append("--- --- --- --- 3.1.1.2").append(System.lineSeparator());
        result.append("--- --- --- 3.1.2").append(System.lineSeparator());
        result.append("--- 4").append(System.lineSeparator());
        assertThat(result.toString(), is(menuString));
    }

    /**
     * Choose Item.
     */
    @Test
    public void whenChooseItem() {
        MenuController menu = new MenuController();
        Composite composite = menu.initComposite();
        Action actionMenu = menu.getActions().get(composite.getId());
        menu.chooseItem(composite.getId());
        assertThat(actionMenu.execute(), is(true));
    }


    /**
     * Choose Not Exist Item.
     */
    @Test
    public void whenChooseNotExistItem() {
        MenuController menu = new MenuController();
        Composite composite = menu.initComposite();
        Action actionNo = new ActionNo();
        menu.chooseItem(composite.getId());
        assertThat(actionNo.execute(), is(false));
    }
}
