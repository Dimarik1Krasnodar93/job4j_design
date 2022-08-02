package ru.job4j.mycode;
import java.lang.reflect.ParameterizedType;
import java.util.*;

public class App {
    public static void main(String[] args) {
        List<String> ll = new LinkedList<>();
        ll.add("1");
        println(ll);

        class FloatList extends ArrayList<Float> {

        }
        ArrayList<Float> listOfNumbers = new FloatList();
        Class actual = listOfNumbers.getClass();
        ParameterizedType type = (ParameterizedType) actual.getGenericSuperclass();
        System.out.println(type);
        Set<String> setStr = new HashSet<String>();
        Set<String> setStr2 = new HashSet<>();
    }

    public static void println(Collection<?> col) {

        Class actual = col.getClass();
        ParameterizedType type = (ParameterizedType) actual.getGenericSuperclass();
        System.out.println(type);
    }


}
