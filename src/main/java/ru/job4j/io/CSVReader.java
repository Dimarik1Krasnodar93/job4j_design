package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        String[] filter = argsName.get("filter").split(",");
        String path = argsName.get("path");
        String deliminter = argsName.get("delimiter");
        String out = argsName.get("out");
        String temp = "";
        String[] columns;
        int[] indexArray = new int[filter.length];
        try (FileReader fr = new FileReader(path);
        FileWriter fw = new FileWriter(out)) {
            Scanner sc = new Scanner(fr);
            boolean firstLine = true;
            while (sc.hasNextLine()) {
                temp = sc.nextLine();
                columns = temp.split(deliminter);
                if (firstLine) {
                    firstLine = false;
                    for (int i = 0; i < filter.length; i++) {
                        for (int j = 0; j < columns.length; j++) {
                            if (filter[i].equals(columns[j])) {
                                indexArray[i] = j;
                                break;
                            }
                        }
                    }
                }
                for (int i = 0; i < indexArray.length; i++) {
                    System.out.print(columns[indexArray[i]] + (i == indexArray.length - 1 ? "" : deliminter ));
                    fw.write(columns[indexArray[i]] + (i == indexArray.length - 1 ? "" : deliminter ));
                }
                System.out.println("");
                fw.write("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
