package ru.job4j.ood.isp.menu;

import java.util.Iterator;

public class Printer implements MenuPrinter {
    @Override
    public void print(Menu menu) {
        Iterator<Menu.MenuItemInfo> iterator = menu.iterator();
        while (iterator.hasNext()) {
            Menu.MenuItemInfo menuItemInfo = iterator.next();
            System.out.println(menuItemInfo.getName());
        }
    }
}
