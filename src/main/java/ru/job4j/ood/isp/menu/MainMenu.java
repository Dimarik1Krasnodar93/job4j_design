package ru.job4j.ood.isp.menu;

public class MainMenu {
    public static void main(String[] args) {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Задача 1.", () -> System.out.println("Delegate 1"));
        menu.add("Задача 1.", "---- Задача 1.1.", () -> System.out.println("Delegate 1"));
        menu.add("Задача 1.", "---- Задача 1.2.", () -> System.out.println("Delegate 2"));
        menu.add("Задача 1.2", "---- Задача 1.2.1", () -> System.out.println("Delegate 3"));
        menu.add(Menu.ROOT, "Задача 2.", () -> System.out.println("Delegate 1"));
        menu.add("Задача 2.", "---- Задача 2.1.", () -> System.out.println("Delegate 4"));
        menu.add("Задача 2.", "---- Задача 2.2.", () -> System.out.println("Delegate 5"));
        Printer printer = new Printer();
        printer.print(menu);
    }

}
