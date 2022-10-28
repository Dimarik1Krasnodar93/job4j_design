package ru.job4j.ood.icp.menu;

import java.util.*;

import ru.job4j.ood.icp.menu.ActionDelegate;
import ru.job4j.ood.icp.menu.MenuItem;

import javax.swing.text.html.Option;

public class SimpleMenu implements Menu {

    private final List<MenuItem> rootElements = new ArrayList<>();

    @Override
    public boolean add(String parentName, String childName, ActionDelegate actionDelegate) {
        if (parentName.equals("")) {
            rootElements.add(new SimpleMenuItem(childName, actionDelegate));
        } else {
            MenuItem parentItem = findItem(parentName).orElseThrow().menuItem;
        }
        return true;
    }

    private Optional<MenuItem> findMenuItem(String parent) {
        Optional<MenuItem> result = Optional.empty();
        for (MenuItem menuItem : rootElements) {
            if (parent.equals(parent)) {
                result = Optional.of(menuItem);
                break;
            }
        }
        return result;
    }

    @Override
    public Optional<MenuItemInfo> select(String itemName) {
        Optional<MenuItemInfo> result = Optional.empty();

        return result;
    }

    @Override
    public Iterator<MenuItemInfo> iterator() {
        Iterator<MenuItemInfo> result = new Iterator<MenuItemInfo>() {

            DFSIterator iterator = new DFSIterator();

            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public MenuItemInfo next() {
                return null;
            }
        };
        return result;
    }

    private Optional<ItemInfo> findItem(String name) {
        return null;
    }

    private static class SimpleMenuItem implements MenuItem {

        private String name;
        private List<MenuItem> children = new ArrayList<>();
        private ActionDelegate actionDelegate;

        public SimpleMenuItem(String name, ActionDelegate actionDelegate) {
            this.name = name;
            this.actionDelegate = actionDelegate;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public List<MenuItem> getChildren() {
            return children;
        }

        @Override
        public ActionDelegate getActionDelegate() {
            return actionDelegate;
        }
    }

    private class DFSIterator implements Iterator<ItemInfo> {

        Deque<MenuItem> stack = new LinkedList<>();

        Deque<String> numbers = new LinkedList<>();

        DFSIterator() {
            int number = 1;
            for (MenuItem item : rootElements) {
                stack.addLast(item);
                numbers.addLast(String.valueOf(number++).concat("."));
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public ItemInfo next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            MenuItem current = stack.removeFirst();
            String lastNumber = numbers.removeFirst();
            List<MenuItem> children = current.getChildren();
            int currentNumber = children.size();
            for (var i = children.listIterator(children.size()); i.hasPrevious();) {
                stack.addFirst(i.previous());
                numbers.addFirst(lastNumber.concat(String.valueOf(currentNumber--)).concat("."));
            }
            return new ItemInfo(current, lastNumber);
        }
    }

    private class ItemInfo {

        MenuItem menuItem;
        String number;

        public ItemInfo(MenuItem menuItem, String number) {
            this.menuItem = menuItem;
            this.number = number;
        }
    }

}
