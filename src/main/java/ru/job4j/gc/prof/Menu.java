package ru.job4j.gc.prof;

import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;

public class Menu {

    public static final int CREATE_ARRAY = 1;
    public static final int MERGE_SORT = 2;
    public static final int BUBBLE_SORT = 3;
    public static final int INSERT_SORT = 4;

    public static final String BEGIN = " Start sort - ";

    public static final String END = " End sort - ";

    public static final String SELECT = "Input elements count";

    public static final String ARRAY_INFO = "Array haas been created and filled random values";

    public static final String MENU = """
                Input 1 to create array.
                Imput 2 to start merge sort.
                Imput 3 to start buble sort.
                Imput 4 to start insert sort.
                Imput any other number to exit.
            """;

    public static void main(String[] args) {
        Data store = new RandomArray(new Random());
        Sort merge = new MergeSort();
        Sort bubble = new BubbleSort();
        Sort insert = new InsertSort();
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println(MENU);
            int userChoice = Integer.parseInt(scanner.nextLine());
            System.out.println(userChoice);
            if (CREATE_ARRAY == userChoice) {
                System.out.println(SELECT);
                int size = Integer.parseInt(scanner.nextLine());
                store.insert(size);
                System.out.println(ARRAY_INFO + size);
            } else if (MERGE_SORT == userChoice) {
                System.out.printf("%s%s%s%n", merge.getClass().getSimpleName(), BEGIN, LocalTime.now());
                merge.sort(store);
                System.out.printf("%s%s%s%n", merge.getClass().getSimpleName(), END, LocalTime.now());
            } else if (BUBBLE_SORT == userChoice) {
                System.out.printf("%s%s%s%n", bubble.getClass().getSimpleName(), BEGIN, LocalTime.now());
                bubble.sort(store);
                System.out.printf("%s%s%s%n", bubble.getClass().getSimpleName(), END, LocalTime.now());
            } else if (INSERT_SORT == userChoice) {
                System.out.printf("%s%s%s%n", insert.getClass().getSimpleName(), BEGIN, LocalTime.now());
                insert.sort(store);
                System.out.printf("%s%s%s%n", insert.getClass().getSimpleName(), END, LocalTime.now());
            } else {
                run = false;
                System.out.println("End");
            }
        }
    }
}
