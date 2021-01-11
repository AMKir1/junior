package ru.job4j.menu;
/*
 * Chapter_009. OOD [#143]
 * Task: Создать меню. [#4748]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
public class MenuController {

    /**
     * init menu.
     * @return Composite.
     */
    public Composite initComposite() {
        Composite composite = new Composite("Меню");
        Composite composite1 = new Composite("1");
        Component item11 = new Item("1.1");
        Component item12 = new Item("1.2");
        Component item13 = new Item("1.3");
        composite1.addComponent(item11);
        composite1.addComponent(item12);
        composite1.addComponent(item13);
        Composite composite2 = new Composite("2");
        Composite composite21 = new Composite("2.1");
        Composite composite211 = new Composite("2.1.1");
        Component item2111 = new Item("2.1.1.1");
        composite2.addComponent(composite21);
        composite21.addComponent(composite211);
        composite211.addComponent(item2111);
        Composite composite3 = new Composite("3");
        Composite composite31 = new Composite("3.1");
        Composite composite311 = new Composite("3.1.1");
        Component item3111 = new Item("3.1.1.1");
        Component item3112 = new Item("3.1.1.2");
        Component item312 = new Item("3.1.2");
        composite3.addComponent(composite31);
        composite31.addComponent(composite311);
        composite31.addComponent(item312);
        composite311.addComponent(item3111);
        composite311.addComponent(item3112);
        Component item4 = new Item("4");
        composite.addComponent(composite1);
        composite.addComponent(composite2);
        composite.addComponent(composite3);
        composite.addComponent(item4);
        return composite;
    }

}
